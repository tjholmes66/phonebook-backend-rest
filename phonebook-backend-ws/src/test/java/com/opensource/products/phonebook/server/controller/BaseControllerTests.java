package com.opensource.products.phonebook.server.controller;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.text.SimpleDateFormat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextConfiguration(locations =
        { "classpath:/spring/phonebook-ws-context.xml", "file:src/main/webapp/WEB-INF/springmvc-servlet.xml" })
@Transactional
public class BaseControllerTests
{
	public final static String BASE_URL = "http://localhost:8080/";

    public final static String DATE_FORMAT = "yyyy-MM-dd";

    private final SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

    @Autowired
    private WebApplicationContext ctx;

    protected MockMvc mockMvc;

    @BeforeEach
    public void setUp()
    {
        this.mockMvc = webAppContextSetup(ctx).build();
    }

}
