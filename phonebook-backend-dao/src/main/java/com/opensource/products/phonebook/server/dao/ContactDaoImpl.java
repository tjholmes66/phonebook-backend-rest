package com.opensource.products.phonebook.server.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaQuery;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.opensource.products.phonebook.server.domain.ContactEntity;
import com.opensource.products.phonebook.server.domain.UserEntity;

@Repository("contactDao")
public class ContactDaoImpl implements ContactDao
{
    @PersistenceContext
    private EntityManager entityManager;

    private static final Log logger = LogFactory.getLog(ContactDaoImpl.class);

    @Override
    public ContactEntity createContactEntity(ContactEntity contactEntity)
    {
        entityManager.persist(contactEntity);
        entityManager.flush();
        entityManager.refresh(contactEntity);
        return contactEntity;
    }

    @Override
    public ContactEntity updateContactEntity(ContactEntity contactEntity)
    {
        entityManager.persist(contactEntity);
        entityManager.flush();
        entityManager.refresh(contactEntity);
        return contactEntity;
    }

    @Override
    public void deleteContactEntity(long contactId)
    {
        ContactEntity contactEntity = entityManager.find(ContactEntity.class, contactId);
        entityManager.remove(contactEntity);
    }

    @Override
    public void deleteContactEntity(ContactEntity contactEntity)
    {
        entityManager.remove(contactEntity);
    }

    @Override
    public List<ContactEntity> getAllContactEntitys()
    {
        String queryString = "from ContactEntity";
        List<ContactEntity> contactEntityList;
        contactEntityList = entityManager.createQuery(queryString).getResultList();
        return contactEntityList;
    }

    @Override
    public ContactEntity getContactEntity(long id)
    {
        return (ContactEntity) entityManager.find(ContactEntity.class, id);
    }

    @Override
    public List<ContactEntity> getContactEntity(ContactEntity exampleEntity)
    {
        CriteriaQuery criteriaQuery = entityManager.getCriteriaBuilder().createQuery(ContactEntity.class);
        List<ContactEntity> contactEntityList;
        contactEntityList = entityManager.createQuery(criteriaQuery).getResultList();
        return contactEntityList;
    }

    @Override
    public List<ContactEntity> getContactEntityByUser(UserEntity exampleEntity)
    {
        Query query =
            entityManager.createQuery("from ContactEntity ce where ce.user = :user");
        query.setParameter("user", exampleEntity);
        List<ContactEntity> contactEntityList = query.getResultList();
        return contactEntityList;
    }

}
