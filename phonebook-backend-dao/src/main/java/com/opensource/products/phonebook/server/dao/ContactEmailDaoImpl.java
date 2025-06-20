package com.opensource.products.phonebook.server.dao;

import java.util.List;

import com.opensource.products.phonebook.server.domain.ContactLinkEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaQuery;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.opensource.products.phonebook.server.domain.ContactEmailEntity;
import com.opensource.products.phonebook.server.domain.ContactEntity;

@Repository("contactEmailDao")
public class ContactEmailDaoImpl implements ContactEmailDao
{

    @PersistenceContext
    private EntityManager entityManager;

    private static final Log logger = LogFactory.getLog(ContactDaoImpl.class);

    @Override
    public ContactEmailEntity createContactEmailEntity(ContactEmailEntity contactEmail)
    {
        // this.getHibernateTemplate().saveOrUpdate(contactEmail);
        entityManager.persist(contactEmail);
        return contactEmail;
    }

    @Override
    public ContactEmailEntity saveContactEmailEntity(ContactEmailEntity contactEmail)
    {
        // this.getHibernateTemplate().saveOrUpdate(contact);
        entityManager.persist(contactEmail);
        return contactEmail;
    }

    @Override
    public ContactEmailEntity updateContactEmailEntity(ContactEmailEntity contactEmail)
    {
        // this.getHibernateTemplate().saveOrUpdate(contact);
        entityManager.merge(contactEmail);
        return contactEmail;
    }

    @Override
    public void deleteContactEmailEntity(Long contactEmailId)
    {
        ContactEmailEntity contactEmailEntity = entityManager.find(ContactEmailEntity.class, contactEmailId);
        entityManager.remove(contactEmailEntity);
    }

    @Override
    public void deleteContactEmailEntity(ContactEmailEntity contactEmail)
    {
        entityManager.remove(contactEmail);
    }

    @Override
    public List<ContactEmailEntity> getAllContactEmailEntitys()
    {
        String queryString = "from ContactEmailEntity";
        // List<ContactEmailEntity> users = this.getHibernateTemplate().find(queryString);
        List<ContactEmailEntity> users = entityManager.createQuery(queryString).getResultList();
        return users;
    }

    @Override
    public ContactEmailEntity getContactEmailEntity(long id)
    {
        // return (ContactEmailEntity)this.getHibernateTemplate().get(ContactEmailEntity.class, id);
        return (ContactEmailEntity) entityManager.find(ContactEmailEntity.class, id);
    }

    @Override
    public List<ContactEmailEntity> getContactEmailEntity(ContactEmailEntity exampleEntity)
    {
        CriteriaQuery criteriaQuery = entityManager.getCriteriaBuilder().createQuery(ContactEmailEntity.class);
        List<ContactEmailEntity> contactEmailEntityList = entityManager.createQuery(criteriaQuery).getResultList();
        return contactEmailEntityList;
    }

    @Override
    public List<ContactEmailEntity> getContactEmailEntityByContact(ContactEntity exampleContactEntity)
    {
        Query query =
            entityManager.createQuery(
                "from ContactEmailEntity cpe where cpe.contact = :contact");
        query.setParameter("contact", exampleContactEntity);
        List<ContactEmailEntity> contactEmailEntityList = query.getResultList();
        return contactEmailEntityList;
    }

    @Override
    public List<ContactEmailEntity> getContactEmailEntityByContactId(long contactId)
    {
        Query query =
            entityManager.createQuery(
                "from ContactEmailEntity cpe where cpe.contact.id = :contact");
        query.setParameter("contact", contactId);
        List<ContactEmailEntity> contactEmailEntityList = query.getResultList();
        return contactEmailEntityList;
    }

}
