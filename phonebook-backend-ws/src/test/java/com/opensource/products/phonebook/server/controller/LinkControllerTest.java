package com.opensource.products.phonebook.server.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class LinkControllerTest extends BaseControllerTests
{

    @Test
    public void testLinkController() throws Exception
    {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/test");
        this.mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isOk());
    }

}
