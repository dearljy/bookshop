package com.tjt.books.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author tjt
 * @date 2022/5/29 9:50
 * @Version 1.0
 */
public class Order {
    private String id;
    private Date createTime;
    private BigDecimal price;
    private Integer state;
    private Integer memberId;

    public Order() {
    }

    public Order(String id, Date createTime, BigDecimal price, Integer state, Integer memberId) {
        this.id = id;
        this.createTime = createTime;
        this.price = price;
        this.state = state;
        this.memberId = memberId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", DATETIME=" + createTime +
                ", price=" + price +
                ", state=" + state +
                ", memberId=" + memberId +
                '}';
    }
}
