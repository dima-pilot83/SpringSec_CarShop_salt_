package ua.kiev.prog.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.kiev.prog.entity.TestDrive;

import java.util.List;

public interface TestDriveRepository extends JpaRepository<TestDrive, Long> {

    @Query("FROM TestDrive ORDER BY car_type ASC")
    List<TestDrive> sortBycarType();

    @Query("FROM TestDrive ORDER BY  STR_TO_DATE(date,'%m/%d/%Y')  ASC")
    List<TestDrive> sortBydate();

    @Query("FROM TestDrive ORDER BY name ASC")
    List<TestDrive> sortByname();

}
