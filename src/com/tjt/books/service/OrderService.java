package com.tjt.books.service;

import com.tjt.books.entity.Order;
import com.tjt.books.entity.OrderItem;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author tjt
 * @date 2022/8/2 10:13
 * @Version 1.0
 */
public interface OrderService {
    public String saveOrder(Integer MemberId);

    public List<Order> getAllOrderByMemberId(Integer memberId);

    public List<OrderItem> queryAllOrderItemByOrderId(String orderId);

    public  BigDecimal getOrderPrice(List<OrderItem> orderItemList);

    public Integer getOrderItemCount(List<OrderItem> orderItemList);

}
