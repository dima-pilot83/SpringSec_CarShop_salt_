package ua.kiev.prog.controller;

import config.TestDataBaseConfig;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ua.kiev.prog.service.UserService;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.*;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.*;

/**
 * Created by Dmitriy on 12.03.2018.
 */

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataBaseConfig.class)
@WebAppConfiguration
public class MyControllerTest {

    @Resource
    private EntityManagerFactory emf;
    protected EntityManager em;

    @Resource
    private UserService userService;

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    private FilterChainProxy springSecurityFilterChain;


    @Before
    public void setUp() throws Exception {
        em = emf.createEntityManager();
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .apply(springSecurity())
                .build();
    }

    @Test
    public void createUserInDB() throws Exception {
        userService.addUser(DataUtil.createCustomUser());
        assertEquals(DataUtil.name, DataUtil.createCustomUser().getName());
        assertNotNull(userService.getUserByLogin(DataUtil.createCustomUser().getLogin()));
    }

    @Test
    public void testCreateUserSuccessfully() throws Exception {
        mockMvc.perform(post("/newuser")
                .param("login", "LOGIN")
                .param("password", "PASSWORD")
                .param("email", "lll@lll"))
                .andExpect(redirectedUrl("/"))
                .andExpect(status().is(302))
                .andDo(print())
                .andReturn().getResponse().getContentAsString();

    }

    @Test
    public void testAdminEnterLoginPageSuccessfully() throws Exception {
        userService.addUser(DataUtil.createAdminUser());
        mockMvc.perform(formLogin("/login").user(DataUtil.loginAdmin).password(DataUtil.pass))
                .andExpect(redirectedUrl("/"))
                .andExpect(status().isOk())
                .andExpect(authenticated().withUsername(DataUtil.loginAdmin).withRoles("ADMIN"))
                .andDo(print())
                .andReturn().getResponse().getContentAsString();

    }
    @Test

    public void testAdminAuthenmtificationSuccessfully() throws Exception{
        userService.addUser(DataUtil.createAdminUser());
        mockMvc.perform(post("/viewcustom"))
                .andExpect(authenticated().withUsername(DataUtil.login))
                .andDo(print())
                .andReturn().getResponse().getContentAsString();

    }
    @Test
    public void httpBasicAuthenticationSuccess() throws Exception {
        userService.addUser(DataUtil.createAdminUser());
        mockMvc
                .perform(get("/login").with(httpBasic(DataUtil.loginAdmin,DataUtil.pass)))
                .andExpect(status().isOk())
               // .andExpect(redirectedUrl("/"))
                .andExpect(authenticated().withUsername(DataUtil.loginAdmin))
                .andDo(print())
                .andReturn().getResponse().getContentAsString();
    }

}