package com.qf.Interceptor;

import com.qf.Entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.InvocationHandler;

/**
 * @author admin
 * 登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
       httpServletResponse.setContentType("text/html;utf-8");
       httpServletResponse.setCharacterEncoding("UTF-8");
        String requestURI = httpServletRequest.getRequestURI();
        System.out.println(requestURI);
        if(requestURI.endsWith("login.html")||requestURI.equals("loginCheck")){
        return true;
        }else{
            HttpSession session = httpServletRequest.getSession();
            User user =(User) session.getAttribute("user");
            if(user==null){
                httpServletResponse.getWriter().write("<script>alert('您还没有登录，请登录');location.href='login.html';</script>");
                return false;
            }
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("Login poastHandle");
    }
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
