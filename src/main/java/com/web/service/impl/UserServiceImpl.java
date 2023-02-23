package com.web.service.impl;

import com.web.dao.UserMapper;
import com.web.entity.User;
import com.web.service.UserService;
import com.web.utils.MybatisUtil;
import jakarta.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSession;

/**
 * @author YXS
 * @PackageName: com.web.servlet.impl
 * @ClassName: UserServiceImpl
 * @Desription:
 * @date 2023/2/16 14:26
 */
public class UserServiceImpl implements UserService {

    @Override
    public boolean auth(String username, String password, HttpSession Session) {

        try (SqlSession sqlSession = MybatisUtil.getSession(true)) {
             UserMapper mapper = sqlSession.getMapper(UserMapper.class);
             User user = mapper.getUser(username, password);
             if (user == null) return false;
             Session.setAttribute("user", user); return true;
        }

    }

}
