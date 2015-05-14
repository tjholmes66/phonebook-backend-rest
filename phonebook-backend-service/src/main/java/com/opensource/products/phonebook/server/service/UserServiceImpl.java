package com.opensource.products.phonebook.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.opensource.products.phonebook.server.dao.UserDao;
import com.opensource.products.phonebook.server.domain.UserEntity;


@Transactional
@Service("userService")
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public List<UserEntity> getAllUsers()
    {
        List<UserEntity> userList = userDao.getAllUserEntitys();
        return userList;
    }

    @Override
    @Transactional
    public UserEntity getUserById(long userId)
    {
        UserEntity userEntity = userDao.getUserEntity(userId);
        return userEntity;
    }

    @Override
    @Transactional
    public UserEntity add(UserEntity newUser)
    {
        UserEntity userEntity = userDao.createUserEntity(newUser);
        return userEntity;
    }

    @Override
    @Transactional
    public void remove(UserEntity userEntity)
    {
        userDao.deleteUserEntity(userEntity.getUserId());
    }

    @Override
    @Transactional
    public void remove(long userId)
    {
        userDao.deleteUserEntity(userId);
    }

    @Override
    @Transactional
    public UserEntity update(UserEntity newUser)
    {
        UserEntity updatedUserEntity = userDao.updateUserEntity(newUser);
        return updatedUserEntity;
    }
}
