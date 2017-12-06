package com.frudo;

import com.frudo.controllers.UserServices;
import com.frudo.model.User;
import com.frudo.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Created by abhimanyus on 12/6/17.
 */

@RunWith(SpringRunner.class)
@WebMvcTest(UserServices.class)
public class UserServicesTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    UserRepository userRepository;



    @Test
    public void testFindUser() throws Exception {
        User user = new User();
        user.setUserId("12345");
        given(userRepository.findByUserId("12345")).willReturn(user);
        mvc.perform(get("/api/user/find/12345").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.userId", is(user.getUserId())));

    }

    @Test
    public void testFindUserByMobile() throws Exception {
        User user = new User();
        user.setUserId("12345");
        given(userRepository.findByMobileNumber(9663824250L)).willReturn(user);
        mvc.perform(get("/api/user/find/9663824250/mobile").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId", is(user.getUserId())));

    }


    @Test
    public void testAddUser() throws Exception {
        User user = new User();
        user.setUserId("12345");
        given(userRepository.save(any(User.class))).willReturn(user);
        mvc.perform(post("/api/user/add").contentType(MediaType.APPLICATION_JSON).content(getUserJson()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId", is(user.getUserId())));

    }

    private String getUserJson(){
        String json = "{" +
                "    \"userId\": \"12345\"," +
                "    \"userName\": \"Abhimanyu\"," +
                "    \"mobileNumber\": 9663824250," +
                "    \"address\": \"some bullshit\"," +
                "    \"email\": \"master.abhimanyu@gmail.com\"," +
                "    \"driver\": null" +
                "}";
        return json;
    }

}
