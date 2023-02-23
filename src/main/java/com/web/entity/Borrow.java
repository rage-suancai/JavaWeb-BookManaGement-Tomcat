package com.web.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author YXS
 * @PackageName: com.web.entity
 * @ClassName: Borrow
 * @Desription:
 * @date 2023/2/17 16:22
 */
@Data
public class Borrow {

    Integer id;
    Integer book_id;
    String book_name;
    Date time;
    String student_name;
    int student_id;

}
