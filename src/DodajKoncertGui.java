
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

public class DodajKoncertGui {

    public DodajKoncertGui() {
        guiDodajKoncert();
    }

    /*
     *metoda koja kreira gui za admina da bi mogao da doda koncert 
     *@param
     */
    private void guiDodajKoncert() {
        DodajKoncertLogika dl = new DodajKoncertLogika();

        Stage stageDodajKoncert = new Stage();

        GridPane gridDodajKoncert = new GridPane();

        Label labelImeBenda = new Label("Ime benda: ");
        TextField tfImeBenda = new TextField();

        Label labelDatum = new Label("Datum: ");
        TextField tfDatum = new TextField();

        Label labelPocetak = new Label("Početak: ");
        TextField tfPocetak = new TextField();

        Label labelCena = new Label("Cena: ");
        TextField tfCena = new TextField();

        Button btnDodajKoncert = new Button("Dodaj ");
        btnDodajKoncert.setOnAction((ActionEvent event) -> {
            try {
                dl.dodajKoncertUBazu(tfImeBenda.getText(), tfDatum.getText(), Integer.parseInt(tfPocetak.getText()), Integer.parseInt(tfCena.getText()));
            } catch (SQLException ex) {
                Logger.getLogger(DodajKoncertGui.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        gridDodajKoncert.setAlignment(Pos.CENTER);

        gridDodajKoncert.add(labelImeBenda, 0, 0);
        gridDodajKoncert.add(tfImeBenda, 1, 0);

        gridDodajKoncert.add(labelDatum, 0, 1);
        gridDodajKoncert.add(tfDatum, 1, 1);

        gridDodajKoncert.add(labelPocetak, 0, 2);
        gridDodajKoncert.add(tfPocetak, 1, 2);

        gridDodajKoncert.add(labelCena, 0, 3);
        gridDodajKoncert.add(tfCena, 1, 3);

        gridDodajKoncert.add(btnDodajKoncert, 1, 4);

        Scene scene = new Scene(gridDodajKoncert, 500, 500);
        stageDodajKoncert.setTitle("Dodaj koncert ");
        stageDodajKoncert.setScene(scene);
        stageDodajKoncert.show();

    }
}
