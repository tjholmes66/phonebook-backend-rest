package com.opensource.products.phonebook.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.opensource.products.phonebook.server.dao.ContactEmailDao;
import com.opensource.products.phonebook.server.domain.ContactEmailEntity;
import com.opensource.products.phonebook.server.domain.ContactEntity;

@Transactional
@Service("contactEmailService")
public class ContactEmailServiceImpl implements ContactEmailService
{
    private ContactEmailDao contactEmailDao;

    public ContactEmailServiceImpl (ContactEmailDao contactEmailDao)
    {
        this.contactEmailDao = contactEmailDao;
    }

    @Override
    public List<ContactEmailEntity> getAllEmailsByContactId(long contactId)
    {
        List<ContactEmailEntity> contactEmailList = contactEmailDao.getContactEmailEntityByContactId(contactId);
        return contactEmailList;
    }

    @Override
    public List<ContactEmailEntity> getAllEmailsByContactId(ContactEntity contactEntity)
    {
        long contactId = contactEntity.getContactId();
        List<ContactEmailEntity> contactEmailList = contactEmailDao.getContactEmailEntityByContactId(contactId);
        return contactEmailList;
    }

    @Override
    public ContactEmailEntity getEmailContactById(long emailId)
    {
        ContactEmailEntity contactEmailEntity = contactEmailDao.getContactEmailEntity(emailId);
        return contactEmailEntity;
    }
}
