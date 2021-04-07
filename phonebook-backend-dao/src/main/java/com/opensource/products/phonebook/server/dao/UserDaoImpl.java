package com.opensource.products.phonebook.server.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
    public UserEntity getUserEntityByLogin(String username, String password)
    {
        Query query = this.sessionFactory.getCurrentSession().createQuery("from UserEntity u where (u.username = :username) and (u.password = :password)");
        query.setParameter("username", username);
        query.setParameter("password", password);
        UserEntity userEntity = (UserEntity) query.uniqueResult();
        return userEntity;
    }

    @Override
    public UserEntity getUserEntityByUsername(String username)
    {
        Query query = this.sessionFactory.getCurrentSession().createQuery("from UserEntity u where (u.username = :username)");
        query.setParameter("username", username);
        UserEntity userEntity = (UserEntity) query.uniqueResult();
        return userEntity;
    }

    @Override
    public UserEntity getUserEntityByEmail(String email)
    {
        Query query = this.sessionFactory.getCurrentSession().createQuery("from UserEntity u where (u.email = :email)");
        query.setParameter("email", email);
        UserEntity userEntity = (UserEntity) query.uniqueResult();
        return userEntity;
    }

}
