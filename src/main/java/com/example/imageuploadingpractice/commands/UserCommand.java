package com.example.imageuploadingpractice.commands;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserCommand {

    private Long id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private Byte[] image;
}
