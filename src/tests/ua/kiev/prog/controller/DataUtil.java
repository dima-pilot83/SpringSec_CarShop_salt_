package ua.kiev.prog.controller;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import ua.kiev.prog.entity.CustomUser;
import ua.kiev.prog.entity.enums.UserRole;

import java.security.SecureRandom;

/**
 * Created by Dmitriy on 12.03.2018.
 */
public class DataUtil {

    private static final String login = "testAdmin";
    private static final String pass = "testPassHash";
    private static final String name = "testName";
    private static final String email = "testEmail@";
    private static final String phone = "testPhone 22 11 89";
    private static final String carT = "testCarT";
    private static final String carN = "testCarN AA 777 AA";

    public static CustomUser createCustomUser(){
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[20];
        random.nextBytes(bytes);

        String salt = String.valueOf(bytes);

        ShaPasswordEncoder encoder = new ShaPasswordEncoder(512);
        String encodedPass = encoder.encodePassword(pass, salt);

        CustomUser dbUser = new CustomUser(login, encodedPass, salt, UserRole.USER, name, email, phone, carT, carN);

        return dbUser;
    }
}
