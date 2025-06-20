package com.opensource.products.phonebook.server.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensource.products.phonebook.server.domain.UserEntity;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LoginServiceImplTest extends BaseServiceImplTests
{
    private static final Log logger = LogFactory.getLog(LoginServiceImplTest.class);

    @Autowired
    private LoginService service;

    @Test
    public void testFetchByLogin() throws Exception
    {
        String username = "demo";
        String password = "demo";
        // ==================================================
        UserEntity user = service.login(username, password);
        assertNotNull(user);
        // ==================================================
        if (user != null)
        {
            System.out.println("users=" + user.toString());
        }
    }

    @Test
    public void testFetchByEmail() throws Exception
    {
        String email = "tom@tomholmes.net";
        // ==================================================
        UserEntity user = service.loginByEmail(email);
        assertNotNull(user);
        // ==================================================
        if (user != null)
        {
            System.out.println("users=" + user.toString());
        }
    }

    @Test
    public void testFetchByUsername() throws Exception
    {
        String username = "demo";
        // ==================================================
        UserEntity user = service.loginByUsername(username);
        assertNotNull(user);
        // ==================================================
        if (user != null)
        {
            System.out.println("users=" + user.toString());
        }
    }

}
