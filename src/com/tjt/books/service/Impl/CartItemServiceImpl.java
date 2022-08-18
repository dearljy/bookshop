package com.tjt.books.service.Impl;

import com.tjt.books.dao.CartItemDao;
import com.tjt.books.dao.Impl.CartItemDaoImpl;
import com.tjt.books.entity.CartItem;
import com.tjt.books.service.CartItemService;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author tjt
 * @date 2022/5/28 15:11
 * @Version 1.0
 */
public class CartItemServiceImpl implements CartItemService {
    private CartItemDao cartItemDao = new CartItemDaoImpl();
    @Override
    public boolean addCartItem(CartItem cartItem) {
        return cartItemDao.addCartItem(cartItem) > 0;
    }

    @Override
    public CartItem queryCartItemByMemberIdAndBookId(int memberId, int bookId) {
        return cartItemDao.queryCartItemByMemberIdAndBookId(memberId,bookId);
    }

    @Override
    public boolean updateCartItemByMemberIdAndBookId(CartItem cartItem) {
        return cartItemDao.updateCartItemByMemberIdAndBookId(cartItem) >0;
    }

    @Override
    public List<CartItem> queryAllCartItemByMemberId(int memberId) {
        return cartItemDao.queryAllCartItemByMemberId(memberId);
    }

    @Override
    public int getTotalCount(int memberId) {
        List<CartItem> cartItems = queryAllCartItemByMemberId(memberId);
        int totalCount = 0;
        if (cartItems.size()!=0){
            for (CartItem cartItem : cartItems) {
                totalCount+=cartItem.getCount();
            }
        }
        return totalCount;
    }

    @Override
    public BigDecimal getSumPrice(int memberId) {
        List<CartItem> cartItems = queryAllCartItemByMemberId(memberId);
        BigDecimal sumPrice = new BigDecimal(0);
        if (cartItems.size()!=0){
            for (CartItem cartItem : cartItems) {
                sumPrice = sumPrice.add(cartItem.getTotalPrice());
            }
        }
        return sumPrice;
    }

    @Override
    public boolean deleteAllCartItemByMemberId(int memberId) {
        return cartItemDao.deleteAllCartItemByMemberId(memberId)>0;
    }

    @Override
    public boolean deleteCartItemByMemberId(int memberId, int bookId) {
        return cartItemDao.deleteCartItemByMemberId(memberId,bookId)>0;
    }
}
