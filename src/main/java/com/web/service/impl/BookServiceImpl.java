package com.web.service.impl;

import com.web.dao.BookMapper;
import com.web.dao.StudentMapper;
import com.web.entity.Book;
import com.web.entity.Borrow;
import com.web.entity.Student;
import com.web.service.BookService;
import com.web.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author YXS
 * @PackageName: com.web.service.impl
 * @ClassName: BookServiceImpl
 * @Desription:
 * @date 2023/2/17 17:28
 */
public class BookServiceImpl implements BookService {

    SqlSession sqlSession = MybatisUtil.getSession(true);
    BookMapper mapper;

    @Override
    public List<Borrow> getBorrowList() {

        mapper = sqlSession.getMapper(BookMapper.class);
        return mapper.getBorrowList();

    }

    @Override
    public List<Student> getStudentList() {

        try (SqlSession sqlSession = MybatisUtil.getSession(true)) {
             StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

             return mapper.getStudentList();
        }

    }

    @Override
    public void addBorrow(Integer sid, Integer bid) {

        mapper.addBorrow(sid, bid);

    }

    @Override
    public void returnBook(Integer id) {

        mapper.deleteBorrow(id);

    }

    @Override
    public List<Book> getActiveBookList() {

        Set<Integer> set = new HashSet<>();
        this.getBorrowList().forEach(borrow -> set.add(borrow.getBook_id()));

        return mapper.getBookList()
                    .stream()
                    .filter(book -> !set.contains(book.getBid()))
                    .collect(Collectors.toList());

    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public Map<Book, Boolean> getBookList() {

        Set<Integer> set = new HashSet<>();
        Map<Book, Boolean> map = new LinkedHashMap<>();
        this.getBorrowList().forEach(borrow -> set.add(borrow.getBook_id()));

        mapper.getBookList().forEach(book -> map.put(book, set.contains(book.getBid())));
        return map;

    }

    @Override
    public void deleteBook(Integer bid) {

        mapper.deleteBook(bid);

    }

    @Override
    public void addBook(String title, String content, Double price) {

        mapper.addBook(title, content, price);

    }

    @Override
    public int CountBook() {

        return mapper.CountBook();

    }

    @Override
    public int CountBorrow() {

        return mapper.CountBorrow();

    }

}
