package com.opensource.products.phonebook.server.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.opensource.products.phonebook.server.domain.UserEntity;

@Repository("userDao")
public class UserDaoImpl implements UserDao
{
    private static final Log logger = LogFactory.getLog(UserDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public UserEntity createUserEntity(UserEntity userEntity)
    {
        this.sessionFactory.getCurrentSession().save(userEntity);
        this.sessionFactory.getCurrentSession().flush();
        this.sessionFactory.getCurrentSession().refresh(userEntity);
        return userEntity;
    }

    @Override
    public UserEntity updateUserEntity(UserEntity userEntity)
    {
        this.sessionFactory.getCurrentSession().update(userEntity);
        this.sessionFactory.getCurrentSession().flush();
        this.sessionFactory.getCurrentSession().refresh(userEntity);
        return userEntity;
    }

    @Override
    public void deleteUserEntity(long userId)
    {
        // UserEntity deleteUser = (UserEntity) this.sessionFactory.getCurrentSession().get(UserEntity.class, userId);
        // deleteUserEntity(deleteUser);
    }

    @Override
    public void deleteUserEntity(UserEntity user)
    {
        // this.sessionFactory.getCurrentSession().delete(user);
    }

    @Override
    public List<UserEntity> getAllUserEntitys()
    {
        String queryString = "from UserEntity";
        // List<UserEntity> users = this.getHibernateTemplate().find(queryString);
        List<UserEntity> users = this.sessionFactory.getCurrentSession().createQuery(queryString).list();
        return users;
    }

    @Override
    public UserEntity getUserEntity(long userId)
    {
        return (UserEntity) this.sessionFactory.getCurrentSession().get(UserEntity.class, userId);
    }

    @Override
    public List<UserEntity> getUsersEntity(UserEntity exampleEntity)
    {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(UserEntity.class);
        List<UserEntity> users = criteria.list();
        return users;
    }

    @Override
    public List<UserEntity> getUserEntityByLogin(String username, String password)
    {
        List<UserEntity> users =
            this.sessionFactory.getCurrentSession()
            .createQuery("from UserEntity users where users.username=? and users.password=?").setParameter(0, username)
            .setParameter(1, password).list();

        return users;
    }

    @Override
    public List<UserEntity> getUserEntityByEmail(String email)
    {
        List<UserEntity> users =
            this.sessionFactory.getCurrentSession().createQuery("from UserEntity users where users.email=?")
            .setParameter(0, email).list();

        return users;
    }

    @Override
    public List<UserEntity> getUserEntityByUsername(String username)
    {
        List<UserEntity> users =
            this.sessionFactory.getCurrentSession().createQuery("from UserEntity users where users.username=?")
            .setParameter(0, username).list();

        return users;
    }

}
