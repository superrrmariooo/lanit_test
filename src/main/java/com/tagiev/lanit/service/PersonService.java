package com.tagiev.lanit.service;

import com.tagiev.lanit.DTO.PersonDTO;

public interface PersonService {

    void create(PersonDTO person);

    void clear();

    boolean existsWithId(long id);

    boolean olderThenEighteen(long id);

}
