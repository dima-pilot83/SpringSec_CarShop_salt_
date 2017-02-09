package ua.kiev.prog.service;

import ua.kiev.prog.entity.TestDrive;

import java.util.List;

public interface TestDriveService {

    TestDrive addTestDrive (TestDrive testDrive);
    List<TestDrive> getAll();
    List <TestDrive> sortBycarType();
    List <TestDrive> sortBydate();
    List <TestDrive> sortByname();
}
