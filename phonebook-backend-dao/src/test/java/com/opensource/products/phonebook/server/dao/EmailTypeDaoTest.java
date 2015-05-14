package com.opensource.products.phonebook.server.dao;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensource.products.phonebook.server.domain.EmailTypeEntity;

public class EmailTypeDaoTest extends BaseDaoTests
{

    final Logger logger = LoggerFactory.getLogger(EmailTypeDaoTest.class);

    @Autowired
    private EmailTypeDao emailTypeDao;

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
    }

    @Test
    public void testEmailTypeSave()
    {
        System.out.println("testEmailTypeSave: START");
        // =================================================================================
        String emailTypeName = "Test";
        boolean emailActive = true;
        String emailTypeDescription = "Test Description";
        // =================================================================================
        EmailTypeEntity emailType = new EmailTypeEntity();
        emailType.setId(0);
        emailType.setActive(emailActive);
        emailType.setDescription(emailTypeDescription);
        System.out.println("testEmailTypeSave: " + emailTypeName + " " + emailTypeDescription);
        // ***************************************************************
        System.out.println("testEmailTypeSave: START: CREATE");
        emailType = emailTypeDao.saveEmailTypeEntity(emailType);
        assertNotNull(emailType);
        System.out.println("testEmailTypeSave: FINISH: CREATE");
        // =================================================================================
    }

    @Test
    public void testEmailTypeUpdate()
    {
        System.out.println("testEmailTypeUpdate: START");
        // =================================================================================
        String emailTypeName = "Test Upd";
        boolean emailActive = true;
        String emailTypeDescription = "Test Description Update";
        // =================================================================================
        EmailTypeEntity emailType = new EmailTypeEntity();
        emailType.setId(0);
        emailType.setActive(emailActive);
        emailType.setDescription(emailTypeDescription);
        System.out.println("testEmailTypeUpdate: " + emailTypeName + " " + emailTypeDescription);
        // ***************************************************************
        System.out.println("testEmailTypeUpdate: START: CREATE");
        emailType = emailTypeDao.saveEmailTypeEntity(emailType);
        assertNotNull(emailType);
        assertEquals(emailActive, emailType.isActive());
        assertEquals(emailTypeDescription, emailType.getDescription());
        System.out.println("testEmailTypeUpdate: FINISH: CREATE");
        // =================================================================================
    }

    @Test
    public void testEmailTypeRetrieve()
    {
        System.out.println("testEmailTypeRetrieve: START");
        // =================================================================================
        // =================================================================================
        // ***************************************************************
        System.out.println("testEmailTypeRetrieve: START: CREATE");
        List<EmailTypeEntity> emailTypes = emailTypeDao.getAllEmailTypeEntitys();
        assertNotNull(emailTypes);
        for (EmailTypeEntity emailType : emailTypes)
        {
            assertNotNull(emailType.getId());
            assertNotNull(emailType.isActive());
            assertNotNull(emailType.getDescription());
            System.out.println("testEmailTypeRetrieve: emailType=" + emailType.getId() + " " + emailType.isActive()
                + " " + emailType.getDescription());
        }
        System.out.println("testEmailTypeRetrieve: FINISH: CREATE");
        // =================================================================================
    }

    @Test
    public void testEmailTypeRetrieveById()
    {
        System.out.println("testEmailTypeRetrieveById: START");
        // =================================================================================
        // =================================================================================
        // ***************************************************************
        System.out.println("testEmailTypeRetrieveById: START: CREATE");
        EmailTypeEntity emailType = emailTypeDao.getEmailTypeEntity(1);
        assertNotNull(emailType.getId());
        assertNotNull(emailType.isActive());
        assertNotNull(emailType.getDescription());
        System.out.println("testEmailTypeRetrieveById: emailType=" + emailType.getId() + " " + emailType.isActive()
            + " " + emailType.getDescription());
        System.out.println("testEmailTypeRetrieveById: FINISH: CREATE");
        // =================================================================================
    }

    @Test
    public void testEmailTypeDelete()
    {
        System.out.println("testEmailTypeDelete: START");
        // =================================================================================
        EmailTypeEntity emailType;
        EmailTypeEntity emailTypeGet;
        // =================================================================================
        // ***************************************************************
        int id = 10;
        emailType = emailTypeDao.getEmailTypeEntity(id);
        emailTypeDao.deleteEmailTypeEntity(emailType);
        emailTypeGet = emailTypeDao.getEmailTypeEntity(id);
        assertEquals(null, emailTypeGet);
        // ***************************************************************
        System.out.println("testEmailTypeDelete: FINISH: CREATE");
        // =================================================================================
    }

    /*
    public void X_testEmailTypeEntityByName() {
    	System.out.println("testEmailTypeEntityByName: START");
    	// =================================================================================
    	String interestName1 = "TEST";
    	String interestUuid1 = "AAA";
    	String interestPath1 = "ABC/AAA";
    	EmailTypeEntity interest1 = new EmailTypeEntity();
    	interest1.setEmailTypeEntityName(interestName1);
    	interest1.setEmailTypeEntityUuid(interestUuid1);
    	interest1.setEmailTypeEntityPath(interestPath1);
    	System.out.println("testEmailTypeEntityByName: " + interestName1 + " " + interestUuid1 + " " + interestPath1);
    	interest1 = emailTypeDao.saveEmailTypeEntity(interest1);
    	assertNotNull(interest1);
    	// =================================================================================
    	String interestName2 = "TEST";
    	String interestUuid2 = "BBB";
    	String interestPath2 = "ABC/BBB";
    	EmailTypeEntity interest2 = new EmailTypeEntity();
    	interest2.setEmailTypeEntityName(interestName2);
    	interest2.setEmailTypeEntityUuid(interestUuid2);
    	interest2.setEmailTypeEntityPath(interestPath2);
    	System.out.println("testEmailTypeEntityByName: " + interestName2 + " " + interestUuid2 + " " + interestPath2);
    	interest2 = emailTypeDao.saveEmailTypeEntity(interest2);
    	assertNotNull(interest2);
    	// =================================================================================
    	String interestName3 = "TEST";
    	String interestUuid3 = "BBB";
    	String interestPath3 = "ABC/BBB";
    	EmailTypeEntity interest3 = new EmailTypeEntity();
    	interest3.setEmailTypeEntityName(interestName3);
    	interest3.setEmailTypeEntityUuid(interestUuid3);
    	interest3.setEmailTypeEntityPath(interestPath3);
    	System.out.println("testEmailTypeEntityByName: " + interestName3 + " " + interestUuid3 + " " + interestPath3);
    	interest3 = emailTypeDao.saveEmailTypeEntity(interest3);
    	assertNotNull(interest2);
    	// =================================================================================
    	String interestName = "TEST";
    	List<EmailTypeEntity> interests = emailTypeDao.getEmailTypeEntitysByName(interestName);
    	System.out.println("testEmailTypeEntityByName: interests: size=" + interests.size() );
    	assertEquals(3,interests.size());
    	// =================================================================================
    	System.out.println("testEmailTypeEntityCRUS: START: DELETE");
    	emailTypeDao.deleteEmailTypeEntity(interest1);
    	emailTypeDao.deleteEmailTypeEntity(interest2);
    	emailTypeDao.deleteEmailTypeEntity(interest3);
    	System.out.println("testEmailTypeEntityCRUS: FINISH: DELETE");
    	// =================================================================================
    }
    */

}
