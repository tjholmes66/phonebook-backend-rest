package com.opensource.products.phonebook.server.service;

import com.opensource.products.phonebook.server.domain.UserEntity;

public interface LoginService
{
    UserEntity login(String username, String password);

    UserEntity loginByEmail(String email);

    UserEntity loginByUsername(String username);
}
