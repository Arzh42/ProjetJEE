package org.projet.DBGestion;

import org.projet.Exception.UserDBException;
import org.tutorial.DBManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
                    DBManager.getInstance().cleanup(co,statement,rs);
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
                String role = rs.getString("role");
                DBManager.getInstance().cleanup(co,statement,rs);
                return role;
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
    public List<User> getUsers() {
        Connection co = DBManager.getInstance().getConnection();
        ArrayList<User> list = new ArrayList<>();
        try {
            PreparedStatement statement = co.prepareStatement("select users.name,roles.role from users JOIN roles ON users.name=roles.name");
            ResultSet rs = statement.executeQuery();
            this.BuildUserFromReq(list,rs);
            DBManager.getInstance().cleanup(co,statement,rs);
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    private void BuildUserFromReq(List<User> list, ResultSet rs) throws SQLException {
        while(rs.next()) {
            String name = rs.getString("name");
            String role = rs.getString("role");
            User u = new User(name,role);
            list.add(u);
        }
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
            System.out.println("name"+name);
            PreparedStatement statement = co.prepareStatement("select question from users where name=?");
            statement.setString(1,name);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String question = rs.getString("question");
                DBManager.getInstance().cleanup(co,statement,rs);
                return question;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean verifyReponse(String name, String reponse) {
        Connection co = DBManager.getInstance().getConnection();
        try {
            PreparedStatement statement = co.prepareStatement("select reponse from users where name=?");
            statement.setString(1,name);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                if (rs.getString("reponse").equals(reponse)) {
                    DBManager.getInstance().cleanup(co,statement,rs);

                    return true;
                }
                else {
                    DBManager.getInstance().cleanup(co,statement,rs);

                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void changeRole(String name, String role) {
        Connection co = DBManager.getInstance().getConnection();
        try {
            PreparedStatement statement = co.prepareStatement("UPDATE roles SET role=? WHERE name=?");
            statement.setString(1,role);
            statement.setString(2,name);
            int status = statement.executeUpdate();
            DBManager.getInstance().cleanup(co,statement,null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
