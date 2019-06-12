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
import java.util.List;
import java.util.ArrayList;
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
    
        String regeximg = "((https|http|ftp)?://\\S+\\.(png|jpg|gif|jpeg|tif))";
        String replacementimg = "<img src=\"$1\" />";
        //String regexvid= "(?:https?:\\/\\/)?(?:www\\.)?youtu\\.?be(?:\\.com)?\\/?.*(?:watch|emed)?(?:.*v=|v\\/|\\/)([\\w\\-_]+)\\&?)";
       // String replacementvid= "<iframe src= \"$1\"/>";
        //String text ="Here is a video http://www.youtube.com/v/i_GFalTRHDA  here is my dog https://images.pexels.com/photos/1108099/pexels-photo-1108099.jpeg?auto=format%2Ccompress&cs=tinysrgb&dpr=1&w=500";
                //Pattern to check if this is a valid URL address
        List<String> extractedUrls = extractUrls(userText);
        boolean flag=false;
        String result=userText;
        for (String url : extractedUrls)
        {
            //System.out.println(url);
            flag= isImage(url);
            //System.out.println(flag);
            if(flag==true){
            result = userText.replaceAll(regeximg, replacementimg);
          }
            //System.out.println(result);
        }
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
     public List<String> extractUrls(String text)
        {
            List<String> containedUrls = new ArrayList<String>();
            String urlRegex = "((https?|ftp|gopher|telnet|file):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)";
            Pattern pattern = Pattern.compile(urlRegex, Pattern.CASE_INSENSITIVE);
            Matcher urlMatcher = pattern.matcher(text);
        
            while (urlMatcher.find())
            {
                containedUrls.add(text.substring(urlMatcher.start(0),
                        urlMatcher.end(0)));
            }
        
            return containedUrls;
        }
}
