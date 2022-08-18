package com.tjt.books.service.Impl;

import com.tjt.books.dao.BookDao;
import com.tjt.books.dao.CartItemDao;
import com.tjt.books.dao.Impl.BookDaoImpl;
import com.tjt.books.dao.Impl.CartItemDaoImpl;
import com.tjt.books.dao.Impl.OrderDaoImpl;
import com.tjt.books.dao.Impl.OrderItemDaoImpl;
import com.tjt.books.dao.OrderDao;
import com.tjt.books.dao.OrderItemDao;
import com.tjt.books.entity.Book;
import com.tjt.books.entity.CartItem;
import com.tjt.books.entity.Order;
import com.tjt.books.entity.OrderItem;
import com.tjt.books.service.OrderService;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @Author tjt
 * @date 2022/8/2 10:13
 * @Version 1.0
 */
@SuppressWarnings({"all"})//抑制警告
public class OrderServiceImpl implements OrderService {
    private CartItemDao cartItemDao = new CartItemDaoImpl();
    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private BookDao bookDao = new BookDaoImpl();
    @Override
    public String saveOrder(Integer memberId) {
        OrderItem orderItem = null;
        //得到该会员购物车的所有物品信息
        List<CartItem> cartItems = cartItemDao.queryAllCartItemByMemberId(memberId);
        BigDecimal price = new BigDecimal(0);
        String id = System.currentTimeMillis()+""+memberId;//生成uuid订单号，保证唯一
        for (CartItem cartItem : cartItems) {//遍历cartItem 构建 orderItem对象
            orderItem = new OrderItem();//将购物车中的每个商品单独封装成一个订单项
            orderItem.setName(cartItem.getName());
            orderItem.setCount(cartItem.getCount());
            orderItem.setPrice(cartItem.getPrice());
            orderItem.setTotal_price(cartItem.getTotalPrice());
            orderItem.setOrderId(id);
            orderItemDao.saveOrderItem(orderItem);//生成订单项，保存到数据库

            //更新book表
            int bookId = cartItem.getBookId();
            Book book = bookDao.queryBookById(bookId);//根据bookId得到book对象
            book.setSales(book.getSales()+cartItem.getCount());
            book.setStock(book.getStock()-cartItem.getCount());
            bookDao.modifyBook(book);//修改book表，销量+1,库存减1

            price = cartItem.getTotalPrice().add(price);//得到商品总价格，即订单总价格
        }
        Order order = new Order();//生成order对象
        order.setId(id);
        order.setCreateTime(new Date());
        order.setPrice(price);
        order.setState(0);
        order.setMemberId(memberId);
        orderDao.saveOrder(order);//生成订单，保存到数据库
        return id;
    }

    @Override
    public List<Order> getAllOrderByMemberId(Integer memberId) {
        return orderDao.getAllOrderByMemberId(memberId);
    }

    @Override
    public List<OrderItem> queryAllOrderItemByOrderId(String orderId) {
        return orderItemDao.queryAllOrderItemByOrderId(orderId);
    }

    @Override
    public BigDecimal getOrderPrice(List<OrderItem> orderItemList) {
        BigDecimal totalPrice = new BigDecimal(0);
        for (OrderItem orderItem : orderItemList) {
            totalPrice = totalPrice.add(orderItem.getTotal_price());
        }
        return totalPrice;
    }

    @Override
    public Integer getOrderItemCount(List<OrderItem> orderItemList) {
        int totalCount = 0;
        for (OrderItem orderItem : orderItemList) {
            totalCount+=orderItem.getCount();
        }
        return totalCount;
    }
}
