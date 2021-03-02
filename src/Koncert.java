
public class Koncert {

    /*
     *klasa koja sluzi da admin moze da unese koncert u bazu 
     *@param
     */

    private int id;
    private String imeBenda;
    private String datum;
    private int pocetak;
    private int cena;

    public Koncert() {
    }

    public Koncert(int id, String imeBenda, String datum, int pocetak, int cena) {
        this.id = id;
        this.imeBenda = imeBenda;
        this.datum = datum;
        this.pocetak = pocetak;
        this.cena = cena;
    }

    public int getId() {
        return id;
    }

    public String getImeBenda() {
        return imeBenda;
    }

    public String getDatum() {
        return datum;
    }

    public int getPocetak() {
        return pocetak;
    }

    public int getCena() {
        return cena;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImeBenda(String imeBenda) {
        this.imeBenda = imeBenda;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public void setPocetak(int pocetak) {
        this.pocetak = pocetak;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

}
