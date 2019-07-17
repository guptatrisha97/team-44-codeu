package com.recipe.servlet;

import com.recipe.domain.User;
import com.recipe.service.UserException;
import com.recipe.service.UserService;
import com.recipe.util.CommonUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        User form = CommonUtils.toBean(request.getParameterMap(), User.class);
        UserService userService = new UserService();
        try {
            User user = userService.login(form);
            request.getSession().setAttribute("sessionUser", user);
            response.sendRedirect(request.getContextPath() + "/user/welcome.jsp");
        } catch (UserException e) {
            request.setAttribute("user", form);
            request.setAttribute("msg", e.getMessage());
            request.getRequestDispatcher("/user/login.jsp").forward(request, response);

        }
    }

}
