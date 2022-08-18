package com.tjt.books.dao.Impl;

import com.tjt.books.dao.BasicDAO;
import com.tjt.books.dao.BookDao;
import com.tjt.books.entity.Book;
import com.tjt.books.entity.Page;

import java.util.List;

/**
 * @Author tjt
 * @date 2022/5/21 11:36
 * @Version 1.0
 */
public class BookDaoImpl extends BasicDAO<Book> implements BookDao {
    @Override
    public List<Book> queryAllBook() {
        String sql = "select id,name,author,price,sales,stock,img_path imgPath from book";
        return queryMulti(sql,Book.class);
    }

    @Override
    public int addBook(Book book) {
        String sql = "insert into book(id,name,author,price,sales,stock,img_path) values(null,?,?,?,?,?,?)";
        return update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),
                book.getImgPath());
    }

    @Override
    public Book queryBookById(int id) {
        String sql = "select id,name,author,price,sales,stock,img_path imgPath from book where id = ?";
        return querySingle(sql,Book.class,id);

    }

    @Override
    public int modifyBook(Book book) {
        String sql = "update book set name = ?,author = ?,price= ?,sales = ?,stock = ?,img_path = ? where id = ?";
        return update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),
                book.getImgPath(),book.getId());
    }

    @Override
    public int deleteBookById(int id) {
        String sql = "delete from book where id = ?";
        return update(sql,id);

    }

    @Override
    public int pageRow() {
        String sql = "select count(*) from book";
        Object o = queryScalar(sql);
        //因为这里Object 对应的是long型，不能直接用Integer转，需要用基本包装类型的父类来强转
        return ((Number)o).intValue();

    }

    @Override
    public List<Book> getPageList(int begin, int value) {
        //limit：数据可分页函数，表示从第一个问号开始，查询[第二个问号]个数据,数据不够多时，就只查询存在的，从0开始计数
        String sql = "select id,name,author,price,sales,stock,img_path imgPath from book limit ?,?";
        List<Book> bookList = queryMulti(sql, Book.class, begin, value);
        return bookList;
    }

    @Override
    public int getPageRowByName(String name) {
        //迷糊查询（关键词查询）
        String sql = "select count(*) from book where name LIKE ?";
        Object o = queryScalar(sql, "%" + name + "%");
        return ((Number)o).intValue();
    }

    @Override
    public List<Book> getBookListByName(int begin, int value, String name) {
        String sql = "select id,name,author,price,sales,stock,img_path imgPath from book where name LIKE ? limit ?,?";
        return queryMulti(sql,Book.class,"%" + name + "%",begin,value);
    }
}
