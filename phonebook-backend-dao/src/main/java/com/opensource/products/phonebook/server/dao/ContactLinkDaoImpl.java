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
import com.opensource.products.phonebook.server.domain.ContactLinkEntity;

@Repository("contactLinkDao")
public class ContactLinkDaoImpl implements ContactLinkDao
{

    @Autowired
    private SessionFactory sessionFactory;

    private static final Log logger = LogFactory.getLog(ContactDaoImpl.class);

    public void setSessionFactory(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public ContactLinkEntity createContactLinkEntity(ContactLinkEntity contactLink)
    {
        // this.getHibernateTemplate().saveOrUpdate(contactLink);
        this.sessionFactory.getCurrentSession().persist(contactLink);
        return contactLink;
    }

    @Override
    public ContactLinkEntity saveContactLinkEntity(ContactLinkEntity contactLink)
    {
        // this.getHibernateTemplate().saveOrUpdate(contact);
        this.sessionFactory.getCurrentSession().saveOrUpdate(contactLink);
        return contactLink;
    }

    @Override
    public ContactLinkEntity updateContactLinkEntity(ContactLinkEntity contactLink)
    {
        // this.getHibernateTemplate().saveOrUpdate(contact);
        this.sessionFactory.getCurrentSession().merge(contactLink);
        return contactLink;
    }

    @Override
    public void deleteContactLinkEntity(Long contactLinkId)
    {
        // this.getgetHibernateTemplate()().delete(interest);
    }

    @Override
    public void deleteContactLinkEntity(ContactLinkEntity contactLink)
    {
        this.sessionFactory.getCurrentSession().delete(contactLink);
    }

    @Override
    public List<ContactLinkEntity> getAllContactLinkEntitys()
    {
        String queryString = "from ContactLinkEntity";
        // List<ContactLinkEntity> users = this.getHibernateTemplate().find(queryString);
        List<ContactLinkEntity> users = this.sessionFactory.getCurrentSession().createQuery(queryString).list();
        return users;
    }

    @Override
    public ContactLinkEntity getContactLinkEntity(long id)
    {
        // return (ContactLinkEntity)this.getHibernateTemplate().get(ContactLinkEntity.class, id);
        return (ContactLinkEntity) this.sessionFactory.getCurrentSession().get(ContactLinkEntity.class, id);
    }

    @Override
    public List<ContactLinkEntity> getContactLinkEntity(ContactLinkEntity exampleEntity)
    {
        // List<ContactLinkEntity> users = this.getHibernateTemplate().findByExample(exampleEntity);
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(ContactLinkEntity.class);
        List<ContactLinkEntity> users = criteria.list();
        return users;
    }

    @Override
    public List<ContactLinkEntity> getContactLinkEntityByContact(ContactEntity exampleContactEntity)
    {
        Query query =
            this.sessionFactory.getCurrentSession().createQuery(
                "from ContactLinkEntity cpe where cpe.contact = :contact");
        query.setParameter("contact", exampleContactEntity);
        List<ContactLinkEntity> contactLinks = query.list();
        return contactLinks;
    }

    @Override
    public List<ContactLinkEntity> getContactLinkEntityByContactId(long contactId)
    {
        Query query =
            this.sessionFactory.getCurrentSession().createQuery(
                "from ContactLinkEntity cpe where cpe.contact.id = :contact");
        query.setParameter("contact", contactId);
        List<ContactLinkEntity> contactLinks = query.list();
        return contactLinks;
    }

}
