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
import java.time.LocalDate;
import java.time.LocalDateTime;

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
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

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
    private LocalDate birthdate;

}
