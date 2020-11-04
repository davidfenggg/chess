import java.util.*;
import java.awt.*;
/**
 * The Bishop class that represents the bishop object
 * @author DavidFeng
 * @version 29 May 2018
 */
public class Bishop extends Piece
{

  /**
   * Constructs a bishop object
   * @param c the color of the piece
   * @param fileName  the name of the file for the piece
   */
  public Bishop(Color c, String fileName)
  {
    super(c, fileName, 3);
  }

  /**
   * Gets all the possible destinations for the piece
   * @return  the possible destinations
   */
  public ArrayList<Location> destinations()
  {
    ArrayList<Location> arr = new ArrayList<Location>();
    for(int i = 45; i < 360; i += 90)
    {
      sweep(arr, i);
    }
    return arr;
  }

}
