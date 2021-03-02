
import java.sql.Connection;

public class Database {

    /*
     *klasa preko koje se aplikacija konektuje na bazu
     *@param
     */

    protected Connection CONNECTION = null;

    protected final String URL = "jdbc:mysql://localhost/koncerti";
    protected final String USERNAME = "root";
    protected final String PASSWORD = "";

    public Database() {
    }

    public Connection getCONNECTION() {
        return CONNECTION;
    }

    public String getURL() {
        return URL;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setCONNECTION(Connection CONNECTION) {
        this.CONNECTION = CONNECTION;
    }

    @Override
    public String toString() {
        return "Database{" + "CONNECTION="
                + CONNECTION + ", URL=" + URL + ", USERNAME=" + USERNAME + ", PASSWORD=" + PASSWORD + '}';
    }

}
