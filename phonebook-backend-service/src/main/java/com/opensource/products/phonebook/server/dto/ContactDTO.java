package com.opensource.products.phonebook.server.dto;

import com.opensource.products.phonebook.server.domain.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("serial")
public class ContactDTO {

    private Long contactId;
    private UserEntity user;
    private String prefix;
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zip;
    private Long companyId;
    private Long enteredBy;
    private LocalDateTime enteredDate;
    private Long editedBy;
    private LocalDateTime editedDate;
    private LocalDate birthDate;

}
