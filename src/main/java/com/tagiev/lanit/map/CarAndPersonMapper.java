package com.tagiev.lanit.map;

import com.tagiev.lanit.DTO.CarDTO;
import com.tagiev.lanit.DTO.PersonDTO;
import com.tagiev.lanit.model.Car;
import com.tagiev.lanit.model.Person;
import com.tagiev.lanit.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarAndPersonMapper {

    private final PersonRepository personRepository;

    @Autowired
    public CarAndPersonMapper(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person fromDTOtoPerson(PersonDTO personDTO) {
        return new Person(
                personDTO.getId(),
                personDTO.getName(),
                personDTO.getBirthdate()
        );
    }

    public PersonDTO fromPersonToDTO(Person person) {
        return new PersonDTO(
                person.getId(),
                person.getName(),
                person.getBirthdate()
        );
    }

    public Car fromDTOtoCar(CarDTO carDTO) {
        return new Car(
                carDTO.getId(),
                carDTO.getModel(),
                carDTO.getHorsepower(),
                personRepository.findById(carDTO.getOwnerid()).get()
        );
    }

    public CarDTO fromCarToDTO(Car car) {
        return new CarDTO(
                car.getId(),
                car.getModel(),
                car.getHorsepower(),
                car.getPerson().getId()
        );
    }

}
