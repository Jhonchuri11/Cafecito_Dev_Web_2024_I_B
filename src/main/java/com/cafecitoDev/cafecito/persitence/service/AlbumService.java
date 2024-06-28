package com.cafecitoDev.cafecito.persitence.service;

import com.cafecitoDev.cafecito.persitence.DTO.album.AlbumSaveDTO;
import com.cafecitoDev.cafecito.persitence.entities.Album;
import com.cafecitoDev.cafecito.persitence.exception.AlbumNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface AlbumService {

    /**
     *
     * @param album
     * @return
     */
    Album createAlbum(Album album);

    /**
     *
     * @param id
     * @return
     */
    Album findAlbumById(int id) throws AlbumNotFoundException;

    /**
     *
     * @param album
     * @return
     */
    Album updateAlbum(Album album);


    /**
     *
     * @param id
     * @return
     */
    void deleteAlbum(int id) throws AlbumNotFoundException;

    String addAlbum(AlbumSaveDTO albumSaveDTO);
}
