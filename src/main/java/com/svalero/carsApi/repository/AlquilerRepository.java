package com.svalero.carsApi.repository;

import com.svalero.carsApi.domain.Alquiler;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlquilerRepository extends CrudRepository <Alquiler, Long>{

    List <Alquiler> findAll();
    Alquiler findById(long id);

}
