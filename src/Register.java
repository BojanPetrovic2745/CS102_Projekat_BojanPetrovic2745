
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

public class Register {

    public Register() {

    }

    /*
     *metoda koja kreira gui za registraciju
     *@param
     */
    public void guiRegister(Stage primaryStage) {
        RegisterLogika rl = new RegisterLogika();
        Stage st = new Stage();
        GridPane grid1 = new GridPane();

        Label labelIme = new Label("Ime: ");
        TextField tfIme = new TextField();

        Label labelPrezime = new Label("Prezime: ");
        TextField tfPrezime = new TextField();

        Label labelGodinaRodjenja = new Label("Godina rodjenja: ");
        TextField tfGodinaRodjenja = new TextField();

        Label labelUsername = new Label("Username: ");
        TextField tfUsername = new TextField();

        Label labelPassword = new Label("Password: ");
        PasswordField pfPassword = new PasswordField();

        Label labelEmail = new Label("Email: ");
        TextField tfEmail = new TextField();

        Button btnReg = new Button("Register");

        User s = new User();
        btnReg.setOnAction((ActionEvent event) -> {
            try {
                rl.unetiUbazu(tfIme.getText(), tfPrezime.getText(), tfGodinaRodjenja.getText(), tfUsername.getText(), s.HashPassword(pfPassword.getText()), tfEmail.getText());
                Main m = new Main();
                m.start(primaryStage);
                st.close();

            } catch (SQLException ex) {

            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

        grid1.setAlignment(Pos.CENTER);

        grid1.add(labelIme, 0, 0);
        grid1.add(tfIme, 1, 0);

        grid1.add(labelPrezime, 0, 1);
        grid1.add(tfPrezime, 1, 1);

        grid1.add(labelGodinaRodjenja, 0, 2);
        grid1.add(tfGodinaRodjenja, 1, 2);

        grid1.add(labelUsername, 0, 3);
        grid1.add(tfUsername, 1, 3);

        grid1.add(labelPassword, 0, 4);
        grid1.add(pfPassword, 1, 4);

        grid1.add(labelEmail, 0, 5);
        grid1.add(tfEmail, 1, 5);

        grid1.add(btnReg, 1, 6);

        Scene scene1 = new Scene(grid1, 500, 500);

        st.setTitle("Registracija");
        st.setScene(scene1);
        st.show();
    }
}