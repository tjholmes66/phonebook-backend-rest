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

// CREATE TABLE `contacts_link` (
// `contacts_link_id` int(11) NOT NULL IDENTITY_INCREMENT,
// `contact_id` int(11) NOT NULL,
// `link_type_id` int(11) NOT NULL,
// `link_description` varchar(80) NOT NULL,
// `link_url` varchar(245) NOT NULL,
// `entered_date` datetime DEFAULT NULL,
// `link` varchar(255) DEFAULT NULL,
// `id` bigint(20) DEFAULT NULL,
// PRIMARY KEY (`contacts_link_id`),
// UNIQUE KEY `index2` (`link_url`),
// KEY `fk_contacts_link_1` (`contact_id`),
// KEY `fk_contacts_link_2` (`link_type_id`),
// CONSTRAINT `fk_contacts_link_1` FOREIGN KEY (`contact_id`) REFERENCES `contacts` (`contact_id`) ON DELETE CASCADE ON
// UPDATE CASCADE,
// CONSTRAINT `fk_contacts_link_2` FOREIGN KEY (`link_type_id`) REFERENCES `link_type` (`link_type_id`) ON DELETE NO
// ACTION ON UPDATE NO ACTION
// ) ENGINE=InnoDB DEFAULT CHARSET=utf8$$

/**
 * The persistent class for the Positions database table.
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "contacts_link")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactLinkEntity implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contacts_link_id")
    private Long linkId;

    // bi-directional many-to-one association to ContactEntity
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "contact_id")
    private ContactEntity contact;

    // bi-directional many-to-one association to ContactEntity
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "link_type_id")
    private LinkTypeEntity linkType;

    @Column(name = "link_url")
    private String link;

    @Column(name = "link_description")
    private String linkDescription;

    @Column(name = "entered_date")
    private LocalDateTime enteredDate;

}
