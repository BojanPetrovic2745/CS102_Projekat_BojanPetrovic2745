
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PocetniStage {

    /*
     *metoda koja kreira pocetni stage 
     *@param
     */
    public void pocetni(Stage primaryStage) {

        GridPane grid = new GridPane();

        Button logIn = new Button("Log in");
        Button register = new Button("Register");

        register.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Register r = new Register();
                r.guiRegister(primaryStage);
                primaryStage.close();

            }

        });

        logIn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Login l = new Login();
                l.guiLogin(primaryStage);
                primaryStage.close();

            }

        });
        grid.setAlignment(Pos.CENTER);

        grid.add(logIn, 0, 0);
        grid.add(register, 1, 0);

        Scene scene = new Scene(grid, 450, 150);

        primaryStage.setTitle("Dobrodosli!");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}