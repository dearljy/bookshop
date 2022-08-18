package com.tjt.books.dao.Impl;

import com.tjt.books.dao.BasicDAO;
import com.tjt.books.dao.ManageDao;
import com.tjt.books.entity.Book;
import com.tjt.books.entity.Manage;

/**
 * @Author tjt
 * @date 2022/5/21 9:50
 * @Version 1.0
 */
public class ManageDaoImpl extends BasicDAO<Manage> implements ManageDao {
    @Override
    public Manage queryManageByUsernameAndPassword(String username, String password) {
        String sql = "select id,username,password from manage where username=? and password = MD5(?)";
        return querySingle(sql,Manage.class,username,password);
    }
}
