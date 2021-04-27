package com.example.crm.service;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthServiceImp implements AuthService{

    @Override
    public String loginPageRedirect(/*HttpServletRequest request, HttpServletResponse response, */Authentication auth) {

        String role = auth.getAuthorities().toString();

        /*if (role.contains("ROLE_ADMIN")) {
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/admin"));
        } else if (role.contains("ROLE_USER")) {
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/user"));
        } else {
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/login"));
        }*/

        if (role.contains("ROLE_ADMIN"))
            return "/admin";
        else if (role.contains("ROLE_USER"))
            return "/user";
        else
            return "/login";
    }
}
