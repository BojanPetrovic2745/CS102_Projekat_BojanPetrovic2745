
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Login extends Database {

    public Login() { }

    public void guiLogin(Stage primaryStage) {
        User noviUser = new User();
        LoginLogika lk = new LoginLogika();
        Stage st2 = new Stage();
        GridPane grid2 = new GridPane();

        Label labelUsername = new Label("Username: ");
        TextField tfUsername = new TextField();

        Label labelPassword = new Label("Password: ");
        PasswordField pfPassword = new PasswordField();

        Button btnLog = new Button("Login");

        btnLog.setOnAction((ActionEvent event) -> {
            
            User s = new User();
            try {
                s = lk.proveriLogin(tfUsername.getText(), s.HashPassword(pfPassword.getText()));    
                //int jelAdmin = lk.proveriLogin(tfUsername.getText(), s.HashPassword(pfPassword.getText()));
                if (s.getUsername().isEmpty()) {

                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Nije unet username ili password");
                        alert.setHeaderText("Greska");
                        alert.setContentText("Pokusajte ponovo.");

                } else{
                    if (s.getAdmin()) {
                        AdminGui ag = new AdminGui();
                        ag.guiAdmin(s.proveriUserName(tfUsername.getText()));
                        st2.close();
                    } else{
                        KorisnikGui kg = new KorisnikGui();
                        kg.guiKorisnik(s.proveriUserName(tfUsername.getText()));
                        st2.close();
                    }
                }

            } catch (SQLException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Greska");
                alert.setHeaderText(ex.getMessage());
                alert.setContentText("Pokusajte ponovo.");

            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
        grid2.setAlignment(Pos.CENTER);

        grid2.add(labelUsername, 0, 0);
        grid2.add(tfUsername, 1, 0);

        grid2.add(labelPassword, 0, 1);
        grid2.add(pfPassword, 1, 1);

        grid2.add(btnLog, 1, 2);

        Scene scene2 = new Scene(grid2, 500, 500);

        st2.setTitle("Login: ");
        st2.setScene(scene2);
        st2.show();
    }

}