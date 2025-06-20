package com.opensource.products.phonebook.server.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaQuery;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.opensource.products.phonebook.server.domain.ContactEntity;
import com.opensource.products.phonebook.server.domain.ContactLinkEntity;

@Repository("contactLinkDao")
public class ContactLinkDaoImpl implements ContactLinkDao
{

    @PersistenceContext
    private EntityManager entityManager;

    private static final Log logger = LogFactory.getLog(ContactDaoImpl.class);

    @Override
    public ContactLinkEntity createContactLinkEntity(ContactLinkEntity contactLink)
    {
        entityManager.persist(contactLink);
        return contactLink;
    }

    @Override
    public ContactLinkEntity saveContactLinkEntity(ContactLinkEntity contactLink)
    {
        entityManager.persist(contactLink);
        return contactLink;
    }

    @Override
    public ContactLinkEntity updateContactLinkEntity(ContactLinkEntity contactLink)
    {
        entityManager.merge(contactLink);
        return contactLink;
    }

    @Override
    public void deleteContactLinkEntity(Long contactLinkId)
    {
        ContactLinkEntity contactLinkEntity = entityManager.find(ContactLinkEntity.class, contactLinkId);
        entityManager.remove(contactLinkEntity);
    }

    @Override
    public void deleteContactLinkEntity(ContactLinkEntity contactLink)
    {
        entityManager.remove(contactLink);
    }

    @Override
    public List<ContactLinkEntity> getAllContactLinkEntitys()
    {
        String queryString = "from ContactLinkEntity";
        // List<ContactLinkEntity> users = this.getHibernateTemplate().find(queryString);
        List<ContactLinkEntity> contactLinkEntityList = entityManager.createQuery(queryString).getResultList();
        return contactLinkEntityList;
    }

    @Override
    public ContactLinkEntity getContactLinkEntity(long id)
    {
        // return (ContactLinkEntity)this.getHibernateTemplate().get(ContactLinkEntity.class, id);
        return (ContactLinkEntity) entityManager.find(ContactLinkEntity.class, id);
    }

    @Override
    public List<ContactLinkEntity> getContactLinkEntity(ContactLinkEntity exampleEntity)
    {
        // List<ContactLinkEntity> users = this.getHibernateTemplate().findByExample(exampleEntity);
        CriteriaQuery criteriaQuery = entityManager.getCriteriaBuilder().createQuery(ContactLinkEntity.class);
        List<ContactLinkEntity> contactLinkEntityList = entityManager.createQuery(criteriaQuery).getResultList();
        return contactLinkEntityList;
    }

    @Override
    public List<ContactLinkEntity> getContactLinkEntityByContact(ContactEntity exampleContactEntity)
    {
        Query query =
            entityManager.createQuery(
                "from ContactLinkEntity cpe where cpe.contact = :contact");
        query.setParameter("contact", exampleContactEntity);
        List<ContactLinkEntity> contactLinks = query.getResultList();
        return contactLinks;
    }

    @Override
    public List<ContactLinkEntity> getContactLinkEntityByContactId(long contactId)
    {
        Query query =
            entityManager.createQuery(
                "from ContactLinkEntity cpe where cpe.contact.id = :contact");
        query.setParameter("contact", contactId);
        List<ContactLinkEntity> contactLinks = query.getResultList();
        return contactLinks;
    }

}
