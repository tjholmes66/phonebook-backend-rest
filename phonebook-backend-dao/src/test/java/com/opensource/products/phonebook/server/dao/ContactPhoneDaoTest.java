package com.opensource.products.phonebook.server.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensource.products.phonebook.server.domain.ContactEntity;
import com.opensource.products.phonebook.server.domain.ContactPhoneEntity;
import com.opensource.products.phonebook.server.domain.PhoneTypeEntity;

public class ContactPhoneDaoTest extends BaseDaoTests
{

    final Logger logger = LoggerFactory.getLogger(ContactPhoneDaoTest.class);

    private SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

    @Autowired
    private ContactDao contactDao;
    @Autowired
    private ContactPhoneDao contactPhoneDao;

    private long id = 2;
    private boolean active = true;
    private String address1 = "123 main street";
    private String address2 = "Apt. 456";
    private boolean admin = false;
    private String dob = "11/03/1966";
    private Date birthDate = null;
    private String city = "Randolph";
    private long companyId = 0;
    private String firstName = "first_name";
    private String lastName = "last_name";
    private String password = "password";
    private String username = "username";
    private String prefix = "Mr.";
    private String suffix = "Jr.";
    private String state = "MA";
    private String zip = "12345-1234";
    private String phoneNew = "tom@tomholmes.net";
    private String phoneUpd = "tholmes@yahoo.com";
    private long phoneTypeId = 1;
    private long contactId = 4;

    private ContactEntity contact;

    protected void setUp() throws Exception
    {
        System.out.println("setup: Loading application context");
        System.out.println("setup: Done loading application context");
    }

    protected void tearDown() throws Exception
    {
        super.tearDown();
        System.out.println("tearDown: START");
        System.out.println("tearDown: FINISH");
        contact = null;
    }

    @Test
    public void testContactPhoneFetchByContact() throws Exception
    {
        long contactId = 0; // should be no results for contactId=4
        System.out.println("testContactPhoneFetchByContact: START");

        List<ContactPhoneEntity> contactPhones = contactPhoneDao.getContactPhoneEntityByContactId(contactId);
        if (contactPhones != null)
        {
            System.out.println("testContactPhoneFetchByContact: size=" + contactPhones.size());
        }
        assertEquals(0, contactPhones.size());

        System.out.println("testContactPhoneFetchByContact: FINISH");
    }

    @Test
    public void testCreate() throws Exception
    {
        System.out.println("testCreate: START");
        // =================================================================================
        PhoneTypeEntity phoneType = new PhoneTypeEntity();
        phoneType.setId(phoneTypeId);
        contact = contactDao.getContactEntity(contactId);
        // =================================================================================
        ContactPhoneEntity contactPhone = new ContactPhoneEntity();
        // contactPhone.setId(id);
        contactPhone.setContact(contact);
        contactPhone.setPhone(phoneNew);
        contactPhone.setEnteredDate(new Date());
        contactPhone.setPhoneType(phoneType);
        System.out.println("testCreate: " + contactPhone.toString());
        // ***************************************************************
        System.out.println("testCreate: START: CREATE");
        contactPhone = contactPhoneDao.saveContactPhoneEntity(contactPhone);
        assertNotNull(contactPhone);
        System.out.println("testCreate: FINISH: CREATE");
        // =================================================================================
        System.out.println("testCreate: START");
        List<ContactPhoneEntity> contactPhones = contactPhoneDao.getContactPhoneEntityByContactId(contactId);
        if (contactPhones != null)
        {
            System.out.println("testCreate: size=" + contactPhones.size());
        }
        assertNotNull(contactPhones.size());
        System.out.println("testCreate: FINISH");
        // =================================================================================
        // contactPhoneDao.deleteContactPhoneEntity(contactPhone);
    }

    // @Test
    public void testContactRetrieve()
    {
        System.out.println("testContactRetrieve: START");
        // =================================================================================
        // =================================================================================
        // ***************************************************************
        System.out.println("testContactRetrieve: START: CREATE");
        List<ContactPhoneEntity> contactPhones = contactPhoneDao.getAllContactPhoneEntitys();
        assertNotNull(contactPhones);
        for (ContactPhoneEntity contactPhone : contactPhones)
        {
            assertNotNull(contactPhone.getPhoneId());
            assertNotNull(contactPhone.getContact());
            assertNotNull(contactPhone.getPhoneType());
            assertEquals(contactPhone.getContact().getContactId(), id);
            assertEquals(contactPhone.getPhoneType().getId(), phoneTypeId);
            // ************************************************************
            System.out.println("testContactRetrieve: contactPhone=" + contactPhone.toString());
        }
        System.out.println("testContactRetrieve: FINISH: CREATE");
        // =================================================================================
    }

    // @Test
    public void testContactRetrieveById()
    {
        System.out.println("testContactRetrieveById: START");
        // =================================================================================
        // =================================================================================
        // ***************************************************************
        System.out.println("testContactRetrieveById: START: CREATE");
        ContactPhoneEntity contactPhone = contactPhoneDao.getContactPhoneEntity(id);
        assertNotNull(contactPhone.getPhoneId());
        // ************************************************************
        assertNotNull(contactPhone.getPhoneId());
        assertNotNull(contactPhone.getContact());
        assertNotNull(contactPhone.getPhoneType());
        assertEquals(contactPhone.getContact().getContactId(), id);
        assertEquals(contactPhone.getPhoneType().getId(), phoneTypeId);
        // ************************************************************
        System.out.println("testContactRetrieve: contactPhone=" + contactPhone.toString());
        System.out.println("testContactRetrieveById: FINISH: CREATE");
        // =================================================================================
    }

    // @Test
    public void XtestContactDelete()
    {
        System.out.println("testContactDelete: START");
        // =================================================================================
        ContactPhoneEntity contactPhone;
        ContactPhoneEntity contactPhoneGet;
        // =================================================================================
        // ***************************************************************
        int id = 10;
        contactPhone = contactPhoneDao.getContactPhoneEntity(id);
        contactPhoneDao.deleteContactPhoneEntity(contactPhone);
        contactPhoneGet = contactPhoneDao.getContactPhoneEntity(id);
        assertEquals(null, contactPhoneGet);
        // ***************************************************************
        System.out.println("testContactDelete: FINISH: CREATE");
        // =================================================================================
    }

    /*
    public void X_testContactPhoneEntityByName() {
        System.out.println("testContactPhoneEntityByName: START");
        // =================================================================================
        String interestName1 = "TEST";
        String interestUuid1 = "AAA";
        String interestPath1 = "ABC/AAA";
        ContactPhoneEntity interest1 = new ContactPhoneEntity();
        interest1.setContactPhoneEntityName(interestName1);
        interest1.setContactPhoneEntityUuid(interestUuid1);
        interest1.setContactPhoneEntityPath(interestPath1);
        System.out.println("testContactPhoneEntityByName: " + interestName1 + " " + interestUuid1 + " " + interestPath1);
        interest1 = contactPhoneDao.saveContactPhoneEntity(interest1);
        assertNotNull(interest1);
        // =================================================================================
        String interestName2 = "TEST";
        String interestUuid2 = "BBB";
        String interestPath2 = "ABC/BBB";
        ContactPhoneEntity interest2 = new ContactPhoneEntity();
        interest2.setContactPhoneEntityName(interestName2);
        interest2.setContactPhoneEntityUuid(interestUuid2);
        interest2.setContactPhoneEntityPath(interestPath2);
        System.out.println("testContactPhoneEntityByName: " + interestName2 + " " + interestUuid2 + " " + interestPath2);
        interest2 = contactPhoneDao.saveContactPhoneEntity(interest2);
        assertNotNull(interest2);
        // =================================================================================
        String interestName3 = "TEST";
        String interestUuid3 = "BBB";
        String interestPath3 = "ABC/BBB";
        ContactPhoneEntity interest3 = new ContactPhoneEntity();
        interest3.setContactPhoneEntityName(interestName3);
        interest3.setContactPhoneEntityUuid(interestUuid3);
        interest3.setContactPhoneEntityPath(interestPath3);
        System.out.println("testContactPhoneEntityByName: " + interestName3 + " " + interestUuid3 + " " + interestPath3);
        interest3 = contactPhoneDao.saveContactPhoneEntity(interest3);
        assertNotNull(interest2);
        // =================================================================================
        String interestName = "TEST";
        List<ContactPhoneEntity> interests = contactPhoneDao.getContactPhoneEntitysByName(interestName);
        System.out.println("testContactPhoneEntityByName: interests: size=" + interests.size() );
        assertEquals(3,interests.size());
        // =================================================================================
        System.out.println("testContactPhoneEntityCRUS: START: DELETE");
        contactPhoneDao.deleteContactPhoneEntity(interest1);
        contactPhoneDao.deleteContactPhoneEntity(interest2);
        contactPhoneDao.deleteContactPhoneEntity(interest3);
        System.out.println("testContactPhoneEntityCRUS: FINISH: DELETE");
        // =================================================================================
    }
    */

    // @Test
    public void testContactUpdate()
    {
        System.out.println("testContactUpdate: START");
        // =================================================================================
        String updateCity = "Randolph";
        String updateFirstName = "updated_fn";
        String updateLastName = "updated_ln";
        String updatePassword = "updated_pwd";
        String updateUsername = "updated_username";
        // =================================================================================
        ContactPhoneEntity contactPhone = contactPhoneDao.getContactPhoneEntity(id);
// assertEquals(contactPhone.getAddress1(),address1);
// assertEquals(contactPhone.getAddress2(),address2);
// assertEquals(contactPhone.getCity(),city);
// assertEquals(contactPhone.getCompanyId(),companyId);
// assertEquals(contactPhone.getFirstName(),firstName);
// assertEquals(contactPhone.getId(),id);
// assertEquals(contactPhone.getLastName(),lastName);
// //assertEquals(contactPhone.getMiddleName(),middleName);
// assertEquals(contactPhone.getPassword(),password);
// assertEquals(contactPhone.getPrefix(),prefix);
// assertEquals(contactPhone.getState(),state);
// assertEquals(contactPhone.getSuffix(),suffix);
// assertEquals(contactPhone.getUsername(),username);
// assertEquals(contactPhone.getZip(),zip);
        System.out.println("testContactUpdate: " + contactPhone.toString());
        // ***************************************************************
// contactPhone.setCity(updateCity);
// contactPhone.setFirstName(updateFirstName);
// contactPhone.setLastName(updateLastName);
// contactPhone.setPassword(updatePassword);
// contactPhone.setUsername(updateUsername);
        // ***************************************************************
        System.out.println("testContactUpdate: START: CREATE");
        contactPhone = contactPhoneDao.saveContactPhoneEntity(contactPhone);
        assertNotNull(contactPhone);
// assertEquals(contactPhone.getCity(),updateCity);
// assertEquals(contactPhone.getFirstName(),updateFirstName);
// assertEquals(contactPhone.getLastName(),updateLastName);
// assertEquals(contactPhone.getPassword(),updatePassword);
// assertEquals(contactPhone.getUsername(),updateUsername);
        System.out.println("testContactUpdate: FINISH: CREATE");
        // =================================================================================
    }

}
