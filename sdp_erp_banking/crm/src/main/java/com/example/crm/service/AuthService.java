package com.example.crm.service;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface AuthService {

    String loginPageRedirect(/*HttpServletRequest request, HttpServletResponse response, */Authentication auth) /*throws IOException*/;
}
