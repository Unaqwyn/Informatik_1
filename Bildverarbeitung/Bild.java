import java.util.*;

/**
 * Klasse zur Verarbeitung von Bildern.
 * 
 * @author Carlo Bach
 * @version 16.2.2016
 */
public class Bild {
    
    private String titel;
    private int[][] bild;
    private int[] histogramm;
    private int[][] bildPhantom;
       
    /**
     * Erzeuge ein neues leeres Bild mit dem Titel "Kein Bild".
     */
    public Bild() {
        this("Kein Bild", null);
    }
    
    /**
     * Erzeuge ein neues Bild mit dem gegebenen Titel und den Bilddaten.
     * 
     * @param titel die Titel des Bildes
     * @param bild die Bilddaten
     */
    public Bild(String titel, int[][] bild) {
        this.titel = titel;
        this.bild = bild;
        bildPhantom=bild;
        histogramm=new int[256];
    }

    /**
     * Der Titel des Bildes.
     * 
     * @return der Titel des Bildes
     */
    public String gibTitel() {
        return titel + " (" + gibBreite() + " x " + gibHoehe() + ")";
    }
    
    /**
     * Die Breite des Bildes. Falls kein Bild gesetzt worden ist, gibt die Methode 0 zurück.
     * 
     * @return die Bildbreite, oder 0, falls kein Bild gesetzt worden ist.
     */
    public int gibBreite() {
        if (bild != null){
            return bild.length;
        } else {
            return 0;
        }
    }
    
    /**
     * Die Höhe des Bildes. Falls kein Bild gesetzt worden ist, gibt die Methode 0 zurück.
     * 
     * @return die Bildhöhe, oder 0, falls kein Bild gesetzt worden ist.
     */
    public int gibHoehe() {
        if (bild != null && bild[0] != null){
            return bild[0].length;
        } else {
            return 0;
        }
    }

    /**
     * Die Intensität an der gegebenen Spalte und Zeile. Falls die Angaben bezüglich Zeile oder Spalte ungültig sind, wird 0 zurückgegeben. 
     * 
     * @param spalte die Spalte
     * @param zeile die Zeile
     * @return der Intensitätswert zwischen 0 (schwarz) und 255 (weiss), oder 0 bei ungültigen Zeilen-/Spaltenwerten 
     */
    public int gibIntensitaetswert(int spalte, int zeile) {
        if (0 <= spalte && spalte < gibBreite() && 0 <= zeile && zeile < gibHoehe()) {
            return bild[spalte][zeile];
        } else {
            //Der Rueckgabewert 0 ermoeglicht eine einfache Randbehandlung bei linearen Filtern.
            return 0;
        }
    }
    
    /**
     * Die Bilddaten des Bildes.
     * 
     * @return die Bilddaten oder null, falls kein Bild gesetzt wurde.
     */
    public int[][] gibBilddaten() {
        return bild;
    }
    
    /**
     * Bild kopieren
     *
     * @return eine Kopie des Bildes. Als Titel wird an den Originalnamen die Endung " - Kopie" angehängt
     */
    public Bild erstelleKopie() {
        int[][] b = new int[gibBreite()][gibHoehe()];
        for (int spalte = 0; spalte < gibBreite(); spalte++) {
            for (int zeile = 0; zeile < gibHoehe(); zeile++) {
                b[spalte][zeile] = bild[spalte][zeile];
            }
        }
        return new Bild(gibTitel() + " - Kopie", b);
    }
    
    /**
     * Aufgabe: Histogramm berechnen
     * 
     * @return das Histogramm 
     */
    public int[] gibHistogramm() {
        for(int i=0;i<bild.length;i++)
        {
            for(int j=0;j<bild[0].length;j++)
            {
                histogramm[gibIntensitaetswert(i,j)]++;
            }
        }
        return histogramm;
    }
    
    public int getDarkest()
    {
        for(int i=0;i<256;i++)
        {
            if(histogramm[i]!=0) 
            {
                return (i);
            }
        }
        return 0;
    }
    
    public int getBrightest()
    {
        for(int i=255;i>0;i--)
        {
            if(histogramm[i]!=0) 
            {
                return (i);
            }
        }
        return 255;
    }
    
    public void printHistogramm()
    {
        for(int i=0;i<256;i++)
        {
            System.out.print(""+ histogramm[i]+" ");
        }
    }

    /**
     * Aufgabe: Invertieren 
     */
    public void bild_invertieren() {
        for(int i=0;i<bild.length;i++)
        {
            for(int j=0;j<bild[0].length;j++)
            {
                bild[i][j]=(255-bild[i][j]);
            }
        }
    }
    

    /**
     * Aufgabe: Aufhellen um einen Offset anheben
     * 
     * @param offset der Offset, um den die Intensitaetswerte angehoben werden
     */
    public void bild_aufhellen(int offset) {
         for(int i=0;i<bild.length;i++)
        {
            for(int j=0;j<bild[0].length;j++)
            {
                bild[i][j]+=offset;
                if(bild[i][j]>255)
                {
                    bild[i][j]=255;
                }
                else if(bild[i][j]<0)
                {
                    bild[i][j]=0;
                }
            }
        }
    }

    /**
     * Aufgabe: Kontrast um einen Faktor erhöhen 
     * 
     * @param faktor der Faktor, um den die Intensitaetswerte angehoben werden
     */
    public void bild_kontrastErhoehen(double faktor) {
         for(int i=0;i<bild.length;i++)
        {
            for(int j=0;j<bild[0].length;j++)
            {
                bild[i][j]=(int) (faktor*bild[i][j]);
                if(bild[i][j]>255)
                {
                    bild[i][j]=255;
                }
                else if(bild[i][j]<0)
                {
                    bild[i][j]=0;
                }
            }
        }
    }

    /**
     * Aufgabe: Kontrast optimieren 
     */
    public void bild_kontrastOptimieren() {
        int offset=-1*getDarkest();
        bild_aufhellen(offset);
        double f=(double) (255./getBrightest());
        bild_kontrastErhoehen(f);
        
    }

    /**
     * Aufgabe: Schwellwertverfahren 
     * 
     * @param schwellwert der Schwellwert, der als Grenze genommen wird
     */
    public void bild_schwellwertAnwenden(int schwellwert) {
         for(int i=0;i<bild.length;i++)
        {
            for(int j=0;j<bild[0].length;j++)
            {
                if(bild[i][j]>schwellwert)
                {
                    bild[i][j]=255;
                }
                else if(bild[i][j]<schwellwert)
                {
                    bild[i][j]=0;
                }
            }
        }
    }

    /**
     * Aufgabe: Mittelwertfilter 3x3
     * 
     * @param eingangsbild das Bild, das gefiltert wird
     */
    public void bild_mittelwertfilter(Bild eingangsbild) {
        for(int i=0;i<bild.length;i++)
        {
            for(int j=0;j<bild[0].length;j++)
            {
                bild[i][j]=mittelwert(i,j);
            }
        }
    }
    
    public int mittelwert(int posI,int posK)
    {
        int sum=0;
        for(int i=posI-1;i<=posI+1;i++)
        {
            for(int k=posK-1;k<=posK+1;k++)
            {
                sum+=gibIntensitaetswert(i, k);
            }
        }
        sum/=9;
        return sum;
    }

    /**
     * Aufgabe: Genereller Linearer Filter mit einem Filterkern
     * 
     * @param eingangsbild das Bild, das gefiltert wird
     * @param filter der Filterkern
     */
    public void bild_linearerfilter(Bild eingangsbild, double[][] filter) {
         for(int i=0;i<bild.length;i++)
        {
            for(int j=0;j<bild[0].length;j++)
            {
                bild[i][j]=filtered(i,j, filter);
            }
        }
    }
    
    public int filtered(int posI, int posJ, double[][] filter)
    {
        double sum=0.;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                sum+=(gibIntensitaetswert(posI-1+i, posJ-1+j)*filter[i][j]);
            }
        }
        if(sum>255) sum=255;
        if(sum<0) sum=0;
        return (int)sum;
    }
    
    //bild[posI-1+i][posJ-1+j]
    /**
     * Aufgabe: Medianfilter 3x3
     * 
     * @param eingangsbild das Bild, das gefiltert wird
     */
    public void bild_medianfilter(Bild eingangsbild) {
        for(int i=0;i<bild.length;i++)
        {
            for(int j=0;j<bild[0].length;j++)
            {
                bild[i][j]=median(i,j);
            }
        }
    }
    
    public int median(int posI,int posK)
    {
        int[] intensities=new int[9];
        int j=0;
        for(int i=posI-1;i<=posI+1;i++)
        {
            for(int k=posK-1;k<=posK+1;k++)
            {
                    intensities[j]=gibIntensitaetswert(i, k);
                    j++;
            }
        }
        Arrays.sort(intensities);
        return intensities[4];
    }

    /**
     * Aufgabe: Template Matching
     * 
     * @param suchbild das Bild, das durchsucht wird
     * @param template das Bild, das gesucht wird
     */
    public void bild_templatematching(Bild suchbild, Bild template) {
    }
        
    
    /**
     * Aufgabe: Geometrische Transformation: Rotation. Beachten Sie, dass das Rotationszentrum zuerst in den Ursprung geschoben, dann rotiert und wieder zurueckgeschoben werden muss.
     * 
     * @param eingangsbild das Bild, das veraendert wird
     * @param rotationszentrumSpalte die u-Position des Rotationszentrums
     * @param rotationszentrumZeile die v-Position des Rotationszentrums
     * @param winkel der Rotationswinkel (Achtung in Radian)
     */
    public void bild_rotation(Bild eingangsbild, int rotationszentrumSpalte, int rotationszentrumZeile, double winkel) {
    }

    /**
     * Aufgabe: Verzerren. Twirl-Transformation: Rotation um alpha, die mit dem Abstand vom Zentrum abnimmt 
     * 
     * @param eingangsbild das Bild, das veraendert wird
     * @param rmax der maximale Radius, bis wohin gedreht wird
     * @param alpha der Rotationswinkel (Achtung in Radian)
     */
    public void bild_twirl(Bild eingangsbild, int rmax, double alpha) {
    }

}