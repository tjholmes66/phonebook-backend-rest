package com.opensource.products.phonebook.server.domain;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/*
 * CREATE TABLE `dict_suffix` (
 * `dict_suffix_id` int NOT NULL AUTO_INCREMENT,
 * `dict_suffix_name` varchar(45) NOT NULL,
 * `dict_suffix_active` tinyint(1) NOT NULL DEFAULT '1',
 * PRIMARY KEY (`dict_suffix_id`)
 * ) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
 * 
 */

public class SuffixEntity
{
    // `dict_suffix_id` int NOT NULL AUTO_INCREMENT,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dict_suffix_id")
    private Long suffixId;

    // `dict_suffix_name` varchar(45) NOT NULL,
    @Column(name = "dict_suffix_name")
    private Boolean suffixName;

    // `dict_suffix_active` tinyint(1) NOT NULL DEFAULT '1',
    @Column(name = "active")
    private Boolean active;

}
