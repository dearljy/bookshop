package com.tjt.books.entity;

import java.math.BigDecimal;

/**
 * @Author tjt
 * @date 2022/5/28 14:40
 * @Version 1.0
 */
public class CartItem {
    private Integer memberId;
    private Integer bookId;
    private String name;
    private BigDecimal price;
    private Integer count;
    private BigDecimal totalPrice;

    public CartItem() {
    }

    public CartItem(Integer memberId, Integer bookId, String name, BigDecimal price, Integer count, BigDecimal totalPrice) {
        this.memberId = memberId;
        this.bookId = bookId;
        this.name = name;
        this.price = price;
        this.count = count;
        this.totalPrice = totalPrice;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
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

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "memberId=" + memberId +
                ", bookId=" + bookId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
