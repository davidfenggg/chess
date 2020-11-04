import java.awt.Color;
import java.util.*;

/**
 * Represents a human player amongst the players
 *
 * @author DavidFeng
 * @version 29 May 2018
 */
public class HumanPlayer extends Player
{
  /**
   * Instance variables hold info
   */
  public BoardDisplay display;
  private int turn;

  /**
   * Constructs a Human Player object
   * @param b the board
   * @param s the name
   * @param c the color
   * @param display the display for the board
   */
  public HumanPlayer(Board b, String s, Color c, BoardDisplay display)
  {
    super(b, s, c);
    this.display = display;
    if(color.equals(Color.WHITE))
    {
      turn = -1;
    }
    else
    {
      turn = 0;
    }
  }

  /**
   * Gets the next move of the HumanPlayer
   * @return  the next move
   */
  public Move nextMove()
  {
    Move move = display.selectMove();
    while(!isLegal(move))
    {
      move = display.selectMove();
    }
    System.out.println(printMove(move));
    return move;
  }

  /**
   * Checks if a move is legal
   * @param move  the move to be checked
   * @return  true  if the move is legal
   *          false otherwise
   */
  private boolean isLegal(Move move)
  {
    ArrayList<Move> arr = board.allMoves(color);
    for(int i = 0; i < arr.size(); i++)
    {
      if(move.equals(arr.get(i)))
      {
        return true;
      }
    }
    return false;
  }

  /**
   * Returns the move in chess notation
   * @param move  the move to be printed
   * @return  the move in chess notation
   */
  private String printMove(Move move)
  {
    boolean taken = false;
    boolean isPawn = false;
    Piece p = move.getPiece();
    String piece = "";
    String piece2 = "";
    if(p instanceof Pawn)
    {
      piece = "";
      isPawn = true;
    }
    else if(p instanceof Rook)
    {
      piece = "R";
    }
    else if(p instanceof Knight)
    {
      piece = "N";
    }
    else if(p instanceof Bishop)
    {
      piece = "B";
    }
    else if(p instanceof Queen)
    {
      piece = "Q";
    }
    else if(p instanceof King)
    {
      piece = "K";
    }
    Location loc = move.getDestination();
    String location = locationCoordinates(loc);
    if(board.get(loc) != null)
    {
      taken = true;
    }
    if(taken && isPawn)
    {
      piece = locationCoordinates(p.getLocation()).substring(0,1);
    }
    if(taken)
    {
      return turn + " " + color(p.getColor()) + ": " + piece + "x" + location;
    }
    turn++;
    return turn + " " + color(p.getColor()) + ": " + piece + location;
  }

  /**
   * Gets the coordinates of the location in chess notation
   * @param loc the location to be gotten
   * @return the coordinates of the loc
   */
  private String locationCoordinates(Location loc)
  {
    int r = loc.getRow();
    int c = loc.getCol();
    String col = "";
    if(c == 0)
    {
      col = "a";
    }
    if(c == 1)
    {
      col = "b";
    }
    if(c == 2)
    {
      col = "c";
    }
    if(c == 3)
    {
      col = "d";
    }
    if(c == 4)
    {
      col = "e";
    }
    if(c == 5)
    {
      col = "f";
    }
    if(c == 6)
    {
      col = "g";
    }
    if(c == 7)
    {
      col = "h";
    }
    int row = 8 - r;
    return col + row;
  }

  /**
   * Converts the color to a string
   * @param color the color to be converted
   * @return  the color in a String form
   */
  public String color(Color color)
  {
    if(color.equals(Color.BLACK))
    {
      return "BLACK";
    }
    return "WHITE";
  }
}
