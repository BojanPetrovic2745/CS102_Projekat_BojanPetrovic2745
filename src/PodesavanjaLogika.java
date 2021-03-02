
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PodesavanjaLogika extends Database {
    /*
     *metoda koja radi update za email korisnika
     *@param
     */

    public void updateEmail(String username, String email) {


        try {
            CONNECTION = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String query = "UPDATE korisnici SET email = ? WHERE username = ?";
            PreparedStatement ps = CONNECTION.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, username);
            ps.executeUpdate();
            ps.close();
            CONNECTION.close();
        } catch (SQLException ex) {
            Logger.getLogger(PodesavanjaLogika.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     /*
      *metoda koja radi update za password korisnika
      *@param
      */

    public void updatePass(String username, String password) {

        User s = new User();

        s.setUsername(username);
        s.setPassword(password);
        try {
            CONNECTION = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String query = "UPDATE korisnici SET password = ? WHERE username = ?";
            PreparedStatement ps = CONNECTION.prepareStatement(query);
            ps.setString(1, password);
            ps.setString(2, username);
            ps.execute();
            ps.close();

            PreparedStatement p = CONNECTION.prepareStatement(query);

            
        } catch (SQLException ex) {
            Logger.getLogger(PodesavanjaLogika.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}