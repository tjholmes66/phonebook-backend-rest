package com.opensource.products.phonebook.server.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

/*
 * CREATE TABLE `company` (
 * `company_id` int NOT NULL AUTO_INCREMENT,
 * `active` tinyint(1) NOT NULL,
 * `code` varchar(10) NOT NULL,
 * `name` varchar(45) NOT NULL,
 * `description` varchar(345) DEFAULT NULL,
 * `address1` varchar(45) DEFAULT NULL,
 * `address2` varchar(45) DEFAULT NULL,
 * `city` varchar(45) DEFAULT NULL,
 * `state` varchar(45) DEFAULT NULL,
 * `zip` varchar(45) DEFAULT NULL,
 * PRIMARY KEY (`company_id`),
 * KEY `code` (`code`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 * 
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("serial")
@Entity
@Table(name = "company")
public class CompanyEntity implements Serializable
{
    // `company_id` int NOT NULL AUTO_INCREMENT,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Long companyId;

    // `active` tinyint(1) NOT NULL,
    @Column(name = "active")
    private Boolean active;

    // `code` varchar(10) NOT NULL,
    @Column(name = "code")
    private String companyCode;

    // `name` varchar(45) NOT NULL,
    @Column(name = "name")
    private String companyName;

    // `description` varchar(345) DEFAULT NULL,
    @Column(name = "description")
    private String description;

    // `address1` varchar(45) DEFAULT NULL,
    @Column(name = "address1")
    private String address1;

    // `address2` varchar(45) DEFAULT NULL,
    @Column(name = "address2")
    private String address2;

    // `city` varchar(45) DEFAULT NULL,
    @Column(name = "city")
    private String city;

    // `state` varchar(45) DEFAULT NULL,
    @Column(name = "state")
    private String state;

    // `zip` varchar(45) DEFAULT NULL,
    @Column(name = "zip")
    private String zip;

}
