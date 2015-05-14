package com.opensource.products.phonebook.server.dao;

import java.util.List;

import com.opensource.products.phonebook.server.domain.EmailTypeEntity;

public interface EmailTypeDao
{

    public EmailTypeEntity saveEmailTypeEntity(EmailTypeEntity emailType);

    public void deleteEmailTypeEntity(Long emailTypeId);

    public void deleteEmailTypeEntity(EmailTypeEntity emailType);

    public List<EmailTypeEntity> getAllEmailTypeEntitys();

    // Retrieve
    public EmailTypeEntity getEmailTypeEntity(long id);

    public List<EmailTypeEntity> getEmailTypeEntity(EmailTypeEntity exampleEntity);

}
