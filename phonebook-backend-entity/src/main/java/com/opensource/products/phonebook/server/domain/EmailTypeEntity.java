package com.opensource.products.phonebook.server.domain;

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

import java.time.LocalDateTime;
// CREATE TABLE `email_type` (
// `email_type_id` int(11) NOT NULL IDENTITY_INCREMENT,
// `email_type_description` varchar(45) NOT NULL,
// `email_type_active` tinyint(1) NOT NULL DEFAULT '1',
// PRIMARY KEY (`email_type_id`),
// UNIQUE KEY `email_type_description_UNIQUE` (`email_type_description`)
// ) ENGINE=InnoDB IDENTITY_INCREMENT=4 DEFAULT CHARSET=utf8$$

/**
 * The persistent class for the Positions database table.
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "email_type")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailTypeEntity implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "email_type_id")
    private Long id;

    @Column(name = "email_type_description")
    private String description;

    @Column(name = "email_type_active")
    private boolean active;

}
