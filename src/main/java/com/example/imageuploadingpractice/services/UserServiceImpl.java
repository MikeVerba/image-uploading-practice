package com.example.imageuploadingpractice.services;

import com.example.imageuploadingpractice.commands.UserCommand;
import com.example.imageuploadingpractice.converters.UserCommandToUserEntity;
import com.example.imageuploadingpractice.converters.UserEntityToUserCommand;
import com.example.imageuploadingpractice.domain.UserEntity;
import com.example.imageuploadingpractice.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserEntityToUserCommand userEntityToUserCommand;
    private final UserCommandToUserEntity userCommandToUserEntity;

    public UserServiceImpl(UserRepository userRepository, UserEntityToUserCommand userEntityToUserCommand, UserCommandToUserEntity userCommandToUserEntity) {
        this.userRepository = userRepository;
        this.userEntityToUserCommand = userEntityToUserCommand;
        this.userCommandToUserEntity = userCommandToUserEntity;
    }


    @Transactional
    @Override
    public UserCommand findUserCommandById(Long id) {

        log.info("I'm in Service");

        Optional<UserEntity> userEntityOptional = userRepository.findById(id);

        if(!userEntityOptional.isPresent()){

            log.error("User not found: "+id);

            throw new RuntimeException("User not found: "+id);
        }

        return userEntityToUserCommand.convert(userEntityOptional.get());
    }

    @Transactional
    @Override
    public List<UserCommand> getAllUserCommands() {
        log.info("I'm in Service");

        List<UserEntity> userEntityList = userRepository.findAll();


        return userEntityList.stream()
                .map(userEntity -> userEntityToUserCommand.convert(userEntity))
                .collect(Collectors.toList());

    }

    @Transactional
    @Override
    public void saveUser(UserCommand userCommand) {
        log.info("I'm in Service");

    }
}
