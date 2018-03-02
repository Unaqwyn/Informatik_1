import java.util.ArrayList;


public class Fahrplan
{
    private Zeit zeit;
    private Zug zug;
    ArrayList<Zug> plan;
    
    public Fahrplan()
    {
        System.out.print('\u000C');
        plan=new ArrayList<>();
    }
    
    public void drucke()
    {
        System.out.println(zeit.toStringZeit()+"   "+ zug.toStringOrt()+" Gleis: "+ zug.gibGleis());
    }
    
    public void addZug(Zug zug)
    {
        plan.add(zug);
    }
    
    public ArrayList<Zug> zugNach(String ort)
    {
        ArrayList<Zug> moeglich=new ArrayList<>();
        for(int i=0;i<plan.size();i++)
        {
            if(plan.get(i).getOrte().contains(ort))
            {
                moeglich.add(plan.get(i));
            }
        }
        return moeglich;
    }
    
    public Zug naechsterZugNach(String ort, Zeit jetzt)
    {
        ArrayList<Zug> possible=zugNach(ort);
        int h=jetzt.gibMin();
        int min=jetzt.gibH();
        Zeit latest=new Zeit(23,59);
        for(int i=0;i<possible.size();i++)
        {
            if(possible.get(i).gibH()>=h&&possible.get(i).gibH()<latest.gibH())
            {
                Zug zug=possible.get(i);
                latest=possible.get(i).getZeit();
            }
            else if(possible.get(i).gibH()>=h&&possible.get(i).gibH()<=latest.gibH())
            {
                if(possible.get(i).gibMin()>=min&&possible.get(i).gibMin()<=latest.gibMin())
                {
                    Zug zug=possible.get(i);
                    latest=possible.get(i).getZeit();
                }
            }
        }
        return zug;
    }
}
