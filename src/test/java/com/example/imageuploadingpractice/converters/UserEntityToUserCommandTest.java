package com.example.imageuploadingpractice.converters;

import com.example.imageuploadingpractice.commands.UserCommand;
import com.example.imageuploadingpractice.domain.UserEntity;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserEntityToUserCommandTest {

    UserEntityToUserCommand converter;

    static final Long LONG_VALUE = 1L;
    static  final String FIRST_NAME ="Test First Name";
    static  final String LAST_NAME ="Test Last Name";
    static  final String EMAIL_ADDRESS ="somename@example.com";
    static final Byte[] IMAGE = new Byte[]{0,0,0,0,0};

    @Before
    public void setUp() throws Exception {
        converter = new UserEntityToUserCommand();
    }

    @Test
    public void testNullValue(){
        assertNull(converter.convert(null));
    }

    @Test
    public void convertTest() {

        //given

        UserEntity userEntity = new UserEntity();
        userEntity.setId(LONG_VALUE);
        userEntity.setFirstName(FIRST_NAME);
        userEntity.setLastName(LAST_NAME);
        userEntity.setEmailAddress(EMAIL_ADDRESS);
        userEntity.setImage(IMAGE);


        //when

        UserCommand userCommand = converter.convert(userEntity);

        //then

        assertEquals(userCommand.getId(),LONG_VALUE);
        assertEquals(userCommand.getFirstName(),FIRST_NAME);
        assertEquals(userCommand.getLastName(),LAST_NAME);
        assertEquals(userCommand.getEmailAddress(),EMAIL_ADDRESS);
        assertEquals(userCommand.getImage(),IMAGE);


    }
}