import java.util.ArrayList;
import java.util.Random;



public class Queens
{
    ArrayList<int[]> positions;
    int[] positionNew;
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
        System.out.print('\u000C');
        positions=new ArrayList<>();
        random=new Random();
        nextPosition=false;
        position1=newPosition();
        positions.add(position1);
        System.out.println(position1[0]+", "+position1[1]);
        position2=newPosition();
        positions.add(position2);
        System.out.println(position2[0]+", "+position2[1]);
        position3=newPosition();
        positions.add(position3);
        System.out.println(position3[0]+", "+position3[1]);
        position4=newPosition();
        positions.add(position4);
        System.out.println(position4[0]+", "+position4[1]);
        position5=newPosition();
        positions.add(position5);
        System.out.println(position5[0]+", "+position5[1]);
        position6=newPosition();
        positions.add(position6);
        System.out.println(position6[0]+", "+position6[1]);
        position7=newPosition();
        positions.add(position7);
        System.out.println(position7[0]+", "+position7[1]);
        position8=newPosition();
        positions.add(position8);
        System.out.println(position8[0]+", "+position8[1]);
    }

    private int[] nextPosition()
    {
        nextPosition=false;
        boolean position=true;
        while(nextPosition==false)
        {
            int[] positionNew={random.nextInt(7),random.nextInt(7)};
            for(int i=0;i<positions.size();i++)
            {
                if(gleichesX(positionNew,positions.get(i)))
                {
                    position=false;
                }
                if(gleichesY(positionNew,positions.get(i)))
                {
                    position=false;
                }
                if(gleicheDiagonale(positionNew, positions.get(i)))
                {
                    position=false;
                }
                if(i==positions.size()-1&&position==true)
                {
                    nextPosition=true;
                    return positionNew;
                }
            }
        }
        
        
        return positionNew;
    }
    
    private int[] newPosition()
    {
        nextPosition=false;
        boolean position=true;
        while(nextPosition==false)
        {
            int x=random.nextInt(7)+1;
            int index=0;
            while(index<positions.size())
            {
                if(gleichesX(x,positions.get(index)))
                {
                    x=random.nextInt(7)+1;
                    index=0;
                }
                else
                {
                    index++;
                }
            }
            index=0;
            int y=random.nextInt(7)+1;
            while(index<positions.size())
            {
                if(gleichesY(y,positions.get(index)))
                {
                    y=random.nextInt(7)+1;
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
                    nextPosition=true;
                    return positionNew;
                }
            }
            if(positions.size()==0)
            {
                return positionNew;
            }
        }
        
        
        return positionNew;
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
}
