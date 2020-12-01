package com.java.eval.web.service;

import com.java.eval.web.model.Album;
import com.java.eval.web.repository.AlbumRepository;
import com.java.eval.web.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private ArtistRepository artistRepository;

    public Album findById(Integer _id) {
        Optional<Album> album = albumRepository.findById(_id);
        if(album.isEmpty()) // Gestion error 404
            throw new EntityNotFoundException("L'album d'identifiant " + _id + " n'a pas été trouvé.");

        return album.get();
    }

    public Album addAlbum(Album _album){
        if (albumRepository.findByTitle(_album.getTitle()) != null)
            throw new EntityExistsException("Un album avec le même nom existe déjà dans la BDD !");

        if (artistRepository.findByName(_album.getArtist().getName()) == null)
            throw new EntityNotFoundException("L'artiste " + _album.getArtist().getName() + " n'existe pas dans la BDD !");

        return albumRepository.save(_album);
    }

    public void deleteAlbum(Integer _id) {
        albumRepository.deleteById(_id);
    }

}
