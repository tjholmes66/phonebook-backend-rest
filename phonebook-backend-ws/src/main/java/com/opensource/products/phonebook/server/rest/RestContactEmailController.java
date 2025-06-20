package com.opensource.products.phonebook.server.rest;

import com.opensource.products.phonebook.server.service.ContactService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/contact/email")
@CrossOrigin(origins = "*")
public class RestContactEmailController
{
    private ContactService contactService;

    
}
