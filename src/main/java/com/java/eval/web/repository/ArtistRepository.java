package com.java.eval.web.repository;

import com.java.eval.web.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Integer> {

    List<Artist> findByNameLike(@Param("name") String _name);

    Artist findByName(@Param("name") String _name);
}
