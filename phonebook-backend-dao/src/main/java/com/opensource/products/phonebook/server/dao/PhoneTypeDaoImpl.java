package com.opensource.products.phonebook.server.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.opensource.products.phonebook.server.domain.PhoneTypeEntity;

@Repository("phoneTypeDao")
public class PhoneTypeDaoImpl implements PhoneTypeDao
{
    @Autowired
    private SessionFactory sessionFactory;

    private static final Log logger = LogFactory.getLog(PhoneTypeDaoImpl.class);

    public void setSessionFactory(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public PhoneTypeEntity savePhoneTypeEntity(PhoneTypeEntity phoneType)
    {
        return phoneType;
    }

    @Override
    public void deletePhoneTypeEntity(Long phoneTypeId)
    {
        // this.getgetHibernateTemplate()().delete(interest);
    }

    @Override
    public void deletePhoneTypeEntity(PhoneTypeEntity phoneType)
    {
        // this.getHibernateTemplate().delete(phoneType);
    }

    @Override
    public List<PhoneTypeEntity> getAllPhoneTypeEntitys()
    {
        String queryString = "from PhoneTypeEntity";
        // List<PhoneTypeEntity> users = this.getHibernateTemplate().find(queryString);
        List<PhoneTypeEntity> users = this.sessionFactory.getCurrentSession().createQuery(queryString).list();
        return users;
    }

    @Override
    public PhoneTypeEntity getPhoneTypeEntity(long id)
    {
        // return (PhoneTypeEntity)this.getHibernateTemplate().get(PhoneTypeEntity.class, id);
        return (PhoneTypeEntity) this.sessionFactory.getCurrentSession().get(PhoneTypeEntity.class, id);
    }

    @Override
    public List<PhoneTypeEntity> getPhoneTypeEntity(PhoneTypeEntity exampleEntity)
    {
        // List<PhoneTypeEntity> users = this.getHibernateTemplate().findByExample(exampleEntity);
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(PhoneTypeEntity.class);
        List<PhoneTypeEntity> users = criteria.list();
        return users;
    }

}
