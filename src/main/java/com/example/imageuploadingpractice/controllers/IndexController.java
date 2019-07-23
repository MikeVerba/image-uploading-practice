package com.example.imageuploadingpractice.controllers;

import com.example.imageuploadingpractice.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class IndexController {


    private final UserService userService;

    public IndexController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping({"","/"})
    public String getIndexPage(){

        log.info("I'm in index controller");

        return "index";
    }



}
