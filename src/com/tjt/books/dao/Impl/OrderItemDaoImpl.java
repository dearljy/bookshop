package com.tjt.books.dao.Impl;

import com.tjt.books.dao.BasicDAO;
import com.tjt.books.dao.OrderItemDao;
import com.tjt.books.entity.OrderItem;

import java.util.List;

/**
 * @Author tjt
 * @date 2022/8/2 16:16
 * @Version 1.0
 */
public class OrderItemDaoImpl extends BasicDAO<OrderItem> implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "INSERT into `order_item`(`id`,`name`,`price`,`count`,`total_price`,`order_id`)" +
                " VALUES(null,?,?,?,?,?);";
        int i = update(sql, orderItem.getName(), orderItem.getPrice(), orderItem.getCount(), orderItem.getTotal_price()
                , orderItem.getOrderId());
        return i;
    }

    @Override
    public List<OrderItem> queryAllOrderItemByOrderId(String orderId) {
        String sql = "select `id`,`name`,`price`,`count`,`total_price` from `order_item` " +
                        "where `order_id` = ?";
        List<OrderItem> orderItemList = queryMulti(sql, OrderItem.class, orderId);
        return orderItemList;
    }
}
