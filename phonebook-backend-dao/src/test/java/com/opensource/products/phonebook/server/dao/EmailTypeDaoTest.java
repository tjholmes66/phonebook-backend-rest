package com.opensource.products.phonebook.server.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensource.products.phonebook.server.domain.EmailTypeEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EmailTypeDaoTest extends BaseDaoTests
{

    @Autowired
    private EmailTypeDao emailTypeDao;

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
        emailType.setId(null);
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
        String emailTypeName = "Test NEW";
        boolean emailActive = true;
        String emailTypeDescription = "Test Description NEW";
        // =================================================================================
        EmailTypeEntity emailTypeEntity = new EmailTypeEntity();
        emailTypeEntity.setId(null);
        emailTypeEntity.setActive(emailActive);
        emailTypeEntity.setDescription(emailTypeDescription);
        System.out.println("testEmailTypeUpdate: START: CREATE");
        EmailTypeEntity emailType = emailTypeDao.saveEmailTypeEntity(emailTypeEntity);
        assertNotNull(emailType);
        System.out.println("testEmailTypeUpdate: FINISH: CREATE");
        System.out.println("testEmailTypeUpdate: " + emailType.getId() + " " + emailType.getDescription());
        // ***************************************************************
        System.out.println("testEmailTypeUpdate: START: UPDATE");
        String emailTypeNameUpdate = "Test Updated";
        boolean emailActiveUpdate = false;
        String emailTypeDescriptionUpdate = "Test Description Updated";

        emailType.setActive(emailActiveUpdate);
        emailType.setDescription(emailTypeDescriptionUpdate);

        System.out.println("testEmailTypeUpdate: START: UPDATE");
        emailType = emailTypeDao.saveEmailTypeEntity(emailType);
        assertNotNull(emailType);
        System.out.println("testEmailTypeUpdate: FINISH: UPDATE");

        assertEquals(emailActiveUpdate, emailType.isActive());
        assertEquals(emailTypeDescriptionUpdate, emailType.getDescription());
        System.out.println("testEmailTypeUpdate: " + emailType.getId() + " " + emailType.getDescription());
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
        Long emailTypeId = 4L;
        emailType = emailTypeDao.getEmailTypeEntity(emailTypeId);
        emailTypeDao.deleteEmailTypeEntity(emailType);
        emailTypeGet = emailTypeDao.getEmailTypeEntity(emailTypeId);
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
