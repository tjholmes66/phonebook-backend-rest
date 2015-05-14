package com.opensource.products.phonebook.server.dao;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensource.products.phonebook.server.domain.PhoneTypeEntity;

public class PhoneTypeDaoTest extends BaseDaoTests
{

    final Logger logger = LoggerFactory.getLogger(PhoneTypeDaoTest.class);

    @Autowired
    private PhoneTypeDao phoneTypeDao;

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
    public void testPhoneTypeSave()
    {
        System.out.println("testPhoneTypeSave: START");
        // =================================================================================
        String phoneTypeName = "Test";
        boolean phoneActive = true;
        String phoneTypeDescription = "Test Description";
        // =================================================================================
        PhoneTypeEntity phoneType = new PhoneTypeEntity();
        phoneType.setId(0);
        phoneType.setActive(phoneActive);
        phoneType.setDescription(phoneTypeDescription);
        System.out.println("testPhoneTypeSave: " + phoneTypeName + " " + phoneTypeDescription);
        // ***************************************************************
        System.out.println("testPhoneTypeSave: START: CREATE");
        phoneType = phoneTypeDao.savePhoneTypeEntity(phoneType);
        assertNotNull(phoneType);
        System.out.println("testPhoneTypeSave: FINISH: CREATE");
        // =================================================================================
    }

    @Test
    public void testPhoneTypeUpdate()
    {
        System.out.println("testPhoneTypeUpdate: START");
        // =================================================================================
        String phoneTypeName = "Test Upd";
        boolean phoneActive = true;
        String phoneTypeDescription = "Test Description Update";
        // =================================================================================
        PhoneTypeEntity phoneType = new PhoneTypeEntity();
        phoneType.setId(0);
        phoneType.setActive(phoneActive);
        phoneType.setDescription(phoneTypeDescription);
        System.out.println("testPhoneTypeUpdate: " + phoneTypeName + " " + phoneTypeDescription);
        // ***************************************************************
        System.out.println("testPhoneTypeUpdate: START: CREATE");
        phoneType = phoneTypeDao.savePhoneTypeEntity(phoneType);
        assertNotNull(phoneType);
        assertEquals(phoneActive, phoneType.isActive());
        assertEquals(phoneTypeDescription, phoneType.getDescription());
        System.out.println("testPhoneTypeUpdate: FINISH: CREATE");
        // =================================================================================
    }

    @Test
    public void testPhoneTypeRetrieve()
    {
        System.out.println("testPhoneTypeRetrieve: START");
        // =================================================================================
        // =================================================================================
        // ***************************************************************
        System.out.println("testPhoneTypeRetrieve: START: CREATE");
        List<PhoneTypeEntity> phoneTypes = phoneTypeDao.getAllPhoneTypeEntitys();
        assertNotNull(phoneTypes);
        for (PhoneTypeEntity phoneType : phoneTypes)
        {
            assertNotNull(phoneType.getId());
            assertNotNull(phoneType.isActive());
            assertNotNull(phoneType.getDescription());
            System.out.println("testPhoneTypeRetrieve: phoneType=" + phoneType.getId() + " " + phoneType.isActive()
                + " " + phoneType.getDescription());
        }
        System.out.println("testPhoneTypeRetrieve: FINISH: CREATE");
        // =================================================================================
    }

    @Test
    public void testPhoneTypeRetrieveById()
    {
        System.out.println("testPhoneTypeRetrieveById: START");
        // =================================================================================
        // =================================================================================
        // ***************************************************************
        System.out.println("testPhoneTypeRetrieveById: START: CREATE");
        PhoneTypeEntity phoneType = phoneTypeDao.getPhoneTypeEntity(1);
        assertNotNull(phoneType.getId());
        assertNotNull(phoneType.isActive());
        assertNotNull(phoneType.getDescription());
        System.out.println("testPhoneTypeRetrieveById: phoneType=" + phoneType.getId() + " " + phoneType.isActive()
            + " " + phoneType.getDescription());
        System.out.println("testPhoneTypeRetrieveById: FINISH: CREATE");
        // =================================================================================
    }

    @Test
    public void testPhoneTypeDelete()
    {
        System.out.println("testPhoneTypeDelete: START");
        // =================================================================================
        PhoneTypeEntity phoneType;
        PhoneTypeEntity phoneTypeGet;
        // =================================================================================
        // ***************************************************************
        int id = 10;
        phoneType = phoneTypeDao.getPhoneTypeEntity(id);
        phoneTypeDao.deletePhoneTypeEntity(phoneType);
        phoneTypeGet = phoneTypeDao.getPhoneTypeEntity(id);
        assertEquals(null, phoneTypeGet);
        // ***************************************************************
        System.out.println("testPhoneTypeDelete: FINISH: CREATE");
        // =================================================================================
    }

    /*
    public void X_testPhoneTypeEntityByName() {
        System.out.println("testPhoneTypeEntityByName: START");
        // =================================================================================
        String interestName1 = "TEST";
        String interestUuid1 = "AAA";
        String interestPath1 = "ABC/AAA";
        PhoneTypeEntity interest1 = new PhoneTypeEntity();
        interest1.setPhoneTypeEntityName(interestName1);
        interest1.setPhoneTypeEntityUuid(interestUuid1);
        interest1.setPhoneTypeEntityPath(interestPath1);
        System.out.println("testPhoneTypeEntityByName: " + interestName1 + " " + interestUuid1 + " " + interestPath1);
        interest1 = phoneTypeDao.savePhoneTypeEntity(interest1);
        assertNotNull(interest1);
        // =================================================================================
        String interestName2 = "TEST";
        String interestUuid2 = "BBB";
        String interestPath2 = "ABC/BBB";
        PhoneTypeEntity interest2 = new PhoneTypeEntity();
        interest2.setPhoneTypeEntityName(interestName2);
        interest2.setPhoneTypeEntityUuid(interestUuid2);
        interest2.setPhoneTypeEntityPath(interestPath2);
        System.out.println("testPhoneTypeEntityByName: " + interestName2 + " " + interestUuid2 + " " + interestPath2);
        interest2 = phoneTypeDao.savePhoneTypeEntity(interest2);
        assertNotNull(interest2);
        // =================================================================================
        String interestName3 = "TEST";
        String interestUuid3 = "BBB";
        String interestPath3 = "ABC/BBB";
        PhoneTypeEntity interest3 = new PhoneTypeEntity();
        interest3.setPhoneTypeEntityName(interestName3);
        interest3.setPhoneTypeEntityUuid(interestUuid3);
        interest3.setPhoneTypeEntityPath(interestPath3);
        System.out.println("testPhoneTypeEntityByName: " + interestName3 + " " + interestUuid3 + " " + interestPath3);
        interest3 = phoneTypeDao.savePhoneTypeEntity(interest3);
        assertNotNull(interest2);
        // =================================================================================
        String interestName = "TEST";
        List<PhoneTypeEntity> interests = phoneTypeDao.getPhoneTypeEntitysByName(interestName);
        System.out.println("testPhoneTypeEntityByName: interests: size=" + interests.size() );
        assertEquals(3,interests.size());
        // =================================================================================
        System.out.println("testPhoneTypeEntityCRUS: START: DELETE");
        phoneTypeDao.deletePhoneTypeEntity(interest1);
        phoneTypeDao.deletePhoneTypeEntity(interest2);
        phoneTypeDao.deletePhoneTypeEntity(interest3);
        System.out.println("testPhoneTypeEntityCRUS: FINISH: DELETE");
        // =================================================================================
    }
    */

}
