
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

public class PrikaziKorisnikeLogika extends Database {

    public PrikaziKorisnikeLogika() {

    }

    /*
     *metoda koja iz baze prikazuje sve korisnike
     *@param
     */
    public ObservableList<User> prikaziSveKorisnike() {
        ObservableList<User> korisnik = FXCollections.observableArrayList();

        try {
            CONNECTION = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String query = "SELECT * FROM korisnici";
            PreparedStatement st = CONNECTION.prepareStatement(query);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String ime = rs.getString("ime");
                String prezime = rs.getString("prezime");
                String godinaRodjenja = rs.getString("godinaRodjenja");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");
                boolean admin = rs.getBoolean("admin");
                korisnik.add(new User(id, ime, prezime, godinaRodjenja, username, password, email, admin));
            }

            st.close();
            CONNECTION.close();
        } catch (SQLException ex) {
            System.out.println("Exception is: " + ex);
        }

        return korisnik;

    }

}