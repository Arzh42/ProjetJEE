package org.projet.DBGestion;

import org.apache.commons.codec.digest.DigestUtils;
import org.projet.Exception.UserDBException;
import org.tutorial.DBManager;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.Arrays;

import static javax.xml.crypto.dsig.DigestMethod.SHA256;
import static javax.xml.crypto.dsig.DigestMethod.SHA3_256;

public class UserServiceImpl implements UserService {

    @Override
    public boolean verifyUserIdentity(String name, String password) {
        Connection co = DBManager.getInstance().getConnection();
        try {
            PreparedStatement statement = co.prepareStatement("select password from users where name=?");
            statement.setString(1,name);
            ResultSet rs = statement.executeQuery();
            String hashPass = toHash(password);
            System.out.println(hashPass);
            if (rs.next()) {
                if ( hashPass.equals(rs.getString("password"))) {
                    return true;
                }
            }
        } catch (SQLException | NoSuchAlgorithmException e) {
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
            statement.setString(1,toHash(password));
            statement.setString(2,name);
            int status = statement.executeUpdate();
            System.out.println(status);
        } catch (SQLException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

    }

    public void changeQuestion(String name,String question, String reponse) {
        Connection co = DBManager.getInstance().getConnection();
        try {
            System.out.println(question+"  "+reponse);
            PreparedStatement statement = co.prepareStatement("UPDATE users SET Question=?,Reponse=? WHERE name=?");
            statement.setString(1,question);
            statement.setString(2,reponse);
            statement.setString(3,name);
            int status = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
    private String toHash(String word) throws NoSuchAlgorithmException {
        return Arrays.toString(DigestUtils.sha512(word));

    }

}
