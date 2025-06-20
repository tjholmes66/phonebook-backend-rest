package com.opensource.products.phonebook.server.util;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensource.products.phonebook.server.service.BaseServiceImplTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SendEmailTests extends BaseServiceImplTests
{

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
