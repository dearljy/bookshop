package com.tjt.books.web;

import com.tjt.books.entity.Book;
import com.tjt.books.entity.Manage;
import com.tjt.books.service.Impl.ManageServiceImpl;
import com.tjt.books.service.ManageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author tjt
 * @date 2022/5/21 10:04
 * @Version 1.0
 */
@WebServlet("/manageServlet")
public class ManageServlet extends BasicServlet{
    private ManageService manageService = new ManageServiceImpl();
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Manage manage = manageService.queryManageByUsernameAndPassword(username, password);
        if (manage == null){
            req.setAttribute("error","请输入正确的用户名,密码");
            req.getRequestDispatcher("/views/manage/manage_login.jsp").forward(req,resp);
        }else {
            req.getSession().setAttribute("manage",manage);
            req.getRequestDispatcher("/views/manage/manage_menu.jsp").forward(req,resp);
        }

    }
}
