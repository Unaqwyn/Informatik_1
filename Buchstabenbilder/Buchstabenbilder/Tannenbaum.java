import java.util.Random;
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
        Random random = new Random();
        System.out.print('\u000C');
        int breite = 2*hoehe;
        for(int i=0;i<hoehe;i++)
        {
            for(int j=0;j<breite;j++)
            {
                if(j>=hoehe-i&&j<=hoehe+i)
                {
                    if(random.nextInt(10)==1&&i!=0)
                    {
                        System.out.print("O");
                    }
                    else if(random.nextInt(10)==2&&i!=0)
                    {
                        System.out.print("i");
                    }
                    else
                    {
                        System.out.print("*");
                    }
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
    
    public void tannenbaum(int hoehe, int stammHoehe, int stammBreite)
    {
        Random random = new Random();
        System.out.print('\u000C');
        int breite = 2*hoehe;
        for(int i=0;i<hoehe;i++)
        {
            for(int j=0;j<breite;j++)
            {
                if(j>=hoehe-i&&j<=hoehe+i)
                {
                    if(random.nextInt(10)==1&&i!=0)
                    {
                        System.out.print("O");
                    }
                    else if(random.nextInt(10)==2&&i!=0)
                    {
                        System.out.print("i");
                    }
                    else
                    {
                        System.out.print("*");
                    }
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
        for(int m=0;m<stammHoehe;m++)
        {
            for(int k=0;k<(hoehe-(stammBreite/2));k++)
            {
                System.out.print(" ");
            }
            for(int l=0;l<stammBreite;l++)
            {
                System.out.print("I");
            }
            System.out.println();
        }
    }
}
