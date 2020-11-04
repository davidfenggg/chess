import java.awt.Color;

/**
 * The player abstract class
 *
 * @author David Feng
 * @version 29 May 2018
 */
public abstract class Player
{
  /**
   * Instance variable stores board
   */
  public Board board;
  /**
   * Instance variable stores name
   */
  public String name;
  /**
   * Instance variable stores color
   */
  public Color color;

  /**
   * Constructs a player object
   * @param b the board
   * @param s the name
   * @param c the color
   */
  public Player(Board b, String s, Color c)
  {
    board = b;
    name = s;
    color = c;
  }

  /**
   * Gets the board of the player
   * @return the board
   */
  public Board getBoard()
  {
    return board;
  }

  /**
   * Gets the name of the player
   * @return  the name
   */
  public String getName()
  {
    return name;
  }

  /**
   * Gets the color of the player
   * @return color
   */
  public Color getColor()
  {
    return color;
  }

  /**
   * Gets the next move
   * @return  the next move
   */
  public abstract Move nextMove();

}
