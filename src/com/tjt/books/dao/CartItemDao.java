package com.tjt.books.dao;

import com.tjt.books.entity.CartItem;

import java.util.List;

/**
 * @Author tjt
 * @date 2022/5/28 14:49
 * @Version 1.0
 */
public interface CartItemDao {
    /**
     * 添加一个CartItem到数据库中
     * @param cartItem
     * @return
     */
    public int addCartItem(CartItem cartItem);

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
    public int updateCartItemByMemberIdAndBookId(CartItem cartItem);

    /**
     * 查询用户所有的购物车的物品
     * @param memberId
     * @return
     */
    public List<CartItem> queryAllCartItemByMemberId(int memberId);

    /**
     * 根据用户id删除所有的cartItem
     * @param memberId
     * @return
     */
    public int deleteAllCartItemByMemberId(int memberId);

    /**
     * 根据用户id和memberId删除的cartItem
     * @param memberId
     * @return
     */
    public int deleteCartItemByMemberId(int memberId,int bookId);
}
