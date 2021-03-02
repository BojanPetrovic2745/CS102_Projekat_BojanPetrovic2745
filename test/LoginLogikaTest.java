import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class LoginLogikaTest {

    @Test
    public void proveriLoginPass() throws SQLException, NoSuchAlgorithmException {

        User s = new User();

        LoginLogika loginLogika = new LoginLogika();

        System.out.println(loginLogika.proveriLogin("bojan", s.HashPassword("bojan123")));

    }

    @Test
    public void proveriLoginFail() throws SQLException, NoSuchAlgorithmException {

        User s = new User();

        LoginLogika loginLogika = new LoginLogika();

        System.out.println(loginLogika.proveriLogin("bojan", s.HashPassword("123")));

    }
}
