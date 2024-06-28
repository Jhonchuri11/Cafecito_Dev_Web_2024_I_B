package com.cafecitoDev.cafecito.persitence.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Data
@Entity
@AllArgsConstructor

public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 255)
    private String nombre_album;

    @Column(length = 255)
    private String artista;

    private int anio_lanzamiento;


    public Album() {}

    public Album(String nombre_album, String artista, int anio_lanzamiento) {
        this.nombre_album = nombre_album;
        this.artista = artista;
        this.anio_lanzamiento = anio_lanzamiento;
    }
}
