package com.tjt.books.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public abstract class BasicServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决接收到的中文乱码问题
        req.setCharacterEncoding("utf-8");
        String action = req.getParameter("action");
        System.out.println("action="+action);
        //1.this 就是请求的servlet
        //2.getMethod方法对象就是当前请求的servlet对应的“action名字”的方法,该方法对象是根据用户请求动态变化的，
        //体会：使用模板模式+反射+动态机制===>简化多个if-else if。。。。 
        Class<? extends BasicServlet> aClass = this.getClass();
        try {
            Method declaredMethod = aClass.getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            declaredMethod.invoke(this,req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
