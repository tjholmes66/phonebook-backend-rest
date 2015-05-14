package com.opensource.products.phonebook.server.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.opensource.products.phonebook.server.domain.ContactEntity;
import com.opensource.products.phonebook.server.service.ContactService;

@Controller
@RequestMapping("/contacts")
public class ContactController
{
    @Autowired
    private ContactService service;

    @RequestMapping(value = "", method = RequestMethod.GET, headers = "Accept=application/json")
    public @ResponseBody
    ArrayList<ContactEntity> getContactList1()
    {
        ArrayList<ContactEntity> contactEntityList = (ArrayList) service.getAllContacts();
        return contactEntityList;
    }
    
    @RequestMapping(value = "/", method = RequestMethod.GET, headers = "Accept=application/json")
    public @ResponseBody
    ArrayList<ContactEntity> getContactList2()
    {
        ArrayList<ContactEntity> contactEntityList = (ArrayList) service.getAllContacts();
        return contactEntityList;
    }

    @RequestMapping(value = "/contactId/{contactId}", method = RequestMethod.GET, headers = "Accept=application/json")
    public @ResponseBody
    ContactEntity getContactById(@PathVariable("contactId") long contactId)
    {
        ContactEntity contactEntity = service.getContactById(contactId);
        System.out.println("ContactController: retrieveContact: contactEntity=" + contactEntity);
        return contactEntity;
    }

    @RequestMapping(value = "/userId/{userId}", method = RequestMethod.GET, headers = "Accept=application/json")
    public @ResponseBody
    ArrayList<ContactEntity> getContactsByUserId(@PathVariable("userId") long userId)
    {
        ArrayList<ContactEntity> contactEntityList = (ArrayList) service.getContactsByUserId(userId);
        return contactEntityList;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json",
        headers = "content-type=application/json")
    public @ResponseBody
    ContactEntity createContact(@RequestBody ContactEntity contact)
    {
        System.out.println("ContactController: createContact: contact=" + contact);
        ContactEntity contactEntity = service.add(contact);
        return contactEntity;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json",
        headers = "content-type=application/json")
    public @ResponseBody
    ContactEntity updateContact(@RequestBody ContactEntity contact)
    {
        System.out.println("ContactController: START: updateContact: contact=" + contact);
        ContactEntity contactEntity = service.update(contact);
        System.out.println("ContactController: FINISH: updateContact: contactEntity=" + contactEntity);
        return contactEntity;
    }

    @RequestMapping(value = "/delete/{contactId}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public @ResponseBody
    void deleteContact(@PathVariable("contactId") long contactId)
    {
        System.out.println("ContactController: START: deleteContact: contactId=" + contactId);
        service.remove(contactId);
        System.out.println("ContactController: FINISH: deleteContact:");
    }

}
