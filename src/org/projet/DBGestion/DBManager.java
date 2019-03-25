
package org.projet.DBGestion;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;

public class DBManager {

    private static DBManager instance;

    private ResourceBundle properties;

    private static String resourceBundle = "config";
    private DataSource ds;

    private DBManager() {
        properties = ResourceBundle.getBundle(resourceBundle);
        Context initCtx = null;
        try {
            initCtx = new InitialContext();

            Context envCtx = null;
            envCtx = (Context) initCtx.lookup("java:comp/env");

            ds = (DataSource) envCtx.lookup("jdbc/JEE");

        } catch (NamingException e) {
            e.printStackTrace();
        }

    }

    public static DBManager getInstance() {
        if (instance == null) {
            synchronized (DBManager.class) {
                instance = new DBManager();
            }
        }
        return instance;
    }

    public Connection getConnection() {

        Connection connection = null;
        try {
            connection = ds.getConnection();

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return connection;

    }

    public void cleanup(Connection connection, Statement stat, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (stat != null) {
            try {
                stat.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    /**
     * permet de tester la connexion à la DB
     *
     * @param args
     */
    public static void main(String[] args) {
        Connection c = DBManager.getInstance().getConnection();
        if (c != null) {
            try {
                System.out.println("Connection to db : " + c.getCatalog());
                Properties p = c.getClientInfo();
                Enumeration<Object> keys = p.keys();
                while (keys.hasMoreElements()) {
                    String key = (String) keys.nextElement();
                    System.out.println(key + ":" + p.getProperty(key));
                }

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                DBManager.getInstance().cleanup(c, null, null);
            }
        }
    }
}


