package com.opensource.products.phonebook.server.dao;

import com.opensource.products.phonebook.server.domain.CompanyEntity;
import com.opensource.products.phonebook.server.domain.UserEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaQuery;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("companyDao")
public class CompanyDaoImpl implements  CompanyDao {

    @PersistenceContext
    private EntityManager entityManager;

    private static final Log logger = LogFactory.getLog(CompanyDaoImpl.class);

    @Override
    public CompanyEntity createCompanyEntity(CompanyEntity companyEntity)
    {
        entityManager.persist(companyEntity);
        entityManager.flush();
        entityManager.refresh(companyEntity);
        return companyEntity;
    }

    @Override
    public CompanyEntity updateCompanyEntity(CompanyEntity companyEntity)
    {
        entityManager.persist(companyEntity);
        entityManager.flush();
        entityManager.refresh(companyEntity);
        return companyEntity;
    }

    @Override
    public void deleteCompanyEntity(long companyId)
    {
        CompanyEntity companyEntity = entityManager.find(CompanyEntity.class, companyId);
        entityManager.remove(companyEntity);
    }

    @Override
    public void deleteCompanyEntity(CompanyEntity companyEntity)
    {
        entityManager.remove(companyEntity);
    }

    @Override
    public List<CompanyEntity> getAllCompanyEntitys()
    {
        String queryString = "from CompanyEntity";
        List<CompanyEntity> companyEntityList;
        companyEntityList = entityManager.createQuery(queryString).getResultList();
        return companyEntityList;
    }

    @Override
    public CompanyEntity getCompanyEntity(long id)
    {
        return (CompanyEntity) entityManager.find(CompanyEntity.class, id);
    }

    @Override
    public List<CompanyEntity> getCompanyEntity(CompanyEntity exampleEntity)
    {
        CriteriaQuery criteriaQuery = entityManager.getCriteriaBuilder().createQuery(CompanyEntity.class);
        List<CompanyEntity> companyEntityList;
        companyEntityList = entityManager.createQuery(criteriaQuery).getResultList();
        return companyEntityList;
    }

}
