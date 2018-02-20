import java.lang.Math;
import java.util.ArrayList;

public class Balance
{
    private ArrayList<Force> forces;
    
    /**
     * Constructor for objects of class Balance
     */
    public Balance()
    {
        System.out.print('\u000C');
        forces=new ArrayList<>();
    }

    public void addForce(double a, double f)
    {
        Force force=new Force(a,f);
        forces.add(force);
    }
    
    public void getFr()
    {
        double fX=0;
        for(int i=0;i<forces.size();i++)
        {
            fX+=forces.get(i).getFX();
        }
        double fY=0;
        for(int i=0;i<forces.size();i++)
        {
            fY+=forces.get(i).getFY();
        }
        double f=Math.sqrt(fX*fX+fY*fY);
        double alpha=Math.atan(fY/fX);
        System.out.println("f= "+ f);
        System.out.println("alpha= "+ alpha);
    }
}
