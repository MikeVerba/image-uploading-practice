package com.example.imageuploadingpractice.services;


import com.example.imageuploadingpractice.converters.UserCommandToUserEntity;
import com.example.imageuploadingpractice.converters.UserEntityToUserCommand;
import com.example.imageuploadingpractice.domain.UserEntity;
import com.example.imageuploadingpractice.repositories.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class UserServiceImplTest {

    @Mock
    UserRepository userRepository;

    @Mock
    UserEntityToUserCommand userEntityToUserCommand;

    @Mock
    UserCommandToUserEntity userCommandToUserEntity;

    UserServiceImpl userService;

    static final Long LONG_VALUE = 1L;
    static  final String FIRST_NAME ="Test First Name";
    static  final String LAST_NAME ="Test Last Name";
    static  final String EMAIL_ADDRESS ="somename@example.com";
    static final Byte[] IMAGE = new Byte[]{0,0,0,0,0};

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
        userService = new UserServiceImpl(userRepository,userEntityToUserCommand,userCommandToUserEntity);
    }

    @Test
    public void findUserCommandByIdTest() {

        //given
        UserEntity userEntity = new UserEntity();
        userEntity.setId(LONG_VALUE);
        userEntity.setFirstName(FIRST_NAME);
        userEntity.setLastName(LAST_NAME);
        userEntity.setEmailAddress(EMAIL_ADDRESS);
        userEntity.setImage(IMAGE);

        Optional<UserEntity> userEntityOptional = Optional.of(userEntity);

        when(userRepository.findById(anyLong())).thenReturn(userEntityOptional);

        //when

        userService.findUserCommandById(LONG_VALUE);


        //then

        verify(userRepository,times(1)).findById(anyLong());
        verify(userRepository,never()).findAll();

    }

    @Test
    public void getAllUsersTest() {

        //given
        UserEntity userEntity1 = new UserEntity();
        userEntity1.setId(LONG_VALUE);
        userEntity1.setFirstName(FIRST_NAME);
        userEntity1.setLastName(LAST_NAME);
        userEntity1.setEmailAddress(EMAIL_ADDRESS);
        userEntity1.setImage(IMAGE);

        UserEntity userEntity2 = new UserEntity();
        userEntity2.setId(LONG_VALUE);
        userEntity2.setFirstName(FIRST_NAME);
        userEntity2.setLastName(LAST_NAME);
        userEntity2.setEmailAddress(EMAIL_ADDRESS);
        userEntity2.setImage(IMAGE);

        List<UserEntity> userEntityList = new ArrayList<>();
        userEntityList.add(userEntity1);
        userEntityList.add(userEntity2);

        when(userRepository.findAll()).thenReturn(userEntityList);

        //when

        userService.getAllUserCommands();


        //then

        verify(userRepository,times(1)).findAll();
        verify(userRepository,never()).findById(anyLong());
    }

    @Test
    public void saveUserTest() {
    }
}