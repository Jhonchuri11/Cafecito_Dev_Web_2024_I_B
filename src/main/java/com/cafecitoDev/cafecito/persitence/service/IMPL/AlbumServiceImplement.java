package com.cafecitoDev.cafecito.persitence.service.IMPL;

import com.cafecitoDev.cafecito.persitence.DTO.album.AlbumSaveDTO;
import com.cafecitoDev.cafecito.persitence.entities.Album;
import com.cafecitoDev.cafecito.persitence.exception.AlbumNotFoundException;
import com.cafecitoDev.cafecito.persitence.repository.AlbumRepository;
import com.cafecitoDev.cafecito.persitence.service.AlbumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j

public class AlbumServiceImplement implements AlbumService {

    AlbumRepository albumRepository;

    public AlbumServiceImplement (AlbumRepository albumRepository)
    {
        this.albumRepository = albumRepository;
    }

    @Override
    public Album createAlbum(Album album)
    {
        return albumRepository.save(album);
    }

    /**
     *
     * @param id
     * @return
     */

    @Override
    public Album findAlbumById(int id) throws AlbumNotFoundException
    {
        Optional<Album> albumOptional = albumRepository.findById(id);

        if (!albumOptional.isPresent())
            throw new AlbumNotFoundException("Record album not found!");

        return albumOptional.get();
    }

    // Permite la actualizacion de un nuevo album
    /**
     *
     * @param album
     * @return
     */
    @Override
    public Album updateAlbum(Album album) {
        return albumRepository.save(album);
    }

    // Permite la eliminacion de un album por su ID
    /**
     *
     * @param id
     * @return
     */

    @Override
    public void deleteAlbum(int id) throws AlbumNotFoundException
    {
        Album album = findAlbumById(id);
        albumRepository.delete(album);
    }

    @Override
    public String addAlbum(AlbumSaveDTO albumSaveDTO) {

        Album album = new Album(
          albumSaveDTO.getNombre_album(),
                albumSaveDTO.getArtista(),
                albumSaveDTO.getAnio_lanzamiento()
        );

        albumRepository.save(album);

        return album.getNombre_album();
    }
}
