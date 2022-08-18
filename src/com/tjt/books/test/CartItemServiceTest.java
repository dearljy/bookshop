package com.tjt.books.test;

import com.tjt.books.entity.Cart;
import com.tjt.books.entity.CartItem;
import com.tjt.books.service.CartItemService;
import com.tjt.books.service.Impl.CartItemServiceImpl;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author tjt
 * @date 2022/5/28 15:48
 * @Version 1.0
 */
public class CartItemServiceTest {
    private CartItemService cartItemService = new CartItemServiceImpl();
    @Test
    public void add(){
        CartItem cartItem = new CartItem(1, 2, "导演", new BigDecimal(180), 1, new BigDecimal(180));
        boolean b = cartItemService.addCartItem(cartItem);
        System.out.println(b);

    }
    @Test
    public void update(){
        CartItem cartItem = new CartItem(1, 2, "导演", new BigDecimal(180), 2, new BigDecimal(360));
        boolean b = cartItemService.updateCartItemByMemberIdAndBookId(cartItem);
        System.out.println(b);
    }
    @Test
    public void cart(){
        Cart cart = new Cart();
        List<CartItem> cartItems = cartItemService.queryAllCartItemByMemberId(8);
        cart.setItems(cartItems);
        cart.setTotalCount(cartItemService.getTotalCount(8));
        cart.setSumPrice(cartItemService.getSumPrice(8));
        System.out.println(cart);
    }
}
