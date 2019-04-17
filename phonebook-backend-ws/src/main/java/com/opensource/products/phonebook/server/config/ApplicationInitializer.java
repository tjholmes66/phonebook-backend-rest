package com.opensource.products.phonebook.server.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{

    private static final Log logger = LogFactory.getLog(ApplicationInitializer.class);

    @Override
    protected Class<?>[] getRootConfigClasses()
    {
        return new Class[]
        { PhoneBookAppConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses()
    {
        return new Class[]
        {};
    }

    @Override
    protected String[] getServletMappings()
    {
        return new String[]
        { "/api/*" };
    }

}
