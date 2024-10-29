package com.tagiev.lanit.DTO;

public class PersonWithCarsDTO {

    private PersonDTO person;

    private CarDTO[] cars;

    public PersonWithCarsDTO() {
    }

    public PersonWithCarsDTO(PersonDTO person, CarDTO[] cars) {
        this.person = person;
        this.cars = cars;
    }

    public PersonDTO getPerson() {
        return person;
    }

    public void setPerson(PersonDTO person) {
        this.person = person;
    }

    public CarDTO[] getCars() {
        return cars;
    }

    public void setCars(CarDTO[] cars) {
        this.cars = cars;
    }

}
