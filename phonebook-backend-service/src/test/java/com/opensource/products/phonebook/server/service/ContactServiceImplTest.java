package com.opensource.products.phonebook.server.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensource.products.phonebook.server.domain.ContactEntity;
import com.opensource.products.phonebook.server.domain.UserEntity;

public class ContactServiceImplTest extends BaseServiceImplTests
{
    private static final Log logger = LogFactory.getLog(ContactServiceImplTest.class);

    @Autowired
    private ContactService service;

    @org.junit.Before
    public void setUp() throws Exception
    {
        System.out.println("setUp: service: " + service);
    }

    @org.junit.After
    public void tearDown()
    {
        service = null;
        System.out.println("tearDown: context set null.");
    }

    private final static int id = 0;
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
    private final static Date enteredDate = new Date();
    private final static long editedBy = 1;
    private final static Date editedDate = new Date();

    private final static Date birthDate = new Date();
    private final static boolean admin = false;

    private ContactEntity createContactEntity()
    {
        long userId = 2;
        UserEntity user = new UserEntity();
        user.setUserId(userId);

        ContactEntity contactEntity = new ContactEntity();
        contactEntity.setUser(user);
        contactEntity.setContactId(id);

        contactEntity.setPrefix(prefix);
        contactEntity.setFirstName(firstname);
        contactEntity.setMiddleName(middlename);
        contactEntity.setLastName(lastname);
        contactEntity.setPrefix(suffix);

        contactEntity.setAddress1(address1);
        contactEntity.setAddress2(address2);
        contactEntity.setCity(city);
        contactEntity.setState(state);
        contactEntity.setZip(zip);

        contactEntity.setEnteredBy(enteredBy);
        contactEntity.setEnteredDate(enteredDate);
        contactEntity.setEditedBy(editedBy);
        contactEntity.setEditedDate(editedDate);

        // contactEntity.setCompanyId(companyId);
        contactEntity.setBirthDate(birthDate);

        return contactEntity;
    }

    // @Test
    public void testCreateContact() throws Exception
    {
        ContactEntity contactEntity = createContactEntity();
        // ==================================================
        ContactEntity newContactDto = null; // service.add(contactDto);
        assertNotNull(newContactDto);
        // ==================================================
    }

    @Test
    public void testFetchAll() throws Exception
    {
        ContactEntity dummy = new ContactEntity();
        dummy.setFirstName("test_description");
        // ==================================================
        List<ContactEntity> contactEntityList = service.getAllContacts();
        System.out.println("contacts: count=" + contactEntityList.size());
        assertNotNull(contactEntityList);
        // ==================================================
    }

    // @Test
    public void testFetchByExample() throws Exception
    {
        ContactEntity dummy = new ContactEntity();
        dummy.setCity(city);
        // ==================================================
        List<ContactEntity> contacts = null; // service.fetch(dummy);
        ContactEntity contact = contacts.get(0);
        System.out.println("testFetchByExample: contacts: id=" + contact.getContactId());
        System.out.println("testFetchByExample: contacts: firstname=" + contact.getFirstName());
        System.out.println("testFetchByExample: contacts: lastname=" + contact.getLastName());
        System.out.println("testFetchByExample: contacts=" + contact.toString());
        assertNotNull(contact);
        // ==================================================
    }

    // @Test
    public void testFetchByUserExample() throws Exception
    {
        UserEntity dummy = new UserEntity();
        dummy.setUserId(2);
        // ==================================================
        List<ContactEntity> contacts = null; // service.fetch(dummy);
        ContactEntity contact = null;
        if (contacts != null)
        {
            System.out.println("testFetchByUserExample: contacts: size=" + contacts.size());
            System.out.println("testFetchByUserExample: contacts=" + contacts.toString());
            contact = contacts.get(0);
            System.out.println("testFetchByUserExample: contacts: id=" + contact.getContactId());
            System.out.println("testFetchByUserExample: contacts: firstname=" + contact.getFirstName());
            System.out.println("testFetchByUserExample: contacts: lastname=" + contact.getLastName());
            System.out.println("testFetchByUserExample: contacts=" + contact.toString());
        }
        assertNotNull(contact);
        // ==================================================
    }

    @Test
    public void testFetchById() throws Exception
    {
        long contactId = 2;
        // ==================================================
        ContactEntity contact = service.getContactById(contactId);
        System.out.println("contacts: id=" + contact.getContactId());
        System.out.println("contacts: firstname=" + contact.getFirstName());
        System.out.println("contacts: lastname=" + contact.getLastName());
        System.out.println("contacts=" + contact.toString());
        assertNotNull(contact);
        // ==================================================
    }

}
