package ua.kiev.prog.controller;

import org.junit.Test;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

import java.security.SecureRandom;

import static org.junit.Assert.*;

/**
 * Created by Dmitriy on 11.03.2018.
 */
public class MyControllerTest {
    @Test
    public void update() throws Exception {

        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[20];
        byte bytes2[] = new byte[20];
        random.nextBytes(bytes);
        random.nextBytes(bytes2);
        String salt = String.valueOf(bytes);

        ShaPasswordEncoder encoder = new ShaPasswordEncoder(512);
        String encodedPass = encoder.encodePassword("dima", salt);
        System.out.println(encoder.isPasswordValid( encodedPass,"dima", salt));
    }

}