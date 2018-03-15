package ua.kiev.prog.controller;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import ua.kiev.prog.entity.CustomUser;
import ua.kiev.prog.entity.enums.UserRole;

import java.security.SecureRandom;

/**
 * Created by Dmitriy on 12.03.2018.
 */
public class DataUtil {

    protected static final String login = "testLogin";
    protected static final String loginAdmin = "testLoginAdmin";
    protected static final String pass = "testPassHash";
    protected static final String name = "testName";
    protected static final String email = "testEmail@";
    protected static final String phone = "testPhone 22 11 89";
    protected static final String carT = "testCarT";
    protected static final String carN = "testCarN AA 777 AA";

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

    public static CustomUser createAdminUser(){
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[20];
        random.nextBytes(bytes);

        String salt = String.valueOf(bytes);

        ShaPasswordEncoder encoder = new ShaPasswordEncoder(512);
        String encodedPass = encoder.encodePassword(pass, salt);

        CustomUser dbUser = new CustomUser(loginAdmin, encodedPass, salt, UserRole.ADMIN, name, email, phone, carT, carN);

        return dbUser;
    }
}
