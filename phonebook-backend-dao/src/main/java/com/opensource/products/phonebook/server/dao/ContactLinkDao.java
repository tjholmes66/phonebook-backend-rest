package com.opensource.products.phonebook.server.dao;

import java.util.List;

import com.opensource.products.phonebook.server.domain.ContactEntity;
import com.opensource.products.phonebook.server.domain.ContactLinkEntity;

public interface ContactLinkDao
{

    public ContactLinkEntity saveContactLinkEntity(ContactLinkEntity contactLink);

    public ContactLinkEntity createContactLinkEntity(ContactLinkEntity contactLink);

    public ContactLinkEntity updateContactLinkEntity(ContactLinkEntity contactLink);

    public void deleteContactLinkEntity(Long contactLinkId);

    public void deleteContactLinkEntity(ContactLinkEntity contactLink);

    public List<ContactLinkEntity> getAllContactLinkEntitys();

    // Retrieve
    public ContactLinkEntity getContactLinkEntity(long id);

    public List<ContactLinkEntity> getContactLinkEntity(ContactLinkEntity exampleEntity);

    public List<ContactLinkEntity> getContactLinkEntityByContact(ContactEntity exampleContactEntity);

    public List<ContactLinkEntity> getContactLinkEntityByContactId(long contactId);

}
