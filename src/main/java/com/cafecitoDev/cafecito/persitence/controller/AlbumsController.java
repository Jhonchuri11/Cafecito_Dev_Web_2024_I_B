package com.cafecitoDev.cafecito.persitence.controller;

import com.cafecitoDev.cafecito.persitence.DTO.album.AlbumSaveDTO;
import com.cafecitoDev.cafecito.persitence.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("cafecito/v1/album")

public class AlbumsController {


    @Autowired
    AlbumService albumService;

    @PostMapping(path = "/save")
    public String saveAlbum(@RequestBody AlbumSaveDTO albumSaveDTO)
    {
        String name = albumService.addAlbum(albumSaveDTO);
        return name;
    }
}
