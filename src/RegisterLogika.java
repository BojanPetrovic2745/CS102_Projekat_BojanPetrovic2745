
import java.sql.DriverManager;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.scene.control.Alert;

class RegisterLogika extends Database {

    /*
     *metoda za registraciju korisnika
     *@param
     */

    public void unetiUbazu(String ime, String prezime, String godinaRodjenja, String username, String password, String email) throws SQLException, NoSuchAlgorithmException {
        try {

            User user = new User();
            user.setIme(ime);
            user.setPrezime(prezime);
            user.setGodinaRodjenja(godinaRodjenja);
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);
            user.setAdmin(false);
            if (user.getIme().isEmpty() || user.getPrezime().isEmpty() || user.getGodinaRodjenja().isEmpty()
                    || user.getUsername().isEmpty() || user.getPassword().isEmpty() || user.getEmail().isEmpty()) {
                System.err.println("error");

            } else {

                CONNECTION = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                String query = "INSERT INTO korisnici  (ime,prezime,godinaRodjenja,username,password,email,admin) VALUES(?,?,?,?,?,?,?)";

                PreparedStatement ps = CONNECTION.prepareStatement(query);
                ps.setString(1, user.getIme());
                ps.setString(2, user.getPrezime());
                ps.setString(3, user.getGodinaRodjenja());
                ps.setString(4, user.getUsername());
                ps.setString(5, user.getPassword());
                ps.setString(6, user.getEmail());
                ps.setBoolean(7, user.getAdmin());
                ps.execute();

                ps.close();
                CONNECTION.close();

            }
        } catch (SQLException ex) {
           ex.printStackTrace();
        }

    }
}