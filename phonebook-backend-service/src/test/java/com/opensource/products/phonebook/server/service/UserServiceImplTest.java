package com.opensource.products.phonebook.server.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensource.products.phonebook.server.domain.PositionEntity;
import com.opensource.products.phonebook.server.domain.UserEntity;

public class UserServiceImplTest extends BaseServiceImplTests
{
    private static final Log logger = LogFactory.getLog(UserServiceImplTest.class);

    @Autowired
    private UserService service;

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
    private final static String email = "tom@tomholmes.new";
    private final static int positionId = 2;
    private final static String firstname = "tom_new";
    private final static String lastname = "holmes_new";
    private final static String username = "user1new";
    private final static String password = "pass1new";
    private final static String securityQuestion1 = "question1";
    private final static String securityQuestion2 = "question2";
    private final static String securityAnswer1 = "answer1";
    private final static String securityAnswer2 = "answer2";

    private UserEntity createUserEntity()
    {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(id);
        userEntity.setActive(true);
        userEntity.setEmail(email);
        PositionEntity position = new PositionEntity();
        position.setId(positionId);
        position.setActive(true);
        userEntity.setPosition(position);
        userEntity.setFirstname(firstname);
        userEntity.setLastname(lastname);
        userEntity.setUsername(username);
        userEntity.setPassword(password);
        userEntity.setSecurityQuestion1(securityQuestion1);
        userEntity.setSecurityAnswer1(securityAnswer1);
        userEntity.setSecurityQuestion2(securityQuestion2);
        userEntity.setSecurityAnswer2(securityAnswer2);
        return userEntity;
    }

    @Test
    public void testCreateUser() throws Exception
    {
        UserEntity userEntity = createUserEntity();
        // ==================================================
        UserEntity newUserEntity = service.add(userEntity);
        assertNotNull(newUserEntity);
        if (newUserEntity != null)
        {
            assertEquals(email, newUserEntity.getEmail());
        }
        // ==================================================
    }

    @Test
    public void testFetchById() throws Exception
    {
        long userId = 2;
        // ==================================================
        UserEntity user = service.getUserById(userId);
        assertNotNull(user);
        // ==================================================
        if (user != null)
        {
            System.out.println("users=" + user.toString());
        }
    }

    // @Test
    public void testUpdateById() throws Exception
    {
        long userId = 6;
        // ==================================================
        String email = "tom@tomholmes.upd";
        int positionId = 2;
        String firstname = "tom_upd";
        String lastname = "holmes_upd";
        String username = "user1upd";
        String password = "pass1upd";
        String securityQuestion1 = "question11";
        String securityQuestion2 = "question22";
        String securityAnswer1 = "answer11";
        String securityAnswer2 = "answer22";
        // ==================================================
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(userId);
        userEntity.setActive(false);
        userEntity.setEmail(email);
        PositionEntity position = new PositionEntity();
        position.setId(positionId);
        position.setActive(true);
        userEntity.setPosition(position);
        userEntity.setFirstname(firstname);
        userEntity.setLastname(lastname);
        userEntity.setUsername(username);
        userEntity.setPassword(password);
        userEntity.setSecurityQuestion1(securityQuestion1);
        userEntity.setSecurityAnswer1(securityAnswer1);
        userEntity.setSecurityQuestion2(securityQuestion2);
        userEntity.setSecurityAnswer2(securityAnswer2);
        // ==================================================
        UserEntity user = service.update(userEntity);
        assertNotNull(user);
        if (user != null)
        {
            assertEquals(email, user.getEmail());
            assertEquals(firstname, user.getFirstname());
        }
        // ==================================================
        if (user != null)
        {
            System.out.println("users=" + user.toString());
        }
    }

}
