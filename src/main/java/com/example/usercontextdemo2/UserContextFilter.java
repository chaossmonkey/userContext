package com.example.usercontextdemo2;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class UserContextFilter implements Filter {

    private static final String USERNAME_HEADER = "X-My-App-Username";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String username = httpServletRequest.getHeader(USERNAME_HEADER);
        UserContext.setCurrentUser(username);
        chain.doFilter(request, response);
        UserContext.clear();
    }
}
