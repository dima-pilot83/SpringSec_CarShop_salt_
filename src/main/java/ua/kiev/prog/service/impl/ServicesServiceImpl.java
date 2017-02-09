package ua.kiev.prog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.kiev.prog.entity.Services;
import ua.kiev.prog.repository.ServicesRepository;
import ua.kiev.prog.service.ServicesService;

import java.util.List;

@Service
public class ServicesServiceImpl implements ServicesService {

    @Autowired
    private ServicesRepository servicesRepository;

    @Override
    @Transactional
    public Services addServices(Services services) {
        return servicesRepository.saveAndFlush(services);
    }

    @Override
    @Transactional
    public void delete(long id) {
        servicesRepository.delete(id);
    }

    @Override
    @Transactional
    public Services getById(long id) {
       return servicesRepository.findById(id);
    }

    @Override
    @Transactional
    public List<Services> getAll() {
        return servicesRepository.findAll();
    }
}
