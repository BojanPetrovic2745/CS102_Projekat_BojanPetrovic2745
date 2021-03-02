import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class DodajKoncertLogikaTest {

    private DodajKoncertLogika dodajKoncertLogika = new DodajKoncertLogika();

    @Test
    public void dodajKoncertUBazuPass() {

        try{
            dodajKoncertLogika.dodajKoncertUBazu("Iron Maiden", "20.1.2021.", 20, 3500);
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    @Test
    public void dodajKoncertUBazuFail() {

        try{
            dodajKoncertLogika.dodajKoncertUBazu("", "", 20, 3500);
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}