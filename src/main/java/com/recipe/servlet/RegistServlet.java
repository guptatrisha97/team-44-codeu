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
import java.util.HashMap;
import java.util.Map;

public class RegistServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        UserService userService = new UserService();
        User form = CommonUtils.toBean(request.getParameterMap(), User.class);

        Map<String, String> errors = new HashMap<>();
        String username = form.getUsername();
        if (username == null || username.trim().isEmpty()) {
            errors.put("username", "Username cannot be empty");
        } else if (username.length() < 3 || username.length() > 15) {
            errors.put("username", "Username should be between 3 ~ 15");
        }

        String password = form.getPassword();
        if (password == null || password.trim().isEmpty()) {
            errors.put("verifyCode", "Password cannot be empty");
        } else if (password.length() < 3 || password.length() > 15) {
            errors.put("password", "Password should be between 3 ~ 15");
        }


        if (errors != null && errors.size() > 0) {
            request.setAttribute("errors", errors);
            request.setAttribute("user", form);
            request.getRequestDispatcher("/user/regist.jsp").forward(request, response);
            return;
        }


        try {
            userService.regist(form);
            response.getWriter().println("<h1>Register OK</h1><a href='" + request.getContextPath() + "/user/login.jsp" + "'>Click here to log in</a>");
        } catch (UserException e) {
            request.setAttribute("user", form);
            request.setAttribute("msg", e.getMessage());
            request.getRequestDispatcher("/user/regist.jsp").forward(request, response);
        }
    }

}
