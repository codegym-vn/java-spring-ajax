package com.codegym.repository;

import com.codegym.model.Smartphone;
import org.springframework.data.repository.CrudRepository;

public interface SmartphoneRepository extends CrudRepository<Smartphone, Integer> {

}
