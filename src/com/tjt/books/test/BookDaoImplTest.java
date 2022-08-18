package com.tjt.books.test;

import com.tjt.books.dao.BookDao;
import com.tjt.books.dao.Impl.BookDaoImpl;
import com.tjt.books.entity.Book;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @Author tjt
 * @date 2022/5/21 11:52
 * @Version 1.0
 */
public class BookDaoImplTest {

    private BookDao bookDao = new BookDaoImpl();
    @Test
    public void queryBooks(){
        List<Book> books = bookDao.queryAllBook();
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
