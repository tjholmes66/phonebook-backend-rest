package com.opensource.products.phonebook.server.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.opensource.products.phonebook.server.domain.ContactEntity;
import com.opensource.products.phonebook.server.domain.UserEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;


public class ContactControllerTest extends BaseControllerTests
{
    private final static Long contactId = 0L;
    // =============================================
    private final static String prefix = "Mr.";
    private final static String firstName = "contact_fn1";
    private final static String middleName = "contact_mn1";
    private final static String lastName = "contact_ln1";
    private final static String suffix = "Jr.";
    // =============================================
    private final static String address1 = "123 Main Street";
    private final static String address2 = "Apartment 38A";
    private final static String city = "Boston";
    private final static String state = "MA";
    private final static String zip = "02368-1234";
    // =============================================
    private final static int editedBy = 1;
    private final static LocalDateTime editedDate = LocalDateTime.now();
    private final static int enteredBy = 1;
    private final static LocalDateTime enteredDate = LocalDateTime.now();
    // =============================================
    private final static int companyId = 0;
    private final static LocalDate birthDate = LocalDate.now();

    // =============================================

    private ContactEntity createContactEntity()
    {
        ContactEntity contactEntity = new ContactEntity();
        contactEntity.setContactId(contactId);
        // =============================================
        contactEntity.setPrefix(prefix);
        contactEntity.setFirstName(firstName);
        contactEntity.setMiddleName(middleName);
        contactEntity.setLastName(lastName);
        contactEntity.setSuffix(suffix);
        // =============================================
        contactEntity.setAddress1(address1);
        contactEntity.setAddress2(address2);
        contactEntity.setCity(city);
        contactEntity.setState(state);
        contactEntity.setZip(zip);
        // =============================================
        contactEntity.setCompanyId(companyId);
        contactEntity.setBirthDate(birthDate);
        // =============================================
        contactEntity.setEditedBy(editedBy);
        contactEntity.setEditedDate(editedDate);
        contactEntity.setEnteredBy(enteredBy);
        contactEntity.setEnteredDate(enteredDate);
        // =============================================
        // contactEntity.setEmails(emails)
        // contactEntity.setPhones(phones)
        // contactEntity.setLinks(links)
        // =============================================
        long userId = 1;
        UserEntity user = new UserEntity();
        user.setUserId(userId);
        // =============================================
        contactEntity.setUser(user);
        // =============================================
        return contactEntity;
    }

    private final static int updId = 9;
    private final static String updEmail = "tom@tomholmes.new";
    private final static int updPositionId = 3;
    private final static String updFirstname = "tom4_upd";
    private final static String updLastname = "holmes4_upd";
    private final static String updPassword = "pass4upd";
    private final static String updSecurityQuestion1 = "question1upd";
    private final static String updSecurityQuestion2 = "question2upd";
    private final static String updSecurityAnswer1 = "answer1upd";
    private final static String updSecurityAnswer2 = "answer2upd";

    /*
    I have the following URIs:

        /contacts - Returns all contacts
        /contacts/contact/{id} - Return a specific user
        /contacts/create/{user} - Add user to db
        /contacts/update/{user} - Update user
        /contacts/delete/{id} - Delete Contact
    */

    @Test
    public void testContactJSONtoObject() throws IOException, ParseException
    {}
    
    @Test
    public void testGetContacts()
    {
        assertEquals(true, true);
    }
    
    @Test
    public void testMockGetContacts1() throws Exception
    {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/contacts");
        this.mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isOk());
    }
    
    @Test
    public void testMockGetContacts2() throws Exception
    {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/contacts/");
        this.mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void testMockGetContactByContactId() throws Exception
    {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/contacts/contactId/1");
        this.mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isOk());
    }

}
