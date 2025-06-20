package com.opensource.products.phonebook.server.rest;

import com.opensource.products.phonebook.server.domain.UserEntity;
import com.opensource.products.phonebook.server.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/users")
@CrossOrigin(origins = "*")
public class RestUserController
{
    private UserService userService;

    public RestUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "", headers = "Accept=application/json")
    public List<UserEntity> getUserList1()
    {
        List<UserEntity> userEntityList = userService.getAllUsers();
        return userEntityList;
    }

    @GetMapping(value = "/", headers = "Accept=application/json")
    public @ResponseBody List<UserEntity> getUserList2()
    {
        List<UserEntity> userEntityList = userService.getAllUsers();
        return userEntityList;
    }

    @GetMapping(value = "/userId/{userId}", headers = "Accept=application/json")
    public @ResponseBody UserEntity getUserById(@PathVariable("userId") long userId)
    {
        UserEntity userEntity = userService.getUserById(userId);
        System.out.println("UserController: retrieveUser: userEntity=" + userEntity);
        return userEntity;
    }

    @PostMapping(value = "/create", produces = "application/json", headers = "content-type=application/json")
    public @ResponseBody UserEntity createUser(@RequestBody UserEntity user)
    {
        System.out.println("UserController: createUser: user=" + user);
        UserEntity userEntity = userService.add(user);
        return userEntity;
    }

    @PutMapping(value = "/update", produces = "application/json", headers = "content-type=application/json")
    public @ResponseBody UserEntity updateUser(@RequestBody UserEntity user)
    {
        System.out.println("UserController: START: updateUser: user=" + user);
        UserEntity userEntity = userService.update(user);
        System.out.println("UserController: FINISH: updateUser: userEntity=" + userEntity);
        return userEntity;
    }

    @DeleteMapping(value = "/delete/{userId}",  headers = "Accept=application/json")
    public @ResponseBody void deleteUser(@PathVariable("userId") long userId)
    {
        System.out.println("UserController: START: deleteUser: userId=" + userId);
        userService.remove(userId);
        System.out.println("UserController: FINISH: deleteUser:");
    }
}
