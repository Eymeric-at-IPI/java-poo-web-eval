package com.java.eval.web.service;

import com.java.eval.web.model.Album;
import com.java.eval.web.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    public Album findById(Integer _id) {
        Optional<Album> album = albumRepository.findById(_id);
        if(album.isEmpty()){ // Gestion error 404
            throw new EntityNotFoundException("L'album d'identifiant " + _id + " n'a pas été trouvé.");
        }

        return album.get();
    }

}
