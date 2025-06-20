package com.opensource.products.phonebook.server.service;

import java.util.List;

import com.opensource.products.phonebook.server.domain.ContactEntity;
import com.opensource.products.phonebook.server.dto.ContactDTO;
import com.opensource.products.phonebook.server.dto.ContactDataResponseDTO;

public interface ContactService
{
    List<ContactEntity> getAllContacts();

    List<ContactEntity> getContactsByUserId(long userId);

    ContactEntity getContactById(long contactId);

    ContactEntity add(ContactEntity newContact);

    ContactEntity update(ContactEntity newContact);

    void remove(long contactId);

    List<ContactDTO> getContactDtoListByUserId(long userId);

    ContactDataResponseDTO getContactDataById(long contactId);

}
