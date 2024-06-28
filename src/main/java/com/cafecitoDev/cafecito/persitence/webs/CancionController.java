package com.cafecitoDev.cafecito.persitence.webs;

import com.cafecitoDev.cafecito.persitence.entities.Cancion;
import com.cafecitoDev.cafecito.persitence.repository.CancionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cafecito/songs")
@CrossOrigin(origins = "http://localhost:4200/")
public class CancionController {

    @Autowired
    private CancionRepository cancionRepository;

    @PostMapping(value = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Cancion> createMusic(@RequestBody Cancion cancion)
    {
        Cancion cancionCreated = cancionRepository.save(cancion);

        return ResponseEntity.status(HttpStatus.CREATED).body(cancionCreated);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Cancion>> getSongs()
    {
        List<Cancion> cancions = (List<Cancion>) cancionRepository.findAll();
        return ResponseEntity.ok(cancions);
    }

    @GetMapping(value = "/find/{id}")
    public  ResponseEntity<Cancion> getMusicById(@PathVariable Integer id)
    {
        Optional<Cancion> optionalSongs = cancionRepository.findById(id);
        return optionalSongs.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }


    // Actualizar una cancion
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateCancion(@PathVariable Integer id, @RequestBody Cancion updatecancion)
    {
        Optional<Cancion> optionalSongs = cancionRepository.findById(id);
        if (optionalSongs.isPresent()) {
            Cancion cancions = optionalSongs.get();

            cancions.setTitle(updatecancion.getTitle());
            cancions.setDescription(updatecancion.getDescription());
            cancions.setImage(updatecancion.getImage());
            cancions.setMp3(updatecancion.getMp3());
            cancions.setAuthor(updatecancion.getAuthor());

            // Se guarda los nuevos documentos
            cancionRepository.save(cancions);

            return ResponseEntity.ok("Cancion updated");

        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cancion not found");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSong(@PathVariable Integer id)
    {
        Optional<Cancion> optionalSong = cancionRepository.findById(id);
        if (optionalSong.isPresent())
        {
            cancionRepository.deleteById(id);
            return ResponseEntity.ok("Canción eliminada del albúm!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cancion no encontrada");
    }

}
