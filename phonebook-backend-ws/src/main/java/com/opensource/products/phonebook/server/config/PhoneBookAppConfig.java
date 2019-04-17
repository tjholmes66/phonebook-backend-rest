package com.opensource.products.phonebook.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@Import(value =
{ ServiceConfig.class })
@EnableWebMvc
public class PhoneBookAppConfig
{

}
