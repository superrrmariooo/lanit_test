package com.tagiev.lanit.service.impl;

import com.tagiev.lanit.DTO.StatisticsDTO;
import com.tagiev.lanit.model.Car;
import com.tagiev.lanit.repository.CarRepository;
import com.tagiev.lanit.repository.PersonRepository;
import com.tagiev.lanit.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    private final PersonRepository personRepository;

    private final CarRepository carRepository;

    @Autowired
    public StatisticsServiceImpl(PersonRepository personRepository, CarRepository carRepository) {
        this.personRepository = personRepository;
        this.carRepository = carRepository;
    }

    @Override
    public StatisticsDTO read() {
        List<Car> allCars = carRepository.findAll();
        return new StatisticsDTO(personRepository.findAll().size(),
                allCars.size(),
                countUniqueVendor(allCars));
    }

    private long countUniqueVendor(List<Car> cars){
        return cars.stream()
                .map(Car::getModel)
                .map(String::toLowerCase)
                .map(x -> x.substring(0, x.indexOf('-')))
                .distinct()
                .count();
    }

}
