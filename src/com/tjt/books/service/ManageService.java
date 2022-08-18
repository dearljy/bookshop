package com.tjt.books.service;

import com.tjt.books.entity.Book;
import com.tjt.books.entity.Manage;

import java.util.List;

/**
 * @Author tjt
 * @date 2022/5/21 9:58
 * @Version 1.0
 */
public interface ManageService {
    /**
     * 根据用户名密码，查询管理员是否存在
     * @param username
     * @param password
     * @return
     */
    public Manage queryManageByUsernameAndPassword(String username, String password);



}
