package org.example.java.libraray.management.repository;

import org.example.java.libraray.management.model.Genre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class GenreRepository {

    private final Map<Long, Genre> genreMap = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public Genre findById(Long id) {
        if (!genreMap.containsKey(id)) {
            throw new RuntimeException("Genre not found with id: " + id);
        }

        return genreMap.get(id);
    }

    public List<Genre> findAll() {
        return new ArrayList<>(genreMap.values());
    }

    public Genre create(Genre genre ) {
        if (genre.getId() == null) {
            genre.setId(idGenerator.getAndIncrement());
        }

        genreMap.put(genre.getId(), genre);
        return genre;
    }

    public Genre update(Genre genre) {
        if (genre.getId() == null || !genreMap.containsKey(genre.getId())) {
            throw new RuntimeException("Genre not found with id: " + genre.getId());
        }

        genreMap.put(genre.getId(), genre);
        return genre;
    }

    public Genre delete(Long id) {
        if (!genreMap.containsKey(id)) {
            throw new RuntimeException("Genre not found with id: " + id);
        }

        return genreMap.remove(id);
    }

    public List<Genre> search(String search) {
        if (search == null || search.trim().isEmpty()) {
            return findAll();
        }

        String searchLower = search.toLowerCase();

        return genreMap.values().stream()
                .filter(genre->
                        genre.getName().toLowerCase().contains(searchLower))
                .toList();
    }
}
