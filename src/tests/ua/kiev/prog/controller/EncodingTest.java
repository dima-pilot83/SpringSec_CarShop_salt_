package ua.kiev.prog.controller;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

import java.security.SecureRandom;

/**
 * Created by Dmitriy on 12.03.2018.
 */
public class EncodingTest {

    @Test
    public void correctEncoding()throws Exception{
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[20];
        random.nextBytes(bytes);
        String salt = String.valueOf(bytes);

        ShaPasswordEncoder encoder = new ShaPasswordEncoder(512);

        String encodedPass = encoder.encodePassword("dima", salt);
        Assert.assertTrue(encoder.isPasswordValid( encodedPass,"dima", salt));
    }
}
