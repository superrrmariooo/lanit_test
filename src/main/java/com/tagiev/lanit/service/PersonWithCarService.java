package com.tagiev.lanit.service;

import com.tagiev.lanit.DTO.PersonWithCarsDTO;

import java.util.Optional;

public interface PersonWithCarService {

    Optional<PersonWithCarsDTO> read(long id);

}
