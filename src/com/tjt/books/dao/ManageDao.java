package com.tjt.books.dao;

import com.tjt.books.entity.Book;
import com.tjt.books.entity.Manage;

/**
 * @Author tjt
 * @date 2022/5/21 9:12
 * @Version 1.0
 */
public interface ManageDao {
    public Manage queryManageByUsernameAndPassword(String username, String password);
}
