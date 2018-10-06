package com.example.ch05;

import com.example.ch05.controller.UserController;
import com.example.ch05.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Ch05Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestAPITest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String scheme = "http";
    private String host = "localhost";
    @LocalServerPort
    private int port;
    private String path = "/user/{userNo}";
    @Test
    public void testGetUserById(){
        for(int i=0; i<UserController.userList.size(); i++) {
            URI uri = UriComponentsBuilder.newInstance().scheme(scheme)
                    .host(host)
                    .port(port)
                    .path(path)
                    .build().expand(i)
                    .encode()
                    .toUri();
            User user = restTemplate.getForObject(uri, User.class);
            Assert.assertEquals(user.getUserNo()-1, i);
        }
    }
}
