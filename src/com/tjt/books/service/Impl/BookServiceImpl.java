package com.tjt.books.service.Impl;

import com.tjt.books.dao.BookDao;
import com.tjt.books.dao.Impl.BookDaoImpl;
import com.tjt.books.entity.Book;
import com.tjt.books.entity.Page;
import com.tjt.books.service.BookService;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author tjt
 * @date 2022/5/21 11:56
 * @Version 1.0
 */
public class BookServiceImpl implements BookService {
    private BookDao bookDao = new BookDaoImpl();
    @Override
    public List<Book> queryAllBook() {
        return bookDao.queryAllBook();
    }

    @Override
    public boolean addBook(Book book) {
        int i = bookDao.addBook(book);
        return i>0;
    }

    @Override
    public Book queryBookById(int id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public boolean modifyBook(Book book) {
        int i = bookDao.modifyBook(book);
        return i>0;
    }

    @Override
    public boolean deleteBook(int id) {
        int i = bookDao.deleteBookById(id);
        return i>0;
    }

    @Override
    public Page page(int pageNo, int pageSize) {
        Page<Book> page = new Page<>();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        int pageRow = bookDao.pageRow();
        page.setTotalRow(pageRow);
        //总记录数/每页显示的记录数，再向上取整，得到总页数
        page.setTotalPage((int)(Math.ceil((double)pageRow/pageSize)));
        List<Book> pageList = bookDao.getPageList((pageNo - 1) * pageSize, pageSize);
        page.setItems(pageList);
        return page;
    }

    @Override
    public Page getPageByName(int pageNo, int pageSize, String name) {
        Page<Book> page = new Page<>();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        int pageRow = bookDao.getPageRowByName(name);//得到书名等于name的总记录数
        page.setTotalRow(pageRow);
        int pageTotal = (int) Math.ceil((double) pageRow / pageSize);//得到总页数
        page.setTotalPage(pageTotal);
        List<Book> bookList = bookDao.getBookListByName((pageNo - 1) * pageSize, pageSize, name);
        page.setItems(bookList);
        return page;
    }
}
