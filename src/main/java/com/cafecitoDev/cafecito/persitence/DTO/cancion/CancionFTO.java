package com.cafecitoDev.cafecito.persitence.DTO.cancion;

import com.cafecitoDev.cafecito.persitence.entities.Album;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CancionFTO {
    private Integer id;

    private String title;

    private String description;

    private String image;

    private String mp3;

    private String author;

    private Album album;
}
