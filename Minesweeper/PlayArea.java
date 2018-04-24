
/**
 * Write a description of class PlayArea here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PlayArea
{
    private Tile[][] tiles;
    private int[][] values;
    
    public PlayArea(BombMap bombMap)
    {
        values=bombMap.getValues();
        tiles=new Tile[Const.size][Const.size];
        for(int y=0;y<Const.size;y++)
        {
            for(int x=0;x<Const.size;x++)
            {
                tiles[x][y]=new Tile(values[x][y]);
            }
        }
    }
}
