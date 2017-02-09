package ua.kiev.prog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.kiev.prog.entity.TestDrive;
import ua.kiev.prog.repository.TestDriveRepository;
import ua.kiev.prog.service.TestDriveService;

import java.util.List;

@Service
public class TestDriveServiceImpl implements TestDriveService {

    @Autowired
    private TestDriveRepository testDriveRepository;

    @Override
    @Transactional
    public TestDrive addTestDrive(TestDrive testDrive) {

        return testDriveRepository.saveAndFlush(testDrive);
    }

    @Override
    @Transactional
    public List<TestDrive> getAll() {
        return testDriveRepository.findAll();
    }

    @Override
    @Transactional
    public List<TestDrive> sortBycarType() {
        return testDriveRepository.sortBycarType();
    }

    @Override
    @Transactional
    public List<TestDrive> sortBydate() {
        return testDriveRepository.sortBydate();
    }

    @Override
    @Transactional
    public List<TestDrive> sortByname() {
        return testDriveRepository.sortByname();
    }


}
