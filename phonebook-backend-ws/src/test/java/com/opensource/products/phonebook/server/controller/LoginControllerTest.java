package com.opensource.products.phonebook.server.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class LoginControllerTest extends BaseControllerTests
{
  
    private final static Log logger = LogFactory.getLog(LoginControllerTest.class);

    /*
     * @Test
    public void testMockGetUserByUsernameAndPassword1() throws Exception
    {
        MockHttpServletRequestBuilder requestBuilder =
            MockMvcRequestBuilders.get("/login/user/{username}/pwd/{password}");

        requestBuilder.param("username", "tholmes");
        requestBuilder.param("password", "pass11");

        //this.mockMvc.perform(requestBuilder).andDo(print());
    }
      */

    
    @Test
    public void testMockGetUserByUsernameAndPassword2() throws Exception
    {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/login/user/user1/pwd/pass11");
        this.mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void testMockGetUserByEmail() throws Exception
    {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/login/email/tom@tomholmes.net");
        this.mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isOk());
    }

}
