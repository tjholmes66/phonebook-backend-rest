package com.opensource.products.phonebook.server.dto;

import com.opensource.products.phonebook.server.domain.ContactEntity;
import com.opensource.products.phonebook.server.domain.LinkTypeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("serial")
public class ContactLinkDTO
{
    private Long linkId;
    private ContactEntity contact;
    private LinkTypeEntity linkType;
    private String link;
    private String linkDescription;
    private LocalDateTime enteredDate;
}
