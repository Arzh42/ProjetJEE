package org.projet.DBGestion;

import org.projet.Exception.UserDBException;
import org.tutorial.DBManager;

import java.sql.*;

public class UserServiceImpl implements UserService {

    @Override
    public boolean verifyUserIdentity(String name, String password) {
        Connection co = DBManager.getInstance().getConnection();
        try {
            PreparedStatement statement = co.prepareStatement("select password from users where name=?");
            statement.setString(1,name);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                if ( password.equals(rs.getString("password"))) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String getUserRole(String name) throws UserDBException {
        Connection co = DBManager.getInstance().getConnection();
        try {
            PreparedStatement statement = co.prepareStatement("select role from roles where name=?");
            statement.setString(1,name);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getString("role");
            }
            else {
                throw new UserDBException("Role Introuvable");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void changePassword(String name, String password) {
        Connection co = DBManager.getInstance().getConnection();
        try {
            PreparedStatement statement = co.prepareStatement("UPDATE users SET password=? WHERE name=?");
            statement.setString(1,password);
            statement.setString(2, name);
            int status = statement.executeUpdate();
            System.out.println(status);
            DBManager.getInstance().cleanup(co,statement,null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void changeQuestion(String name, String question, String reponse) {
        Connection co = DBManager.getInstance().getConnection();
        try {
            PreparedStatement statement = co.prepareStatement("UPDATE users SET question=? AND reponse=? WHERE name=?");
            statement.setString(1,question);
            statement.setString(2,reponse);
            statement.setString(3,name);
            int status = statement.executeUpdate();
            DBManager.getInstance().cleanup(co,statement,null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String getQuestion(String name) {
        Connection co = DBManager.getInstance().getConnection();
        try {
            PreparedStatement statement = co.prepareStatement("select question from users where name=?");
            statement.setString(1,name);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getString("question");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
