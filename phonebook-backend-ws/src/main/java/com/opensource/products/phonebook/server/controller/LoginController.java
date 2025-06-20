package com.opensource.products.phonebook.server.controller;

import java.text.SimpleDateFormat;
import org.springframework.web.bind.annotation.*;

import com.opensource.products.phonebook.server.domain.UserEntity;
import com.opensource.products.phonebook.server.service.LoginService;
import com.opensource.products.phonebook.server.util.SendEmailService;

@RestController
@RequestMapping("/login")
public class LoginController
{
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-MM");

    private LoginService loginService;
    private SendEmailService emailService;

    public LoginController(LoginService loginService, SendEmailService emailService)
    {
        this.loginService = loginService;
        this.emailService = emailService;
    }

    @RequestMapping(value = "/user/{username}/pwd/{password}", method = RequestMethod.GET, headers = "Accept=application/json")
    public UserEntity login(@PathVariable("username") String username, @PathVariable("password") String password)
    {
        System.out.println("LoginController: login: START: username=" + username + " password=" + password);
        UserEntity userEntity = null;
        if (username != null && (password != null && !password.equals("null")))
        {
            userEntity = loginService.login(username, password);
        }
        else
        {
            userEntity = loginService.loginByUsername(username);
        }
        System.out.println("LoginController: login: FINISH: userEntity=" + userEntity);
        return userEntity;
    }

    @RequestMapping(value = "/email/{email:.*}", method = RequestMethod.GET, headers = "Accept=application/json")
    public UserEntity login(@PathVariable("email") String email)
    {
        System.out.println("LoginController: login: START: email=" + email);

        UserEntity userEntity = loginService.loginByEmail(email);

        if (userEntity != null)
        {
            String msgBody = "Found your username: " + userEntity.getUsername();

            // sendMail(String from, String to, String subject, String msg)

            // emailService.sendMail("phonebook_app@tomholmes.net", userEntity.getEmail(), "Phonebook App - Found Username", msgBody);
        }
        System.out.println("LoginController: login: FINISH: userEntity=" + userEntity);
        return userEntity;
    }

}
