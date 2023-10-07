package com.java.mvc.repositories;

import com.java.mvc.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarsRepository extends JpaRepository<Car, Long> {
    List<Car> findAllByOwner_FirstName(String firstNameOwner);

    @Query(nativeQuery = true, value = "SELECT * FROM fix_car WHERE model = ?l;")
    List<Car> findAllByModel(String model);
}
