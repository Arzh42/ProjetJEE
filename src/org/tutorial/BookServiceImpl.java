package org.tutorial;

import java.util.List;

public class BookServiceImpl implements BookService {
    @Override
    public List<Book> getAllBooks() {
        BookDAO impl = new BookDAOImpl();
        return impl.findByAll();
    }
}
