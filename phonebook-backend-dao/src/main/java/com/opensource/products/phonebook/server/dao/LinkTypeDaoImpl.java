package com.opensource.products.phonebook.server.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaQuery;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.opensource.products.phonebook.server.domain.LinkTypeEntity;

@Repository("linkTypeDao")
public class LinkTypeDaoImpl implements LinkTypeDao
{
    @PersistenceContext
    private EntityManager entityManager;

    private static final Log logger = LogFactory.getLog(LinkTypeDaoImpl.class);

    @Override
    public LinkTypeEntity saveLinkTypeEntity(LinkTypeEntity linkTypeEntity)
    {
        entityManager.persist(linkTypeEntity);
        entityManager.flush();
        entityManager.refresh(linkTypeEntity);
        return linkTypeEntity;
    }

    @Override
    public void deleteLinkTypeEntity(Long linkTypeId)
    {
        LinkTypeEntity linkTypeEntity = entityManager.find(LinkTypeEntity.class, linkTypeId);
        entityManager.remove(linkTypeEntity);
    }

    @Override
    public void deleteLinkTypeEntity(LinkTypeEntity linkTypeEntity)
    {
        entityManager.remove(linkTypeEntity);
    }

    @Override
    public List<LinkTypeEntity> getAllLinkTypeEntitys()
    {
        String queryString = "from LinkTypeEntity";
        List<LinkTypeEntity> linkTypeEntityList = entityManager.createQuery(queryString).getResultList();
        return linkTypeEntityList;
    }

    @Override
    public LinkTypeEntity getLinkTypeEntity(long id)
    {
        return (LinkTypeEntity) entityManager.find(LinkTypeEntity.class, id);
    }

    @Override
    public List<LinkTypeEntity> getLinkTypeEntity(LinkTypeEntity exampleEntity)
    {
        // List<LinkTypeEntity> users = this.getHibernateTemplate().findByExample(exampleEntity);
        CriteriaQuery criteriaQuery = entityManager.getCriteriaBuilder().createQuery(LinkTypeEntity.class);
        List<LinkTypeEntity> linkTypeEntityList = criteriaQuery.getOrderList();
        return linkTypeEntityList;
    }

}
