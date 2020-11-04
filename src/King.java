import java.awt.Color;
import java.util.*;
/**
 * The King class that extends Piece
 * @author DavidFeng
 * @version 29 May 2018
 */
public class King extends Piece
{

  /**
   * Constructs a king object
   * @param col the color of the object
   * @param fileName  the fileName of the king
   */
  public King(Color col, String fileName)
  {
    super(col, fileName, 1000);
  }

  /**
   * Gets all the possible destinations for the piece
   * @return  the possible destinations
   */
  public ArrayList<Location> destinations()
  {
    ArrayList<Location> locs = new ArrayList<Location>();
    int r = getLocation().getRow();
    int c = getLocation().getCol();
    Location loc1 = new Location(r+1, c);
    if(isValidDestination(loc1))
    {
      locs.add(loc1);
    }
    Location loc2 = new Location(r+1, c+1);
    if(isValidDestination(loc2))
    {
      locs.add(loc2);
    }
    Location loc3 = new Location(r+1, c-1);
    if(isValidDestination(loc3))
    {
      locs.add(loc3);
    }
    Location loc4 = new Location(r, c+1);
    if(isValidDestination(loc4))
    {
      locs.add(loc4);
    }
    Location loc5 = new Location(r, c-1);
    if(isValidDestination(loc5))
    {
      locs.add(loc5);
    }
    Location loc6 = new Location(r-1, c);
    if(isValidDestination(loc6))
    {
      locs.add(loc6);
    }
    Location loc7 = new Location(r-1, c+1);
    if(isValidDestination(loc7))
    {
      locs.add(loc7);
    }
    Location loc8 = new Location(r-1, c-1);
    if(isValidDestination(loc8))
    {
      locs.add(loc8);
    }
    return locs;
  }

}
