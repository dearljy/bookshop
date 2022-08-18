package com.tjt.books.service;

import com.tjt.books.entity.Book;
import com.tjt.books.entity.Page;

import java.util.List;

/**
 * @Author tjt
 * @date 2022/5/21 11:56
 * @Version 1.0
 */
public interface BookService {

    /**
     * 查询所有的书籍信息
     * @return
     */
    public List<Book> queryAllBook();

    /**
     * 添加书籍
     * @param book
     * @return
     */
    public boolean addBook(Book book);
    public Book queryBookById(int id);

    /**
     * 修改书籍信息
     * @param book
     * @return
     */
    public boolean modifyBook(Book book);

    /**
     * 删除书籍
     * @param id
     * @return
     */
    public boolean deleteBook(int id);

    /**
     * 通过传入页码和每页的记录数，构造page对象，并返回
     * @param pageNo
     * @param pageSize
     * @return
     */
    public Page page(int pageNo,int pageSize);

    /**
     * 根据pageNo，pageSize,name，查询page信息
     * @param pageNo 页码
     * @param pageSize 每页的记录数
     * @param name 书籍名
     * @return 返回分页信息
     */
    public Page getPageByName(int pageNo,int pageSize,String name);
}
