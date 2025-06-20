package com.opensource.products.phonebook.server.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations =
        { "classpath:/spring/phonebook-services-context.xml" })
@Transactional
public class BaseServiceImplTests
{

}
