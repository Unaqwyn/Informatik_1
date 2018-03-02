import java.util.ArrayList;

public class Zug
{
    private Zeit zeit;
    private int gleis;
    private ArrayList<String> ort;
    
    public Zug(Zeit zeit,int gleis,ArrayList<String> ort)
    {
        this.zeit=zeit;
        this.gleis=gleis;
        this.ort=ort;
    }
    
    public Zug(Zeit zeit,int gleis,String ort)
    {

    }
    
    public void drucke()
    {
        System.out.println(zeit.toStringZeit()+"   "+ toStringOrt() +" Gleis: "+gleis);
    }
    
    public ArrayList<String> getOrte()
    {
        return ort;
    }
    
    public String toStringOrt()
    {
        String ortliste="";
        for(int i=0;i<ort.size();i++)
        {
            ortliste=ortliste+ort.get(i);
            ortliste+=", ";
        }
        return ortliste;
    }
    
    public Zeit getZeit()
    {
        return zeit;
    }
    
    public int gibMin()
    {
        int min=zeit.gibMin();
        return min;
    }
    
    public int gibH()
    {
        int h=zeit.gibMin();
        return h;
    }
    
    public int gibGleis()
    {
        return gleis;
    }
}
