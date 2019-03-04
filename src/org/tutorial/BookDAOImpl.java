package org.tutorial;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImpl implements BookDAO {
    @Override
    public List<Book> findByAll() {
        Connection co = DBManager.getInstance().getConnection();
        List<Book> list = new ArrayList<>();

        try {
            Statement statement = co.createStatement();
            ResultSet rs = statement.executeQuery("select * from etudiant");
            while(rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("nom");
                String author = rs.getString("prenom");
                Book book = new Book(id,title,author);
                list.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
