package com.web.service;

import com.web.entity.Book;
import com.web.entity.Borrow;
import com.web.entity.Student;
import com.web.entity.TableResult;

import java.util.List;
import java.util.Map;

public interface BookService {

    List<Borrow> getBorrowList();

    List<Student> getStudentList();

    void addBorrow(Integer sid, Integer bid);

    void returnBook(Integer id);

    List<Book> getActiveBookList();

    // -----------------------------------------------------------------------------------------------------------------

    Map<Book, Boolean> getBookList();

    void deleteBook(Integer bid);

    void addBook(String title, String content, Double price);

    int CountBook();

    int CountBorrow();

}
