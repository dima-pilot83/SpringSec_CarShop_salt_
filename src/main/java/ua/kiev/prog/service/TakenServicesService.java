package ua.kiev.prog.service;

import ua.kiev.prog.entity.TakenServices;

import java.util.List;

public interface TakenServicesService {

    TakenServices addTakenServices(TakenServices takenServices);
    List<TakenServices> getAll();
    List <TakenServices> sortBylogin();
    List <TakenServices> sortBydate();
    List <TakenServices> sortByprice();
    List <TakenServices> getTsByLogin(String login);
}
