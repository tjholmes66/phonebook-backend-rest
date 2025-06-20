package com.opensource.products.phonebook.server.domain;

//
// CREATE TABLE `contacts` (
// `contact_id` int(11) NOT NULL IDENTITY_INCREMENT,
// `prefix` varchar(45) DEFAULT NULL,
// `first_name` varchar(45) NOT NULL,
// `middle_name` varchar(45) DEFAULT NULL,
// `last_name` varchar(45) NOT NULL,
// `suffix` varchar(45) DEFAULT NULL,
// `address1` varchar(45) DEFAULT NULL,
// `address2` varchar(45) DEFAULT NULL,
// `city` varchar(45) DEFAULT NULL,
// `state` varchar(2) DEFAULT NULL,
// `zip` varchar(45) DEFAULT NULL,
// `company_id` int(11) DEFAULT NULL,
// `entered_by` int(11) DEFAULT NULL,
// `entered_date` datetime DEFAULT NULL,
// `edited_by` int(11) DEFAULT NULL,
// `edited_date` datetime DEFAULT NULL,
// `birthdate` datetime DEFAULT NULL
// PRIMARY KEY (`contact_id`),
// UNIQUE KEY `username_UNIQUE` (`username`)
// ) ENGINE=InnoDB DEFAULT CHARSET=utf8$$

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * The persistent class for the Positions database table.
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "contacts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactEntity implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    private Long contactId;

    // bi-directional many-to-one association to UserEntity
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column(name = "prefix")
    private String prefix;

// `first_name` varchar(45) NOT NULL,
    @Column(name = "first_name")
    private String firstName;

// `middle_name` varchar(45) DEFAULT NULL,
    @Column(name = "middle_name")
    private String middleName;

// `last_name` varchar(45) NOT NULL,
    @Column(name = "last_name")
    private String lastName;

// `suffix` varchar(45) DEFAULT NULL,
    @Column(name = "suffix")
    private String suffix;

// `address1` varchar(45) DEFAULT NULL,
    @Column(name = "address1")
    private String address1;

// `address2` varchar(45) DEFAULT NULL,
    @Column(name = "address2")
    private String address2;

// `city` varchar(45) DEFAULT NULL,
    @Column(name = "city")
    private String city;

// `state` varchar(2) DEFAULT NULL,
    @Column(name = "state")
    private String state;

// `zip` varchar(45) DEFAULT NULL,
    @Column(name = "zip")
    private String zip;

// `company_id` int(11) DEFAULT NULL,
    @Column(name = "company_id")
    private long companyId;

// `entered_by` int(11) DEFAULT NULL,
    @Column(name = "entered_by")
    private long enteredBy;

// `entered_date` datetime DEFAULT NULL,
    @Column(name = "entered_date")
    private LocalDateTime enteredDate;

// `edited_by` int(11) DEFAULT NULL,
    @Column(name = "edited_by")
    private long editedBy;

// `edited_date` datetime DEFAULT NULL,
    @Column(name = "edited_date")
    private LocalDateTime editedDate;

// `birthdate` datetime DEFAULT NULL,
    @Column(name = "birthdate")
    private LocalDate birthDate;

}
