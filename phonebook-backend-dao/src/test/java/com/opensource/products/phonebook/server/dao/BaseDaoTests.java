package com.opensource.products.phonebook.server.dao;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.opensource.products.phonebook.server.config.DatabaseConfig;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes =
{ DatabaseConfig.class })
@Transactional
public class BaseDaoTests extends TestCase
{

}
