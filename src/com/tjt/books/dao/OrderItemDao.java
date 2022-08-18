package com.tjt.books.dao;

import com.tjt.books.entity.OrderItem;

import java.util.List;

/**
 * @Author tjt
 * @date 2022/8/2 16:15
 * @Version 1.0
 */
public interface OrderItemDao {
    public int saveOrderItem(OrderItem orderItem);
    public List<OrderItem> queryAllOrderItemByOrderId(String orderId);
}
