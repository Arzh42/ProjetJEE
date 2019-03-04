package org.tutorial;

import java.util.ArrayList;
import java.util.List;

public class BookDAOMockImpl implements BookDAO {


    public List<Book> findByAll() {
        List<Book> liste = new ArrayList<Book>();
        liste.add(new Book(0,"1","moi"));

        liste.add(new Book(1,"14","moi"));
        liste.add(new Book(2,"2","moi"));
        liste.add(new Book(3,"3","moi"));
        liste.add(new Book(4,"4","moi"));
        liste.add(new Book(5,"5","moi"));

        return liste;
    }
}
