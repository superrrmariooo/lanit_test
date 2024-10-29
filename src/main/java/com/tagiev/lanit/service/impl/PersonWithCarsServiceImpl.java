package com.tagiev.lanit.service.impl;

import com.tagiev.lanit.DTO.CarDTO;
import com.tagiev.lanit.DTO.PersonWithCarsDTO;
import com.tagiev.lanit.map.CarAndPersonMapper;
import com.tagiev.lanit.model.Car;
import com.tagiev.lanit.repository.CarRepository;
import com.tagiev.lanit.repository.PersonRepository;
import com.tagiev.lanit.service.PersonWithCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PersonWithCarsServiceImpl implements PersonWithCarService {

    private final PersonRepository personRepository;

    private final CarRepository carRepository;

    private final CarAndPersonMapper carAndPersonMapper;

    @Autowired
    public PersonWithCarsServiceImpl(PersonRepository personRepository,
                                     CarRepository carRepository,
                                     CarAndPersonMapper carAndPersonMapper) {
        this.personRepository = personRepository;
        this.carRepository = carRepository;
        this.carAndPersonMapper = carAndPersonMapper;
    }

    @Override
    public Optional<PersonWithCarsDTO> read(long id) {
        try {
            return Optional.of( new PersonWithCarsDTO(
                    carAndPersonMapper.fromPersonToDTO(personRepository.findById(id).get()),
                    Arrays.stream(carRepository.findByPersonId(id).toArray(Car[]::new))
                            .map(carAndPersonMapper::fromCarToDTO)
                            .toArray(CarDTO[]::new)));
        } catch (NoSuchElementException e) {
            return Optional.empty();
        }

    }

}
