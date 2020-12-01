package com.java.eval.web.repository;

import com.java.eval.web.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> {

    Album findByTitle(String _title);

    List<Album> findByArtistId(Integer _id);

}
