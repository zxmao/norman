package com.junxiong.norman.web;

import com.junxiong.norman.dto.UserDTO;
import com.junxiong.norman.service.UserService;
import com.junxiong.norman.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangjunxiong
 * @since 2017/7/27
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/{id}")
    public Object getUserInfo(@PathVariable(name = "id")Long id){
        return userService.getUser(id);
    }

    @RequestMapping(value = "/user/list")
    public Page<UserDTO.Summary> getAllUserInfo(UserRepo.Condition condition, Pageable pageable){
        return userService.findAllUser(condition,pageable);
    }

    @RequestMapping(value = "/user/save")
    public Object saveUserInfo(UserDTO.AddUser addUser){
        return userService.saveUser(addUser);
    }

    @RequestMapping(value = "/city/{id}")
    public Object saveUserInfo(@PathVariable(name = "id")Long id){
        return userService.findCityById(id);
    }
}
