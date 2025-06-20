package com.opensource.products.phonebook.server.service;

import com.opensource.products.phonebook.server.domain.UserEntity;
import com.opensource.products.phonebook.server.dto.LoginDTO;

public interface LoginService
{
    UserEntity login(LoginDTO loginDto);

    UserEntity login(String username, String password);

    UserEntity loginByEmail(String email);

    UserEntity loginByUsername(String username);
}
