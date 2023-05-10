package com.jy.controller;

import com.jy.entity.User;
import com.jy.service.UserService;
import com.jy.util.AESUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TokenInterceptor implements HandlerInterceptor {
    @Autowired
    UserService us;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
      try{
          String token=request.getParameter("token");
          System.out.println(token);
          String key=(String) request.getServletContext().getAttribute("key");//取出密钥
          String de_token= AESUtils.decrypt(token,key);//把token解密
          System.out.println("解密后的token:"+de_token);
          //请求到达后先判断有没有token
          String username=de_token.split(",")[0].split(":")[1];
          String userId=de_token.split(",")[1].split(":")[1];
          //验证。。。
          User user=us.findById(Integer.parseInt(userId));
          if(user==null){
              System.out.println("false");
              return false;
          }else{
              System.out.println("true");
              return true;
          }

      }catch(Exception e){
          e.printStackTrace();
          return false;
      }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("【HelloInterceptor】postHandle....");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("【HelloInterceptor】afterCompletion..");
    }

}
