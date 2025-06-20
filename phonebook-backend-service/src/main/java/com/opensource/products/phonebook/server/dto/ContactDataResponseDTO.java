package com.opensource.products.phonebook.server.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("serial")
public class ContactDataResponseDTO
{
    List<ContactEmailDTO> emailList;
    List<ContactPhoneDTO> phoneList;
    List<ContactLinkDTO> linkList;
}
