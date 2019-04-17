package com.opensource.products.phonebook.server.service;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.opensource.products.phonebook.server.config.ServiceConfig;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes =
{ ServiceConfig.class })
@Transactional
public class BaseServiceImplTests extends TestCase
{

}
