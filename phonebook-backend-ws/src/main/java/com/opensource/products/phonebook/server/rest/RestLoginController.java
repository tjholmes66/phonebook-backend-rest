package com.opensource.products.phonebook.server.rest;

import com.opensource.products.phonebook.server.domain.UserEntity;
import com.opensource.products.phonebook.server.dto.LoginDTO;
import com.opensource.products.phonebook.server.service.LoginService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/login")
@CrossOrigin(origins = "*")
public class RestLoginController
{
    private LoginService loginService;

    public RestLoginController(LoginService service)
    {
        this.loginService = service;
    }

    @PostMapping(value = "", produces = "application/json", headers = "content-type=application/json")
    public UserEntity login(@RequestBody LoginDTO loginDto)
    {
        System.out.println("RestLoginController: login: loginDto=" + loginDto);
        UserEntity userEntity = loginService.login(loginDto);
        System.out.println("RestLoginController: login: user=" + userEntity);
        return (userEntity == null ? new UserEntity() : userEntity);
    }

}
