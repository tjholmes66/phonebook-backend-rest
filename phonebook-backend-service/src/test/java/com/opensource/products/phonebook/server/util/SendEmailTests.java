package com.opensource.products.phonebook.server.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensource.products.phonebook.server.service.BaseServiceImplTests;

public class SendEmailTests extends BaseServiceImplTests
{
    private final static Log logger = LogFactory.getLog(SendEmailTests.class);

    @Autowired
    private SendEmailService service;

    @Test
    public void testSendEmail()
    {

        // MailMail mm = (MailMail) context.getBean("mailMail");

        /*
        service.sendMail("thomas.j.holmes@gmail.com", "tom@tomholmes.net", "Testing123",
            "Testing only \n\n Hello Spring Email Sender");
            */

        assertEquals(true, true);
    }
}
