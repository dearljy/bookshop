package com.tjt.books.web;

import com.tjt.books.entity.Book;
import com.tjt.books.entity.Page;
import com.tjt.books.service.BookService;
import com.tjt.books.service.Impl.BookServiceImpl;
import com.tjt.books.utils.DataUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author tjt
 * @date 2022/5/21 10:06
 * @Version 1.0
 */
@WebServlet("/manage/bookServlet")
public class BookServlet extends BasicServlet{
    private BookService bookService = new BookServiceImpl();
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> bookList = bookService.queryAllBook();
        req.setAttribute("bookList",bookList);
        System.out.println("从list方法跳转成功！");
        req.getRequestDispatcher("/views/manage/book_manage.jsp").forward(req,resp);

    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = DataUtils.copyParameterToBean(req.getParameterMap(), new Book());
        int pageNo = DataUtils.parseInt(req.getParameter("pageNo"), 1);
        if (bookService.addBook(book)){
            System.out.println("从add方法跳转成功！");
            resp.sendRedirect(req.getContextPath()+"/manage/bookServlet?action=page&pageNo="+pageNo);
        }else {
            req.getRequestDispatcher("book_add.jsp").forward(req,resp);
        }

    }

    protected void showBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = DataUtils.parseInt(req.getParameter("id"), 1);
        Book book = bookService.queryBookById(id);
        req.setAttribute("book",book);
        req.getRequestDispatcher("/views/manage/book_update.jsp").forward(req,resp);
    }

    protected void modify(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = DataUtils.copyParameterToBean(req.getParameterMap(), new Book());
        int pageNo = DataUtils.parseInt(req.getParameter("pageNo"), 1);
        if (bookService.modifyBook(book)){
            resp.sendRedirect(req.getContextPath()+"/manage/bookServlet?action=page&pageNo="+pageNo);
        }else {
            req.setAttribute("error","输入的修改信息有误");
            req.getRequestDispatcher("/views/manage/book_update.jsp").forward(req,resp);
        }
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageNo = req.getParameter("pageNo");
        int id = DataUtils.parseInt(req.getParameter("id"), 0);
        bookService.deleteBook(id);
        resp.sendRedirect(req.getContextPath()+"/manage/bookServlet?action=page&pageNo="+pageNo);
    }

    /**
     * 分页显示
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = DataUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = DataUtils.parseInt(req.getParameter("pageSize"), Page.SIZE);
        Page page = bookService.page(pageNo, pageSize);
        req.setAttribute("page",page);
        req.getRequestDispatcher("/views/manage/book_manage.jsp").forward(req,resp);
    }
}
