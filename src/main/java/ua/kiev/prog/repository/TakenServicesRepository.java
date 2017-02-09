package ua.kiev.prog.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.kiev.prog.entity.TakenServices;

import java.util.List;

public interface TakenServicesRepository extends JpaRepository<TakenServices, Long> {

    @Query("FROM TakenServices ORDER BY login ASC")
    List<TakenServices> sortBylogin();

    @Query("FROM TakenServices ORDER BY  STR_TO_DATE(date,'%m/%d/%Y')  ASC")
    List<TakenServices> sortBydate();

    @Query("FROM TakenServices ORDER BY price ASC")
    List<TakenServices> sortByprice();

    @Query("SELECT u FROM TakenServices u where u.login = :login")
    List <TakenServices> findByLogin(@Param("login") String login);
}
