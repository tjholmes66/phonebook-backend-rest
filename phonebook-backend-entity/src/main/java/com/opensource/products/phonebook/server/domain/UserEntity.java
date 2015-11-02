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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

// CREATE TABLE `users` (
// `user_id` int(11) NOT NULL IDENTITY_INCREMENT,
// `active` tinyint(1) NOT NULL DEFAULT '1',
// `position_id` int(11) NOT NULL DEFAULT '2',
// `username` varchar(10) NOT NULL,
// `password` varchar(15) NOT NULL,
// `firstname` varchar(45) DEFAULT NULL,
// `lastname` varchar(45) DEFAULT NULL,
// `email` varchar(45) NOT NULL,
// `security_question_1` varchar(145) NOT NULL,
// `security_answer_1` varchar(45) NOT NULL,
// `security_question_2` varchar(145) NOT NULL,
// `security_answer_2` varchar(45) NOT NULL,
// PRIMARY KEY (`user_id`),
// UNIQUE KEY `username_uq` (`username`),
// KEY `fk_users_1` (`position_id`),
// CONSTRAINT `fk_users_1` FOREIGN KEY (`position_id`) REFERENCES `position` (`position_id`) ON DELETE NO ACTION ON
// UPDATE NO ACTION
// ) ENGINE=InnoDB IDENTITY_INCREMENT=2 DEFAULT CHARSET=utf8$$

/**
 * The persistent class for the Positions database table.
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "users")
public class UserEntity implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long userId;

// `active` tinyint(1) NOT NULL DEFAULT '1',
    @Column(name = "active")
    private boolean active;

// `position_id` int(11) NOT NULL DEFAULT '2',
// bi-directional many-to-one association to ContactEntity
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "position_id")
    private PositionEntity position;

// `username` varchar(10) NOT NULL,
    @Column(name = "username")
    private String username;

// `password` varchar(15) NOT NULL,
    @Column(name = "password")
    private String password;

// `firstname` varchar(45) DEFAULT NULL,
    @Column(name = "firstname")
    private String firstname;

// `lastname` varchar(45) DEFAULT NULL,
    @Column(name = "lastname")
    private String lastname;

// `lastname` varchar(45) DEFAULT NULL,
    @Column(name = "email")
    private String email;

// `security_question_1` varchar(145) NOT NULL,
    @Column(name = "security_question_1")
    private String securityQuestion1;

// `security_answer_1` varchar(45) NOT NULL,
    @Column(name = "security_answer_1")
    private String securityAnswer1;

// `security_question_2` varchar(245) NOT NULL,
    @Column(name = "security_question_2")
    private String securityQuestion2;

// `security_answer_2` varchar(45) NOT NULL,
    @Column(name = "security_answer_2")
    private String securityAnswer2;

    @Column(name = "birthdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthdate;

    /*
    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER)
    @Cascade(
    { org.hibernate.annotations.CascadeType.ALL })
    @JoinColumn(name = "user_id")
    private Set<ContactEntity> contacts;
    */

    public long getUserId()
    {
        return userId;
    }

    public void setUserId(long userId)
    {
        this.userId = userId;
    }

    public boolean isActive()
    {
        return active;
    }

    public void setActive(boolean active)
    {
        this.active = active;
    }

    public PositionEntity getPosition()
    {
        return position;
    }

    public void setPosition(PositionEntity position)
    {
        this.position = position;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getFirstname()
    {
        return firstname;
    }

    public void setFirstname(String firstname)
    {
        this.firstname = firstname;
    }

    public String getLastname()
    {
        return lastname;
    }

    public void setLastname(String lastname)
    {
        this.lastname = lastname;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getSecurityQuestion1()
    {
        return securityQuestion1;
    }

    public void setSecurityQuestion1(String securityQuestion1)
    {
        this.securityQuestion1 = securityQuestion1;
    }

    public String getSecurityAnswer1()
    {
        return securityAnswer1;
    }

    public void setSecurityAnswer1(String securityAnswer1)
    {
        this.securityAnswer1 = securityAnswer1;
    }

    public String getSecurityQuestion2()
    {
        return securityQuestion2;
    }

    public void setSecurityQuestion2(String securityQuestion2)
    {
        this.securityQuestion2 = securityQuestion2;
    }

    public String getSecurityAnswer2()
    {
        return securityAnswer2;
    }

    public void setSecurityAnswer2(String securityAnswer2)
    {
        this.securityAnswer2 = securityAnswer2;
    }

    public Date getBirthdate()
    {
        return birthdate;
    }

    public void setBirthdate(Date birthdate)
    {
        this.birthdate = birthdate;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + (active ? 1231 : 1237);
        result = prime * result + ((birthdate == null) ? 0 : birthdate.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
        result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((position == null) ? 0 : position.hashCode());
        result = prime * result + ((securityAnswer1 == null) ? 0 : securityAnswer1.hashCode());
        result = prime * result + ((securityAnswer2 == null) ? 0 : securityAnswer2.hashCode());
        result = prime * result + ((securityQuestion1 == null) ? 0 : securityQuestion1.hashCode());
        result = prime * result + ((securityQuestion2 == null) ? 0 : securityQuestion2.hashCode());
        result = prime * result + (int) (userId ^ (userId >>> 32));
        result = prime * result + ((username == null) ? 0 : username.hashCode());
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
        UserEntity other = (UserEntity) obj;
        if (active != other.active)
            return false;
        if (birthdate == null)
        {
            if (other.birthdate != null)
                return false;
        }
        else if (!birthdate.equals(other.birthdate))
            return false;
        if (email == null)
        {
            if (other.email != null)
                return false;
        }
        else if (!email.equals(other.email))
            return false;
        if (firstname == null)
        {
            if (other.firstname != null)
                return false;
        }
        else if (!firstname.equals(other.firstname))
            return false;
        if (lastname == null)
        {
            if (other.lastname != null)
                return false;
        }
        else if (!lastname.equals(other.lastname))
            return false;
        if (password == null)
        {
            if (other.password != null)
                return false;
        }
        else if (!password.equals(other.password))
            return false;
        if (position == null)
        {
            if (other.position != null)
                return false;
        }
        else if (!position.equals(other.position))
            return false;
        if (securityAnswer1 == null)
        {
            if (other.securityAnswer1 != null)
                return false;
        }
        else if (!securityAnswer1.equals(other.securityAnswer1))
            return false;
        if (securityAnswer2 == null)
        {
            if (other.securityAnswer2 != null)
                return false;
        }
        else if (!securityAnswer2.equals(other.securityAnswer2))
            return false;
        if (securityQuestion1 == null)
        {
            if (other.securityQuestion1 != null)
                return false;
        }
        else if (!securityQuestion1.equals(other.securityQuestion1))
            return false;
        if (securityQuestion2 == null)
        {
            if (other.securityQuestion2 != null)
                return false;
        }
        else if (!securityQuestion2.equals(other.securityQuestion2))
            return false;
        if (userId != other.userId)
            return false;
        if (username == null)
        {
            if (other.username != null)
                return false;
        }
        else if (!username.equals(other.username))
            return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "UserEntity [userId=" + userId + ", active=" + active + ", position=" + position + ", username="
            + username + ", password=" + password + ", firstname=" + firstname + ", lastname=" + lastname + ", email="
            + email + ", securityQuestion1=" + securityQuestion1 + ", securityAnswer1=" + securityAnswer1
            + ", securityQuestion2=" + securityQuestion2 + ", securityAnswer2=" + securityAnswer2 + ", birthdate="
            + birthdate + "]";
    }

}
