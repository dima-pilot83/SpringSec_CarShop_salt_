package ua.kiev.prog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.kiev.prog.entity.TakenServices;
import ua.kiev.prog.repository.TakenServicesRepository;
import ua.kiev.prog.service.TakenServicesService;

import java.util.List;

@Service
public class TakenServicesServiceImpl implements TakenServicesService {

    @Autowired
    TakenServicesRepository takenServicesRepository;

    @Override
    @Transactional
    public TakenServices addTakenServices(TakenServices takenServices) {
        return takenServicesRepository.saveAndFlush(takenServices);
    }

    @Override
    @Transactional
    public List<TakenServices> getAll() {
        return takenServicesRepository.findAll();
    }

    @Override
    @Transactional
    public List<TakenServices> sortBylogin() {
        return takenServicesRepository.sortBylogin();
    }

    @Override
    @Transactional
    public List<TakenServices> sortByprice() {
        return takenServicesRepository.sortByprice();
    }

    @Override
    @Transactional
    public List<TakenServices> sortBydate() {
        return takenServicesRepository.sortBydate();
    }


    @Override
    @Transactional
    public List<TakenServices> getTsByLogin(String login) {
        return takenServicesRepository.findByLogin(login);
    }


}
