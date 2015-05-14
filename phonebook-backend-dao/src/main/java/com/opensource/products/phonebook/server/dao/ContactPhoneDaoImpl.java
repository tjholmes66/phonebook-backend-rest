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
import com.opensource.products.phonebook.server.domain.ContactPhoneEntity;

@Repository("contactPhoneDao")
public class ContactPhoneDaoImpl implements ContactPhoneDao
{

    @Autowired
    private SessionFactory sessionFactory;

    private static final Log logger = LogFactory.getLog(ContactDaoImpl.class);

    public void setSessionFactory(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public ContactPhoneEntity createContactPhoneEntity(ContactPhoneEntity contactPhone)
    {
        // this.getHibernateTemplate().saveOrUpdate(contactPhone);
        this.sessionFactory.getCurrentSession().persist(contactPhone);
        return contactPhone;
    }

    @Override
    public ContactPhoneEntity saveContactPhoneEntity(ContactPhoneEntity contactPhone)
    {
        // this.getHibernateTemplate().saveOrUpdate(contact);
        this.sessionFactory.getCurrentSession().saveOrUpdate(contactPhone);
        return contactPhone;
    }

    @Override
    public ContactPhoneEntity updateContactPhoneEntity(ContactPhoneEntity contactPhone)
    {
        // this.getHibernateTemplate().saveOrUpdate(contact);
        this.sessionFactory.getCurrentSession().merge(contactPhone);
        return contactPhone;
    }

    @Override
    public void deleteContactPhoneEntity(Long contactPhoneId)
    {
        // this.getgetHibernateTemplate()().delete(interest);
    }

    @Override
    public void deleteContactPhoneEntity(ContactPhoneEntity contactPhone)
    {
        this.sessionFactory.getCurrentSession().delete(contactPhone);
    }

    @Override
    public List<ContactPhoneEntity> getAllContactPhoneEntitys()
    {
        String queryString = "from ContactPhoneEntity";
        // List<ContactPhoneEntity> users = this.getHibernateTemplate().find(queryString);
        List<ContactPhoneEntity> users = this.sessionFactory.getCurrentSession().createQuery(queryString).list();
        return users;
    }

    @Override
    public ContactPhoneEntity getContactPhoneEntity(long id)
    {
        // return (ContactPhoneEntity)this.getHibernateTemplate().get(ContactPhoneEntity.class, id);
        return (ContactPhoneEntity) this.sessionFactory.getCurrentSession().get(ContactPhoneEntity.class, id);
    }

    @Override
    public List<ContactPhoneEntity> getContactPhoneEntity(ContactPhoneEntity exampleEntity)
    {
        // List<ContactPhoneEntity> users = this.getHibernateTemplate().findByExample(exampleEntity);
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(ContactPhoneEntity.class);
        List<ContactPhoneEntity> users = criteria.list();
        return users;
    }

    @Override
    public List<ContactPhoneEntity> getContactPhoneEntityByContact(ContactEntity exampleContactEntity)
    {
        Query query =
            this.sessionFactory.getCurrentSession().createQuery(
                "from ContactPhoneEntity cpe where cpe.contact = :contact");
        query.setParameter("contact", exampleContactEntity);
        List<ContactPhoneEntity> contactPhones = query.list();
        return contactPhones;
    }

    @Override
    public List<ContactPhoneEntity> getContactPhoneEntityByContactId(long contactId)
    {
        Query query =
            this.sessionFactory.getCurrentSession().createQuery(
                "from ContactPhoneEntity cpe where cpe.contact.id = :contact");
        query.setParameter("contact", contactId);
        List<ContactPhoneEntity> contactPhones = query.list();
        return contactPhones;
    }

}
