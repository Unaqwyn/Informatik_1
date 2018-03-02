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

    //@param a is angle divided by PI
    //@param f is force
    //@param b is angle divided by PI
    //@param r is distance
    public void addForce(double a, double f, double b, double r)
    {
        double radius=(r*Math.cos(b*Math.PI));
        Force force=new Force(a,f,r);
        forces.add(force);
    }
    
    //@param a is angle divided by PI
    //@param f is force
    //@param r is direct distance ortaconal to direction of force
    public void addForce(double a, double f, double r)
    {
        Force force=new Force(a,f,r);
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
        double m = 0;
        for(int i=0;i<forces.size();i++)
        {
            m+=forces.get(i).getM();
        }
        System.out.println("f= "+ f);
        System.out.println("alpha= "+ alpha);
        System.out.println("m= "+ m);
    }
}
