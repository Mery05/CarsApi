package com.svalero.carsApi.repository;

import com.svalero.carsApi.domain.Coche;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CocheRepository extends CrudRepository <Coche, Long> {

    List <Coche> findAll();
    Coche findById(long id);

}
