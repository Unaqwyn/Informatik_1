
/**
 * Write a description of class Buchstabenbilder here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Buchstabenbilder
{
    // instance variables - replace the example below with your own
    

    /**
     * Constructor for objects of class Buchstabenbilder
     */
    public Buchstabenbilder()
    {
        System.out.print('\u000C');
    }

    public void horizontaleLinie(int laenge)
    {
        System.out.print('\u000C');
        for(int i=0;i<laenge;i++)
        {
            System.out.print("X");
        }
    }
    
    public void vertikaleLinie(int laenge)
    {
        System.out.print('\u000C');
        for(int i=0;i<laenge;i++)
        {
            System.out.println("X");
        }
    }
    
    public void quadrat(int seite)
    {
        System.out.print('\u000C');
        for(int i=0;i<seite;i++)
        {
            
            for(int j=0;j<seite;j++)
            {
                System.out.print("X");
            }
            System.out.println();
        }
    }
    
    public void rechtEck(int hoehe, int breite)
    {
        System.out.print('\u000C');
        for(int i=0;i<hoehe;i++)
        {
            
            for(int j=0;j<breite;j++)
            {
                System.out.print("X");
            }
            System.out.println();
        }
    }
    
    public void L(int hoehe, int breite)
    {
        System.out.print('\u000C');
        for(int i=0;i<hoehe;i++)
        {
            if(i==(hoehe-1))
            {
                for(int j=0;j<breite;j++)
                {
                    System.out.print("X");
                }
            }
            else
            {
                System.out.print("X");
            }
            System.out.println();
        }
    }
    
    public void E(int hoehe, int breite)
    {
        if(hoehe<5)
        {
            System.out.println("mindestens Höhe 5");
        }
        else
        {
            System.out.print('\u000C');
            int mitte=(hoehe/2);
            for(int i=0;i<hoehe;i++)
            {
                if((i==0)||(i==mitte-1)||(i==hoehe-1))
                {
                    for(int j=0;j<breite;j++)
                    {
                        System.out.print("X");
                    }
                    System.out.println();
                }
                else
                {
                    System.out.println("X");
                }
            }
        }
    }
    
    public void U(int hoehe, int breite)
    {
        System.out.print('\u000C');
        for(int i=0;i<hoehe;i++)
        {
            if(i==(hoehe-1))
            {
                for(int j=0;j<breite;j++)
                {
                    System.out.print("X");
                }
                System.out.println();
            }
            else
            {
                for(int j=0;j<breite;j++)
                {
                    if((j==0)||(j==(breite-1)))
                    {
                        System.out.print("X");
                    }
                    else
                    {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
            
        }
    }
    
    public void Z(int hoehe)
    {
        System.out.print('\u000C');
        for(int i=0;i<hoehe;i++)
        {
            if(i==0||i==hoehe-1)
            {
                for(int k=0;k<hoehe;k++)
                {
                    System.out.print("X");
                }
                System.out.println();
            }
            else
            {
                for(int j=(hoehe-i-1);j>0;j--)
                {
                    System.out.print(" ");
                }
                System.out.print("X");
                System.out.println();
            }
        }   
    }
}
