package com.tjt.books.web;

import com.tjt.books.entity.Book;
import com.tjt.books.entity.Cart;
import com.tjt.books.entity.CartItem;
import com.tjt.books.entity.Member;
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
import java.math.BigDecimal;
import java.util.List;
/**
 * @Author tjt
 * @date 2022/5/28 15:17
 * @Version 1.0
 */
@WebServlet("/cartServlet")
public class CartServlet extends BasicServlet{
    private BookService bookService = new BookServiceImpl();
    private CartItemService cartItemService = new CartItemServiceImpl();
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Member member = (Member)req.getSession().getAttribute("member");
        int bookId = DataUtils.parseInt(req.getParameter("bookId"), 0);
        Book book = bookService.queryBookById(bookId);
        CartItem cartItem = new CartItem();
        cartItem.setMemberId(member.getId());
        cartItem.setBookId(bookId);
        cartItem.setName(book.getName());
        cartItem.setPrice(book.getPrice());
        CartItem OldCartItem = cartItemService.queryCartItemByMemberIdAndBookId(member.getId(), bookId);
        //如果该商品已经在购物车中存在则更新该商品的数量个价格，否则加入购物车
        if ( OldCartItem== null){
            cartItem.setCount(1);
            cartItem.setTotalPrice(cartItem.getPrice());
            cartItemService.addCartItem(cartItem);
            int totalCount = cartItemService.getTotalCount(member.getId());//得到商品总数
            resp.sendRedirect(req.getContextPath()+"/index.jsp?totalCount="+totalCount);//返回请求前的页面
        }else {
            cartItem.setCount(OldCartItem.getCount()+1);
            cartItem.setTotalPrice(OldCartItem.getPrice().multiply(new BigDecimal(OldCartItem.getCount()+1)));
            cartItemService.updateCartItemByMemberIdAndBookId(cartItem);
            int totalCount = cartItemService.getTotalCount(member.getId());//得到商品总数
            resp.sendRedirect(req.getContextPath()+"/index.jsp?totalCount="+totalCount);//返回请求前的页面
        }
    }
    protected void showCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Member member = (Member)req.getSession().getAttribute("member");
        Cart cart = new Cart();
        List<CartItem> cartItems = cartItemService.queryAllCartItemByMemberId(member.getId());
        cart.setItems(cartItems);
        cart.setTotalCount(cartItemService.getTotalCount(member.getId()));
        cart.setSumPrice(cartItemService.getSumPrice(member.getId()));
        req.setAttribute("cart",cart);
        req.getRequestDispatcher("/views/cart/cart.jsp").forward(req,resp);
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bookId = DataUtils.parseInt(req.getParameter("bookId"), 0);
        int count = DataUtils.parseInt(req.getParameter("count"), 0);
        Member member = (Member)req.getSession().getAttribute("member");
        CartItem cartItem = cartItemService.queryCartItemByMemberIdAndBookId(member.getId(), bookId);
        cartItem.setCount(count);
        cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(count)));
        cartItemService.updateCartItemByMemberIdAndBookId(cartItem);
        resp.sendRedirect(req.getHeader("Referer"));//返回请求前的页面
    }

    protected void deleteAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Member member = (Member)req.getSession().getAttribute("member");
        cartItemService.deleteAllCartItemByMemberId(member.getId());
        resp.sendRedirect(req.getHeader("Referer"));//返回请求前的页面
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Member member = (Member)req.getSession().getAttribute("member");
        int bookId = DataUtils.parseInt(req.getParameter("bookId"), 0);
        cartItemService.deleteCartItemByMemberId(member.getId(), bookId);
        resp.sendRedirect(req.getHeader("Referer"));//返回请求前的页面
    }
}
