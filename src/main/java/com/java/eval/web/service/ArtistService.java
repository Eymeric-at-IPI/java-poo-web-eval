package com.java.eval.web.service;

import com.java.eval.web.model.Artist;
import com.java.eval.web.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class ArtistService {

    @Autowired
    private ArtistRepository artistRepository;

    public Artist findById(Integer _id){
        Optional<Artist> artist = artistRepository.findById(_id);
        if(artist.isEmpty()){ // Gestion error 404
            throw new EntityNotFoundException("L'artist d'identifiant " + _id + " n'a pas été trouvé.");
        }

        return artist.get();
    }

}
