package com.tjt.books.dao.Impl;

import com.sun.org.apache.xpath.internal.operations.Or;
import com.tjt.books.dao.BasicDAO;
import com.tjt.books.dao.OrderDao;
import com.tjt.books.entity.Order;

import java.util.List;

/**
 * @Author tjt
 * @date 2022/8/2 9:57
 * @Version 1.0
 */
public class OrderDaoImpl extends BasicDAO<Order> implements OrderDao {
    @Override
    public int saveOrder(Order order) {
        String sql = "insert into `order`(id,create_time,price,state,memberId) values(?,?,?,?,?)";
        int i = update(sql, order.getId(), order.getCreateTime(), order.getPrice(), order.getState(), order.getMemberId());
        return i;
    }

    @Override
    public List<Order> getAllOrderByMemberId(Integer memberId) {
        String sql = "select `id`,`create_time` createTime,`price`,`state` from `order` where memberId = ?";
        return queryMulti(sql,Order.class,memberId);
    }
}
