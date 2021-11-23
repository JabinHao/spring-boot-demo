package com.olivine.mybatis.controller;

import com.olivine.mybatis.entity.domain.UserDO;
import com.olivine.mybatis.entity.vo.User;
import com.olivine.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author jphao
 * @Date 14:29 2021/11/15
 * @Description
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public List<User> getUsers(){
        return userService.getAll();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void saveUser(@RequestBody User user){
        userService.saveUser(user);
    }
}
