package com.opensource.products.phonebook.server.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaQuery;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.opensource.products.phonebook.server.domain.PhoneTypeEntity;

@Repository("phoneTypeDao")
public class PhoneTypeDaoImpl implements PhoneTypeDao
{
    @PersistenceContext
    private EntityManager entityManager;

    private static final Log logger = LogFactory.getLog(PhoneTypeDaoImpl.class);

    @Override
    public PhoneTypeEntity savePhoneTypeEntity(PhoneTypeEntity phoneTypeEntity)
    {
        entityManager.persist(phoneTypeEntity);
        entityManager.flush();
        entityManager.refresh(phoneTypeEntity);
        return phoneTypeEntity;
    }

    @Override
    public void deletePhoneTypeEntity(Long phoneTypeId)
    {
        PhoneTypeEntity phoneTypeEntity = entityManager.find(PhoneTypeEntity.class, phoneTypeId);
        entityManager.remove(phoneTypeEntity);
    }

    @Override
    public void deletePhoneTypeEntity(PhoneTypeEntity phoneTypeEntity)
    {
        entityManager.remove(phoneTypeEntity);
    }

    @Override
    public List<PhoneTypeEntity> getAllPhoneTypeEntitys()
    {
        String queryString = "from PhoneTypeEntity";
        List<PhoneTypeEntity> phoneTypeEntityList = entityManager.createQuery(queryString).getResultList();
        return phoneTypeEntityList;
    }

    @Override
    public PhoneTypeEntity getPhoneTypeEntity(long id)
    {
        return (PhoneTypeEntity) entityManager.find(PhoneTypeEntity.class, id);
    }

    @Override
    public List<PhoneTypeEntity> getPhoneTypeEntity(PhoneTypeEntity exampleEntity)
    {
        // List<PhoneTypeEntity> users = this.getHibernateTemplate().findByExample(exampleEntity);
        CriteriaQuery criteriaQuery = entityManager.getCriteriaBuilder().createQuery(PhoneTypeEntity.class);
        List<PhoneTypeEntity> phoneTypeEntityList = criteriaQuery.getOrderList();
        return phoneTypeEntityList;
    }

}
