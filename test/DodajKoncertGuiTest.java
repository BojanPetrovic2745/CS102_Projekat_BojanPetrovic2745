import javafx.application.Application;
import javafx.stage.Stage;

import static org.testng.Assert.*;

public class DodajKoncertGuiTest extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        new DodajKoncertGui();
    }
}