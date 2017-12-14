import java.util.ArrayList;
/**
 * Write a description of class Adressverwaltung here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Adressverwaltung
{
    ArrayList<Adresse> adressen;
    
    /**
     * Constructor for objects of class Adressverwaltung
     */
    public Adressverwaltung()
    {
        System.out.print('\u000C');
        adressen=new ArrayList<>();
    }

    public void erfasse(String vorname, String nachname, String postleitZahl, String wohnOrt)
    {
        Adresse adresse=new Adresse(vorname, nachname, postleitZahl,wohnOrt);
        adressen.add(adresse);
    }
    
    public void erfasse(String vorname, String nachname, String postleitZahl, String wohnOrt, String strasse, String strassenNummer)
    {
        Adresse adresse=new Adresse(vorname, nachname, postleitZahl,wohnOrt, strasse,strassenNummer);
        adressen.add(adresse);
    }
    
    public void drucken(int index)
    {
        System.out.println("Vorname: " + adressen.get(index).gibVorname());
        System.out.println("Nachname: " + adressen.get(index).gibNachname());
        System.out.println("Postleitzahl: " + adressen.get(index).gibPostleitZahl());
        System.out.println("Wohnort: " + adressen.get(index).gibWohnOrt());
        System.out.println("Strasse: " + adressen.get(index).gibStrasse()+ " " +adressen.get(index).gibStrassenNummer());
    }
    
    public void druckenKompakt(int index)
    {
        System.out.println(adressen.get(index).gibVorname()+ ", "+adressen.get(index).gibNachname()+", "+adressen.get(index).gibPostleitZahl()+", "+adressen.get(index).gibWohnOrt()+ ", "+adressen.get(index).gibStrasse()+ " "+adressen.get(index).gibStrassenNummer());
    }
    
    public void drucken()
    {
        for(int i=0;i<adressen.size();i++)
        {
            druckenKompakt(i);
        }
        System.out.println("Anzahl Adressen: "+adressen.size());
    }
    
    public int gibAnzahl()
    {
        return adressen.size();
    }
    
    public int suchen(String nachname)
    {
        for(int i=0;i<adressen.size();i++)
        {
            if(adressen.get(i).gibNachname().equals(nachname))
            {
                return i;
            }
        }
        return 0;
    }
    
    public void sucheNachname(String nachname)
    {
        drucken(suchen(nachname));
    }
    
    public void test()
    {
        erfasse("Romario","Jäger","7000","Chur","Dreibündenstr.","76");
        erfasse("Jeannot","Zwick","7001","Chur", "Kupfergasse","14");
        
    }
}
