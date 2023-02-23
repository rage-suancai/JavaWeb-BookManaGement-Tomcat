package com.web.dao;

import com.web.entity.Book;
import com.web.entity.Borrow;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author YXS
 * @PackageName: com.web.dao
 * @ClassName: BookMapper
 * @Desription:
 * @date 2023/2/17 16:25
 */
public interface BookMapper {

    @Select("select bid,title,content,price from book") // 查询书籍信息
    List<Book> getBookList();

    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "bid", property = "book_id"),
            @Result(column = "title", property = "book_name"),
            @Result(column = "time", property = "time"),
            @Result(column = "name", property = "student_name"),
            @Result(column = "sid", property = "student_id")
    })
    @Select("select * from borrow,student,book where borrow.bid = book.bid and student.sid = borrow.sid") // 映射借阅信息
    List<Borrow> getBorrowList();

    @Insert("insert into borrow(bid,sid,time) values(#{bid}, #{sid}, NOW())") // 增加书籍借阅信息
    void addBorrow(@Param("sid") int sid, @Param("bid") int bid);

    @Delete("delete from borrow where id = #{id}") // 删除借阅信息
    void deleteBorrow(Integer id);

    // -----------------------------------------------------------------------------------------------------------------

    @Insert("insert into book(title,content,price) values(#{title}, #{content}, #{price})") // 添加书籍信息
    void addBook(@Param("title") String title, @Param("content") String content, @Param("price") Double price);

    @Delete("delete from book where bid = #{bid}") // 删除书籍信息
    void deleteBook(Integer bid);

    @Select("select count(title) from book") // 书籍数量统计
    int CountBook();

    @Select("select count(*) from borrow") // 借阅数量统计
    int CountBorrow();

}
