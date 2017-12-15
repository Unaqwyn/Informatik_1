import java.util.ArrayList;
import java.util.Random;



public class Queens
{
    ArrayList<int[]> positions;
    int[] positionNew;
    int[] position1;
    int[] lastRemoved;
    int[] lastRemoved2;
    boolean nextPosition;
    Random random;
    ArrayList<Integer> yProbiert;
    

    public Queens()
    {
        System.out.print('\u000C');
        positions=new ArrayList<>();
        random=new Random();
        nextPosition=false;
        for(int i=0;positions.size()<8;i++)
        {
            position1=newPosition();
            if(position1!=null)
            {
                positions.add(position1);
                System.out.println(position1[0]+", "+position1[1]);
            }
            else if(position1==null&&positions.get(positions.size()-1)!=lastRemoved)
            {
                i--;
                System.out.println("Removed: "+ positions.get(positions.size()-1)[0]+", "+positions.get(positions.size()-1)[1]);
                lastRemoved=positions.get(positions.size()-1);
                positions.remove(positions.size()-1);
            }
            else if((position1==null&&positions.get(positions.size()-1)==lastRemoved)&&positions.get(positions.size()-2)!=lastRemoved2)
            {
                i=i-2;
                System.out.println("Removed: "+ positions.get(positions.size()-1)[0]+", "+positions.get(positions.size()-1)[1]);
                lastRemoved2=positions.get(positions.size()-1);
                positions.remove(positions.size()-1);
                System.out.println("Removed: "+ positions.get(positions.size()-1)[0]+", "+positions.get(positions.size()-1)[1]);
                lastRemoved=positions.get(positions.size()-1);
                positions.remove(positions.size()-1);
            }
            else if(position1==null&&positions.get(positions.size()-1)==lastRemoved)
            {
                i=i-3;
                System.out.println("Removed: "+ positions.get(positions.size()-1)[0]+", "+positions.get(positions.size()-1)[1]);
                lastRemoved2=positions.get(positions.size()-1);
                positions.remove(positions.size()-1);
                System.out.println("Removed: "+ positions.get(positions.size()-1)[0]+", "+positions.get(positions.size()-1)[1]);
                lastRemoved=positions.get(positions.size()-1);
                positions.remove(positions.size()-1);
                System.out.println("Removed: "+ positions.get(positions.size()-1)[0]+", "+positions.get(positions.size()-1)[1]);
                lastRemoved=positions.get(positions.size()-1);
                positions.remove(positions.size()-1);
            }
        }
        /*
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
        */
    }

    private int[] nextPosition()
    {
        nextPosition=false;
        boolean position=true;
        while(nextPosition==false)
        {
            int[] positionNew={random.nextInt(8)+1,random.nextInt(8)+1};
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
    
    private int[] newPosition2()
    {
        nextPosition=false;
        boolean position=true;
        while(nextPosition==false)
        {
            position=true;
            int x=random.nextInt(8)+1;
            int index=0;
            while(index<positions.size())
            {
                if(gleichesX(x,positions.get(index)))
                {
                    x=random.nextInt(8)+1;
                    index=0;
                }
                else
                {
                    index++;
                }
            }
            index=0;
            int y=random.nextInt(8)+1;
            while(index<positions.size())
            {
                if(gleichesY(y,positions.get(index)))
                {
                    y=random.nextInt(8)+1;
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
    
    private int[] newPosition()
    {
        nextPosition=false;
        boolean position=true;
        yProbiert=new ArrayList<>();
        while(nextPosition==false&&yProbiert.size()<8)
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
                    nextPosition=true;
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
}
