package com.opensource.products.phonebook.server.service;

import java.util.ArrayList;
import java.util.List;

import com.opensource.products.phonebook.server.dao.ContactEmailDao;
import com.opensource.products.phonebook.server.dao.ContactLinkDao;
import com.opensource.products.phonebook.server.dao.ContactPhoneDao;
import com.opensource.products.phonebook.server.domain.*;
import com.opensource.products.phonebook.server.dto.*;
import com.opensource.products.phonebook.server.mapper.ContactEmailListMapper;
import com.opensource.products.phonebook.server.mapper.ContactLinkListMapper;
import com.opensource.products.phonebook.server.mapper.ContactListMapper;
import com.opensource.products.phonebook.server.mapper.ContactPhoneListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.opensource.products.phonebook.server.dao.ContactDao;

@Transactional
@Service("contactService")
public class ContactServiceImpl implements ContactService
{
    private ContactDao contactDao;

    private ContactEmailDao contactEmailDao;
    private ContactPhoneDao contactPhoneDao;
    private ContactLinkDao contactLinkDao;

    private ContactListMapper contactListMapper;

    private ContactEmailListMapper contactEmailListMapper;
    private ContactPhoneListMapper contactPhoneListMapper;
    private ContactLinkListMapper contactLinkListMapper;

    public ContactServiceImpl(ContactDao contactDao,
                              ContactListMapper contactListMapper,
                              ContactEmailDao contactEmailDao,
                              ContactPhoneDao contactPhoneDao,
                              ContactLinkDao contactLinkDao,
                              ContactEmailListMapper contactEmailListMapper,
                              ContactPhoneListMapper contactPhoneListMapper,
                              ContactLinkListMapper contactLinkListMapper
    )
    {
        this.contactDao = contactDao;
        this.contactListMapper = contactListMapper;
        this.contactEmailDao = contactEmailDao;
        this.contactPhoneDao = contactPhoneDao;
        this.contactLinkDao = contactLinkDao;
        this.contactEmailListMapper = contactEmailListMapper;
        this.contactPhoneListMapper = contactPhoneListMapper;
        this.contactLinkListMapper = contactLinkListMapper;
    }


    @Override
    public List<ContactEntity> getAllContacts()
    {
        List<ContactEntity> contactList = contactDao.getAllContactEntitys();
        return contactList;
    }

    @Override
    public List<ContactEntity> getContactsByUserId(long userId)
    {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(userId);
        List<ContactEntity> contactList = contactDao.getContactEntityByUser(userEntity);
        return contactList;
    }

    @Override
    public ContactEntity getContactById(long contactId)
    {
        ContactEntity contactEntity = contactDao.getContactEntity(contactId);
        return contactEntity;
    }

    @Override
    public ContactEntity add(ContactEntity newContact)
    {
        ContactEntity contactEntity = contactDao.createContactEntity(newContact);
        return contactEntity;
    }

    @Override
    public ContactEntity update(ContactEntity newContact)
    {
        ContactEntity updatedContactEntity = contactDao.updateContactEntity(newContact);
        return updatedContactEntity;
    }

    @Override
    public void remove(long contactId)
    {
        System.out.println("remove: contactId=" + contactId);
        contactDao.deleteContactEntity(contactId);
    }

    //=====================================================================================

    @Override
    public List<ContactDTO> getContactDtoListByUserId(long userId)
    {
        List<ContactDTO> contactDTOList = new ArrayList<ContactDTO>();
        List<ContactEntity> contactEntityList = contactDao.getContactEntityByUserId(userId);
        contactDTOList = contactListMapper.entityListToDtoList(contactEntityList);
        return contactDTOList;
    }

    @Override
    public ContactDataResponseDTO getContactDataById(long contactId) {
        System.out.println("getContactDataById: contactId=" + contactId);
        ContactDataResponseDTO contactDataResponseDTO = new ContactDataResponseDTO();

        List<ContactEmailEntity> contactEmailEntityList = contactEmailDao.getContactEmailEntityByContactId(contactId);
        List<ContactEmailDTO> contactEmailDTOList = contactEmailListMapper.entityListToDtoList(contactEmailEntityList);
        contactDataResponseDTO.setEmailList(contactEmailDTOList);

        List<ContactPhoneEntity> contactPhoneEntityList = contactPhoneDao.getContactPhoneEntityByContactId(contactId);
        List<ContactPhoneDTO> contactPhoneDTOList = contactPhoneListMapper.entityListToDtoList(contactPhoneEntityList);
        contactDataResponseDTO.setPhoneList(contactPhoneDTOList);

        List<ContactLinkEntity> contactLinkEntityList = contactLinkDao.getContactLinkEntityByContactId(contactId);
        List<ContactLinkDTO> contactLinkDTOList = contactLinkListMapper.entityListToDtoList(contactLinkEntityList);
        contactDataResponseDTO.setLinkList(contactLinkDTOList);

        return contactDataResponseDTO;
    }
}
