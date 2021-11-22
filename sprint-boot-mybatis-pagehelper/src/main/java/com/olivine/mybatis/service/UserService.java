package com.olivine.mybatis.service;

import com.olivine.mybatis.dto.User;

import java.util.List;

/**
 * @Author jphao
 * @Date 14:29 2021/11/15
 * @Description
 */
public interface UserService {
    List<User> getAll();

    void saveUser(User user);

    List<User> getAllByPageNumSize(int pageNum, int pageSize);
}
