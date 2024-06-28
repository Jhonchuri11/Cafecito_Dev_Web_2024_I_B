package com.cafecitoDev.cafecito.persitence.DTO.album;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AlbumDTO {

    private Integer id;

    private String nombre_album;

    private String artista;

    private int anio_lanzamiento;
}
