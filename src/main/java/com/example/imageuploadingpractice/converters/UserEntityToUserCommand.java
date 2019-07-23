package com.example.imageuploadingpractice.converters;

import com.example.imageuploadingpractice.commands.UserCommand;
import com.example.imageuploadingpractice.domain.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Slf4j
public class UserEntityToUserCommand implements Converter<UserEntity, UserCommand> {

    @Override
    @Transactional
    @Nullable
    public UserCommand convert(UserEntity source) {

        log.info("I'm in converter");

        if(source==null){
            log.error("I'm in converter: source is null");
            return null;
        }

        UserCommand userCommand = new UserCommand();
        userCommand.setId(source.getId());
        userCommand.setFirstName(source.getFirstName());
        userCommand.setLastName(source.getLastName());
        userCommand.setEmailAddress(source.getEmailAddress());
        userCommand.setImage(source.getImage());

        return userCommand;


    }
}
