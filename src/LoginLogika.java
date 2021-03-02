
import java.security.NoSuchAlgorithmException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.Alert;

public class LoginLogika extends Database {

    /*
     *metoda koja proverava da li korisnik posoji u bazi  
     *@param
     */
    User proveriLogin(String username, String password) throws SQLException, NoSuchAlgorithmException {
        
        User user = new User();
        
        try {
            if(username.isEmpty() || password.isEmpty() || user.HashPassword(password).isEmpty()){
                System.out.println("error");
            }else{
                CONNECTION = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                String query = "SELECT * FROM korisnici WHERE username = ?";
                PreparedStatement ps = CONNECTION.prepareStatement(query);
                ps.setString(1, username);
                ResultSet rs = ps.executeQuery();
                rs.next();
                user = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getBoolean("admin"));
                ps.close();
                CONNECTION.close();
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        if (user.getPassword().equals(password)) {
                return user;
        } else {
                return null;
            }
    }

}