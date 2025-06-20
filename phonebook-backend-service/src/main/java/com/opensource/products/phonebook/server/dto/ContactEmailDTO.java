package com.opensource.products.phonebook.server.dto;

import com.opensource.products.phonebook.server.domain.ContactEntity;
import com.opensource.products.phonebook.server.domain.EmailTypeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("serial")
public class ContactEmailDTO
{
    private Long emailId;
    private ContactEntity contact;
    private EmailTypeEntity emailType;
    private String email;
    private LocalDateTime enteredDate;
}
