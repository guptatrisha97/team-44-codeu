/*
 * Copyright 2019 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.codeu.servlets;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.codeu.data.Datastore;
import com.google.codeu.data.Message;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

import java.util.regex.Matcher; 
import java.util.regex.Pattern; 
import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException; 
import java.net.URL; 

/** Handles fetching and saving {@link Message} instances. */
@WebServlet("/messages")
public class MessageServlet extends HttpServlet {

  private Datastore datastore;

  @Override
  public void init() {
    datastore = new Datastore();
  }

  /**
   * Responds with a JSON representation of {@link Message} data for a specific user. Responds with
   * an empty array if the user is not provided.
   */
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    response.setContentType("application/json");

    String user = request.getParameter("user");

    if (user == null || user.equals("")) {
      // Request is invalid, return empty array
      response.getWriter().println("[]");
      return;
    }

    List<Message> messages = datastore.getMessages(user);
    Gson gson = new Gson();
    String json = gson.toJson(messages);

    response.getWriter().println(json);
  }

  /** Stores a new {@link Message}. */
  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    UserService userService = UserServiceFactory.getUserService();
    if (!userService.isUserLoggedIn()) {
      response.sendRedirect("/index.html");
      return;
    }

    String user = userService.getCurrentUser().getEmail();
    String text = Jsoup.clean(request.getParameter("text"), Whitelist.none());

    String userText = Jsoup.clean(request.getParameter("text"), Whitelist.none());
    
    String regex = "((https|http)?://\\S+\\.(png|jpg|gif|tif|jpeg))$";
    String replacement = "<img src=\"$1\" />";
    // String text = "Here is an image https://media.boingboing.net/wp-content/uploads/2019/02/cats.jpg";
    //Pattern to check if this is a valid URL address
    Pattern p = Pattern.compile("((https|http|ftp)?://\\S+\\.(png|jpg|gif|tif|jpeg))");
    Matcher m;
    m=p.matcher(userText);
    boolean matches=false;
    String result="";
    if (m.find())
     {
        String newtext=m.group(1);
        //System.out.println(newtext);
        Matcher m1;
        m1=p.matcher(newtext);
        matches = isImage(newtext);
        //System.out.println(matches);
     }
    if(matches){
      result = userText.replaceAll(regex, replacement);
    }
    else{
      result = userText;
    }
    result = userText.replaceAll(regex, replacement);
    Message message = new Message(user, result);
    datastore.storeMessage(message);
    response.sendRedirect("/user-page.html?user=" + user);
  }

  public boolean isImage(String image_path){
            //String url1 = "https://fbcdn-dragon-a.akamaihd.net/hphotos-ak-xft1/t39.1997-6/p200x200/851575_126362190881911_254357215_n.png";
            Image image=null;
            try{
                image = ImageIO.read(new URL(image_path));
            }
            catch (IOException e){
                //System.out.println("Error");
            }
            if(image != null){
                return true;
            }else{
               return false; 
        }
    }
}
