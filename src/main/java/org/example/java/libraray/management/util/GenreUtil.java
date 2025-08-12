package org.example.java.libraray.management.util;

import org.example.java.libraray.management.model.Genre;

import java.util.HashMap;
import java.util.Map;

public class GenreUtil {

    public static Map<Long, Genre> defaultSeedGenreMap() {
        Map<Long, Genre> genres = new HashMap<>();

        Genre g1 = new Genre();
        g1.setId(1L);
        g1.setName("Fantasy");

        Genre g2 = new Genre();
        g2.setId(2L);
        g2.setName("Mystery");

        Genre g3 = new Genre();
        g3.setId(3L);
        g3.setName("Horror");

        Genre g4 = new Genre();
        g4.setId(4L);
        g4.setName("Science Fiction");

        Genre g5 = new Genre();
        g5.setId(5L);
        g5.setName("Adventure");

        genres.put(g1.getId(), g1);
        genres.put(g2.getId(), g2);
        genres.put(g3.getId(), g3);
        genres.put(g4.getId(), g4);
        genres.put(g5.getId(), g5);

        return genres;
    }
}
