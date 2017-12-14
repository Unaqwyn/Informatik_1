import java.util.ArrayList;
/**
 * Write a description of class Adresse here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Adresse
{
    // instance variables - replace the example below with your own

    ArrayList<String> adresse;
    
    /**
     * Constructor for objects of class Adresse
     */
    public Adresse(String vorname, String nachname, String postleitZahl, String wohnOrt)
    {
        adresse = new ArrayList<>();
        adresse.add(vorname);
        adresse.add(nachname);
        adresse.add(postleitZahl);
        adresse.add(wohnOrt);
        adresse.add("unbekannt");
        adresse.add("unbekannt");
    }
    
    public Adresse(String vorname, String nachname, String postleitZahl, String wohnOrt, String strasse, String strassenNummer)
    {
        adresse = new ArrayList<>();
        adresse.add(vorname);
        adresse.add(nachname);
        adresse.add(postleitZahl);
        adresse.add(wohnOrt);
        adresse.add(strasse);
        adresse.add(strassenNummer);
    }

    public String gibVorname()
    {
        return adresse.get(0);
    }
    
    public String gibNachname()
    {
        return adresse.get(1);
    }
    
    public String gibPostleitZahl()
    {
        return adresse.get(2);
    }
    
    public String gibWohnOrt()
    {
        return adresse.get(3);
    }
    
    public String gibStrasse()
    {
        return adresse.get(4);
    }
    
    public String gibStrassenNummer()
    {
        return adresse.get(5);
    }
}
