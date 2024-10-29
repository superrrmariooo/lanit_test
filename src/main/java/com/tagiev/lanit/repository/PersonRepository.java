package com.tagiev.lanit.repository;

import com.tagiev.lanit.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
