package com.example.imageuploadingpractice.services;

import com.example.imageuploadingpractice.commands.UserCommand;


import java.util.List;


public interface UserService {

    UserCommand findUserCommandById(Long id);
    List<UserCommand> getAllUserCommands();
    void saveUser(UserCommand userCommand);
}
