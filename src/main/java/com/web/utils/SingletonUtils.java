package com.web.utils;

import com.web.service.BookService;
import com.web.service.StudentService;
import com.web.service.impl.BookServiceImpl;
import com.web.service.impl.StudentServiceImpl;

/**
 * @author YXS
 * @PackageName: com.web.utils
 * @ClassName: SingletonUtils
 * @Desription:
 * @date 2023/2/22 15:16
 */
public class SingletonUtils {

    private static class SingletonHolder {

        private static final BookService BOOK_SERVICE = new BookServiceImpl();
        private static final StudentService STUDENT_SERVICE = new StudentServiceImpl();

    }

    public static final BookService getBookServiceSingleton() {

        return SingletonHolder.BOOK_SERVICE;

    }

    public static final StudentService getStudentServiceSingleton() {

        return SingletonHolder.STUDENT_SERVICE;

    }

}
