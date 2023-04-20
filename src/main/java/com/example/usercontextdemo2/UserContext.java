package com.example.usercontextdemo2;

import jakarta.servlet.http.HttpSession;

public class UserContext {

    public static void setCurrentUser(HttpSession session, String username) {
        session.setAttribute("username", username);
    }

    public static String getCurrentUser(HttpSession session) {
        return (String) session.getAttribute("username");
    }
}
