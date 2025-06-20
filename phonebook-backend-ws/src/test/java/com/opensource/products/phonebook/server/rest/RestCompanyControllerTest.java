package com.opensource.products.phonebook.server.rest;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextConfiguration(locations =
        { "classpath:/spring/phonebook-ws-context.xml", "file:src/main/webapp/WEB-INF/springmvc-servlet.xml" })
@Transactional
public class RestCompanyControllerTest
{
    @Autowired
    private WebApplicationContext ctx;

    protected MockMvc mockMvc;

    @BeforeEach
    public void setUp()
    {
        this.mockMvc = webAppContextSetup(ctx).build();
    }

    @Test
    public void testMockGetUserList1() throws Exception
    {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/rest/companys");
        this.mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isOk());
    }

}
