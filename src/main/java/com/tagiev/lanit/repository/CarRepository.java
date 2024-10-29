package com.tagiev.lanit.repository;

import com.tagiev.lanit.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,Long> {

    List<Car> findByPersonId (Long PersonId);

}
