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

import com.opensource.products.phonebook.server.domain.ContactEntity;
import com.opensource.products.phonebook.server.domain.ContactPhoneEntity;

@Repository("contactPhoneDao")
public class ContactPhoneDaoImpl implements ContactPhoneDao
{

    @PersistenceContext
    private EntityManager entityManager;

    private static final Log logger = LogFactory.getLog(ContactDaoImpl.class);

    @Override
    public ContactPhoneEntity createContactPhoneEntity(ContactPhoneEntity contactPhone)
    {
       entityManager.persist(contactPhone);
        return contactPhone;
    }

    @Override
    public ContactPhoneEntity saveContactPhoneEntity(ContactPhoneEntity contactPhone)
    {
       entityManager.persist(contactPhone);
        return contactPhone;
    }

    @Override
    public ContactPhoneEntity updateContactPhoneEntity(ContactPhoneEntity contactPhone)
    {
       entityManager.merge(contactPhone);
        return contactPhone;
    }

    @Override
    public void deleteContactPhoneEntity(Long contactPhoneId)
    {
        ContactPhoneEntity contactPhoneEntity = entityManager.find(ContactPhoneEntity.class, contactPhoneId);
        entityManager.remove(contactPhoneEntity);
    }

    @Override
    public void deleteContactPhoneEntity(ContactPhoneEntity contactPhone)
    {
       entityManager.remove(contactPhone);
    }

    @Override
    public List<ContactPhoneEntity> getAllContactPhoneEntitys()
    {
        String queryString = "from ContactPhoneEntity";
        List<ContactPhoneEntity> contactPhoneEntityList =entityManager.createQuery(queryString).getResultList();
        return contactPhoneEntityList;
    }

    @Override
    public ContactPhoneEntity getContactPhoneEntity(long id)
    {
        return (ContactPhoneEntity)entityManager.find(ContactPhoneEntity.class, id);
    }

    @Override
    public List<ContactPhoneEntity> getContactPhoneEntity(ContactPhoneEntity exampleEntity)
    {
        // List<ContactPhoneEntity> users = this.getHibernateTemplate().findByExample(exampleEntity);
        CriteriaQuery criteriaQuery =entityManager.getCriteriaBuilder().createQuery(ContactPhoneEntity.class);
        List<ContactPhoneEntity> contactPhoneEntityList =entityManager.createQuery(criteriaQuery).getResultList();
        return contactPhoneEntityList;
    }

    @Override
    public List<ContactPhoneEntity> getContactPhoneEntityByContact(ContactEntity exampleContactEntity)
    {
        Query query =
           entityManager.createQuery(
                "from ContactPhoneEntity cpe where cpe.contact = :contact");
        query.setParameter("contact", exampleContactEntity);
        List<ContactPhoneEntity> contactPhoneEntityList = query.getResultList();
        return contactPhoneEntityList;
    }

    @Override
    public List<ContactPhoneEntity> getContactPhoneEntityByContactId(long contactId)
    {
        Query query =
           entityManager.createQuery(
                "from ContactPhoneEntity cpe where cpe.contact.id = :contact");
        query.setParameter("contact", contactId);
        List<ContactPhoneEntity> contactPhoneEntityList = query.getResultList();
        return contactPhoneEntityList;
    }

}
