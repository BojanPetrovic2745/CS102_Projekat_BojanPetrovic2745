import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminLogika extends Database {

    /*
       *metoda koja omogucava adminu da izbrise korisnika / koncert iz baze
       *@param
     */

    public void izbrisiIzBaze(int id, String tabela){

        try {

            if(id ==0){
                System.out.println("error");
            }else {
                CONNECTION = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                String query = "DELETE FROM " + tabela + " WHERE id = ?";

                PreparedStatement ps = CONNECTION.prepareStatement(query);
                ps.setInt(1, id);

                ps.executeUpdate();

                CONNECTION.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdminGui.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
