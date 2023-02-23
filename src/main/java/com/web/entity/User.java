package com.web.entity;

import lombok.Data;

/**
 * @author YXS
 * @PackageName: com.web.entity
 * @ClassName: User
 * @Desription:
 * @date 2023/2/16 11:44
 */
@Data
public class User {

    Integer id;
    String name;
    String role;
    String password;

}
