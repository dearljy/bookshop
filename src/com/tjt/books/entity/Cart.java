package com.tjt.books.entity;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author tjt
 * @date 2022/5/28 16:35
 * @Version 1.0
 */
public class Cart {
    private List<CartItem> items;
    private int totalCount;
    private BigDecimal sumPrice;

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public BigDecimal getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(BigDecimal sumPrice) {
        this.sumPrice = sumPrice;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "items=" + items +
                ", totalCount=" + totalCount +
                ", sumPrice=" + sumPrice +
                '}';
    }
}
