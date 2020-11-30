package com.java.eval.web.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Objects;

@Entity
@Table(name="Artist")
public class Artist {

    //private static final long serialVersionUID = -633481376872387016L; // TODO: what does it mean ?

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ArtistId")
    private Integer m_id;

    @Size(max = 120)
    @Column(name = "Name")
    private String m_name;

    public Artist() {

    }

    public Artist(String _name) {
        this.m_name = _name;
    }

    // ############
    // ## Getter ##
    // ############

    public Integer getId() {
        return m_id;
    }

    public String getName() {
        return m_name;
    }

    // ############
    // ## Setter ##
    // ############

    public void setId(Integer _id) {
        this.m_id = _id;
    }

    public void setName(String _name) {
        this.m_name = _name;
    }

    // #############
    // ## Methods ##
    // #############

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Artist{");
        sb.append("nom='").append(m_name).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Artist)) return false;

        Artist artist = (Artist) o;

        if (this.m_name != null ? !this.m_name.equals(artist.getName()) : !artist.getName().equals(null)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(m_name);
    }

    // TODO : util ?
    public String getType() {
        return this.getClass().getSimpleName().toLowerCase();
    }

}