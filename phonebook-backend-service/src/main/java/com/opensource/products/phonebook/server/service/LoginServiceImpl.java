package com.opensource.products.phonebook.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.opensource.products.phonebook.server.dao.UserDao;
import com.opensource.products.phonebook.server.domain.UserEntity;

@Transactional
@Service("loginService")
public class LoginServiceImpl implements LoginService
{
    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public UserEntity login(String username, String password)
    {
        UserEntity userEntity = userDao.getUserEntityByLogin(username, password);
        return userEntity;
    }

    @Override
    @Transactional
    public UserEntity loginByEmail(String email)
    {
        UserEntity userEntity = userDao.getUserEntityByEmail(email);
        return userEntity;
    }

    @Override
    @Transactional
    public UserEntity loginByUsername(String username)
    {
        UserEntity userEntity = userDao.getUserEntityByUsername(username);
        return userEntity;
    }

}
