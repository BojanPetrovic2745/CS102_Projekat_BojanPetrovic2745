
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.scene.control.Alert;

public class Kupi {

    /*
      * model
      *@param
     */

    private int id;
    private String imeBenda;
    private int cena;
    private String ime;
    private String prezime;
    private int racun;

    public Kupi() {

    }

    public Kupi(int id, String imeBenda, int cena, String ime, String prezime, int racun) {
        this.id = id;
        this.imeBenda = imeBenda;
        this.cena = cena;
        this.ime = ime;
        this.prezime = prezime;
        this.racun = racun;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImeBenda() {
        return imeBenda;
    }

    public void setImeBenda(String imeBenda) {
        this.imeBenda = imeBenda;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public int getRacun() {
        return racun;
    }

    public void setRacun(int racun) {
        this.racun = racun;
    }

}
