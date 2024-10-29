package com.tagiev.lanit.controller;

import com.tagiev.lanit.DTO.CarDTO;
import com.tagiev.lanit.DTO.PersonDTO;
import com.tagiev.lanit.DTO.PersonWithCarsDTO;
import com.tagiev.lanit.DTO.StatisticsDTO;
import com.tagiev.lanit.service.CarService;
import com.tagiev.lanit.service.PersonService;
import com.tagiev.lanit.service.PersonWithCarService;
import com.tagiev.lanit.service.StatisticsService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
public class RequestController {

    private final CarService carService;

    private final PersonService personService;

    private final PersonWithCarService personWithCarService;

    private final StatisticsService statisticsService;

    @Autowired
    public RequestController(CarService carService,
                             PersonService personService,
                             PersonWithCarService personWithCarService,
                             StatisticsService statisticsService) {
        this.carService = carService;
        this.personService = personService;
        this.personWithCarService = personWithCarService;
        this.statisticsService = statisticsService;
    }

    @PostMapping(value = "/person")
    public ResponseEntity<?> create(@Valid @RequestBody PersonDTO person){
        if (personService.existsWithId(person.getId()) | person.getBirthdate().isAfter(LocalDate.now())){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        personService.create(person);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/car")
    public ResponseEntity<?> create(@Valid @RequestBody CarDTO car){
        if (carService.existsWithId(car.getId()) | !personService.olderThenEighteen(car.getOwnerid())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        carService.create(car);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "personwithcars")
    public ResponseEntity<PersonWithCarsDTO> read(@RequestParam @NotNull @Min(1) long id){
        Optional<PersonWithCarsDTO> personWithCars = personWithCarService.read(id);
        return personWithCars.map(personWithCarsDTO -> new ResponseEntity<>(personWithCarsDTO, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "statistics")
    public ResponseEntity<StatisticsDTO> read(){
        StatisticsDTO statistics = statisticsService.read();
        return new ResponseEntity<>(statistics, HttpStatus.OK);
    }

    @GetMapping(value = "clear")
    public ResponseEntity<?> delete(){
        carService.clear();
        personService.clear();
        return new ResponseEntity<>(HttpStatus.OK);
    }

}