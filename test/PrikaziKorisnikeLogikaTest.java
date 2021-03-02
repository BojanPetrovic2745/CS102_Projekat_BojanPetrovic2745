import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.*;

import static org.junit.Assert.*;

public class PrikaziKorisnikeLogikaTest extends Database {

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }


    @Test
    public void prikaziSveKorisnikeFail() {

        PrikaziKorisnikeLogika instance = new PrikaziKorisnikeLogika();

        ObservableList<User> expResult = FXCollections.observableArrayList();
        ObservableList<User> result = instance.prikaziSveKorisnike();

        System.out.println(result.toString());
        System.out.println(expResult);

        assertNotEquals(expResult, result);
        //assertEquals(expResult, result);
    }

    @Test
    public void prikaziSveKorisnikePass() {

        PrikaziKorisnikeLogika instance = new PrikaziKorisnikeLogika();


        ObservableList<User> expResult = FXCollections.observableArrayList();
        ObservableList<User> result = instance.prikaziSveKorisnike();

        System.out.println(result);
        System.out.println(expResult);

        assertNotEquals(expResult, result);
    }


}