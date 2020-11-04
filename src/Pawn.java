import java.awt.Color;
import java.util.*;

/**
 * The Pawn piece outline
 * @author David Feng
 * @version 29 May 2018
 */
public class Pawn extends Piece
{

  /**
   * Constructs a pawn object
   * @param col the color of the pawn
   * @param fileName  the filename for the pawn
   */
  public Pawn(Color col, String fileName)
  {
    super(col, fileName, 1);
  }

  /**
   * Gets all the possible destinations for the piece
   * @return  the possible destinations
   */
  public ArrayList<Location> destinations()
  {
    ArrayList<Location> destinations = new ArrayList<Location>();
    ArrayList<Location> tempWhite = new ArrayList<Location>();
    ArrayList<Location> tempBlack = new ArrayList<Location>();
    int row = getLocation().getRow();
    int col = getLocation().getCol();
    for (int i = 0; i < 8; i++)
    {
      tempBlack.add(new Location(1, i));
      tempWhite.add(new Location(6, i));
    }
    if (getColor().equals(Color.BLACK))
    {
      Location loc1 = new Location(row + 1, col);
      if (isValidDestination(loc1))
      {
        destinations.add(loc1);
        Location loc2 = new Location(row + 2, col);
        if (isValidDestination(loc2) && isIn(getLocation(), tempBlack))
        {
          destinations.add(loc2);
        }
      }
      Location loc3 = new Location(row + 1, col + 1);
      if (inBounds(loc3))
      {
        Piece p = getBoard().get(loc3);
        if (p != null && p.getColor().equals(Color.WHITE))
        {
          destinations.add(loc3);
        }
      }
      Location loc4 = new Location(row + 1, col - 1);
      if (inBounds(loc4))
      {
        Piece p = getBoard().get(loc4);
        if (p != null && p.getColor().equals(Color.WHITE))
        {
          destinations.add(loc4);
        }
      }
      return destinations;
    }
    else
    {
      Location loc1w = new Location(row - 1, col);
      if (isValidDestination(loc1w))
      {
        destinations.add(loc1w);
        Location loc2 = new Location(row - 2, col);
        if (isValidDestination(loc2) && isIn(getLocation(), tempWhite))
        {
          destinations.add(loc2);
        }
      }
      Location loc3 = new Location(row - 1, col - 1);
      if (inBounds(loc3))
      {
        Piece p = getBoard().get(loc3);
        if (p != null && p.getColor().equals(Color.BLACK))
        {
          destinations.add(loc3);
        }
      }
      Location loc4 = new Location(row - 1, col + 1);
      if (inBounds(loc4))
      {
        Piece p = getBoard().get(loc4);
        if (p != null && p.getColor().equals(Color.BLACK))
        {
          destinations.add(loc4);
        }
      }
      return destinations;
    }
  }

  /**
   * Checks if a loc is in locs
   * @param loc the location
   * @param locs  the location array list
   * @return true if the loc is in locs
   *         false otherwise
   */
  private boolean isIn(Location loc, ArrayList<Location> locs)
  {
    for(int i = 0; i < locs.size(); i++)
    {
      if(loc.equals(locs.get(i)))
      {
        return true;
      }
    }
    return false;
  }

  /**
   * Checks if a location is in bounds
   * @param loc the location to be checked
   * @return  true if the loc is in bounds
   *          false otherwise
   */
  private boolean inBounds(Location loc)
  {
    int row = loc.getRow();
    int col = loc.getCol();
    return (row < 8 && row >= 0 && col < 8 && col >= 0);
  }

  /**
   * Checks if the destination is valid
   * @param dest  the loc to be checked
   * @return  true if dest is valid
   *          false otherwise
   */
  public boolean isValidDestination(Location dest)
  {
    int x = dest.getRow();
    int y = dest.getCol();
    if(getBoard().isValid(dest))
    {
      Piece temp = getBoard().get(dest);
      if (temp == null)
      {
        return true;
      }
    }
    return false;
  }

}
