
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class KupiGui {

    public KupiGui() throws SQLException {
        guiKupi();
    }

    /*
      *metoda koja kreira gui za kupovinu karata 
      *@param
     */
    private void guiKupi() throws SQLException {

        Stage stageKupi = new Stage();

        GridPane gridKupi = new GridPane();

        Label labelImeBenda = new Label("Ime benda: ");
        TextField tfImeBenda = new TextField();

        Label labelCena = new Label("Cena: ");
        TextField tfCena = new TextField();

        Label labelIme = new Label("Ime: ");
        TextField tfIme = new TextField();

        Label labelPrezime = new Label("Prezime: ");
        TextField tfPrezime = new TextField();

        Label labelRacun = new Label("Račun: ");
        TextField tfRacun = new TextField();

        Button btnKupi = new Button("Kupi kartu ");

        btnKupi.setOnAction((ActionEvent event) -> {
            try {
                KupiLogika kl = new KupiLogika();

                kl.kupiKartu(tfImeBenda.getText(), Integer.parseInt(tfCena.getText()), tfIme.getText(), tfPrezime.getText(), Integer.parseInt(tfRacun.getText()));

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Uspešno dodavanje!");
                alert.setHeaderText("Koncert je dodat!");
                alert.setContentText("Dodali se koncert benda : \n" + tfImeBenda.getText());
                alert.showAndWait();

            } catch (SQLException ex) {
                Logger.getLogger(KupiGui.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

        gridKupi.setAlignment(Pos.CENTER);

        gridKupi.add(labelImeBenda, 0, 0);
        gridKupi.add(tfImeBenda, 1, 0);

        gridKupi.add(labelCena, 0, 1);
        gridKupi.add(tfCena, 1, 1);

        gridKupi.add(labelIme, 0, 2);
        gridKupi.add(tfIme, 1, 2);

        gridKupi.add(labelPrezime, 0, 3);
        gridKupi.add(tfPrezime, 1, 3);

        gridKupi.add(labelRacun, 0, 4);
        gridKupi.add(tfRacun, 1, 4);

        gridKupi.add(btnKupi, 1, 5);

        Scene scene = new Scene(gridKupi, 500, 500);

        stageKupi.setTitle("Kupi kartu: ");
        stageKupi.setScene(scene);
        stageKupi.show();

    }
}
