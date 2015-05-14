package com.opensource.products.phonebook.server.service;

import java.util.List;

import com.opensource.products.phonebook.server.domain.UserEntity;

public interface UserService
{
    public List<UserEntity> getAllUsers();

    UserEntity getUserById(long userId);

    UserEntity add(UserEntity userEntity);

    void remove(UserEntity record);

    UserEntity update(UserEntity userEntity);

    void remove(long userId);
}
