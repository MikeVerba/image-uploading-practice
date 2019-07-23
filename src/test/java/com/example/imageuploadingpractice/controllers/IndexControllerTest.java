package com.example.imageuploadingpractice.controllers;

import com.example.imageuploadingpractice.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class IndexControllerTest {

    IndexController indexController;

    @Mock
    UserService userService;

    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        indexController = new IndexController(userService);

        mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
    }

    @Test
    public void getIndexPage() throws Exception {

        mockMvc.perform(get(""))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));

    }
}