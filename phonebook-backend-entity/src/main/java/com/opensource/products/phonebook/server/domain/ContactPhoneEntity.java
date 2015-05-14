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

/**
 * The persistent class for the Positions database table.
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "contacts_phone")
public class ContactPhoneEntity implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "contacts_phone_id")
    private long phoneId;

    // bi-directional many-to-one association to ContactEntity
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "contact_id")
    private ContactEntity contact;

    // bi-directional many-to-one association to ContactEntity
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "phone_type_id")
    private PhoneTypeEntity phoneType;

    @Column(name = "phone")
    private String phone;

    @Column(name = "entered_date")
    private Date enteredDate;

    public long getPhoneId()
    {
        return phoneId;
    }

    public void setPhoneId(long phoneId)
    {
        this.phoneId = phoneId;
    }

    public ContactEntity getContact()
    {
        return contact;
    }

    public void setContact(ContactEntity contact)
    {
        this.contact = contact;
    }

    public PhoneTypeEntity getPhoneType()
    {
        return phoneType;
    }

    public void setPhoneType(PhoneTypeEntity phoneType)
    {
        this.phoneType = phoneType;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public Date getEnteredDate()
    {
        return enteredDate;
    }

    public void setEnteredDate(Date enteredDate)
    {
        this.enteredDate = enteredDate;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((phone == null) ? 0 : phone.hashCode());
        result = prime * result + (int) (phoneId ^ (phoneId >>> 32));
        result = prime * result + ((phoneType == null) ? 0 : phoneType.hashCode());
        result = prime * result + ((enteredDate == null) ? 0 : enteredDate.hashCode());
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
        ContactPhoneEntity other = (ContactPhoneEntity) obj;
        if (phone == null)
        {
            if (other.phone != null)
                return false;
        }
        else if (!phone.equals(other.phone))
            return false;
        if (phoneId != other.phoneId)
            return false;
        if (phoneType == null)
        {
            if (other.phoneType != null)
                return false;
        }
        else if (!phoneType.equals(other.phoneType))
            return false;
        if (enteredDate == null)
        {
            if (other.enteredDate != null)
                return false;
        }
        else if (!enteredDate.equals(other.enteredDate))
            return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "ContactPhoneEntity [phoneId=" + phoneId + ", phoneType=" + phoneType + ", phone=" + phone
            + ", enteredDate=" + enteredDate + "]";
    }

}
