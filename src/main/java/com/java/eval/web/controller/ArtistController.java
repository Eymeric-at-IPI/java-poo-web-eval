package com.java.eval.web.controller;

import com.java.eval.web.model.Artist;
import com.java.eval.web.repository.ArtistRepository;
import com.java.eval.web.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/artists")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    /**
     * Permet de récupérer les informations d'un artiste à partir de son identifiant technique
     *
     * @param id Identifiant technique de l'artiste
     * @return l'artiste si l'identifiant est trouvé ou une erreur 404 sinon.
     */
    @RequestMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public Artist Artist_byId(@PathVariable("id") Integer _id) {

        return artistService.findById(_id);
    }

    // TODO : paginé ?
    /**
     * Permet de récupérer les informations d'un artiste à partir de tout ou d'une partie de sont nom
     *
     * @param name tout ou partie du nom de l'artiste
     * @return une liste d'artiste avec les correspondance trouvé.
     */
    @RequestMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET, params = "name")
    public List<Artist> Artist_byNameLike(@RequestParam("name") String _name) {
        return artistService.findByNameLike(_name);
    }

    /**
     * Permet de récupérer les artistes de manière paginée et triée
     *
     * @param page Numéro de la page en partant de 0
     * @param size Taille de la page
     * @param sortDirection Tri ascendant ASC ou descendant DESC
     * @param sortProperty Propriété utilisée par le tri
     * @return Une page contenant les artistes
     */
    @RequestMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public Page<Artist> Artiste_pagedList(
            @RequestParam(value = "page", defaultValue = "0") Integer _page,
            @RequestParam(value = "size", defaultValue = "10") Integer _size,
            @RequestParam(value = "sortProperty", defaultValue = "name") String _sortProperty,
            @RequestParam(value = "sortDirection", defaultValue = "ASC") Sort.Direction _sortDirection){

        // le href du lien capture le comptenu du champ de recherche !

        return artistService.listArtists(_page, _size, _sortProperty, _sortDirection);
    }


    @RequestMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public Artist addArtist(@RequestBody Artist _artist){
        return artistService.addArtist(_artist);
    }

}
