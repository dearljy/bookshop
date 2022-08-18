package com.tjt.books.dao;

import com.tjt.books.entity.Book;
import com.tjt.books.entity.Page;

import java.util.List;

/**
 * @Author tjt
 * @date 2022/5/21 11:35
 * @Version 1.0
 */
public interface BookDao {
    /**
     * 查询所有书籍
     * @return
     */
    public List<Book> queryAllBook();

    /**
     * 添加书籍
     * @param book
     * @return
     */
    public int addBook(Book book);

    /**
     * 通过id查询书籍
     * @param id
     * @return
     */
    public Book queryBookById(int id);

    /**
     * 修改书籍，传入一个将修改后的书籍对象，更新到数据库
     * @param book
     * @return
     */
    public int modifyBook(Book book);

    /**
     * 根据id删除书籍
     * @param id
     * @return
     */
    public int deleteBookById(int id);

    /**
     * 返回书籍总数
     * @return
     */
    public int pageRow();

    /**
     * 根据begin和value返回书籍信息
     * @param begin
     * @param value
     * @return
     */
    public List<Book> getPageList(int begin,int value);

    /**
     * 根据name查询所有书籍信息
     * @param name
     * @return
     */
    public int getPageRowByName(String name);

    /**
     * 根据begin，value，name来查询书籍信息
     * @param begin 页码
     * @param value 每页显示的记录数
     * @param name 书籍名
     * @return 符合条件的书籍信息
     */
    public List<Book> getBookListByName(int begin,int value,String name);
}
