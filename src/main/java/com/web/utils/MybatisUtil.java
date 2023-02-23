package com.web.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author YXS
 * @PackageName: com.web.utils
 * @ClassName: MybatisUtils
 * @Desription:
 * @date 2023/2/16 10:59
 */
public class MybatisUtil {

    private static SqlSessionFactory factory;

    static {

        try {
            factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static SqlSession getSession(boolean autoCommit){

        return factory.openSession(autoCommit);

    }

}
