package com.java.eval.web;

import com.java.eval.web.model.Artist;
import com.java.eval.web.repository.AlbumRepository;
import com.java.eval.web.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private ArtistRepository artistRepository;

    public void run(String ... strings) throws Exception {
        String url = "jdbc:mysql://localhost:8889/audio?serverTimezone=UTC";
        String user = "root";
        String pwd = "root";
        java.sql.Connection connexion = null;

        try{
            connexion = java.sql.DriverManager.getConnection(url, user, pwd);
            System.out.println("Connexion à la base de donnée 'audio' réussie !");
            System.out.println("La base de donnée 'audio' possède " + artistRepository.count() + " entré(s) artiste.");
            System.out.println("La base de donnée 'audio' possède " + albumRepository.count() + " entré(s) album.");
        } catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }

        if(connexion != null) {
            try {
                connexion.close();
            } catch (java.sql.SQLException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
