package com.java.eval.web.controller;

import com.java.eval.web.model.Artist;
import com.java.eval.web.repository.ArtistRepository;
import com.java.eval.web.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/artists")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @RequestMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public List Artists_homePage() {

        return artistService.findAll();
    }

    @RequestMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public Artist Artist_byId(@PathVariable("id") Integer _id) {

        return artistService.findById(_id);
    }

    /*
    @RequestMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET )
    public Artist findById(@PathVariable(value = "id") Long id) {
        //return artistService.findById(id);
        return null;
    }
    */
}
