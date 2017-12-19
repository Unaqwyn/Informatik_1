import java.util.ArrayList;
import java.util.Random;

public class Queens
{
    ArrayList<int[]> positions;
    int[] positionNew;
    int[] position1;
    int[] lastRemoved;
    boolean nextPosition;
    Random random;
    int cnt;
    ArrayList<Integer> yProbiert;
    
    public Queens()
    {
        System.out.print('\u000C');
        positions=new ArrayList<>();
        random=new Random();
        nextPosition=false;
        lastRemoved=newPosition();
        cnt=0;
        while(positions.size()<8)
        {
            position1=newPosition();
            if(position1!=null)
            {
                positions.add(position1);
                System.out.println(position1[0]+", "+position1[1]);
            }
            else if(position1==null&&positions.get(positions.size()-1)[1]!=lastRemoved[1])
            {
                System.out.println("Removed: "+ positions.get(positions.size()-1)[0]+", "+positions.get(positions.size()-1)[1]);
                lastRemoved=positions.get(positions.size()-1);
                positions.remove(positions.size()-1);
                System.out.println(lastRemoved[0]+ " " +lastRemoved[1]);
            }
            else if(position1==null&&cnt<=5)
            {
                System.out.println("Removed ..: "+ positions.get(positions.size()-1)[0]+", "+positions.get(positions.size()-1)[1]);
                positions.remove(positions.size()-1);
                System.out.println("Removed ..: "+ positions.get(positions.size()-1)[0]+", "+positions.get(positions.size()-1)[1]);
                lastRemoved=positions.get(positions.size()-1);
                positions.remove(positions.size()-1);
                cnt++;
            }
            
            else if(position1==null)
            {
                cnt=0;
                System.out.println("reset");
                positions=new ArrayList<>();
            }
        }
    }
    
    public void print()
    {
        System.out.print('\u000C');
        for(int i=0;i<8;i++)
        {
            System.out.println(positions.get(i)[0]+", "+positions.get(i)[1]);
        }
    }

    private int[] newPosition()
    {
        boolean position=true;
        yProbiert=new ArrayList<>();
        while(yProbiert.size()<8)
        {
            position=true;
            int x=positions.size()+1;
            int index=0;
            int y=random.nextInt(8)+1;
            int yTested=1;
            if(!yProbiert.contains(y))yProbiert.add(y);
            while(index<positions.size())
            {
                if(gleichesY(y,positions.get(index)))
                {
                    y=random.nextInt(8)+1;
                    yTested++;
                    if(!yProbiert.contains(y))yProbiert.add(y);
                    index=0;
                }
                else
                {
                    index++;
                }
            }
            int[] positionNew={x,y};
            for(int i=0;i<positions.size();i++)
            {
                if(gleicheDiagonale(positionNew, positions.get(i)))
                {
                    position=false;
                }
                else if(i==positions.size()-1&&position==true)
                {
                    return positionNew;
                }
            }
            if(positions.size()==0)
            {
                return positionNew;
            }
        }
        
        return null;
    }
    
    public ArrayList<int[]> gibPosition()
    {
        return positions;
    }
    
    private boolean gleichesX(int[] p1,int[] p2)
    {
        if(p1[0]==p2[0])
        {
            return true;
        }
        return false;
    }
    
    private boolean gleichesX(int x1,int[] p2)
    {
        if(x1==p2[0])
        {
            return true;
        }
        return false;
    }
    
    private boolean gleichesY(int[] p1,int[] p2)
    {
        if(p1[1]==p2[1])
        {
            return true;
        }
        return false;
    }
    
    private boolean gleichesY(int y1,int[] p2)
    {
        if(y1==p2[1])
        {
            return true;
        }
        return false;
    }
    
    private boolean gleicheDiagonale(int[] p1,int[] p2)
    {
        double dX=p1[0]-p2[0];
        double dY=p1[1]-p2[1];
        double d=dX/dY;
        if(d*d==1)
        {
            return true;
        }
        return false;
    }
    
    public boolean testX()
    {
        for(int i=0;i<positions.size();i++)
        {
            for(int j=i+1;j<positions.size();j++)
            {
                if(positions.get(i)[0]==positions.get(j)[0])
                {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean testY()
    {
        for(int i=0;i<positions.size();i++)
        {
            for(int j=i+1;j<positions.size();j++)
            {
                if(positions.get(i)[1]==positions.get(j)[1])
                {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean testDiagonale()
    {
        for(int i=0;i<positions.size();i++)
        {
            for(int j=i+1;j<positions.size();j++)
            {
                double dX=positions.get(i)[0]-positions.get(j)[0];
                double dY=positions.get(i)[1]-positions.get(j)[1];
                double d=dX/dY;
                if(d*d==1)
                {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean test()
    {
        return ((testX()&&testY())&&testDiagonale());
    }
}
