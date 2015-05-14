package com.opensource.products.phonebook.server.dao;

import java.util.List;

import com.opensource.products.phonebook.server.domain.ContactEntity;
import com.opensource.products.phonebook.server.domain.UserEntity;

public interface ContactDao
{

    ContactEntity createContactEntity(ContactEntity contactEntity);

    ContactEntity updateContactEntity(ContactEntity contactEntity);

    void deleteContactEntity(long contactId);

    void deleteContactEntity(ContactEntity contactEntity);

    List<ContactEntity> getAllContactEntitys();

    ContactEntity getContactEntity(long id);

    List<ContactEntity> getContactEntityByUser(UserEntity exampleEntity);

    List<ContactEntity> getContactEntity(ContactEntity exampleEntity);

}
