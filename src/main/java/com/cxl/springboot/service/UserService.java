package com.cxl.springboot.service;

import com.cxl.springboot.model.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUser();
    public int update();

}
