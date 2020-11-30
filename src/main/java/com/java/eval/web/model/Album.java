package com.java.eval.web.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "album")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AlbumId")
    private Integer id;

    @Size(max = 160)
    @Column(name = "Title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "ArtistId")
    private Artist artist;

    public Album() {

    }

    public Album(String _title) {
        this.title = _title;
    }

    public Album(String _title, Artist _artist) {
        this.title = _title;
        this.artist = _artist;
    }

    // ############
    // ## Getter ##
    // ############

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Artist getArtist() {
        return artist;
    }

    // ############
    // ## Setter ##
    // ############

    public void setId(Integer _id) {
        this.id = _id;
    }

    public void setTitle(String _title) {
        this.title = _title;
    }

    public void setArtist(Artist _artist) {
        this.artist = _artist;
    }

    // #############
    // ## Methods ##
    // #############

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Album{");
        sb.append("title='").append(title).append('\'');
        sb.append(", artist='").append(artist.getName()).append('\'');
        sb.append('}');

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Album)) return false;

        Album album = (Album) o;

        return Objects.equals(id, album.getId()) &&
                Objects.equals(title, album.getTitle()) &&
                Objects.equals(artist, album.getArtist());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, artist);
    }
}
