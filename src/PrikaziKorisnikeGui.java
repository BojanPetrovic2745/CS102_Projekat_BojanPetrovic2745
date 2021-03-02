
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PrikaziKorisnikeGui {

    int id;
    TableView tableView = new TableView<>();

    public PrikaziKorisnikeGui() {
        
        prikaziGuiZaKorisnike();
    }
    
    
    /*
     *metoda koja kreira gui za prikaz svih korisnika iz baze 
     *@param
     */
    public void prikaziGuiZaKorisnike() {
        Stage stageSviKorisnici = new Stage();

        Pane paneKorisnik = new Pane();

        paneKorisnik.getChildren().add(TabelaZaPrikazIzBaze());

        Scene scene = new Scene(paneKorisnik, 500, 500);
        
        stageSviKorisnici.setTitle("Svi korisnici");
        stageSviKorisnici.setScene(scene);
        stageSviKorisnici.show();

    }

    public Node TabelaZaPrikazIzBaze() {
        TableColumn<User, String> idKol = new TableColumn<>("Id");
        TableColumn<User, String> imeKol = new TableColumn<>("Ime");
        TableColumn<User, String> prezimeKol = new TableColumn<>("Prezime");
        TableColumn<User, String> godinaRodjenjaKol = new TableColumn<>("Godina Rodjenja");
        TableColumn<User, String> usernameKol = new TableColumn<>("Username");
        TableColumn<User, String> passwordKol = new TableColumn<>("Password");
        TableColumn<User, String> emailKol = new TableColumn<>("Email");
        TableColumn<User, String> adminKol = new TableColumn<>("Admin");

        idKol.setCellValueFactory(new PropertyValueFactory<>("id"));
        idKol.setMinWidth(70);

        imeKol.setCellValueFactory(new PropertyValueFactory<>("ime"));
        imeKol.setMinWidth(70);

        prezimeKol.setCellValueFactory(new PropertyValueFactory<>("prezime"));
        prezimeKol.setMinWidth(70);

        godinaRodjenjaKol.setCellValueFactory(new PropertyValueFactory<>("godinaRodjenja"));
        godinaRodjenjaKol.setMinWidth(70);

        usernameKol.setCellValueFactory(new PropertyValueFactory<>("username"));
        usernameKol.setMinWidth(70);

        passwordKol.setCellValueFactory(new PropertyValueFactory<>("password"));
        passwordKol.setMinWidth(70);

        emailKol.setCellValueFactory(new PropertyValueFactory<>("email"));
        emailKol.setMinWidth(70);

        adminKol.setCellValueFactory(new PropertyValueFactory<>("admin"));
        adminKol.setMinWidth(70);
        PrikaziKorisnikeLogika korisnikL = new PrikaziKorisnikeLogika();
        tableView = new TableView<>(korisnikL.prikaziSveKorisnike());
        tableView.setEditable(true);
        tableView.getSelectionModel().setCellSelectionEnabled(true);
        tableView.getColumns().setAll(idKol, imeKol, prezimeKol, usernameKol, passwordKol, emailKol, adminKol);

        VBox vbox = new VBox();

        vbox.setSpacing(5);
        vbox.setPadding(new Insets(5, 0, 0, 0));
        vbox.getChildren().add(tableView);

        return vbox;
    }

}