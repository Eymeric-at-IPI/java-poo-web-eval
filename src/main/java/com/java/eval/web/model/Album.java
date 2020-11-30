package com.java.eval.web.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "Album")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AlbumId")
    private Integer m_id;

    @Size(max = 160)
    @Column(name = "Title")
    private String m_title;

    @Column(name = "ArtistId")
    private Integer m_artist;

    public Album() {

    }

    public Album(String _title) {
        this.m_title = _title;
    }

    // ############
    // ## Getter ##
    // ############

    public Integer getId() {
        return m_id;
    }

    public String getTitle() {
        return m_title;
    }

    public Integer getArtist() {
        return m_artist;
    }

    // ############
    // ## Setter ##
    // ############

    public void setId(Integer _id) {
        this.m_id = _id;
    }

    public void setTitle(String _title) {
        this.m_title = _title;
    }

    public void setArtist(Integer _artist) {
        this.m_artist = _artist;
    }

    // #############
    // ## Methods ##
    // #############

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Album{");
        sb.append("title='").append(m_title).append('\'');
        sb.append(", artist='").append(m_artist).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Album)) return false;

        Album album = (Album) o;

        if (this.m_title != null ? !this.m_title.equals(album.getTitle()) : !album.getTitle().equals(null)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(m_title);
    }

    // TODO : util ?
    public String getType() {
        return this.getClass().getSimpleName().toLowerCase();
    }
}
