package com.tagiev.lanit.service.impl;

import com.tagiev.lanit.DTO.PersonDTO;
import com.tagiev.lanit.map.CarAndPersonMapper;
import com.tagiev.lanit.repository.PersonRepository;
import com.tagiev.lanit.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.NoSuchElementException;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    private final CarAndPersonMapper carAndPersonMapper;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository, CarAndPersonMapper carAndPersonMapper) {
        this.personRepository = personRepository;
        this.carAndPersonMapper = carAndPersonMapper;
    }

    @Override
    public void create(PersonDTO person) {
        personRepository.save(carAndPersonMapper.fromDTOtoPerson(person));
    }

    @Override
    public void clear() {
        personRepository.deleteAll();
    }

    @Override
    public boolean existsWithId(long id) {
        return personRepository.existsById(id);
    }

    @Override
    public boolean olderThenEighteen(long id) {
        try {
            LocalDate birthdate = personRepository.findById(id).orElseThrow(NoSuchElementException::new).getBirthdate();
            return Period.between(birthdate, LocalDate.now()).getYears() >= 18;
        } catch (NoSuchElementException noSuchElementException){
            return false;
        }

    }

}
