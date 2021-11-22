package com.olivine.mybatis.service.impl;

import com.github.pagehelper.PageHelper;
import com.olivine.mybatis.domain.UserDO;
import com.olivine.mybatis.dto.User;
import com.olivine.mybatis.mapper.UserMapper;
import com.olivine.mybatis.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author jphao
 * @Date 14:29 2021/11/15
 * @Description
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> getAll() {
        // 分页
        // PageHelper.startPage(1, 10);
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

    @Override
    public List<User> getAllByPageNumSize(int pageNum, int pageSize) {

        final List<UserDO> userDOList = userMapper.quaryAllByPageNumSize(pageNum, pageSize);

        final List<User> users = userDOList.parallelStream().map(userDO -> {
            User user = new User();
            BeanUtils.copyProperties(userDO, user);
            return user;
        }).collect(Collectors.toList());

        return users;
    }
}
