package com.opensource.products.phonebook.server.controller;

import java.util.ArrayList;

import com.opensource.products.phonebook.server.domain.ContactEntity;
import com.opensource.products.phonebook.server.service.ContactService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contacts")
public class ContactController
{
    private ContactService contactService;

    public ContactController(ContactService contactService)
    {
        this.contactService = contactService;
    }

    @GetMapping(value = "", headers = "Accept=application/json", produces = "applicatio/json")
    public ArrayList<ContactEntity> getContactList1()
    {
        ArrayList<ContactEntity> contactEntityList = (ArrayList) contactService.getAllContacts();
        return contactEntityList;
    }
    
    @GetMapping(value = "/", headers = "Accept=application/json")
    public ArrayList<ContactEntity> getContactList2()
    {
        ArrayList<ContactEntity> contactEntityList = (ArrayList) contactService.getAllContacts();
        return contactEntityList;
    }

    @GetMapping(value = "/contactId/{contactId}", headers = "Accept=application/json")
    public ContactEntity getContactById(@PathVariable("contactId") long contactId)
    {
        ContactEntity contactEntity = contactService.getContactById(contactId);
        System.out.println("ContactController: retrieveContact: contactEntity=" + contactEntity);
        return contactEntity;
    }

    @GetMapping(value = "/userId/{userId}", headers = "Accept=application/json", produces = "application/json")
    public ArrayList<ContactEntity> getContactsByUserId(@PathVariable("userId") long userId)
    {
        ArrayList<ContactEntity> contactEntityList = (ArrayList) contactService.getContactsByUserId(userId);
        return contactEntityList;
    }

    @PostMapping(value = "/create", headers = "Accept=application/json", produces = "application/json")
    public ContactEntity createContact(@RequestBody ContactEntity contact)
    {
        System.out.println("ContactController: createContact: contact=" + contact);
        ContactEntity contactEntity = contactService.add(contact);
        return contactEntity;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json",
        headers = "content-type=application/json")
    public ContactEntity updateContact(@RequestBody ContactEntity contact)
    {
        System.out.println("ContactController: START: updateContact: contact=" + contact);
        ContactEntity contactEntity = contactService.update(contact);
        System.out.println("ContactController: FINISH: updateContact: contactEntity=" + contactEntity);
        return contactEntity;
    }

    @RequestMapping(value = "/delete/{contactId}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public void deleteContact(@PathVariable("contactId") long contactId)
    {
        System.out.println("ContactController: START: deleteContact: contactId=" + contactId);
        contactService.remove(contactId);
        System.out.println("ContactController: FINISH: deleteContact:");
    }

}
