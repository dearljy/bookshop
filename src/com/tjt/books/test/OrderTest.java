package com.tjt.books.test;

import com.tjt.books.dao.Impl.OrderItemDaoImpl;
import com.tjt.books.dao.OrderItemDao;
import com.tjt.books.entity.Order;
import com.tjt.books.entity.OrderItem;
import com.tjt.books.service.Impl.OrderServiceImpl;
import com.tjt.books.service.OrderService;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @Author tjt
 * @date 2022/8/2 10:36
 * @Version 1.0
 */
public class OrderTest {
    private OrderService orderService = new OrderServiceImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    @Test
    public void saveOrder(){
        String s = orderService.saveOrder(8);

        System.out.println(s);
    }
    @Test
    public void getAllOrderByMemberId(){
        List<Order> orderList = orderService.getAllOrderByMemberId(8);
        for (Order order : orderList) {
            System.out.println("order="+order);
        }
    }
    @Test
    public void queryAllOrderItemByOrderId(){
        List<OrderItem> orderItems = orderItemDao.queryAllOrderItemByOrderId("124342543654");
        for (OrderItem orderItem : orderItems) {
            System.out.println("orderItem="+orderItem);
        }

    }
}
