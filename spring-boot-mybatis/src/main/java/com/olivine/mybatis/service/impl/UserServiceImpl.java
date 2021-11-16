package com.olivine.mybatis.service.impl;

import com.olivine.mybatis.entity.domain.UserDO;
import com.olivine.mybatis.entity.vo.User;
import com.olivine.mybatis.mapper.UserMapper;
import com.olivine.mybatis.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author jphao
 * @Date 14:29 2021/11/15
 * @Description
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAll() {
        List<UserDO> userDOs = userMapper.quaryAll();
        List<User> res = new ArrayList<>();
        for (UserDO userDO : userDOs) {
            User user = new User();
            BeanUtils.copyProperties(userDO, user);
            res.add(user);
        }
        return res;
    }

    @Override
    public void saveUser(User user) {
        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(user, userDO);
        int insert = userMapper.insert(userDO);
    }
}
