package com.tjt.books.service;

import com.tjt.books.entity.CartItem;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author tjt
 * @date 2022/5/28 15:11
 * @Version 1.0
 */
public interface CartItemService {

    public boolean addCartItem(CartItem cartItem);

    /**
     * 查询是否存在，memberId bookId可以唯一标识一条记录
     * @param memberId
     * @param bookId
     * @return
     */
    public CartItem queryCartItemByMemberIdAndBookId(int memberId,int bookId);

    /**
     * 更新cartItem
     * @param cartItem
     * @return
     */
    public boolean updateCartItemByMemberIdAndBookId(CartItem cartItem);

    /**
     * 查询用户所有的购物车的物品
     * @param memberId
     * @return
     */
    public List<CartItem> queryAllCartItemByMemberId(int memberId);

    /**
     * 得到购物车热商品的总件数
     * @param memberId
     * @return
     */
    public int getTotalCount(int memberId);

    /**
     * 得到购物车热商品的总价钱
     * @param memberId
     * @return
     */
    public BigDecimal getSumPrice(int memberId);

    /**
     * 根据用户id删除cartItem
     * @param memberId
     * @return
     */
    public boolean deleteAllCartItemByMemberId(int memberId);

    /**
     * 根据用户id和memberId删除的cartItem
     * @param memberId
     * @return
     */
    public boolean deleteCartItemByMemberId(int memberId,int bookId);
}
