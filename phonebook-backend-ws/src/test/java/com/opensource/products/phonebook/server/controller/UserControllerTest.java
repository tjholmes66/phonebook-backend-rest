package com.opensource.products.phonebook.server.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.opensource.products.phonebook.server.domain.PositionEntity;
import com.opensource.products.phonebook.server.domain.UserEntity;

public class UserControllerTest extends BaseControllerTests
{
    
    private final static Log logger = LogFactory.getLog(UserControllerTest.class);

    private final static int id = 0;
    private final static String email = "tom@tomholmes.new";
    private final static int positionId = 2;
    private final static String firstname = "tom5_new";
    private final static String lastname = "holmes5_new";
    private final static String username = "user5new";
    private final static String password = "pass5new";
    private final static String securityQuestion1 = "question1new";
    private final static String securityQuestion2 = "question2new";
    private final static String securityAnswer1 = "answer1new";
    private final static String securityAnswer2 = "answer2ew";

    private UserEntity createUserEntity()
    {
        UserEntity userEntity = new UserEntity();
        // =============================================
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
        // =============================================
        return userEntity;
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

    private UserEntity updateUserDto(UserEntity userEntity)
    {
        userEntity.setUserId(updId);
        userEntity.setActive(false);
        userEntity.setEmail(updEmail);
        // ------------------------------------------
        PositionEntity position = new PositionEntity();
        position.setId(updPositionId);
        position.setActive(true);
        userEntity.setPosition(position);
        // ------------------------------------------
        userEntity.setFirstname(updFirstname);
        userEntity.setLastname(updLastname);
        userEntity.setPassword(updPassword);
        userEntity.setSecurityQuestion1(updSecurityQuestion1);
        userEntity.setSecurityAnswer1(updSecurityAnswer1);
        userEntity.setSecurityQuestion2(updSecurityQuestion2);
        userEntity.setSecurityAnswer2(updSecurityAnswer2);
        // ------------------------------------------
        return userEntity;
    }

    /*
    I have the following URIs:

        /users - Returns all users
        /users/ - Returns all users
        /users/user/{id} - Return a specific user
        /users/create/{user} - Add user to db
        /users/update/{user} - Update user
        /users/delete/{id} - Delete User
    */

    @Test
    public void testMockGetUserList1() throws Exception
    {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users/");
        this.mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isOk());
    }
    
    @Test
    public void testMockGetUserList2() throws Exception
    {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users");
        this.mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void testMockGetUserByUserId() throws Exception
    {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users/userId/1");
        this.mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isOk());
    }

}
