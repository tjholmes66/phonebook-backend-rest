package com.opensource.products.phonebook.server.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

// CREATE TABLE `link_type` (
// `link_type_id` int(11) NOT NULL IDENTITY_INCREMENT,
// `link_type_description` varchar(45) NOT NULL,
// `link_type_active` tinyint(1) NOT NULL DEFAULT '1',
// PRIMARY KEY (`link_type_id`),
// UNIQUE KEY `link_type_description_UNIQUE` (`link_type_description`)
// ) ENGINE=InnoDB IDENTITY_INCREMENT=4 DEFAULT CHARSET=utf8$$

/**
 * The persistent class for the Positions database table.
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "link_type")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinkTypeEntity implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "link_type_id")
    private Long id;

    @Column(name = "link_type_description")
    private String description;

    @Column(name = "link_type_active")
    private boolean active;

}
