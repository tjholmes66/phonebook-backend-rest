package com.opensource.products.phonebook.server.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensource.products.phonebook.server.domain.ContactEmailEntity;
import com.opensource.products.phonebook.server.domain.ContactEntity;
import com.opensource.products.phonebook.server.domain.EmailTypeEntity;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ContactEmailServiceImplTest extends BaseServiceImplTests
{
    @Autowired
    private ContactEmailService service;

    private final static Long id = 0L;
    private final static String prefix = "Mr.";
    private final static String firstname = "Thomas";
    private final static String middlename = "Joseph";
    private final static String lastname = "Holmes";
    private final static String suffix = "Jr.";

    private final static String address1 = "42 Wheeler Circle";
    private final static String address2 = "Apartment 38";
    private final static String city = "Stoughton";
    private final static String state = "MA";
    private final static String zip = "02072";

    private final static long enteredBy = 1;
    private final static LocalDateTime enteredDate = LocalDateTime.now();
    private final static long editedBy = 1;
    private final static LocalDateTime editedDate = LocalDateTime.now();

    private final static LocalDate birthDate = LocalDate.now();
    private final static boolean admin = false;

    private final static String email = "111-222-1234";
    private final static long emailTypeId = 1;

    private ContactEmailEntity createContactEmailDto()
    {
        Long contactId = 4L;
        ContactEntity contactEntity = new ContactEntity();
        contactEntity.setContactId(contactId);
        // ============================================================
        ContactEmailEntity contactEmailDto = new ContactEmailEntity();
        contactEmailDto.setContact(contactEntity);
        contactEmailDto.setEmailId(id);
        contactEmailDto.setEnteredDate(enteredDate);
        contactEmailDto.setEmail(email);

        EmailTypeEntity emailType = new EmailTypeEntity();
        emailType.setId(emailTypeId);
        contactEmailDto.setEmailType(emailType);

        return contactEmailDto;
    }

// @Test
// public void testCreateContactEmail() throws Exception
// {
// System.out.println("testCreateContactEmail: START");
// ContactEmailEntity contactEmailDto = createContactEmailDto();
// // ==================================================
// ContactEmailEntity newContactEmailDto = service.add(contactEmailDto);
// assertNotNull(newContactEmailDto);
// // ==================================================
// System.out.println("testCreateContactEmail: FINISH");
// }

    @Test
    public void testRetrieveEmailsByContactDto1() throws Exception
    {
        System.out.println("testRetrieveEmailsByContactDto1: START");
        Long contactId = 1L;
        ContactEntity contactEntity = new ContactEntity();
        contactEntity.setContactId(contactId);
        // ==================================================
        List<ContactEmailEntity> contactEmails = service.getAllEmailsByContactId(contactEntity.getContactId());
        ContactEmailEntity contactEmail = null;
        if (contactEmails != null)
        {
            System.out.println("testRetrieveEmailsByContactDto1: contacts: size=" + contactEmails.size());
            System.out.println("testRetrieveEmailsByContactDto1: contacts=" + contactEmails.toString());

            if (contactEmails.size() > 0)
            {
                contactEmail = contactEmails.get(0);
                System.out.println("testRetrieveEmailsByContactDto1: contactEmail: id=" + contactEmail.getEmailId());
                System.out.println("testRetrieveEmailsByContactDto1: contactEmail: contactId="
                    + contactEmail.getContact().getContactId());
                System.out.println("testRetrieveEmailsByContactDto1: contactEmail: email=" + contactEmail.getEmail());
                System.out.println("testRetrieveEmailsByContactDto1: contactEmail=" + contactEmail.toString());
            }
        }
        assertNotNull(contactEmails);
        // ==================================================
        System.out.println("testRetrieveEmailsByContactDto1: FINISH");
    }

    @Test
    public void testRetrieveEmailsByContactDto2() throws Exception
    {
        System.out.println("testRetrieveEmailsByContactDto2: START");
        Long contactId = 4L;
        ContactEntity contactEntity = new ContactEntity();
        contactEntity.setContactId(contactId);
        // ==================================================
        List<ContactEmailEntity> contactEmails = service.getAllEmailsByContactId(contactEntity.getContactId());
        ContactEmailEntity contactEmail = null;
        if (contactEmails != null)
        {
            System.out.println("testRetrieveEmailsByContactDto2: contacts: size=" + contactEmails.size());
            System.out.println("testRetrieveEmailsByContactDto2: contacts=" + contactEmails.toString());

            if (contactEmails.size() > 0)
            {
                contactEmail = contactEmails.get(0);
                System.out.println("testRetrieveEmailsByContactDto2: contactEmail: id=" + contactEmail.getEmailId());
                System.out.println("testRetrieveEmailsByContactDto2: contactEmail: contactId="
                    + contactEmail.getContact().getContactId());
                System.out.println("testRetrieveEmailsByContactDto2: contactEmail: email=" + contactEmail.getEmail());
                System.out.println("testRetrieveEmailsByContactDto2: contactEmail=" + contactEmail.toString());
            }
        }
        assertNotNull(contactEmails);
        // ==================================================
        System.out.println("testRetrieveEmailsByContactDto2: FINISH");
    }

    @Test
    public void testFetchById() throws Exception
    {
        System.out.println("testFetchById: START");
        Long emailId = 4L;
        // ==================================================
        ContactEmailEntity contactEmail = service.getEmailContactById(emailId);
        System.out.println("testFetchById: contactEmail: id=" + contactEmail.getEmailId());
        System.out.println("testFetchById: contactEmail: contactId="
            + contactEmail.getContact().getContactId());
        System.out.println("testFetchById: contactEmail: email=" + contactEmail.getEmail());
        System.out.println("contacts=" + contactEmail.toString());
        assertNotNull(contactEmail);
        // ==================================================
        System.out.println("testFetchById: FINISH");
    }

}
