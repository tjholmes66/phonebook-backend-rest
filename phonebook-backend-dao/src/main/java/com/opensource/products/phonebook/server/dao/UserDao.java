package com.opensource.products.phonebook.server.dao;

import java.util.List;

import com.opensource.products.phonebook.server.domain.UserEntity;

public interface UserDao
{
    // CREATE
    public UserEntity createUserEntity(UserEntity userEntity);

    // RETRIEVE
    public UserEntity getUserEntity(long id);

    public List<UserEntity> getAllUserEntitys();

    public List<UserEntity> getUsersEntity(UserEntity exampleEntity);

    public UserEntity getUserEntityByLogin(String username, String password);

    UserEntity getUserEntityByEmail(String email);

    UserEntity getUserEntityByUsername(String username);

    // UPDATE
    public UserEntity updateUserEntity(UserEntity userEntity);

    // DELETE
    public void deleteUserEntity(long userId);

    public void deleteUserEntity(UserEntity user);

}
