package com.jingxuan.core.interceptor;

import com.jingxuan.core.po.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url=request.getRequestURI();
        //除了登录请求外，其他的URL都进行拦截控制
        if(url.indexOf("/login.action")>=0){
            return true;
        }
        //获取session
        HttpSession  session=request.getSession();
        User user = (User) session.getAttribute("USER_SESSION");
        if(user!=null){
            return true;
        }
        request.setAttribute("msg","您还没有登录，请先登录");
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);

        return false;
    }
}
