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
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBManager implements Serializable {

    private transient Connection conn;

    public DBManager(String dburl) throws SQLException {
       
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");

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

    /**
     *
     * Autentica un utente in base a un nome utente e a una password
     *
     *
     *
     * @param username il nome utente
     *
     * @param password la password
     *
     * @return null se l'utente non è autenticato, un oggetto User se      *
     * l'utente esiste ed è autenticato
     *
     */
    public Users authenticate(String mail, String password) throws SQLException {

        PreparedStatement stm = conn.prepareStatement("SELECT * FROM USERS WHERE MAIL = ? AND PASSWORD = ?");
        try {
            stm.setString(1, mail);
            stm.setString(2, password);

            ResultSet rs = stm.executeQuery();
            try {
                if (rs.next()) {
                    Users user = new Users();
                    user.setmail(mail);
                    user.setpassword(rs.getString("PASSWORD"));
                    user.setName(rs.getString("NAME"));
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
