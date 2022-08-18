package com.tjt.books.dao;

import com.tjt.books.entity.Order;

import java.util.List;

/**
 * @Author tjt
 * @date 2022/8/2 10:01
 * @Version 1.0
 */
public interface OrderDao {
    public int saveOrder(Order order);
    public List<Order> getAllOrderByMemberId(Integer memberId);
}
