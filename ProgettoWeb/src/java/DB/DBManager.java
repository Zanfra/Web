/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBManager implements Serializable {

    private transient Connection conn;

    public DBManager(String dburl) throws SQLException {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver", true, getClass().getClassLoader());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.conn = DriverManager.getConnection(dburl);
    }

    public static void shutdown() {
        try {
            DriverManager.getConnection("jdbc:derby:;shutdown=true");
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).info(ex.getMessage());
        }
    }

    public Users authenticate(String username, String password) throws SQLException {
        PreparedStatement stm = conn.prepareStatement("SELECT * FROM users WHERE mail = ? AND password = ?");
        try {
            stm.setString(1, username);
            stm.setString(2, password);

            ResultSet rs = stm.executeQuery();
            try {
                if (rs.next()) {
                    Users user = new Users();
                    user.setmail(username);
                    user.setpassword(rs.getString(password));
                    return user;
                } else {
                    return null;
                }
            } finally {
                rs.close();
            }
        } finally {
            stm.close();
        }
    }
}
