
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.Alert;

public class KupiLogika extends Database {

    /*
     *metoda koja sluzi za kupovinu karata za koncert 
     *@param
     */
    public void kupiKartu(String imeBenda1, int cena1, String ime1, String prezime1, int racun1) throws SQLException {

        try {
            Kupi kupi = new Kupi();

            kupi.setImeBenda(imeBenda1);
            kupi.setCena(cena1);
            kupi.setIme(ime1);
            kupi.setPrezime(prezime1);
            kupi.setRacun(racun1);

            if (kupi.getImeBenda().equals("") || kupi.getCena() == 0 || kupi.getRacun() == 0 || kupi.getIme().equals("") || kupi.getPrezime().equals("")){
                System.err.println("error");
            }else{

                CONNECTION = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                String query = "INSERT INTO kupi ( imeBenda, cena, ime, prezime, racun) VALUES ( ?, ?, ?, ?, ?)";

                PreparedStatement ps = CONNECTION.prepareStatement(query);

                ps.setString(1, kupi.getImeBenda());
                ps.setInt(2, kupi.getCena());
                ps.setString(3, kupi.getIme());
                ps.setString(4, kupi.getPrezime());
                ps.setInt(5, kupi.getRacun());
                ps.executeUpdate();

                ps.close();
                CONNECTION.close();
            }



        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
