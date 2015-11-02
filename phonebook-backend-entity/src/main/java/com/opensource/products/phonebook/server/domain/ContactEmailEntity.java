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

@SuppressWarnings("serial")
@Entity
@Table(name = "contacts_email")
public class ContactEmailEntity implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contacts_email_id")
    private long emailId;

    // bi-directional many-to-one association to ContactEntity
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "contact_id")
    private ContactEntity contact;

    // bi-directional many-to-one association to ContactEntity
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "email_type_id")
    private EmailTypeEntity emailType;

    @Column(name = "email")
    private String email;

    @Column(name = "entered_date")
    private Date enteredDate;

    public long getEmailId()
    {
        return emailId;
    }

    public void setEmailId(long emailId)
    {
        this.emailId = emailId;
    }

    public ContactEntity getContact()
    {
        return contact;
    }

    public void setContact(ContactEntity contact)
    {
        this.contact = contact;
    }

    public EmailTypeEntity getEmailType()
    {
        return emailType;
    }

    public void setEmailType(EmailTypeEntity emailType)
    {
        this.emailType = emailType;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
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
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + (int) (emailId ^ (emailId >>> 32));
        result = prime * result + ((emailType == null) ? 0 : emailType.hashCode());
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
        ContactEmailEntity other = (ContactEmailEntity) obj;
        if (email == null)
        {
            if (other.email != null)
                return false;
        }
        else if (!email.equals(other.email))
            return false;
        if (emailId != other.emailId)
            return false;
        if (emailType == null)
        {
            if (other.emailType != null)
                return false;
        }
        else if (!emailType.equals(other.emailType))
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
        return "ContactEmailEntity [emailId=" + emailId + ", email=" + email + ", enteredDate=" + enteredDate + "]";
    }

}
