package com.web.service;

import jakarta.servlet.http.HttpSession;

public interface UserService {

    boolean auth(String username, String password, HttpSession Session);

}
