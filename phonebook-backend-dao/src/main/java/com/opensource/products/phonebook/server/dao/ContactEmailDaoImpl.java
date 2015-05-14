package com.opensource.products.phonebook.server.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.opensource.products.phonebook.server.domain.ContactEmailEntity;
import com.opensource.products.phonebook.server.domain.ContactEntity;

@Repository("contactEmailDao")
public class ContactEmailDaoImpl implements ContactEmailDao
{

    @Autowired
    private SessionFactory sessionFactory;

    private static final Log logger = LogFactory.getLog(ContactDaoImpl.class);

    public void setSessionFactory(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public ContactEmailEntity createContactEmailEntity(ContactEmailEntity contactEmail)
    {
        // this.getHibernateTemplate().saveOrUpdate(contactEmail);
        this.sessionFactory.getCurrentSession().persist(contactEmail);
        return contactEmail;
    }

    @Override
    public ContactEmailEntity saveContactEmailEntity(ContactEmailEntity contactEmail)
    {
        // this.getHibernateTemplate().saveOrUpdate(contact);
        this.sessionFactory.getCurrentSession().saveOrUpdate(contactEmail);
        return contactEmail;
    }

    @Override
    public ContactEmailEntity updateContactEmailEntity(ContactEmailEntity contactEmail)
    {
        // this.getHibernateTemplate().saveOrUpdate(contact);
        this.sessionFactory.getCurrentSession().merge(contactEmail);
        return contactEmail;
    }

    @Override
    public void deleteContactEmailEntity(Long contactEmailId)
    {
        // this.getgetHibernateTemplate()().delete(interest);
    }

    @Override
    public void deleteContactEmailEntity(ContactEmailEntity contactEmail)
    {
        this.sessionFactory.getCurrentSession().delete(contactEmail);
    }

    @Override
    public List<ContactEmailEntity> getAllContactEmailEntitys()
    {
        String queryString = "from ContactEmailEntity";
        // List<ContactEmailEntity> users = this.getHibernateTemplate().find(queryString);
        List<ContactEmailEntity> users = this.sessionFactory.getCurrentSession().createQuery(queryString).list();
        return users;
    }

    @Override
    public ContactEmailEntity getContactEmailEntity(long id)
    {
        // return (ContactEmailEntity)this.getHibernateTemplate().get(ContactEmailEntity.class, id);
        return (ContactEmailEntity) this.sessionFactory.getCurrentSession().get(ContactEmailEntity.class, id);
    }

    @Override
    public List<ContactEmailEntity> getContactEmailEntity(ContactEmailEntity exampleEntity)
    {
        // List<ContactEmailEntity> users = this.getHibernateTemplate().findByExample(exampleEntity);
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(ContactEmailEntity.class);
        List<ContactEmailEntity> users = criteria.list();
        return users;
    }

    @Override
    public List<ContactEmailEntity> getContactEmailEntityByContact(ContactEntity exampleContactEntity)
    {
        Query query =
            this.sessionFactory.getCurrentSession().createQuery(
                "from ContactEmailEntity cpe where cpe.contact = :contact");
        query.setParameter("contact", exampleContactEntity);
        List<ContactEmailEntity> contactEmails = query.list();
        return contactEmails;
    }

    @Override
    public List<ContactEmailEntity> getContactEmailEntityByContactId(long contactId)
    {
        Query query =
            this.sessionFactory.getCurrentSession().createQuery(
                "from ContactEmailEntity cpe where cpe.contact.id = :contact");
        query.setParameter("contact", contactId);
        List<ContactEmailEntity> contactEmails = query.list();
        return contactEmails;
    }

}
