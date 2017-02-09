package ua.kiev.prog.service;

import ua.kiev.prog.entity.CustomUser;

import java.util.List;

public interface UserService {
    CustomUser getUserByLogin(String login);
    boolean existsByLogin(String login);
    void addUser(CustomUser customUser);
    void updateUser(CustomUser customUser);
    List<CustomUser> getAll();
}
