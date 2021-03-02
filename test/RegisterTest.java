import javafx.application.Application;
import javafx.stage.Stage;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RegisterTest extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        new Register().guiRegister(primaryStage);
    }
}