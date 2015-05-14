package com.opensource.products.phonebook.server.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.opensource.products.phonebook.server.domain.UserEntity;
import com.opensource.products.phonebook.server.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController
{
    private final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    private UserService service;
    
    @RequestMapping(value = "", method = RequestMethod.GET, headers = "Accept=application/json")
    public @ResponseBody
    ArrayList<UserEntity> getUserList()
    {
        System.out.println("UserController: getUserList: START");
        ArrayList<UserEntity> userEntityList = (ArrayList) service.getAllUsers();
        return userEntityList;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, headers = "Accept=application/json")
    public @ResponseBody
    ArrayList<UserEntity> getAllUsers()
    {
        System.out.println("UserController: getAllUsers: START");
        ArrayList<UserEntity> userEntityList = (ArrayList) service.getAllUsers();
        return userEntityList;
    }

    @RequestMapping(value = "/userId/{userId}", method = RequestMethod.GET, headers = "Accept=application/json",
        produces = "application/json")
    public @ResponseBody
    UserEntity getUserById(@PathVariable("userId") long userId)
    {
        System.out.println("UserController: getUserById: userId=" + userId);
        UserEntity userEntity = service.getUserById(userId);
        System.out.println("UserController: getUserById: userEntity=" + userEntity);
        return userEntity;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json",
        headers = "content-type=application/json")
    public @ResponseBody
    UserEntity createUser(@RequestBody UserEntity user)
    {
        System.out.println("UserController: createUser: user=" + user);
        UserEntity userEntity = service.add(user);
        System.out.println("UserController: createUser: userDto=" + userEntity);
        return userEntity;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json",
        headers = "content-type=application/json")
    public @ResponseBody
    UserEntity updateUser(@RequestBody UserEntity user)
    {
        System.out.println("UserController: START: updateUser: user=" + user);
        UserEntity userEntity = service.update(user);
        System.out.println("UserController: FINISH: updateUser: userEntity=" + userEntity);
        return userEntity;
    }

    @RequestMapping(value = "/delete/{userId}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public @ResponseBody
    void deleteUser(@PathVariable("userId") long userId)
    {
        service.remove(userId);
    }

}