package com.example.crm.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class DefaultController {


    @GetMapping("/403")
    public String error403() {
        return "/error_403";
    }

    @GetMapping("/login")
    public String loginPage1() {
        return "/login";
    }

    @GetMapping("/")
    public String redirectHome1(Authentication auth) {

        String role = auth.getAuthorities().toString();

        if (role.contains("ROLE_ADMIN"))
            return "/admin";
        else if (role.contains("ROLE_USER"))
            return "/user";
        else
            return "/login";
    }

    @GetMapping("/success")
    public void redirectHome(HttpServletRequest request, HttpServletResponse response, Authentication auth) throws IOException {

        String role = auth.getAuthorities().toString();

        /*if (role.contains("ROLE_ADMIN"))
            return "/admin";
        else if (role.contains("ROLE_USER"))
            return "/user";
        else
            return "/login";*/

        if (role.contains("ROLE_ADMIN")) {
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/admin"));
        } else if (role.contains("ROLE_USER")) {
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/user"));
        } else {
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/login"));
        }
    }
}
