
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class KorisnikGui {

    public KorisnikGui() {
       
    }
     /*
     *metoda koja kreira gui za korisnika koji nije admin 
     *@param
     */

    public void guiKorisnik(int id) {
        Stage stage = new Stage();

        Stage stgKorisnik = new Stage();

        GridPane gridKorisnik = new GridPane();

        Label labelListaKoncerata = new Label("Lista koncerata: ");
        Button btnListaKoncerata = new Button("Prikaži koncerte ");

        Label labelOpcije = new Label("Opcije: ");
        Button btnOpcije = new Button("Prikazi podesavanja ");
         Label labelKupiKartu = new Label("Kupi kartu: ");
         Button btnKupi1 = new Button("Kupi kartu ");

        Button btnLogout = new Button("Logout ");
        
        btnOpcije.setOnAction((ActionEvent event) ->{
            new PodesavanjaGui();
            stgKorisnik.close();
        });
        
        btnKupi1.setOnAction((ActionEvent event) ->{
            try {
                new KupiGui();
                
            } catch (SQLException ex) {
                Logger.getLogger(KorisnikGui.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
         btnListaKoncerata.setOnAction((ActionEvent event) ->{
            new PrikaziKoncerteGui();
            
        });
         btnLogout.setOnAction((ActionEvent event) ->{
             stgKorisnik.close();
            new PocetniStage().pocetni(stage);
            
            
        });
        gridKorisnik.setAlignment(Pos.CENTER);
        
        gridKorisnik.add(labelListaKoncerata, 0, 0);
        gridKorisnik.add(btnListaKoncerata, 1, 0);

        
        gridKorisnik.add(labelOpcije, 0, 1);
        gridKorisnik.add(btnOpcije, 1, 1);
        
        
        
        gridKorisnik.add(labelKupiKartu,0,2);
        gridKorisnik.add(btnKupi1,1,2);
        gridKorisnik.add(btnLogout, 0, 4);
        
        

        Scene scene = new Scene(gridKorisnik, 500, 500);
        
        stgKorisnik.setTitle("Dobrodošli ");
        stgKorisnik.setScene(scene);
        stgKorisnik.show();
    }

}
