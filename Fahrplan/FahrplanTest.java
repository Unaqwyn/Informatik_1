import java.util.ArrayList;

/**
 * Teste die Klasse Fahrplan.
 * 
 * @author Martin Studer
 * @version 30.11.2011
 */
public class FahrplanTest
{
    private Fahrplan fahrplan;

    /**
     * Konstruktor für Objekte der Klasse FahrplanTest
     */
    
    public FahrplanTest()
    {
        fahrplan = new Fahrplan();

        // 5:12, Gleis 4, Sargans,Zuerich HB
        ArrayList<String> orte1 = new ArrayList<String>();
        orte1.add("Sargans");
        orte1.add("Zuerich HB");
        Zug zug1 = new Zug(new Zeit(5,12), 4, orte1);
        fahrplan.addZug(zug1);
        
        // 5:32, Gleis 4, Oberriet SG, Rorschach
        ArrayList<String> orte2 = new ArrayList<String>();
        orte2.add("Oberriet SG");
        orte2.add("Rorschach");
        Zug zug2 = new Zug(new Zeit(5,32), 4, orte2);
        fahrplan.addZug(zug2);

        // 6:00, Gleis 1, Altstätten SG, Heerbrugg, St.Margrethen, Rheineck, Rorschach, St.Gallen
        ArrayList<String> orte3 = new ArrayList<String>();
        orte3.add("Altstätten SG");
        orte3.add("Heerbrugg");
        orte3.add("St.Margrethen");
        orte3.add("Rheineck");
        orte3.add("Rorschach");
        orte3.add("St.Gallen");
        Zug zug3 = new Zug(new Zeit(6,0), 1, orte3);
        fahrplan.addZug(zug3);
        
        // 6:02, Gleis 4, Sargans, Walenstadt
        ArrayList<String> orte4 = new ArrayList<String>();
        orte4.add("Sargans");
        orte4.add("Walenstadt");
        Zug zug4 = new Zug(new Zeit(6,2), 4, orte4);
        fahrplan.addZug(zug4);
        
        // 6:03, Gleis 5, Feldkirch
        ArrayList<String> orte5 = new ArrayList<String>();
        orte5.add("Feldkirch");
        Zug zug5 = new Zug(new Zeit(6,3), 5, orte5);
        fahrplan.addZug(zug5);
    }
    

    /**
     * 
     */
    
    public void zugNach(String ort, int stunde, int minute) {
        Zug zug = fahrplan.naechsterZugNach(ort, new Zeit(stunde,minute));
        if (zug == null) {
            System.out.println("Heute kein Zug mehr nach " + ort + ".");
        } else {
            zug.drucke();
        }
    }
    
    
}
