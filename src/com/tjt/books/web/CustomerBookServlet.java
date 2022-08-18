package com.tjt.books.web;

import com.tjt.books.dao.BasicDAO;
import com.tjt.books.entity.Book;
import com.tjt.books.entity.Member;
import com.tjt.books.entity.Page;
import com.tjt.books.service.BookService;
import com.tjt.books.service.CartItemService;
import com.tjt.books.service.Impl.BookServiceImpl;
import com.tjt.books.service.Impl.CartItemServiceImpl;
import com.tjt.books.utils.DataUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author tjt
 * @date 2022/5/23 12:17
 * @Version 1.0
 */
@WebServlet("/customerBookServlet")
public class CustomerBookServlet extends BasicServlet {
    private BookService bookService = new BookServiceImpl();
    private CartItemService cartItemService  = new CartItemServiceImpl();
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = DataUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = DataUtils.parseInt(req.getParameter("pageSize"), Page.SIZE);
        Page page = bookService.page(pageNo, pageSize);
        req.setAttribute("page",page);
        req.getRequestDispatcher("views/customer/index.jsp").forward(req,resp);
    }

    /**
     * 查询到的书籍名进行分页
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void pageByBookName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = DataUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = DataUtils.parseInt(req.getParameter("pageSize"), Page.SIZE);
        String bookName = req.getParameter("bookName");
        if (bookName == null || bookName.length()==0){
            bookName="";//如果bookName为null 就设置为""空串，这样在数据库操作进行模糊查询时，可查到所有数据
        }
        Page<Book> page = bookService.getPageByName(pageNo, pageSize, bookName);
        System.out.println();
        StringBuilder url = new StringBuilder("customerBookServlet?action=pageByBookName" + "&pageSize=" + pageSize);
        if (bookName != null){
            url.append("&bookName=").append(bookName);
        }
        page.setUrl(url.toString());
        Member member = (Member)req.getSession().getAttribute("member");//为了获得用户id
        //得到该用户的购物车中的商品数量
        int totalCount = 0;
        if (member != null){
            totalCount = cartItemService.getTotalCount(member.getId());//根据用户id，查询商品数量
        }
        req.setAttribute("page",page);
        req.getRequestDispatcher("views/customer/index.jsp?totalCount="+totalCount).forward(req,resp);
    }
}
