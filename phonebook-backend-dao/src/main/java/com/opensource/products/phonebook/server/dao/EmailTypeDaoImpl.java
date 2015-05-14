package com.opensource.products.phonebook.server.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.opensource.products.phonebook.server.domain.EmailTypeEntity;

@Repository("emailTypeDao")
public class EmailTypeDaoImpl implements EmailTypeDao
{

    @Autowired
    private SessionFactory sessionFactory;

    private static final Log logger = LogFactory.getLog(EmailTypeDaoImpl.class);

    public void setSessionFactory(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public EmailTypeEntity saveEmailTypeEntity(EmailTypeEntity emailType)
    {
        // this.getHibernateTemplate().saveOrUpdate(emailType);
        return emailType;
    }

    @Override
    public void deleteEmailTypeEntity(Long emailTypeId)
    {
        // this.getgetHibernateTemplate()().delete(interest);
    }

    @Override
    public void deleteEmailTypeEntity(EmailTypeEntity emailType)
    {
        // this.getHibernateTemplate().delete(emailType);
    }

    @Override
    public List<EmailTypeEntity> getAllEmailTypeEntitys()
    {
        String queryString = "from EmailTypeEntity";
        List<EmailTypeEntity> users = this.sessionFactory.getCurrentSession().createQuery(queryString).list();
        return users;
    }

    @Override
    public EmailTypeEntity getEmailTypeEntity(long id)
    {
        return (EmailTypeEntity) this.sessionFactory.getCurrentSession().get(EmailTypeEntity.class, id);
    }

    @Override
    public List<EmailTypeEntity> getEmailTypeEntity(EmailTypeEntity exampleEntity)
    {
        // List<EmailTypeEntity> users = this.getHibernateTemplate().findByExample(exampleEntity);
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(EmailTypeEntity.class);
        List<EmailTypeEntity> users = criteria.list();
        return users;
    }

}
