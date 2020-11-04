import java.util.*;
import java.awt.*;
/**
 * The Queen Piece class
 *
 * @author David Feng
 * @version 29 May 2018
 */
public class Queen extends Piece
{

  /**
   * Constructs a queen object
   * @param c the color of the queen
   * @param fileName  the filename for the queen
   */
  public Queen(Color c, String fileName)
  {
    super(c, fileName, 9);
  }

  /**
   * Gets all the possible destinations for the piece
   * @return  the possible destinations
   */
  public ArrayList<Location> destinations()
  {
    ArrayList<Location> arr = new ArrayList<Location>();
    for(int i = 0; i < 360; i += 45)
    {
      sweep(arr, i);
    }
    return arr;
  }

}
