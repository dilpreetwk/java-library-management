package org.example.java.libraray.management.util;

import org.example.java.libraray.management.model.Author;

import java.util.HashMap;
import java.util.Map;

public class AuthorUtil {


    public static Map<Long, Author> defaultSeedAuthorMap() {
        Map<Long, Author> authors = new HashMap<>();

        Author a1 = new Author();
        a1.setId(1L);
        a1.setName("J.K. Rowling");

        Author a2 = new Author();
        a2.setId(2L);
        a2.setName("George R.R. Martin");

        Author a3 = new Author();
        a3.setId(3L);
        a3.setName("Agatha Christie");

        Author a4 = new Author();
        a4.setId(4L);
        a4.setName("J.R.R. Tolkien");

        Author a5 = new Author();
        a5.setId(5L);
        a5.setName("Stephen King");

        authors.put(a1.getId(), a1);
        authors.put(a2.getId(), a2);
        authors.put(a3.getId(), a3);
        authors.put(a4.getId(), a4);
        authors.put(a5.getId(), a5);

        return authors;
    }
}
