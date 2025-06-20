package com.opensource.products.phonebook.server.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opensource.products.phonebook.server.dao.UserDao;
import com.opensource.products.phonebook.server.domain.PositionEntity;
import com.opensource.products.phonebook.server.domain.UserEntity;
import com.opensource.products.phonebook.server.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.time.LocalDate;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextConfiguration(locations =
        { "classpath:/spring/phonebook-ws-context.xml", "file:src/main/webapp/WEB-INF/springmvc-servlet.xml" })
@Transactional
public class RestUserControllerTest
{
    private final static String BASE_URL = "/rest/users";

    private final static long userId = 0;
    private final static boolean active = true;
    // =============================================
    private final static String firstName = "user_fn1";
    private final static String lastName = "user_ln1";
    // =============================================
    private final static String username = "User_Name";
    private final static String password = "PassWord";
    private final static LocalDate birthDate = LocalDate.now();
    private final static String email = "user@email.com";
    // =============================================
    private final static String securityQuestion1 = "Security Question One";
    private final static String securityAnswer1 = "Security Answer One";
    private final static String securityQuestion2 = "Security Question Two";
    private final static String securityAnswer2 = "Security Answer Two";
    // =============================================
    private final static long editedBy = 1;
    private final static LocalDateTime editedDate = LocalDateTime.now();
    private final static long enteredBy = 1;
    private final static LocalDateTime enteredDate = LocalDateTime.now();
    // =============================================
    private final static long companyId = 0;


    @Autowired
    private UserDao userRepository;

    @Autowired
    protected WebApplicationContext context;

    protected MockMvc mockMvc;

    @Autowired
    private UserServiceImpl userService;

    @BeforeEach
    public void setUp()
    {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    // =============================================

    private UserEntity createUserEntity()
    {
        UserEntity userEntity = new UserEntity();
        userEntity.setActive(active);
        //userEntity.setUserId(userId); - DO NOT SET
        // =============================================
        userEntity.setFirstname(firstName);
        userEntity.setLastname(lastName);
        // =============================================
        userEntity.setSecurityQuestion1(securityQuestion1);
        userEntity.setSecurityAnswer1(securityAnswer1);
        userEntity.setSecurityQuestion2(securityQuestion2);
        userEntity.setSecurityAnswer2(securityAnswer2);
        // =============================================
        userEntity.setUsername(username);
        userEntity.setPassword(password);
        userEntity.setEmail(email);
        userEntity.setBirthdate(birthDate);
        // =============================================
        Long positionId = 1L;
        PositionEntity positionEntity = new PositionEntity();
        positionEntity.setId(positionId);
        userEntity.setPosition(positionEntity);
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

    /*
    I have the following URIs:
    
        /users - Returns all users
        /users/user/{id} - Return a specific user
        /users/create/{user} - Add user to db
        /users/update/{user} - Update user
        /users/delete/{id} - Delete User
    */

    // @RequestMapping(value = "", method = RequestMethod.GET, headers = "Accept=application/json")
    // public ArrayList<UserEntity> getUserList1()
    @Test
    public void testGetUserList1() throws Exception
    {
        System.out.println("testGetUserList1: START");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(BASE_URL);
        this.mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isOk());
        System.out.println("testGetUserList1: FINISH");
    }

    // @RequestMapping(value = "/", method = RequestMethod.GET, headers = "Accept=application/json")
    // public @ResponseBody ArrayList<UserEntity> getUserList2()
    @Test
    public void testGetUserList2() throws Exception
    {
        System.out.println("testGetUserList2: START");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(BASE_URL + "/");
        this.mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isOk());
        System.out.println("testGetUserList2: FINISH");
    }

    // @RequestMapping(value = "/userId/{userId}", method = RequestMethod.GET, headers =
    // "Accept=application/json")
    // public @ResponseBody UserEntity getUserById(@PathVariable("userId") long userId)
    @Test
    public void testGetUserById() throws Exception
    {
        System.out.println("testGetUserById: START");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(BASE_URL + "/userId/6");
        this.mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isOk());
        System.out.println("testGetUserById: FINISH");
    }

    // @PostMapping(value = "/create", produces = "application/json", headers = "content-type=application/json")
    // public @ResponseBody UserEntity createUser(@RequestBody UserEntity user)
    @Test
    public void testCreateUser() throws Exception
    {
        UserEntity userEntity = createUserEntity();

        ObjectMapper mapper = new ObjectMapper();
        // Register the JavaTimeModule
        mapper.registerModule(new JavaTimeModule());
        // Optional: Disable writing dates as timestamps
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        String json = mapper.writeValueAsString(userEntity);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post(BASE_URL + "/create").content(json).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
        this.mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isOk());
    }


    // @PutMapping(value = "/update", produces = "application/json", headers = "content-type=application/json")
    // public @ResponseBody UserEntity updateUser(@RequestBody UserEntity user)
    @Test
    public void testUpdateUser() throws Exception
    {
       Long userId = 14L;
        UserEntity userEntity =  userRepository.getUserEntity(userId);
        userEntity.setUsername("USER_NAME");
        userEntity.setPassword("PASS_WORD");

        ObjectMapper mapper = new ObjectMapper();
        // Register the JavaTimeModule
        mapper.registerModule(new JavaTimeModule());
        // Optional: Disable writing dates as timestamps
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        String json = mapper.writeValueAsString(userEntity);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put(BASE_URL + "/update").content(json).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
        this.mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isOk());
    }

    // @DeleteMapping(value = "/delete/{userId}",  headers = "Accept=application/json")
    //public @ResponseBody void deleteUser(@PathVariable("userId") long userId)


}
