package com.opensource.products.phonebook.server.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// CREATE TABLE `position` (
// `position_id` int(11) NOT NULL AUTO_INCREMENT,
// `active` tinyint(1) NOT NULL DEFAULT '1',
// `code` varchar(45) NOT NULL,
// `description` varchar(45) DEFAULT NULL,
// PRIMARY KEY (`position_id`),
// UNIQUE KEY `code_unq` (`code`)
// ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8$$

/**
 * The persistent class for the Positions database table.
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "position")
public class PositionEntity implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "position_id")
    private long Id;

    @Column(name = "active")
    private boolean active;

    @Column(name = "code")
    private String code;

    @Column(name = "description")
    private String description;

    public long getId()
    {
        return Id;
    }

    public void setId(long id)
    {
        Id = id;
    }

    public boolean isActive()
    {
        return active;
    }

    public void setActive(boolean active)
    {
        this.active = active;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (Id ^ (Id >>> 32));
        result = prime * result + (active ? 1231 : 1237);
        result = prime * result + ((code == null) ? 0 : code.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
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
        PositionEntity other = (PositionEntity) obj;
        if (Id != other.Id)
            return false;
        if (active != other.active)
            return false;
        if (code == null)
        {
            if (other.code != null)
                return false;
        }
        else if (!code.equals(other.code))
            return false;
        if (description == null)
        {
            if (other.description != null)
                return false;
        }
        else if (!description.equals(other.description))
            return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "PositionEntity [Id=" + Id + ", active=" + active + ", code=" + code + ", description=" + description
            + "]";
    }

}
