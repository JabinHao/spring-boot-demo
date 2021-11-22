package com.olivine.mybatis.controller;

import com.olivine.mybatis.dto.User;
import com.olivine.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/get/page", method = RequestMethod.GET)
    public List<User> getUsers(@RequestParam("page_num") Integer pageNum,
                               @RequestParam("page_size") Integer pageSize){
        return userService.getAllByPageNumSize(pageNum, pageSize);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void saveUser(@RequestBody User user){
        userService.saveUser(user);
    }
}
