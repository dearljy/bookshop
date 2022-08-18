package com.tjt.books.service.Impl;

import com.tjt.books.dao.Impl.ManageDaoImpl;
import com.tjt.books.dao.ManageDao;
import com.tjt.books.dao.MemberDao;
import com.tjt.books.entity.Book;
import com.tjt.books.entity.Manage;
import com.tjt.books.service.ManageService;

import java.util.List;

/**
 * @Author tjt
 * @date 2022/5/21 10:00
 * @Version 1.0
 */
public class ManageServiceImpl implements ManageService{
    private ManageDao manageDao = new ManageDaoImpl();
    @Override
    public Manage queryManageByUsernameAndPassword(String username, String password) {
        return manageDao.queryManageByUsernameAndPassword(username,password);
    }



}
