package com.cafecitoDev.cafecito.persitence.service.IMPL;

import com.cafecitoDev.cafecito.persitence.entities.Cancion;
import com.cafecitoDev.cafecito.persitence.exception.CancionNotFoundException;
import com.cafecitoDev.cafecito.persitence.repository.CancionRepository;
import com.cafecitoDev.cafecito.persitence.service.CancionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j

public class CancionServiceImplement implements CancionService {

    CancionRepository cancionRepository;

    public CancionServiceImplement(CancionRepository cancionRepository)
    {
        this.cancionRepository = cancionRepository;
    }


    @Override
    public Cancion create(Cancion musica) {
        return cancionRepository.save(musica);
    }

    @Override
    public Cancion findById(int id) throws CancionNotFoundException {
        Optional<Cancion> musica = cancionRepository.findById(id);

        if (!musica.isPresent())
            throw new CancionNotFoundException("Record not song found...!");
        return musica.get();
    }

    @Override
    public Cancion update(Cancion musica) {
        return cancionRepository.save(musica);
    }

    @Override
    public void delete(Integer id) throws CancionNotFoundException {

        Cancion musica = findById(id);
        cancionRepository.delete(musica);
    }
}
