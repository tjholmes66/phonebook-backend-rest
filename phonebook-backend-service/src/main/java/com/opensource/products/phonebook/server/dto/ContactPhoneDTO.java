package com.opensource.products.phonebook.server.dto;

import com.opensource.products.phonebook.server.domain.ContactEntity;
import com.opensource.products.phonebook.server.domain.PhoneTypeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("serial")
public class ContactPhoneDTO
{
    private Long phoneId;
    private ContactEntity contact;
    private PhoneTypeEntity phoneType;
    private String phone;
    private LocalDateTime enteredDate;
}
