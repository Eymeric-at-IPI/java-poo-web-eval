package com.java.eval.web.controller;

import com.java.eval.web.model.Album;
import com.java.eval.web.repository.AlbumRepository;
import com.java.eval.web.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    /**
     * Permet d'ajouter un album
     *
     * @param _album instance d'un album crée via autowired et data du POST
     */
    @RequestMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public Album addAlbum(@RequestBody Album _album){
        return albumService.addAlbum(_album);
    }

    /**
     * Permet de supprimé un album
     *
     * @param _id identifiant technique de l'album a supprimer
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAlbum(@PathVariable("id") Integer _id) {
        albumService.deleteAlbum(_id);
    }
}
