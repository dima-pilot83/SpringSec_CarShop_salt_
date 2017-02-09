package ua.kiev.prog.service;

import ua.kiev.prog.entity.Services;

import java.util.List;

public interface ServicesService {

    Services addServices(Services services);
    void delete(long id);
    Services getById(long id);
    List<Services> getAll();
}
