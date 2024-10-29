package com.tagiev.lanit.service;

import com.tagiev.lanit.DTO.CarDTO;

public interface CarService {

    void create(CarDTO car);

    void clear();

    boolean existsWithId(long id);

}
