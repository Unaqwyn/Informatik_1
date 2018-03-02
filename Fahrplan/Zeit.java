
public class Zeit
{
    private Integer min;
    private Integer h;
    private String hString;
    private String minString;
    
    public Zeit(Integer h, Integer min)
    {
        this.min=min;
        this.h=h;
        
        
    }
    
    public int gibMin()
    {
        return min;
    }
    
    public int gibH()
    {
        return h;
    }
    
    public String toStringZeit()
    {
        if(h<10)
        {
            hString = "0"+h.toString();
        }
        else
        {
            hString = h.toString();
        }
        if(min<10)
        {
            minString = "0"+min.toString();
        }
        else
        {
           minString = min.toString();
          
        }
         return hString+": "+minString;
    }
}
