package com.opensource.products.phonebook.server.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.opensource.products.phonebook.server.domain.ContactEntity;
import com.opensource.products.phonebook.server.domain.UserEntity;


@Repository("contactDao")
public class ContactDaoImpl implements ContactDao
{
    @Autowired
    private SessionFactory sessionFactory;

    private static final Log logger = LogFactory.getLog(ContactDaoImpl.class);

    public void setSessionFactory(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public ContactEntity createContactEntity(ContactEntity contactEntity)
    {
        this.sessionFactory.getCurrentSession().save(contactEntity);
        this.sessionFactory.getCurrentSession().flush();
        this.sessionFactory.getCurrentSession().refresh(contactEntity);
        return contactEntity;
    }

    @Override
    public ContactEntity updateContactEntity(ContactEntity contactEntity)
    {
        this.sessionFactory.getCurrentSession().update(contactEntity);
        this.sessionFactory.getCurrentSession().flush();
        this.sessionFactory.getCurrentSession().refresh(contactEntity);
        return contactEntity;
    }

    @Override
    public void deleteContactEntity(long contactId)
    {
        ContactEntity contactEntity = new ContactEntity();
        contactEntity.setContactId(contactId);
        this.sessionFactory.getCurrentSession().delete(contactEntity);
    }

    @Override
    public void deleteContactEntity(ContactEntity contactEntity)
    {
        this.sessionFactory.getCurrentSession().delete(contactEntity);
    }

    @Override
    public List<ContactEntity> getAllContactEntitys()
    {
        String queryString = "from ContactEntity";
        List<ContactEntity> users = this.sessionFactory.getCurrentSession().createQuery(queryString).list();
        return users;
    }

    @Override
    public ContactEntity getContactEntity(long id)
    {
        return (ContactEntity) this.sessionFactory.getCurrentSession().get(ContactEntity.class, id);
    }

    @Override
    public List<ContactEntity> getContactEntity(ContactEntity exampleEntity)
    {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(ContactEntity.class);
        List<ContactEntity> users = criteria.list();
        return users;
    }

    @Override
    public List<ContactEntity> getContactEntityByUser(UserEntity exampleEntity)
    {
        Query query =
            this.sessionFactory.getCurrentSession().createQuery("from ContactEntity ce where ce.user = :user");
        query.setParameter("user", exampleEntity);
        List<ContactEntity> contacts = query.list();
        return contacts;
    }

}
