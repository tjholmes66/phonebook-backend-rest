package com.opensource.products.phonebook.server.dao;

import java.util.List;

import com.opensource.products.phonebook.server.domain.LinkTypeEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensource.products.phonebook.server.domain.LinkTypeEntity;

import static org.junit.jupiter.api.Assertions.*;

public class LinkTypeDaoTest extends BaseDaoTests
{
    @Autowired
    private LinkTypeDao linkTypeDao;

    protected void setUp() throws Exception
    {
        System.out.println("setup: Loading application context");
        System.out.println("setup: Done loading application context");
    }

    @Test
    public void testLinkTypeSave()
    {
        System.out.println("testLinkTypeSave: START");
        // =================================================================================
        String linkTypeName = "Test";
        boolean linkActive = true;
        String linkTypeDescription = "Test Description";
        // =================================================================================
        LinkTypeEntity linkType = new LinkTypeEntity();
        linkType.setActive(linkActive);
        linkType.setDescription(linkTypeDescription);
        System.out.println("testLinkTypeSave: " + linkTypeName + " " + linkTypeDescription);
        // ***************************************************************
        System.out.println("testLinkTypeSave: START: CREATE");
        linkType = linkTypeDao.saveLinkTypeEntity(linkType);
        assertNotNull(linkType);
        System.out.println("testLinkTypeSave: FINISH: CREATE");
        // =================================================================================
    }

    @Test
    public void testLinkTypeUpdate()
    {
        System.out.println("testLinkTypeUpdate: START");
        // =================================================================================
        String linkTypeName = "Test NEW";
        boolean linkActive = true;
        String linkTypeDescription = "Test Description NEW";
        // =================================================================================
        LinkTypeEntity linkTypeEntity = new LinkTypeEntity();
        linkTypeEntity.setId(null);
        linkTypeEntity.setActive(linkActive);
        linkTypeEntity.setDescription(linkTypeDescription);
        System.out.println("testLinkTypeUpdate: START: CREATE");
        LinkTypeEntity linkType = linkTypeDao.saveLinkTypeEntity(linkTypeEntity);
        assertNotNull(linkType);
        System.out.println("testLinkTypeUpdate: FINISH: CREATE");
        System.out.println("testLinkTypeUpdate: " + linkType.getId() + " " + linkType.getDescription());
        // ***************************************************************
        System.out.println("testLinkTypeUpdate: START: UPDATE");
        String linkTypeNameUpdate = "Test Updated";
        boolean linkActiveUpdate = false;
        String linkTypeDescriptionUpdate = "Test Description Updated";

        linkType.setActive(linkActiveUpdate);
        linkType.setDescription(linkTypeDescriptionUpdate);

        System.out.println("testLinkTypeUpdate: START: UPDATE");
        linkType = linkTypeDao.saveLinkTypeEntity(linkType);
        assertNotNull(linkType);
        System.out.println("testLinkTypeUpdate: FINISH: UPDATE");

        assertEquals(linkActiveUpdate, linkType.isActive());
        assertEquals(linkTypeDescriptionUpdate, linkType.getDescription());
        System.out.println("testLinkTypeUpdate: " + linkType.getId() + " " + linkType.getDescription());
        // =================================================================================
    }

    @Test
    public void testLinkTypeRetrieve()
    {
        System.out.println("testLinkTypeRetrieve: START");
        // =================================================================================
        // =================================================================================
        // ***************************************************************
        System.out.println("testLinkTypeRetrieve: START: CREATE");
        List<LinkTypeEntity> linkTypes = linkTypeDao.getAllLinkTypeEntitys();
        assertNotNull(linkTypes);
        for (LinkTypeEntity linkType : linkTypes)
        {
            assertNotNull(linkType.getId());
            assertNotNull(linkType.isActive());
            assertNotNull(linkType.getDescription());
            System.out.println("testLinkTypeRetrieve: linkType=" + linkType.getId() + " " + linkType.isActive() + " "
                + linkType.getDescription());
        }
        System.out.println("testLinkTypeRetrieve: FINISH: CREATE");
        // =================================================================================
    }

    @Test
    public void testLinkTypeRetrieveById()
    {
        System.out.println("testLinkTypeRetrieveById: START");
        // =================================================================================
        // =================================================================================
        // ***************************************************************
        System.out.println("testLinkTypeRetrieveById: START: CREATE");
        LinkTypeEntity linkType = linkTypeDao.getLinkTypeEntity(1);
        assertNotNull(linkType.getId());
        assertNotNull(linkType.isActive());
        assertNotNull(linkType.getDescription());
        System.out.println("testLinkTypeRetrieveById: linkType=" + linkType.getId() + " " + linkType.isActive() + " "
            + linkType.getDescription());
        System.out.println("testLinkTypeRetrieveById: FINISH: CREATE");
        // =================================================================================
    }

    @Test
    public void testLinkTypeDeleteById()
    {
        System.out.println("testLinkTypeDeleteById: START");
        // =================================================================================
        LinkTypeEntity linkType = null;
        LinkTypeEntity linkTypeGet = null;
        // =================================================================================
        // ***************************************************************
        Long linkTypeId = 8L;
        System.out.println("testLinkTypeDeleteById: START: delete");
        linkTypeDao.deleteLinkTypeEntity(linkTypeId);
        System.out.println("testLinkTypeDeleteById: FINISH: delete");
        linkTypeGet = linkTypeDao.getLinkTypeEntity(linkTypeId);
        assertNull(linkTypeGet);
        // ***************************************************************
        System.out.println("testLinkTypeDeleteById: FINISH");
        // =================================================================================
    }

    @Test
    public void testLinkTypeDeleteByEntity()
    {
        System.out.println("testLinkTypeDelete: START");
        // =================================================================================
        LinkTypeEntity linkType = null;
        LinkTypeEntity linkTypeGet = null;
        // =================================================================================
        // ***************************************************************
        Long linkTypeId = 8L;
        linkType = linkTypeDao.getLinkTypeEntity(linkTypeId);
        linkTypeDao.deleteLinkTypeEntity(linkType);
        linkTypeGet = linkTypeDao.getLinkTypeEntity(linkTypeId);
        assertEquals(null, linkTypeGet);
        // ***************************************************************
        System.out.println("testLinkTypeDelete: FINISH: CREATE");
        // =================================================================================
    }

    /*
    public void X_testLinkTypeEntityByName() {
        System.out.println("testLinkTypeEntityByName: START");
        // =================================================================================
        String interestName1 = "TEST";
        String interestUuid1 = "AAA";
        String interestPath1 = "ABC/AAA";
        LinkTypeEntity interest1 = new LinkTypeEntity();
        interest1.setLinkTypeEntityName(interestName1);
        interest1.setLinkTypeEntityUuid(interestUuid1);
        interest1.setLinkTypeEntityPath(interestPath1);
        System.out.println("testLinkTypeEntityByName: " + interestName1 + " " + interestUuid1 + " " + interestPath1);
        interest1 = linkTypeDao.saveLinkTypeEntity(interest1);
        assertNotNull(interest1);
        // =================================================================================
        String interestName2 = "TEST";
        String interestUuid2 = "BBB";
        String interestPath2 = "ABC/BBB";
        LinkTypeEntity interest2 = new LinkTypeEntity();
        interest2.setLinkTypeEntityName(interestName2);
        interest2.setLinkTypeEntityUuid(interestUuid2);
        interest2.setLinkTypeEntityPath(interestPath2);
        System.out.println("testLinkTypeEntityByName: " + interestName2 + " " + interestUuid2 + " " + interestPath2);
        interest2 = linkTypeDao.saveLinkTypeEntity(interest2);
        assertNotNull(interest2);
        // =================================================================================
        String interestName3 = "TEST";
        String interestUuid3 = "BBB";
        String interestPath3 = "ABC/BBB";
        LinkTypeEntity interest3 = new LinkTypeEntity();
        interest3.setLinkTypeEntityName(interestName3);
        interest3.setLinkTypeEntityUuid(interestUuid3);
        interest3.setLinkTypeEntityPath(interestPath3);
        System.out.println("testLinkTypeEntityByName: " + interestName3 + " " + interestUuid3 + " " + interestPath3);
        interest3 = linkTypeDao.saveLinkTypeEntity(interest3);
        assertNotNull(interest2);
        // =================================================================================
        String interestName = "TEST";
        List<LinkTypeEntity> interests = linkTypeDao.getLinkTypeEntitysByName(interestName);
        System.out.println("testLinkTypeEntityByName: interests: size=" + interests.size() );
        assertEquals(3,interests.size());
        // =================================================================================
        System.out.println("testLinkTypeEntityCRUS: START: DELETE");
        linkTypeDao.deleteLinkTypeEntity(interest1);
        linkTypeDao.deleteLinkTypeEntity(interest2);
        linkTypeDao.deleteLinkTypeEntity(interest3);
        System.out.println("testLinkTypeEntityCRUS: FINISH: DELETE");
        // =================================================================================
    }
    */

}
