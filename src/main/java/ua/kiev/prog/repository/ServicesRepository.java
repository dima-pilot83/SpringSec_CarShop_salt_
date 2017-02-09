package ua.kiev.prog.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.kiev.prog.entity.Services;


public interface ServicesRepository extends JpaRepository<Services, Long> {

    @Query("select s from Services s where s.id = :id")
    Services findById(@Param("id") long id);
}
