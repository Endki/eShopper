package com.eshopper.eshopper.controller;

import com.eshopper.eshopper.domain.user.UserRepository;
import org.apache.catalina.security.SecurityConfig;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebAppConfiguration
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = LoginController.class, excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = SecurityConfig.class)})
//@SpringBootTest
public class LoginControllerTest {

    private static final int TEST_USER_ID = 1;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    UserRepository userRepository;

    @After
    public void 삭제() {
        userRepository.deleteAll();
        ;
    }

    @Test
    public void 로그인페이지이동() throws Exception {
        mockMvc.perform(get("/login/index")).andExpect(status().isOk());
    }


    @Test
    public void 유저가입() throws Exception {
        //given
        String name = "Endki";
        String email = "khb3221@naver.com";
        String phoneNumber = "010-0000-0000";

        mockMvc.perform(post("/login/index")
                .param("name", name)
                .param("email", email)
                .param("phoneNumber", phoneNumber)).andExpect(status().isOk());

    }
}
