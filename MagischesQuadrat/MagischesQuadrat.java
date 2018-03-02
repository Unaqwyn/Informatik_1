import java.util.Random;

/**
 * Die Klasse stellt ein magisches Quadrat dar.
 * 
 * @author tbd.
 * @version tbd.
 */
public class MagischesQuadrat
{
    private int[][] quadrat;

    /**
     * Konstruktor für folgendes magische Quadrat mit Seitenlänge 3:
     *  2 9 4
     *  7 5 3
     *  6 1 8
     */
    public MagischesQuadrat()
    {
        System.out.print('\u000C');
        quadrat = new int[][] { {2, 9 , 4}, { 7, 5, 3}, {6, 1, 8}};
        ausgabe(quadrat);
    }

    /**
     * Konstruktor für ein Quadrat der gegebenen Seitenlänge gefüllt mit Zufallszahlen.
     */
    public MagischesQuadrat(int seitenlaenge) {
        System.out.print('\u000C');
        quadrat = new int[seitenlaenge][seitenlaenge];
        Random random = new Random();
        for (int zeile = 0; zeile < seitenlaenge; zeile++) {
            for (int spalte = 0; spalte < seitenlaenge; spalte++) {
                // eine Zufallszahl im Bereich 1 bis seitelaenge^2
                int zahl = random.nextInt(seitenlaenge*seitenlaenge)+1;    
                quadrat[zeile][spalte] = zahl;
            }
        }
        ausgabe(quadrat);
    }

    /**
     * Magisches Quadrat ausgeben.
     */
    public void ausgabe(int[][] quadrat) {
        for(int i=0; i<quadrat.length; i++)
        {
            for(int j=0;j<quadrat[0].length;j++)
            {
                System.out.print(""+quadrat[i][j]+ " ");
            }
            System.out.println();
        }
    }

    /**
     * Summe der Zeile mit gegebenem Zeilenindex.
     * 
     * @zeile der Zeilenindex, erste Zeile hat Index 0
     * @return die Zeilensumme
     */
    public int zeilensumme(int zeile) {
        int sum=0;
        for(int i=0;i<quadrat.length;i++)
        {
            sum+=quadrat[zeile][i];
        }
        return sum;
    }

    /**
     * Summe der Spalte mit gegebenem Spaltenindex.
     * 
     * @param spalte der Spaltenindex, erste Spalte hat Index 0
     * @return die Spaltensumme
     */
    public int spaltensumme(int spalte) {
        int sum=0;
        for(int i=0;i<quadrat[0].length;i++)
        {
            sum+=quadrat[i][spalte];
        }
        return sum;
    }

    /**
     * Summe der Diagonale von links oben nach rechts unten.
     * 
     * @return die Diagonalensumme von links oben nach rechts unten
     */
    public int diagonalensumme1()
    {
        int sum=0;
        for(int i=0;i<quadrat.length;i++)
        {
            sum+=quadrat[i][i];
        }
        return sum;
    }

    /**
     * Summe der Diagonale von rechts oben nach links unten.
     * 
     * @return die Diagonalensumme von rechts oben nach links unten
     */
    public int diagonalensumme2()
    {
        int sum=0;
        for(int i=0;i<quadrat.length;i++)
        {
            sum+=quadrat[i][quadrat.length-i-1];
        }
        return sum;
    }

    /**
     * Ist das Quadrat magisch?
     * 
     * @return true, falls es sich um ein magisches Quadrat handelt, false sonst
     */
    public boolean istMagisch() {
        int target=diagonalensumme1();
        if(diagonalensumme2()!=target) return false;
        for(int i=0;i<quadrat.length;i++)
        {
            if(spaltensumme(i)!=target) return false;
            if(zeilensumme(i)!=target) return false;
        }
        return true;
    }
    
    public int[][] matMult(int[][] a, int[][] b)
    {
        int[][] c= new int[a.length][b[0].length];
        
        for(int i=0;i<a.length;i++)
        {
            for(int j=0;j<b[0].length;j++)
            {
                for(int k=0;k<a.length;k++)
                {
                    c[i][j]+=(a[i][k]*b[k][j]);
                }
            }
        }
        return c;
    }
    
    public void matQuad()
    {
        ausgabe(matMult(quadrat,quadrat));
    }
}
