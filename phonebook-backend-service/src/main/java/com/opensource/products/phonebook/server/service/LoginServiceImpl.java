package com.opensource.products.phonebook.server.service;

import java.util.List;

import com.opensource.products.phonebook.server.dto.LoginDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.opensource.products.phonebook.server.dao.UserDao;
import com.opensource.products.phonebook.server.domain.UserEntity;

@Transactional
@Service("loginService")
public class LoginServiceImpl implements LoginService
{
    private UserDao userDao;

    public LoginServiceImpl(UserDao userDao)
    {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public UserEntity login(LoginDTO loginDto)
    {
        String username = loginDto.getUsername();
        String password = loginDto.getPassword();
        List<UserEntity> userEntitys = userDao.getUserEntityByLogin(username, password);
        UserEntity userEntity = null;
        if (userEntitys != null && userEntitys.size() > 0)
        {
            userEntity = userEntitys.get(0);
        }
        return userEntity;
    }

    @Override
    @Transactional
    public UserEntity login(String username, String password)
    {
        List<UserEntity> userEntitys = userDao.getUserEntityByLogin(username, password);
        UserEntity userEntity = null;
        if (userEntitys != null && userEntitys.size() > 0)
        {
            userEntity = userEntitys.get(0);
        }
        return userEntity;
    }

    @Override
    @Transactional
    public UserEntity loginByEmail(String email)
    {
        List<UserEntity> userEntitys = userDao.getUserEntityByEmail(email);
        UserEntity userEntity = null;
        if (userEntitys != null && userEntitys.size() > 0)
        {
            userEntity = userEntitys.get(0);
        }
        return userEntity;
    }

    @Override
    @Transactional
    public UserEntity loginByUsername(String username)
    {
        List<UserEntity> userEntitys = userDao.getUserEntityByUsername(username);
        UserEntity userEntity = null;
        if (userEntitys != null && userEntitys.size() > 0)
        {
            userEntity = userEntitys.get(0);
        }
        return userEntity;
    }

}
