package com.opensource.products.phonebook.server.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaQuery;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.opensource.products.phonebook.server.domain.UserEntity;

@Repository("userDao")
public class UserDaoImpl implements UserDao
{
    private static final Log logger = LogFactory.getLog(UserDaoImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public UserEntity createUserEntity(UserEntity userEntity)
    {
        entityManager.persist(userEntity);
        entityManager.flush();
        entityManager.refresh(userEntity);
        return userEntity;
    }

    @Override
    public UserEntity updateUserEntity(UserEntity userEntity)
    {
        entityManager.persist(userEntity);
        entityManager.flush();
        entityManager.refresh(userEntity);
        return userEntity;
    }

    @Override
    public void deleteUserEntity(long userId)
    {
        UserEntity userEntity = entityManager.find(UserEntity.class, userId);
        entityManager.remove(userEntity);
    }

    @Override
    public void deleteUserEntity(UserEntity userEntity)
    {
        entityManager.remove(userEntity);
    }

    @Override
    public List<UserEntity> getAllUserEntitys()
    {
        String queryString = "from UserEntity";
        // List<UserEntity> users = this.getHibernateTemplate().find(queryString);
        List<UserEntity> users = entityManager.createQuery(queryString).getResultList();
        return users;
    }

    @Override
    public UserEntity getUserEntity(long userId)
    {
        return (UserEntity) entityManager.find(UserEntity.class, userId);
    }

    @Override
    public List<UserEntity> getUsersEntity(UserEntity exampleEntity)
    {
        CriteriaQuery criteriaQuery = entityManager.getCriteriaBuilder().createQuery(UserEntity.class);
        List<UserEntity> users = criteriaQuery.getOrderList();
        return users;
    }

    @Override
    public List<UserEntity> getUserEntityByLogin(String username, String password)
    {
        List<UserEntity> users =
            entityManager
            .createQuery("from UserEntity users where users.username=:username and users.password=:password")
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .getResultList();
        return users;
    }

    @Override
    public List getUserEntityByEmail(String email)
    {
        List userEntityList;
        userEntityList = entityManager.createQuery("from UserEntity users where users.email=:email")
                .setParameter("email", email)
                .getResultList();
        return userEntityList;
    }

    @Override
    public List<UserEntity> getUserEntityByUsername(String username)
    {
        List<UserEntity> users =
            entityManager.createQuery("from UserEntity users where users.username=:username")
                .setParameter("username", username)
                    .getResultList();
        return users;
    }

}
