import org.junit.Test;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class RegisterLogikaTest {

    private RegisterLogika registerLogika = new RegisterLogika();
    private User user = new User();

    @Test
    public void unetiUbazuPass() throws SQLException, NoSuchAlgorithmException {
        registerLogika
                .unetiUbazu(
                    "asdf",
                    "asdfa",
                    "11.1.1992.",
                    "asdfa",
                    user.HashPassword("asdf"),
                    "asdf@gmail.com");
    }

    @Test
    public void unetiUbazuFail() {

        try{
            registerLogika
                    .unetiUbazu(
                            "a",
                            "b",
                            "11.1.1992.",
                            "asd12",
                            user.HashPassword("asd"),
                            "asd123@gmail.com");
        }
        catch(SQLException ex){ex.printStackTrace();}
        catch (NoSuchAlgorithmException ex1){ex1.printStackTrace();}
    }
}