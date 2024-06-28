package com.cafecitoDev.cafecito.persitence.repository;

import com.cafecitoDev.cafecito.persitence.entities.Cancion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CancionRepository extends JpaRepository<Cancion, Integer> {

}
