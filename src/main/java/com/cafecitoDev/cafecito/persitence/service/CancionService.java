package com.cafecitoDev.cafecito.persitence.service;

import com.cafecitoDev.cafecito.persitence.entities.Cancion;
import com.cafecitoDev.cafecito.persitence.exception.CancionNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface CancionService {
    /**
     *
     * @param cancion
     * @return
     */
    Cancion create(Cancion cancion);

    /**
     *
     * @param id
     * @return
     */
    Cancion findById(int id) throws CancionNotFoundException;

    /**
     *
     * @param cancion
     * @return
     */
    Cancion update(Cancion cancion);

    /**
     *
     * @param id
     * @return
     */
    void delete(Integer id) throws CancionNotFoundException;
}
