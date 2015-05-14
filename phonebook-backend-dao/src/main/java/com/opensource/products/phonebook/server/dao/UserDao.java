package com.opensource.products.phonebook.server.dao;

import java.util.List;

import com.opensource.products.phonebook.server.domain.UserEntity;

public interface UserDao
{
    public UserEntity createUserEntity(UserEntity userEntity);

    public UserEntity updateUserEntity(UserEntity userEntity);

    public void deleteUserEntity(long userId);

    public void deleteUserEntity(UserEntity user);

    public List<UserEntity> getAllUserEntitys();

    // Retrieve
    public UserEntity getUserEntity(long id);

    public List<UserEntity> getUsersEntity(UserEntity exampleEntity);

    public List<UserEntity> getUserEntityByLogin(String username, String password);

    List<UserEntity> getUserEntityByEmail(String email);

    List<UserEntity> getUserEntityByUsername(String username);

}
