package com.zzx.listenerfilterintercept;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Created with IntelliJ IDEA.
 * Created by:  Vivian
 * Date: 2018/7/24 9:30
 */

@Component
//@WebListener()

//@ConfigurationProperties(prefix = "auth")

public class Listener implements ServletContextListener {

    //    @Value("${auth.tokenCheckRequired}")
    public static Boolean tokenCheckRequired;
    //   @Value("${auth.tokenExpireMin}")
    private static int tokenExpireMin;
    //  @Value("${auth.tokenKeyLength}")
    private static int tokenKeyLength;
    //  @Value("${auth.loginURL}")
    private static String loginURL;

    public Listener() {
    }

    public static Boolean getTokenCheckRequired() {
        return tokenCheckRequired;
    }

    public static void setTokenCheckRequired(Boolean tokenCheckRequired) {
        Listener.tokenCheckRequired = tokenCheckRequired;
    }

    public static int getTokenExpireMin() {
        return tokenExpireMin;
    }

    public static void setTokenExpireMin(int tokenExpireMin) {
        Listener.tokenExpireMin = tokenExpireMin;
    }

    public static int getTokenKeyLength() {
        return tokenKeyLength;
    }

    public static void setTokenKeyLength(int tokenKeyLength) {
        Listener.tokenKeyLength = tokenKeyLength;
    }

    public static String getLoginURL() {
        return loginURL;
    }

    public static void setLoginURL(String loginURL) {
        Listener.loginURL = loginURL;
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("监听器初始化......");
        System.out.println("要做事情才用listener......");
    }

    /**
     * 登录成功时调用
     *
     * @param request
     * @param response
     */

    public void loginSuccess(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.setAttribute("isLog", true);
        String sessionId = session.getId();
        String tokenKey;
        String token;
        if (tokenCheckRequired) {
            tokenKey = RandomChar.getRandomStr(tokenKeyLength);
            session.setAttribute("tokenKey", tokenKey);
            token = TokenCheck.createToken(tokenKey, sessionId, tokenExpireMin * 60 * 1000);
            Cookie cookie = new Cookie("token", token);
            cookie.setPath("/");
            cookie.setMaxAge(tokenExpireMin);
            cookie.setDomain(""); // cookie作用域
            response.addCookie(cookie);
        }
    }

    /**
     * 登出成功时调用
     *
     * @param request
     * @param response
     */
    public void logoutSuccess(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.invalidate();
    }


    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }


}
