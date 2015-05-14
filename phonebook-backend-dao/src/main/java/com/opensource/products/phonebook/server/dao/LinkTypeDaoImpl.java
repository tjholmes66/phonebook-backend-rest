package com.opensource.products.phonebook.server.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.opensource.products.phonebook.server.domain.LinkTypeEntity;

@Repository("linkTypeDao")
public class LinkTypeDaoImpl implements LinkTypeDao
{
    @Autowired
    private SessionFactory sessionFactory;

    private static final Log logger = LogFactory.getLog(LinkTypeDaoImpl.class);

    public void setSessionFactory(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public LinkTypeEntity saveLinkTypeEntity(LinkTypeEntity linkType)
    {
        // this.getHibernateTemplate().saveOrUpdate(linkType);
        return linkType;
    }

    @Override
    public void deleteLinkTypeEntity(Long linkTypeId)
    {
        // this.getgetHibernateTemplate()().delete(interest);
    }

    @Override
    public void deleteLinkTypeEntity(LinkTypeEntity linkType)
    {
        // this.getHibernateTemplate().delete(linkType);
    }

    @Override
    public List<LinkTypeEntity> getAllLinkTypeEntitys()
    {
        String queryString = "from LinkTypeEntity";
        // List<LinkTypeEntity> users = this.getHibernateTemplate().find(queryString);
        List<LinkTypeEntity> users = this.sessionFactory.getCurrentSession().createQuery(queryString).list();
        return users;
    }

    @Override
    public LinkTypeEntity getLinkTypeEntity(long id)
    {
        // return (LinkTypeEntity)this.getHibernateTemplate().get(LinkTypeEntity.class, id);
        return (LinkTypeEntity) this.sessionFactory.getCurrentSession().get(LinkTypeEntity.class, id);
    }

    @Override
    public List<LinkTypeEntity> getLinkTypeEntity(LinkTypeEntity exampleEntity)
    {
        // List<LinkTypeEntity> users = this.getHibernateTemplate().findByExample(exampleEntity);
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(LinkTypeEntity.class);
        List<LinkTypeEntity> users = criteria.list();
        return users;
    }

}
