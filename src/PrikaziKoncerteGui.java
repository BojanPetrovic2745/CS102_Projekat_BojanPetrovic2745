
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PrikaziKoncerteGui {
     int id;
    TableView tableView = new TableView<>();

    public PrikaziKoncerteGui() {
        
        prikaziGuiZaKoncerte();
    }
    
    
    /*
     *metoda koja kreira gui za sve koncerte iz baze
     *@param
     */
    public void prikaziGuiZaKoncerte() {
        Stage stageSviKoncerti = new Stage();

        Pane paneKorisnik = new Pane();

        paneKorisnik.getChildren().add(TabelaZaPrikazIzBaze());

        Scene scene = new Scene(paneKorisnik, 500, 500);
        
        stageSviKoncerti.setTitle("Svi korisnici");
        stageSviKoncerti.setScene(scene);
        stageSviKoncerti.show();

    }

    public Node TabelaZaPrikazIzBaze() {
        TableColumn<User, String> idKol = new TableColumn<>("Id");
        TableColumn<User, String> imeBendaKol = new TableColumn<>("Ime Benda");
        TableColumn<User, String> datumKol = new TableColumn<>("Datum");
        TableColumn<User, String> pocetakKol = new TableColumn<>("Pocetak");
        TableColumn<User, String> cenaKol = new TableColumn<>("Cena");
       

        idKol.setCellValueFactory(new PropertyValueFactory<>("id"));
        idKol.setMinWidth(50);

        imeBendaKol.setCellValueFactory(new PropertyValueFactory<>("imeBenda"));
        imeBendaKol.setMinWidth(50);

        datumKol.setCellValueFactory(new PropertyValueFactory<>("datum"));
        datumKol.setMinWidth(50);

        pocetakKol.setCellValueFactory(new PropertyValueFactory<>("pocetak"));
        pocetakKol.setMinWidth(50);

        cenaKol.setCellValueFactory(new PropertyValueFactory<>("cena"));
        cenaKol.setMinWidth(50);

       
        PrikaziKoncerteLogika korisnikL = new PrikaziKoncerteLogika();
        tableView = new TableView<>(korisnikL.prikaziSveKoncerte());
        tableView.setEditable(true);
        tableView.getSelectionModel().setCellSelectionEnabled(true);
        tableView.getColumns().setAll(idKol, imeBendaKol, datumKol, pocetakKol, cenaKol);

        VBox vbox = new VBox();

        vbox.setSpacing(5);
        vbox.setPadding(new Insets(5, 0, 0, 0));
        vbox.getChildren().add(tableView);

        return vbox;
    }
    
}