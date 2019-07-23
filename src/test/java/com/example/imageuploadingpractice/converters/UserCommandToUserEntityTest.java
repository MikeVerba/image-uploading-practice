package com.example.imageuploadingpractice.converters;

import com.example.imageuploadingpractice.commands.UserCommand;
import com.example.imageuploadingpractice.domain.UserEntity;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserCommandToUserEntityTest {


    static  final String FIRST_NAME ="Test First Name";
    static  final String LAST_NAME ="Test Last Name";
    static  final String EMAIL_ADDRESS ="somename@example.com";
    static final Byte[] IMAGE = new Byte[]{0,0,0,0,0};


    UserCommandToUserEntity converter;

    @Before
    public void setUp() throws Exception {
        converter = new UserCommandToUserEntity();
    }

    @Test
    public void testNullValue(){
        assertNull(converter.convert(null));
    }

    @Test
    public void convert() {

        //given

        UserCommand userCommand = new UserCommand();
        userCommand.setFirstName(FIRST_NAME);
        userCommand.setLastName(LAST_NAME);
        userCommand.setEmailAddress(EMAIL_ADDRESS);
        userCommand.setImage(IMAGE);


        //when

        UserEntity userEntity = converter.convert(userCommand);


        //then

        assertEquals(userEntity.getFirstName(),FIRST_NAME);
        assertEquals(userEntity.getLastName(),LAST_NAME);
        assertEquals(userEntity.getEmailAddress(),EMAIL_ADDRESS);
        assertEquals(userEntity.getImage(),IMAGE);




    }
}