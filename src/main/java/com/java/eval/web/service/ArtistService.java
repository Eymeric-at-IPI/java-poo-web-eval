package com.java.eval.web.service;

import com.java.eval.web.model.Album;
import com.java.eval.web.model.Artist;
import com.java.eval.web.repository.AlbumRepository;
import com.java.eval.web.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ArtistService {

    public static final int PAGE_SIZE_MIN = 10;
    public static final int PAGE_SIZE_MAX = 100;
    public static final int PAGE_MIN = 0;
    private static final String PAGE_VALID_MESSAGE = "La taille de la page doit être comprise entre " + PAGE_SIZE_MIN + " et " + PAGE_SIZE_MAX;

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private AlbumRepository albumRepository;

    public Artist findById(Integer _id) {
        Optional<Artist> artist = artistRepository.findById(_id);
        if(artist.isEmpty()) // Gestion error 404
            throw new EntityNotFoundException("L'artist d'identifiant " + _id + " n'a pas été trouvé.");

        return artist.get();
    }

    public List<Artist> findByNameLike(String _name) {
        return artistRepository.findByNameLike("%" + _name + "%");
    }

    public List<Artist> findAll() {
        return artistRepository.findAll();
    }

    public Page<Artist> listArtists(
            @Min(message="Le numéro de page ne peut être inférieur à " + PAGE_MIN, value = PAGE_MIN) Integer _page,
            @Min(message=PAGE_VALID_MESSAGE, value = PAGE_SIZE_MIN) @Max(message=PAGE_VALID_MESSAGE, value = PAGE_SIZE_MAX) Integer _size,
            String _sortProperty,
            Sort.Direction _sortDirection) {

        //Vérification de sortProperty
        if(Arrays.stream( Artist.class.getDeclaredFields() ).map( Field::getName ).filter( s -> s.equals(_sortProperty) ).count() != 1)
            throw new IllegalArgumentException("La propriété " + _sortProperty + " n'existe pas !");

        Pageable pageable = PageRequest.of(_page, _size, _sortDirection, _sortProperty);
        Page<Artist> artists = artistRepository.findAll(pageable);

        if(_page >= artists.getTotalPages())
            throw new IllegalArgumentException("Le numéro de page ne peut être supérieur à " + artists.getTotalPages());
        else if(artists.getTotalElements() == 0)
            throw new EntityNotFoundException("Il n'y a aucun artist dans la base de données");

        return artists;
    }

    public Artist addArtist(Artist _artist) {
        if (artistRepository.findByName(_artist.getName()) != null)
            throw new EntityExistsException("Un artiste avec le même nom existe déjà en BDD !");

        return artistRepository.save(_artist);
    }

    public Artist updateArtist(Artist _artist) {
        if (artistRepository.findById(_artist.getId()).isEmpty())
            throw new EntityNotFoundException("L'artiste que vous essayer de modifier n'existe pas en BDD !");

        return artistRepository.save(_artist);
    }

    public void deleteArtist(Integer _id) {
        if (artistRepository.findById(_id).isEmpty()) // Exception redondante ?
            new EntityNotFoundException("L'artiste avdec l'identifiant " + _id + " n'existe pas en BDD !");

        List<Album> albums = albumRepository.findByArtistId(_id);
        for (Album album : albums)
            albumRepository.deleteById(album.getId());

        artistRepository.deleteById(_id);
    }

}
