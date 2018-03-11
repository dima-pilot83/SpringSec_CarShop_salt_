package ua.kiev.prog;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;


import java.security.SecureRandom;

/**
 * Created by Dmitriy on 11.03.2018.
 */
public class Main {


    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[20];
        random.nextBytes(bytes);

        String salt = String.valueOf(bytes);

        ShaPasswordEncoder encoder = new ShaPasswordEncoder(512);

        String encodedPass = encoder.encodePassword("dima", salt);
        System.out.println(encoder.isPasswordValid( encodedPass,"dima", salt));

    }
}
