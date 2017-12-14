import java.util.ArrayList;
import java.util.Random;
/**
 * Write a description of class Queens here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Queens
{
    ArrayList<int[]> positions;
    int[] position1;
    int[] position2;
    int[] position3;
    int[] position4;
    int[] position5;
    int[] position6;
    int[] position7;
    int[] position8;
    boolean nextPosition;
    Random random;
    

    public Queens()
    {
        positions=new ArrayList<>();
        random=new Random();
        nextPosition=false;
        int[] position1={random.nextInt(7)+1,random.nextInt(7)+1};
        positions.add(position1);
        int[] position2=nextPosition();
        positions.add(position2);
        
    }

    private int[] nextPosition()
    {
        
        nextPosition=false;
        while(nextPosition==false)
        {
            int[] positionNew={random.nextInt(7),random.nextInt(7)};
            for(int i=0;i<positions.size();i++)
            {
            if(getInt(positionNew,0)!=getInt(positions.get(i),0))
               {
                    for(int j=0;j<positions.size();j++)
                    {    
                    if(getInt(positionNew,1)!=getInt(positions.get(j),1))
                       {
                           for(int k=0;k<positions.size();k++)
                           {    
                           double dx=(getInt(positionNew,0)-getInt(positions.get(k),0));
                           double dy=(getInt(positionNew,1)-getInt(positions.get(k),1));
                           double diagonal=dx/dy;    
                            if(diagonal*diagonal!=1)
                            {
                                return positionNew;
                            }
                           }   
                       }
                    }   
               }
            }
        }
        
        return null;
    }
}
