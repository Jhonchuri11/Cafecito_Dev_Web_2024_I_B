package com.cafecitoDev.cafecito.persitence.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Cancion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 255)
    private String title;

    @Column(length = 255)
    private String description;

    @Column(length = 255)
    private String image;

    @Column(length = 255)
    private String mp3;

    @Column(length = 255)
    private String author;

    // Una cancion a un solo album

    @ManyToOne
    @JoinColumn(name = "id_album") // Se refiere a la columna en la tabla de Cancion que almacena la clave foránea del Album
    private Album album;
}
