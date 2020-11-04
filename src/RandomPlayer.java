import java.util.*;
import java.awt.*;

/**
 * The player that does random moves
 *
 * @author David Feng
 * @version 29 May 2018
 */
public class RandomPlayer extends Player
{

  /**
   * Creates a RandomPlayer object
   * @param b the board
   * @param s the name
   * @param c the color
   */
  public RandomPlayer(Board b, String s, Color c)
  {
    super(b, s, c);
  }

  /**
   * Gets the next move of the player
   * @return  the next move
   */
  public Move nextMove()
  {
    ArrayList<Move> moves = board.allMoves(color);
    int size = moves.size();
    int random = (int) (Math.random() * size);
    return moves.get(random);
  }

}
