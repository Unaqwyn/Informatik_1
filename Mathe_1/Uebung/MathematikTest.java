 

import java.util.ArrayList;
/**
 * Teste die Klasse Mathematik.
 * 
 * @author Martin Studer
 * @version 27.11.2011
 */
public class MathematikTest
{
    private Mathematik mathematik;
    
    /**
     * Kreiere ein neues MathematikTest.
     */
    public MathematikTest() 
    {
        mathematik = new Mathematik();
    }
    
    /**
     * Teste Methode durchschnitt.
     */
    public void durchschnittMitArrayList()
    {
        ArrayList<Double> noten = new ArrayList<Double>();
        noten.add(5.0);
        noten.add(4.0);
        noten.add(4.5);
        noten.add(6.0);
        noten.add(3.0);
        noten.add(5.0);
        noten.add(4.0);
        
        // Hier einkommentieren zum Testen
//double durchschnitt = mathematik.average(noten);
 //System.out.println(durchschnitt);
    }

    /**
     * Teste Methode durchschnitt.
     */
    public void durchschnittMitArrays()
    {
        double[] noten = { 5, 4, 4.5, 6, 3.0, 5, 4 };
        
        // Hier einkommentieren zum Testen        
//         double durchschnitt = mathematik.durchschnitt(noten);
//         System.out.println(durchschnitt);
    }
    
    /**
     * Teste Methode standardabweichung.
     */
    public void standardabweichungMitArrayList()
    {
        ArrayList<Double> noten = new ArrayList<Double>();
        noten.add(5.0);
        noten.add(4.0);
        noten.add(4.5);
        noten.add(6.0);
        noten.add(3.0);
        noten.add(5.0);
        noten.add(4.0);

        // Hier einkommentieren zum Testen
//double standardabweichung = mathematik.standardDeviation(noten);
 //System.out.println(standardabweichung);
    }

    
    /**
     * Teste Methode standardabweichung.
     */
    public void standardabweichungMitArrays()
    {
        double[] noten = { 5, 4, 4.5, 6, 3.0, 5, 4 };
        
        // Hier einkommentieren zum Testen        
//         double standardabweichung = mathematik.standardabweichung(noten);
//         System.out.println(standardabweichung);
    }
    
}
