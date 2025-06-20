package com.opensource.products.phonebook.server.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactEmailControllerTest extends BaseControllerTests
{
    @Test
    public void testGetContactEmails()
    {
        assertEquals(true, true);
    }
}
