import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AdminGui extends Database {

    AdminLogika adminLogika = new AdminLogika();

    Stage stage = new Stage();

    Label lblObrisiKoncert = new Label("Obriši koncert: ");
    TextField tfObrisiKoncert = new TextField();
    Button btnObrisiKoncert = new Button("Briši koncert");

    Label labelObrisiKorisnika = new Label("Obriši korisnika: ");
    TextField tfObrisikorisnika = new TextField();
    Button btnObrisi = new Button("Obriši korisnika");

    Label labelPrikaziKorisnike = new Label("Prikazi korisnike: ");
    Button btnPrikaziKorisnike = new Button("Prikazi korisnike");

    Label labelPrikaziKoncerte = new Label("Prikazi koncerte: ");
    Button btnPrikaziKoncerte = new Button("Prikazi koncerte");

    public void guiAdmin(int id) {

        Stage stageAdmin = new Stage();

        btnObrisiKoncert.setOnAction((ActionEvent event) ->{
            adminLogika.izbrisiIzBaze(Integer.parseInt(tfObrisiKoncert.getText()), "koncert");
        });

        btnObrisi.setOnAction((ActionEvent event) -> {
            adminLogika.izbrisiIzBaze(Integer.parseInt(tfObrisikorisnika.getText()), "korisnici");
        });

        Label labelDodajKoncert = new Label("Dodaj koncert: ");
        Button btnDodajKoncert = new Button("Dodaj ");

        Label labelOpcije = new Label("Opcije: ");
        Button btnOpcije = new Button("Podešavanja: ");

        Label labelKupiKartu = new Label("Kupi kartu: ");
        Button btnKupiKartu = new Button("Kupi");

        btnOpcije.setOnAction((ActionEvent event) -> {
            new PodesavanjaGui();
            stageAdmin.close();
        });
        btnDodajKoncert.setOnAction((ActionEvent event) -> {
            new DodajKoncertGui();
        });

        btnPrikaziKorisnike.setOnAction((ActionEvent event) -> {
            new PrikaziKorisnikeGui();
        });
        btnPrikaziKoncerte.setOnAction((ActionEvent event) -> {
            new PrikaziKoncerteGui();
        });

        btnKupiKartu.setOnAction((ActionEvent event) -> {
            try {
                new KupiGui();
            } catch (SQLException ex) {
                Logger.getLogger(AdminGui.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        Button btnLogout = new Button("Logout");
        btnLogout.setOnAction((ActionEvent event) -> {

            stageAdmin.close();
            new PocetniStage().pocetni(stage);

        });

        GridPane gridAdmin = new GridPane();

        gridAdmin.setAlignment(Pos.CENTER);

        gridAdmin.add(lblObrisiKoncert, 0,0);
        gridAdmin.add(tfObrisiKoncert, 1, 0);
        gridAdmin.add(btnObrisiKoncert, 2,0);

        gridAdmin.add(labelObrisiKorisnika, 0, 1);
        gridAdmin.add(tfObrisikorisnika, 1, 1);
        gridAdmin.add(btnObrisi, 2, 1);

        gridAdmin.add(labelDodajKoncert, 0, 2);
        gridAdmin.add(btnDodajKoncert, 1, 2);

        gridAdmin.add(labelOpcije, 0, 3);
        gridAdmin.add(btnOpcije, 1, 3);

        gridAdmin.add(labelPrikaziKorisnike, 0, 5);
        gridAdmin.add(btnPrikaziKorisnike, 1, 5);

        gridAdmin.add(labelPrikaziKoncerte, 0, 6);
        gridAdmin.add(btnPrikaziKoncerte, 1, 6);

        gridAdmin.add(labelKupiKartu, 0, 7);
        gridAdmin.add(btnKupiKartu, 1, 7);

        gridAdmin.add(btnLogout, 0, 8);

        Scene scene = new Scene(gridAdmin, 500, 500);

        stageAdmin.setTitle("Dobrodošli ");
        stageAdmin.setScene(scene);
        stageAdmin.show();

    }

}
