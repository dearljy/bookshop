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
 * @date 2022/8/4 9:44
 * @Version 1.0
 */
public class AuthFilter implements Filter {
    private List<String> exceptList ;//放入要排除的url
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
        Member member = (Member)request.getSession().getAttribute("member");
        if (!exceptList.contains(servletPath)){
            if (member == null){
                request.getRequestDispatcher("/views/member/login.jsp").forward(servletRequest, servletResponse);
                return;
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
