package com.tagiev.lanit.service.impl;

import com.tagiev.lanit.DTO.CarDTO;
import com.tagiev.lanit.map.CarAndPersonMapper;
import com.tagiev.lanit.repository.CarRepository;
import com.tagiev.lanit.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    private final CarAndPersonMapper carAndPersonMapper;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, CarAndPersonMapper carAndPersonMapper) {
        this.carRepository = carRepository;
        this.carAndPersonMapper = carAndPersonMapper;
    }

    @Override
    public void create(CarDTO car) {
        carRepository.save(carAndPersonMapper.fromDTOtoCar(car));
    }

    @Override
    public void clear() {
        carRepository.deleteAll();
    }

    @Override
    public boolean existsWithId(long id) {
        return carRepository.existsById(id);
    }

}
