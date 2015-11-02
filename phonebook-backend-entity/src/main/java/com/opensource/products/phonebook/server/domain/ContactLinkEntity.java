package com.opensource.products.phonebook.server.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
public class ContactLinkEntity implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contacts_link_id")
    private long linkId;

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
    private Date enteredDate;

    public long getLinkId()
    {
        return linkId;
    }

    public void setLinkId(long linkId)
    {
        this.linkId = linkId;
    }

    public ContactEntity getContact()
    {
        return contact;
    }

    public void setContact(ContactEntity contact)
    {
        this.contact = contact;
    }

    public LinkTypeEntity getLinkType()
    {
        return linkType;
    }

    public void setLinkType(LinkTypeEntity linkType)
    {
        this.linkType = linkType;
    }

    public String getLink()
    {
        return link;
    }

    public void setLink(String link)
    {
        this.link = link;
    }

    public Date getEnteredDate()
    {
        return enteredDate;
    }

    public void setEnteredDate(Date enteredDate)
    {
        this.enteredDate = enteredDate;
    }

    public String getLinkDescription()
    {
        return linkDescription;
    }

    public void setLinkDescription(String linkDescription)
    {
        this.linkDescription = linkDescription;
    }

    @Override
    public String toString()
    {
        return "ContactLinkEntity [linkId=" + linkId + ", linkType=" + linkType + ", link=" + link
            + ", linkDescription=" + linkDescription + ", enteredDate=" + enteredDate + "]";
    }

}
