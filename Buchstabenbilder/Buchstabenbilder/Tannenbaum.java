
/**
 * Write a description of class Tannenbaum here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tannenbaum
{
    // instance variables - replace the example below with your own


    /**
     * Constructor for objects of class Tannenbaum
     */
    public Tannenbaum()
    {
        System.out.print('\u000C');
    }

    public void tannenbaum(int hoehe)
    {
        System.out.print('\u000C');
        int breite = 2*hoehe;
        for(int i=0;i<hoehe;i++)
        {
            for(int j=0;j<breite;j++)
            {
                if(j>=hoehe-i&&j<=hoehe+i)
                {
                    System.out.print("*");
                }
                else if(j==breite-1)
                {
                    System.out.println();
                }
                else
                {
                    System.out.print(" ");
                }
            }
        }
        System.out.println();
        for(int k=0;k<hoehe;k++)
        {
            System.out.print(" ");
        }
        System.out.print("I");
        System.out.println();
    }
}
