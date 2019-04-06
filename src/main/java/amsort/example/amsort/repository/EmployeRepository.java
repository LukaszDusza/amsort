package amsort.example.amsort.repository;

import amsort.example.amsort.model.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EmployeRepository extends JpaRepository <Employe, Integer> {

    @Query("select e from Employe e where e.name = ?1")
    Optional<Employe> findByName(String name);

    @Query("select e from Employe e where e.account = ?1")
    Optional<Employe> findAccount();
}
