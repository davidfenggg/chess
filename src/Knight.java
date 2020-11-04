import java.awt.Color;
import java.util.*;

/**
 * The Knight piece outline
 * @author David Feng
 * @version 29 May 2018
 */
public class Knight extends Piece
{
  /**
   * Constructs a knight object
   * @param col the color of the piece
   * @param fileName  the name of the file
   */
  public Knight(Color col, String fileName)
  {
    super(col, fileName, 3);
  }

  /**
   * Gets all the possible destinations for the piece
   * @return  the possible destinations
   */
  public ArrayList<Location> destinations()
  {
    ArrayList<Location> arr = new ArrayList<Location>();
    int r = getLocation().getRow();
    int c = getLocation().getCol();
    Location loc1 = new Location(r + 1, c + 2);
    Location loc2 = new Location(r + 1, c - 2);
    Location loc3 = new Location(r - 1, c + 2);
    Location loc4 = new Location(r - 1, c - 2);
    Location loc5 = new Location(r - 2, c + 1);
    Location loc6 = new Location(r - 2, c - 1);
    Location loc7 = new Location(r + 2, c + 1);
    Location loc8 = new Location(r + 2, c - 1);
    if(isValidDestination(loc1))
    {
      arr.add(loc1);
    }
    if(isValidDestination(loc2))
    {
      arr.add(loc2);
    }
    if(isValidDestination(loc3))
    {
      arr.add(loc3);
    }
    if(isValidDestination(loc4))
    {
      arr.add(loc4);
    }
    if(isValidDestination(loc5))
    {
      arr.add(loc5);
    }
    if(isValidDestination(loc6))
    {
      arr.add(loc6);
    }
    if(isValidDestination(loc7))
    {
      arr.add(loc7);
    }
    if(isValidDestination(loc8))
    {
      arr.add(loc8);
    }
    return arr;
  }
}
