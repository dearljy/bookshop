package com.tjt.books.test;

import com.tjt.books.entity.Book;
import com.tjt.books.entity.Page;
import com.tjt.books.service.BookService;
import com.tjt.books.service.Impl.BookServiceImpl;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author tjt
 * @date 2022/5/21 15:48
 * @Version 1.0
 */
public class BookServiceImplTest {
    private BookService bookService = new BookServiceImpl();
    @Test
    public void add(){
        Book book = new Book(null, "如雪如山", "小梁", new BigDecimal(20.0), 30,
                70, "assets/images/product-image/s14.jpg");
        boolean b = bookService.addBook(book);
        System.out.println(b);

    }
    @Test
    public void showBook(){
        Book book = bookService.queryBookById(1);
        System.out.println(book);
    }
    @Test
    public void modify(){
        Book book = new Book(1, "荒野上的大师", "张泉", new BigDecimal(20.0), 20, 20, "assets/images/product-image/6.jpg");
        boolean b = bookService.modifyBook(book);
        System.out.println(b);
    }
    @Test
    public void delete(){
        boolean b = bookService.deleteBook(27);
        System.out.println(b);
    }
    @Test
    public void page(){
        Page<Book> page = bookService.page(1, 5);
        System.out.println(page);
        List<Book> lists = page.getItems();
        for (Book list : lists) {
            System.out.println(list);
        }
    }
    @Test
    public void getPageByName(){
        Page page = bookService.getPageByName(1, 4, "");
        System.out.println(page);
    }
}
