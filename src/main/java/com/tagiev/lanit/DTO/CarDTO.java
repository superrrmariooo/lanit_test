package com.tagiev.lanit.DTO;

import jakarta.validation.constraints.*;

public class CarDTO {

    @NotNull
    @Min(0)
    private Long id;

    @NotBlank
    @Pattern(regexp = "^([a-zA-Zа-яА-Я0-9]{1})([a-zA-Zа-яА-Я0-9 ]*)([a-zA-Zа-яА-Я0-9]{1})-([a-zA-Zа-яА-Я0-9]{1})([a-zA-Zа-яА-Я0-9 -]*)$")
    private String model;

    @NotNull
    @Min(0)
    private Integer horsepower;

    @NotNull
    @Min(0)
    private Long ownerid;

    public CarDTO() {
    }

    public CarDTO(Long id, String model, Integer horsepower, Long ownerid) {
        this.id = id;
        this.model = model;
        this.horsepower = horsepower;
        this.ownerid = ownerid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(Integer horsepower) {
        this.horsepower = horsepower;
    }

    public Long getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(Long ownerid) {
        this.ownerid = ownerid;
    }
}
