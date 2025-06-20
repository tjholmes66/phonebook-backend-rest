package com.opensource.products.phonebook.server.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.*;

import com.opensource.products.phonebook.server.domain.UserEntity;
import com.opensource.products.phonebook.server.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController
{
    private final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    private UserService userService;

    public UserController(UserService userService)
    {
        this.userService = userService;
    }
    
    @RequestMapping(value = "", method = RequestMethod.GET, headers = "Accept=application/json")
    public ArrayList<UserEntity> getUserList()
    {
        System.out.println("UserController: getUserList: START");
        ArrayList<UserEntity> userEntityList = (ArrayList) userService.getAllUsers();
        return userEntityList;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, headers = "Accept=application/json")
    public ArrayList<UserEntity> getAllUsers()
    {
        System.out.println("UserController: getAllUsers: START");
        ArrayList<UserEntity> userEntityList = (ArrayList) userService.getAllUsers();
        return userEntityList;
    }

    @RequestMapping(value = "/userId/{userId}", method = RequestMethod.GET, headers = "Accept=application/json",
        produces = "application/json")
    public UserEntity getUserById(@PathVariable("userId") long userId)
    {
        System.out.println("UserController: getUserById: userId=" + userId);
        UserEntity userEntity = userService.getUserById(userId);
        System.out.println("UserController: getUserById: userEntity=" + userEntity);
        return userEntity;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json",
        headers = "content-type=application/json")
    public UserEntity createUser(@RequestBody UserEntity user)
    {
        System.out.println("UserController: createUser: user=" + user);
        UserEntity userEntity = userService.add(user);
        System.out.println("UserController: createUser: userDto=" + userEntity);
        return userEntity;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json",
        headers = "content-type=application/json")
    public UserEntity updateUser(@RequestBody UserEntity user)
    {
        System.out.println("UserController: START: updateUser: user=" + user);
        UserEntity userEntity = userService.update(user);
        System.out.println("UserController: FINISH: updateUser: userEntity=" + userEntity);
        return userEntity;
    }

    @RequestMapping(value = "/delete/{userId}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public
    void deleteUser(@PathVariable("userId") long userId)
    {
        userService.remove(userId);
    }

}