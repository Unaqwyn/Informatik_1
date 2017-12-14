 

/**
 * Die Klasse Modell modelliert den Kern eines einfachen Fahrkartenautomaten.
 * Dieser beschränkt sich auf eine einzige Fahrkarte. 
 * Die Klasse implementiert die wesentliche Logik eines Fahrkartenautomaten. Dazu
 * müssen einerseits passende Datenfelder vorgesehen werden, in denen der Zustand, 
 * beispielsweise 
 * das aktuelle Guthaben, abgelegt werden kann. Andererseits sind Methoden nötig, die u.a. 
 * auch
 * notwendige Prüfungen vornehmen. Beispielsweise kann eine Fahrkarte nur gekauft werden, 
 * wenn das Guthaben ausreichend ist.
 *
 * @author NTB, René Pawlitzek
 * @version 8.10.2014
 */
public class Modell
{
    private int preis;
    private String strecke;
    private int guthaben;
    
    /**
     * Erzeuge ein Modell
     * @fahrkartenPreis Der Preis der Fahrkarte
     * @bezeichnung Die Bezeichnung der Fahrkarte, z.B. Balzers-Buchs
     */
    public Modell(int fahrkartenPreis, String bezeichnung)
    {
        if(fahrkartenPreis > 0)
        {
            preis = fahrkartenPreis;
            strecke = bezeichnung;
            guthaben = 0;
        }
        else
        {
            System.out.println("Bitte einen positiven Wert f�r den Preis eingeben.");
        }
        // GUI erzeugen und dieses Modell-Objekt dem GUI übergeben
        new GUI (this);
    
    }

    public Modell()
    {
        preis = 220;
        strecke = "Chur-Buchs";
        guthaben = 0;
        // GUI erzeugen und dieses Modell-Objekt dem GUI übergeben        
        new GUI (this);
    }    

    /**
     * Liefere den Preis einer Fahrkarte in Rappen.
     */
    public int gibPreis()
    {
        return preis;
    }

    /**
     * Liefere das aktuelle Guthaben in Rappen.
     */
    public int gibGuthaben()
    {
        return guthaben;
    }

    /**
     * Schreibe den eingeworfenen Betrag dem Guthaben zu.
     * @betrag  Eingeworfener Betrag
     */
    public void geldEinwerfen(int betrag)
    {
        if(betrag > 0)
        {
            guthaben += betrag;
        }
        else
        {
            System.out.println("Bitte werfen Sie einen positiven Betrag ein");
        }
    }

    /**
     * Kaufe eine Fahrkarte, sofern das Guthaben ausreicht. Passe das Guthaben an.
     */
    public boolean fahrkarteKaufen()
    {
        if (guthaben >= preis)
        {
            guthaben -= preis;
            return true;
        }
        else
        {
            System.out.println("Bitte werfen Sie noch " + (preis - guthaben) + " Rappen ein.");
            return false;
        }
    }

    /**
     * Gib das aktuelle Guthaben zurück und setzt es danach auf Null.
     */
    public int guthabenAuszahlen()
    {
        int  restguthaben = guthaben;
        guthaben = 0;
        return restguthaben;
    }

    /**
     * Gib die Bezeichnung der Fahrkarte zurück.
     */
    public String gibBezeichnung()
    {
        return strecke;
    }
}
