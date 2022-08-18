package com.tjt.books.entity;

import java.math.BigDecimal;

/**
 * @Author tjt
 * @date 2022/8/2 16:12
 * @Version 1.0
 */
public class OrderItem {

    private Integer id;
    private String name;
    private BigDecimal price;
    private Integer count;
    private BigDecimal total_price;
    private String orderId;

    public OrderItem() {
    }

    public OrderItem(Integer id, String name, BigDecimal price, Integer count, BigDecimal total_price, String orderId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.count = count;
        this.total_price = total_price;
        this.orderId = orderId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getTotal_price() {
        return total_price;
    }

    public void setTotal_price(BigDecimal total_price) {
        this.total_price = total_price;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", total_price=" + total_price +
                ", orderId='" + orderId + '\'' +
                '}';
    }
}
