package com.opensource.products.phonebook.server.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
public class LinkTypeEntity implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "link_type_id")
    private long id;

    @Column(name = "link_type_description")
    private String description;

    @Column(name = "link_type_active")
    private boolean active;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public boolean isActive()
    {
        return active;
    }

    public void setActive(boolean active)
    {
        this.active = active;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + (active ? 1231 : 1237);
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        LinkTypeEntity other = (LinkTypeEntity) obj;
        if (active != other.active)
            return false;
        if (description == null)
        {
            if (other.description != null)
                return false;
        }
        else if (!description.equals(other.description))
            return false;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "LinkTypeEntity [id=" + id + ", description=" + description + ", active=" + active + "]";
    }

}
