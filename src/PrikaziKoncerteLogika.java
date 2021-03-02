
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

public class PrikaziKoncerteLogika extends Database{
    ObservableList<Koncert> sviKorisnici = FXCollections.observableArrayList();

    public PrikaziKoncerteLogika() {
    
    
    }
        /*
        *metoda koja iz baze prikazuje sve koncerte
        *@param
        */
    
    public ObservableList<Koncert> prikaziSveKoncerte() {
        ObservableList<Koncert> koncert = FXCollections.observableArrayList();

        try {
            CONNECTION = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String query = "SELECT * FROM koncert";
            PreparedStatement st = CONNECTION.prepareStatement(query);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String imeBenda = rs.getString("imeBenda");
                String datum = rs.getString("datum");
                int pocetak = rs.getInt("pocetak");
                int cena = rs.getInt("cena");
                
                koncert.add(new Koncert(id, imeBenda, datum, pocetak, cena));
            }

            st.close();
            CONNECTION.close();
        } catch (SQLException ex) {
            System.out.println("Exception is: " + ex);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Greska");
            alert.setHeaderText("Dogodila se greska!");
            alert.setContentText("Pokusajte ponovo.");
            alert.showAndWait();
        }

        return  koncert;

    }



}