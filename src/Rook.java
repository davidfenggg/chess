import java.awt.Color;
import java.util.ArrayList;

/**
 * The Rook object on the board
 * @author DavidFeng
 * @version 29 May 2018
 */
public class Rook extends Piece
{

  /**
   * Constructs a rook object
   * @param col the color of the rook
   * @param fileName  the filename for the rook
   */
  public Rook(Color col, String fileName)
  {
    super(col, fileName, 5);
  }

  /**
   * Gets all the possible destinations for the piece
   * @return  the possible destinations
   */
  public ArrayList<Location> destinations()
  {
    ArrayList<Location> arr = new ArrayList<Location>();
    for(int i = 0; i < 360; i+=90)
    {
      sweep(arr, i);
    }
    return arr;
  }

}
