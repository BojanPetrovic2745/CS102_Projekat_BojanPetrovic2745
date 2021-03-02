
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.scene.control.Alert;

public class DodajKoncertLogika extends Database {

    /*
     *metoda koja omogucava admin da doda koncert u bazu 
     *@param
     */
    public void dodajKoncertUBazu(String imeBenda, String datum, int pocetak, int cena) throws SQLException {

        try {
            Koncert koncert = new Koncert();

            koncert.setImeBenda(imeBenda);
            koncert.setDatum(datum);
            koncert.setPocetak(pocetak);
            koncert.setCena(cena);

            if(koncert.getImeBenda().equals("") || koncert.getDatum().equals("") || koncert.getPocetak() == 0  || koncert.getCena() == 0 ){
                System.out.println("error");
            }else{
                CONNECTION = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                String query = "INSERT INTO koncert  (imeBenda,datum,pocetak,cena) VALUES(?,?,?,?)";

                PreparedStatement ps = CONNECTION.prepareStatement(query);


                ps.setString(1, koncert.getImeBenda());
                ps.setString(2, koncert.getDatum());
                ps.setInt(3, koncert.getPocetak());
                ps.setInt(4, koncert.getCena());
                ps.execute();
                ps.close();

                CONNECTION.close();
            }



        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
