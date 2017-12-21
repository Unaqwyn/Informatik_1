import java.util.ArrayList;
import java.util.Random;
import java.lang.Math;


/**
 * Mathematik.
 * 
 * @author Martin Studer 
 * @version 27.11.2011
 */
public class Mathematik
{
    public Mathematik()
    {
    
    }

    public int maximum(ArrayList<Integer> zahlen)
    {
        int max=0;
        for(int i=0;i<zahlen.size();i++)
        {
            if(zahlen.get(i)>max)
            {
                max=zahlen.get(i);
            }
        }
        return max;
    }
    
    public double absoluteValue(double zahl)
    {
        if(zahl<0)
        {
            zahl=((-1)*zahl);
        }
        return zahl;
    }
    
    public ArrayList<Integer> factors(int zahl)
    {
        ArrayList<Integer> zahlen = new ArrayList<>();
        for(int i=2;i<zahl;i++)
        {
            if(zahl%i==0)
            {
                zahlen.add(i);
            }
        }
        return zahlen;
    }
    
    public ArrayList<Integer> primefactors(int zahl)
    {
        ArrayList<Integer> zahlen = new ArrayList<>();
        for(int i=2;i<=zahl;i++)
        {
            if(zahl%i==0)
            {
                zahlen.add(i);
                zahl=zahl/i;
                i--;
            }
        }
        return zahlen;
    }
    
    public double average(ArrayList<Double> zahlen)
    {
        double sum=0;
        for(int i=0;i<zahlen.size();i++)
        {
            sum+=zahlen.get(i);
        }
        return (sum/zahlen.size());
    }
    
    public double standardDeviation(ArrayList<Double> zahlen)
    {
        double average = average(zahlen);
        double sum=0;
        for(int i=0;i<zahlen.size();i++)
        {
            sum+=(zahlen.get(i)-average)*(zahlen.get(i)-average);
        }
        sum=sum/zahlen.size();
        sum=root(sum);
        return sum;
    }
    
    public double root(double zahl)
    {
        zahl=absoluteValue(zahl);
        double max=zahl;
        double min=0.0;
        double root=(min+max)/2;
        while(!(((root*root)>=(zahl*0.9999999999999))&&((root*root)<=(zahl*1.0000000000001))))
        {
            root=(min+max)/2;
            if(root*root>zahl)
            {
                max=root;
            }
            else if(root*root<zahl)
            {
                min=root;
            }
        }
        return root;
    }
    
        public double root(int n,double zahl)
    {
        if(zahl<0&&n%2==0)
        {
            System.out.println("Keine Lösung in R.");
            return 0;
        }
        double root=0;
        if(zahl>=0)
        {
            double max=zahl;
            double min=0.0;
            root=(min+max)/2;
            while(!(((power(root, n))>=(zahl*0.9999999999999))&&((power(root, n)<=(zahl*1.0000000000001)))))
            {
                root=(min+max)/2;
                if((power(root, n)>zahl))
                {
                    max=root;
                }
                else if((power(root, n)<zahl))
                {
                    min=root;
                }
            }   
        }
        else if(zahl<0)
        {
            double max=zahl;
            double min=0.0;
            root=(min+max)/2;
            while(!(((power(root, n))<=(zahl*0.9999999999999))&&((power(root, n)>=(zahl*1.0000000000001)))))
            {
                root=(min+max)/2;
                if((power(root, n)<zahl))
                {
                    max=root;
                }
                else if((power(root, n)>zahl))
                {
                    min=root;
                }
            } 
        }
        return root;
    }
    
    public double sin(double zahl)
    {
        if(zahl>0)
        {
            while(zahl>=2*Math.PI)
            {
                zahl-=2*Math.PI;
            }
        }
        else if(zahl<0)
        {
            while(zahl<=-(2*Math.PI))
            {
                zahl+=2*Math.PI;
            }
        }
        double sum=0;
        for(int i=1;i<10;i++)
        {
            int power=2*i-1;
            sum+=(power(-1,i+1)*(power(zahl,power)/factorial(power)));
        }
        return sum;
    }
    
    public double cos(double zahl)
    {
        return (sin((Math.PI/2)-zahl));
    }
    
    public double tan(double zahl)
    {
        return(sin(zahl)/cos(zahl));
    }
    
    public double power(double zahl, int power)
    {
        if(power<0)
        {
            return 0;
        }
        else if(power==0&&zahl!=0)
        {
            return 1;
        }
        else
        {
            double result=1.;
                for(int i=0;i<power;i++)
            {
                result*=zahl;
            }
            return result;
        }
    }
    
    public double factorial(int zahl)
    {
        double result=1.0;
        for(int i=zahl;i!=0;i--)
        {
            result*=i;
        }
        return result;
    }
}
