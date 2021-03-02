

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.Alert;

public class User extends Database{
    /*
     *klasa koja definise korisnika
     *@param
     */

    private int id;


    private String ime;

    private String prezime;

    private String godinaRodjenja;

    private String username;

    private String password;

    private String email;

    private boolean admin;

    public User() {

    }

    public User(int id, String ime, String prezime, String godinaRodjenja, String username, String password, String email, boolean admin) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.godinaRodjenja = godinaRodjenja;
        this.username = username;
        this.password = password;
        this.email = email;
        this.admin = admin;
    }

    public User(int id,String username, String password, boolean admin){
    
        this.id = id;
        this.username = username;
        this.password = password;
        this.admin = admin;
        
    }

    public int getId() {

        return id;

    }

    public String getIme(){
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public String getGodinaRodjenja() {
        return godinaRodjenja;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIme(String ime) {
            if(ime.length() >= 3){
                this.ime = ime;
            }
    }

    public void setPrezime(String prezime) {
        if(prezime.length() >= 5){
            this.prezime = prezime;
        }
    }

    public void setGodinaRodjenja(String godinaRodjenja) {
        this.godinaRodjenja = godinaRodjenja;
    }

    public void setUsername(String username) {
        if(username.length() >= 5){
        this.username = username;
        }

    }

    public void setPassword(String password) {
        if(password.length() >= 5){
            this.password = password;
        }

    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean getAdmin() {
        return admin;
    }
    
         /*
        *metoda koja vrsi hesuje password zbog sigurnosti korisnika
        *@param
        */

    public String HashPassword(String password) throws NoSuchAlgorithmException{
        
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        
        byte[] b = md.digest();
        
        StringBuffer sb = new StringBuffer();
        
        for(byte b1 : b){
            sb.append(Integer.toHexString(b1 & 0xff).toString());
            
        }
                return sb.toString();
    }

    int proveriUserName(String username){

        User user = new User();
        try {
            CONNECTION = DriverManager.getConnection(URL, USERNAME, PASSWORD); 
            String query = "SELECT * FROM korisnici WHERE username = ?";
            PreparedStatement ps = CONNECTION.prepareStatement(query);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            rs.next();
            user.setId(rs.getInt("id"));
            ps.close();
            CONNECTION.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return user.getId();
    }

}