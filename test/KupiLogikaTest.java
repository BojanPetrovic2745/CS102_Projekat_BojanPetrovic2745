import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class KupiLogikaTest {

    private KupiLogika kupiLogika = new KupiLogika();

    @Test
    public void kupiLogikaPass() throws SQLException {

        kupiLogika.kupiKartu("Tool", 1500,"Bojan", "Petrovic", 123123);
    }

    @Test
    public void kupiLogikaFail() throws SQLException {

        kupiLogika.kupiKartu("", 1500,"", "", 123123);
    }

}