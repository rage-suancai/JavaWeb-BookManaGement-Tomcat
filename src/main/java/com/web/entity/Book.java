package com.web.entity;

import lombok.Data;

/**
 * @author YXS
 * @PackageName: com.web.entity
 * @ClassName: Book
 * @Desription:
 * @date 2023/2/20 11:18
 */
@Data
public class Book {

    Integer bid;
    String title;
    String content;
    Double price;

}
