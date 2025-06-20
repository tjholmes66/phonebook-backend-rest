package com.opensource.products.phonebook.server.dao;

import java.util.List;

import com.opensource.products.phonebook.server.domain.ContactPhoneEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaQuery;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.opensource.products.phonebook.server.domain.EmailTypeEntity;

@Repository("emailTypeDao")
public class EmailTypeDaoImpl implements EmailTypeDao
{
    @PersistenceContext
    private EntityManager entityManager;

    private static final Log logger = LogFactory.getLog(EmailTypeDaoImpl.class);

    @Override
    public EmailTypeEntity saveEmailTypeEntity(EmailTypeEntity emailTypeEntity)
    {
        entityManager.persist(emailTypeEntity);
        entityManager.flush();
        entityManager.refresh(emailTypeEntity);
        return emailTypeEntity;
    }

    @Override
    public void deleteEmailTypeEntity(Long emailTypeId)
    {
        EmailTypeEntity emailTypeEntity = entityManager.find(EmailTypeEntity.class, emailTypeId);
        entityManager.remove(emailTypeEntity);
    }

    @Override
    public void deleteEmailTypeEntity(EmailTypeEntity emailTypeEntity)
    {
        entityManager.remove(emailTypeEntity);
    }

    @Override
    public List<EmailTypeEntity> getAllEmailTypeEntitys()
    {
        String queryString = "from EmailTypeEntity";
        List<EmailTypeEntity> emailTypeEntityList = entityManager.createQuery(queryString).getResultList();
        return emailTypeEntityList;
    }

    @Override
    public EmailTypeEntity getEmailTypeEntity(long id)
    {
        return (EmailTypeEntity) entityManager.find(EmailTypeEntity.class, id);
    }

    @Override
    public List<EmailTypeEntity> getEmailTypeEntity(EmailTypeEntity exampleEntity)
    {
        CriteriaQuery<EmailTypeEntity> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(EmailTypeEntity.class);
        List<EmailTypeEntity> emailTypeEntityList = entityManager.createQuery(criteriaQuery).getResultList();
        return emailTypeEntityList;
    }

}
