import java.lang.Math;

public class Force
{
    // instance variables - replace the example below with your own
    private double fX;
    private double fY;
    private double alpha;
    private double f;
    private double m;

    /**
     * Constructor for objects of class Force
     */
    public Force(double a, double f, double r)
    {
       alpha=a*Math.PI;
       this.f=f;
       fX=f*Math.cos(alpha);
       fY=f*Math.sin(alpha);
       m=r*f;
    }
    
    public double getFX()
    {
        return fX;
    }

    public double getFY()
    {
        return fY;
    }
    
    public double getF()
    {
        return f;
    }
    
    public double getAlpha()
    {
        return alpha;
    }
    
    public double getM()
    {
        return m;
    }
}
