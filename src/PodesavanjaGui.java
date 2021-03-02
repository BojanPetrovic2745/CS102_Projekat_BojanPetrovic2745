
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PodesavanjaGui {

    User s = new User();
    PodesavanjaLogika podesavanjaL = new PodesavanjaLogika();

    public PodesavanjaGui() {
        guiPodesavanja();
    }

    /*
      *metoda koja prikazuje gui za promenu email-a ili password-a korisnika
      *@param
     */
    private void guiPodesavanja() {
        Stage stage = new Stage();

        Stage stagePodesavanja = new Stage();

        GridPane gridPodesavanja = new GridPane();

        Label labelPromeniMail = new Label("Promeni Mail: ");
        TextField tfUsername = new TextField();
        TextField tfPromeniMail = new TextField();
        Button btnPromenaMail = new Button("Promeni mail ");

        TextField tfUsernamePasswd = new TextField();

        Label labelPromeniPassword = new Label("Promeni pass: ");
        PasswordField tfPromeniPassword = new PasswordField();

        Button btnPromeniPassword = new Button("Promeni pass ");

        gridPodesavanja.setAlignment(Pos.CENTER);

        gridPodesavanja.add(labelPromeniMail, 0, 0);
        gridPodesavanja.add(tfUsername, 1, 0);
        gridPodesavanja.add(tfPromeniMail, 2, 0);

        gridPodesavanja.add(btnPromenaMail, 3, 0);

        gridPodesavanja.add(labelPromeniPassword, 0, 1);
        gridPodesavanja.add(tfUsernamePasswd, 1, 1);
        gridPodesavanja.add(tfPromeniPassword, 2, 1);
        gridPodesavanja.add(btnPromeniPassword, 3, 1);

        Scene scene = new Scene(gridPodesavanja, 500, 500);

        stagePodesavanja.setTitle("Podešavanja ");
        stagePodesavanja.setScene(scene);
        stagePodesavanja.show();

        btnPromenaMail.setOnAction((ActionEvent event) -> {
            String usernameKorisnika = tfUsername.getText();
            String emailKorisnika = tfPromeniMail.getText();
            podesavanjaL.updateEmail(usernameKorisnika, emailKorisnika);
            stagePodesavanja.close();
            new PocetniStage().pocetni(stage);

        });

        btnPromeniPassword.setOnAction((ActionEvent event) -> {
            String passwordKorisnika = tfPromeniPassword.getText();
            try {
                podesavanjaL.updatePass(tfUsernamePasswd.getText(), s.HashPassword(passwordKorisnika));
                stagePodesavanja.close();
                new PocetniStage().pocetni(stage);

            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(PodesavanjaGui.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }

}