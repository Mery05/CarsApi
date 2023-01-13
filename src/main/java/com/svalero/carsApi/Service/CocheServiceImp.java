package com.svalero.carsApi.Service;

import com.svalero.carsApi.domain.Coche;
import com.svalero.carsApi.repository.CocheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CocheServiceImp implements CocheService{

    @Autowired
    private CocheRepository cocheRepository;
    @Override
    public List<Coche> listar() {

        return cocheRepository.findAll();
    }

    @Override
    public Coche buscarPorId(long id){
        return cocheRepository.findById(id);

    }

    @Override
    public void añadirCoche(Coche coche) {

        cocheRepository.save(coche);
    }


    @Override
    public Coche eliminarCoche(long id) {
        Coche coche = cocheRepository.findById(id);

        cocheRepository.delete(coche);
        return coche;

    }

    @Override
    public Coche modificarCoche(long id, Coche newCoche) {
        Coche coche = cocheRepository.findById(id);
        coche.setMarca(newCoche.getMarca());
        coche.setMatricula(newCoche.getMatricula());
        coche.setDisponible(newCoche.isDisponible());

        return cocheRepository.save(coche);
    }


}
