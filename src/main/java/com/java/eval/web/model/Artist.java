package com.java.eval.web.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="artist")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ArtistId")
    private Integer id;

    @Size(max = 120)
    @Column(name = "Name")
    private String name;

    @OneToMany(mappedBy = "artist")
    @JsonIgnoreProperties("artist") // prevent recursion loop
    private List<Album> albums;

    public Artist() {

    }

    public Artist(String _name, List<Album> _albums) {
        this.name = _name;
        this.albums = _albums;
    }

    // ############
    // ## Getter ##
    // ############

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    // ############
    // ## Setter ##
    // ############

    public void setId(Integer _id) {
        this.id = _id;
    }

    public void setName(String _name) {
        this.name = _name;
    }

    public void setAlbums(List<Album> _albums) {
        this.albums = _albums;
    }

    // #############
    // ## Methods ##
    // #############

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Artist{");
        sb.append("nom='").append(name).append('\'');
        sb.append(", Albums='").append(albums.toString()).append('\'');
        sb.append('}');

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Artist)) return false;

        Artist artist = (Artist) o;

        return Objects.equals(id, artist.getId()) &&
                Objects.equals(name, artist.getName()) &&
                Objects.equals(albums, artist.getAlbums());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, albums);
    }


}