package com.opensource.products.phonebook.server.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =
{ "classpath:/spring/phonebook-dao-context.xml" })
@Transactional
public class BaseDaoTests extends TestCase
{
    @Test
    public void testTest()
    {
        assertEquals(true, true);
    }
}
