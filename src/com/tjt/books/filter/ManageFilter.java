package com.tjt.books.filter;

import com.tjt.books.entity.Manage;
import com.tjt.books.entity.Member;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author tjt
 * @date 2022/8/5 8:57
 * @Version 1.0
 */
public class ManageFilter implements Filter {
    private List<String> exceptList ;//放入要排除的uri

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String except = filterConfig.getInitParameter("except");
        exceptList = Arrays.asList(except.split(","));
        System.out.println("exceptList="+exceptList);
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        String servletPath = request.getServletPath();//得到请求路径
        System.out.println("servletPath="+servletPath);
        Manage manage = (Manage)request.getSession().getAttribute("manage");
        if (!exceptList.contains(servletPath)){
            if (manage == null){
                request.getRequestDispatcher("/views/manage/manage_login.jsp").forward(servletRequest, servletResponse);
                return;
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {

    }
}
