package com.opensource.products.phonebook.server.service;

import java.util.List;

import com.opensource.products.phonebook.server.domain.ContactEntity;

public interface ContactService
{
    List<ContactEntity> getAllContacts();

    List<ContactEntity> getContactsByUserId(long userId);

    ContactEntity getContactById(long contactId);

    ContactEntity add(ContactEntity newContact);

    ContactEntity update(ContactEntity newContact);

    void remove(long contactId);

}
