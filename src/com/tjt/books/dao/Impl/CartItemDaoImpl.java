package com.tjt.books.dao.Impl;

import com.tjt.books.dao.BasicDAO;
import com.tjt.books.dao.CartItemDao;
import com.tjt.books.entity.CartItem;

import java.util.List;

/**
 * @Author tjt
 * @date 2022/5/28 14:49
 * @Version 1.0
 */
public class CartItemDaoImpl extends BasicDAO<CartItem> implements CartItemDao {
    @Override
    public int addCartItem(CartItem cartItem) {
        String sql = "insert into cart_item(memberId,bookId,name,price,count,totalPrice) values(?,?,?,?,?,?)";
        return update(sql,cartItem.getMemberId(),cartItem.getBookId(),cartItem.getName(),cartItem.getPrice()
                ,cartItem.getCount(),cartItem.getTotalPrice());
    }

    @Override
    public CartItem queryCartItemByMemberIdAndBookId(int memberId, int bookId) {
        String sql = "select memberId,bookId,name,price,count,totalPrice from cart_item where memberId = ? and bookId = ?";
        return querySingle(sql,CartItem.class,memberId,bookId);

    }

    @Override
    public int updateCartItemByMemberIdAndBookId(CartItem cartItem) {
        String sql = "update cart_item set count= ?,totalPrice = ? where memberId = ? and bookId = ?";
        return update(sql,cartItem.getCount(),cartItem.getTotalPrice(),cartItem.getMemberId(),cartItem.getBookId());
    }

    @Override
    public List<CartItem> queryAllCartItemByMemberId(int memberId) {
        String sql = "select memberId,bookId,name,price,count,totalPrice from cart_item where memberId=?";
        return queryMulti(sql,CartItem.class,memberId);
    }

    @Override
    public int deleteAllCartItemByMemberId(int memberId) {
        String sql = "delete from cart_item where memberId = ?";
        return update(sql,memberId);
    }

    @Override
    public int deleteCartItemByMemberId(int memberId,int bookId) {
        String sql = "delete from cart_item where memberId = ? and bookId = ?";
        return update(sql,memberId,bookId);
    }
}
