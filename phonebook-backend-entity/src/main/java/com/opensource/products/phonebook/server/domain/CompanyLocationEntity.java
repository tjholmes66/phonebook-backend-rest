package com.opensource.products.phonebook.server.domain;

import java.io.Serializable;

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
import lombok.With;

/*
 * CREATE TABLE `company_location` (
 * `company_location_id` int NOT NULL AUTO_INCREMENT,
 * `active` tinyint(1) NOT NULL DEFAULT '1',
 * `company_id` int NOT NULL,
 * `address1` varchar(45) DEFAULT NULL,
 * `address2` varchar(45) DEFAULT NULL,
 * `city` varchar(45) DEFAULT NULL,
 * `state` varchar(45) DEFAULT NULL,
 * `zip` varchar(45) DEFAULT NULL,
 * PRIMARY KEY (`company_location_id`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 * 
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("serial")
@Entity
@Table(name = "company_location")
public class CompanyLocationEntity implements Serializable
{
    // `company_location_id` int NOT NULL AUTO_INCREMENT,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_location_id")
    private Long companyLocationId;

    // `active` tinyint(1) NOT NULL DEFAULT '1',
    @Column(name = "active")
    private Boolean active;

    // `company_id` int NOT NULL,
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id")
    private CompanyEntity company;

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
