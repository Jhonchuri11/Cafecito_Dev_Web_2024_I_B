package com.cafecitoDev.cafecito.persitence.webs;

import com.cafecitoDev.cafecito.persitence.entities.Album;
import com.cafecitoDev.cafecito.persitence.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cafecito/albums")
@CrossOrigin(origins = "http://localhost:4200/")

public class AlbumController {

    @Autowired
    private AlbumRepository albumRepository;

    @PostMapping(value = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Album> createAlbum(@RequestBody Album album)
    {
        Album albumCreated = albumRepository.save(album);

        return ResponseEntity.status(HttpStatus.CREATED).body(albumCreated);
    }

    // Endpoind para listar todos los albums
    @GetMapping(value = "/all")
    public ResponseEntity<List<Album>> getAlbums()
    {
        List<Album> albums = (List<Album>) albumRepository.findAll();
        return ResponseEntity.ok(albums);
    }

    // Endpoint para buscar una album por su id
    @GetMapping(value = "/find/{id}")
    public ResponseEntity<Album> getAlbumById(@PathVariable Integer id)
    {
        Optional<Album> optionalAlbum = albumRepository.findById(id);
        return optionalAlbum.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping("update/{id}")
    public ResponseEntity<String> updateAlbum(@PathVariable Integer id, @RequestBody Album updatealbum)
    {
        Optional<Album> optionalAlbum = albumRepository.findById(id);

        if (optionalAlbum.isPresent()) {
            Album album1 = optionalAlbum.get();

            album1.setNombre_album(updatealbum.getNombre_album());
            album1.setArtista(updatealbum.getArtista());
            album1.setAnio_lanzamiento(updatealbum.getAnio_lanzamiento());
            albumRepository.save(album1);
            return ResponseEntity.ok("Album actualizado");

        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Album no encontradi");
    }

    // Endpont para eliminar una cancion o darle de baja
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAlbum(@PathVariable Integer id)
    {
        try {
            albumRepository.deleteById(id);
            return ResponseEntity.ok("Album delete success");
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Album not found");
        }
    }
}
