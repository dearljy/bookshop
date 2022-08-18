package com.tjt.books.web;

import com.tjt.books.entity.CartItem;
import com.tjt.books.entity.Member;
import com.tjt.books.entity.Order;
import com.tjt.books.entity.OrderItem;
import com.tjt.books.service.CartItemService;
import com.tjt.books.service.Impl.CartItemServiceImpl;
import com.tjt.books.service.Impl.OrderServiceImpl;
import com.tjt.books.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Author tjt
 * @date 2022/8/2 17:53
 * @Version 1.0
 */
@WebServlet("/orderServlet")
public class OrderServlet extends BasicServlet{
    private OrderService orderService = new OrderServiceImpl();
    private CartItemService cartItemService = new CartItemServiceImpl();

    protected void saveOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Member member = (Member) session.getAttribute("member");
        if (member == null){//说明用户未登录，则跳转到登录界面
            req.getRequestDispatcher("/views/member/login.jsp").forward(req,resp);
            return;
        }
        Integer memberId = member.getId();
        List<CartItem> cartItems = cartItemService.queryAllCartItemByMemberId(memberId);
        if (cartItems.size() == 0){//说明购物车无商品，则不需要结账
            req.getRequestDispatcher("/index.jsp").forward(req,resp);//返回首页
            return;
        }
        String orderId = orderService.saveOrder(memberId);
        //生成订单后，将购物车物品清空
        cartItemService.deleteAllCartItemByMemberId(memberId);
//        req.setAttribute("orderId",orderId);
        //防止刷新重复请求，用重定向
        resp.sendRedirect(req.getContextPath()+"/views/order/checkout.jsp?orderId="+orderId+"&username="+member.getUsername());
//        req.getRequestDispatcher("/views/order/checkout.jsp").forward(req,resp);
    }

    protected void queryAllOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Member member = (Member) session.getAttribute("member");
        List<Order> orderList = orderService.getAllOrderByMemberId(member.getId());
        req.setAttribute("orderList",orderList);
//        resp.sendRedirect(req.getContextPath()+"/views/order/order.jsp");
        req.getRequestDispatcher("/views/order/order.jsp").forward(req,resp);
    }

    protected void queryAllOrderItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        List<OrderItem> orderItems = orderService.queryAllOrderItemByOrderId(orderId);
        BigDecimal totalPrice = orderService.getOrderPrice(orderItems);
        Integer totalCount = orderService.getOrderItemCount(orderItems);
        req.setAttribute("totalPrice",totalPrice);
        req.setAttribute("totalCount",totalCount);
        req.setAttribute("orderItems",orderItems);
        req.getRequestDispatcher("/views/order/order_detail.jsp").forward(req,resp);
    }
}
