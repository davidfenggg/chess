import java.util.*;
import java.awt.*;
/**
 * A smarter version of player
 *
 * @author David Feng
 * @version 29 May 2018
 */
public class SmartPlayer extends Player
{

  private int turn;

  /**
   * Constructs a Smart Player object
   * @param b the board
   * @param s the name of the player
   * @param c the color of the player
   */
  public SmartPlayer(Board b, String s, Color c)
  {
    super(b, s, c);
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
   * Gets the next move of the player
   * @return  the next move
   */
  public Move nextMove()
  {
    ArrayList<Move> moves = board.allMoves(color);
    ArrayList<Integer> scores = new ArrayList<Integer>();
    for(int i = 0; i < moves.size(); i++)
    {
      scores.add(calculateDiffScore(moves.get(i)));
    }
    int maxIndex = 0;
    for(int i = 0; i < scores.size(); i++)
    {
      if(scores.get(i) > scores.get(maxIndex))
      {
        maxIndex = i;
      }
    }
    System.out.println(printMove(moves.get(maxIndex)));
    if(maxIndex == 0)
    {
      int x = (int) (Math.random() * scores.size());
      return moves.get(x);
    }
    return moves.get(maxIndex);
  }

  /**
   * Calculates the difference in scores after move
   * @param move  the move to be executed
   * @return  the difference in scores
   */
  public int calculateDiffScore(Move move)
  {
    board.executeMove(move);
    int myScore = calculateScore(color);
    int theirScore;
    if(color.equals(Color.BLACK))
    {
      theirScore = calculateScore(Color.WHITE);
    }
    else
    {
      theirScore = calculateScore(Color.BLACK);
    }
    board.undoMove(move);
    return myScore - theirScore;
  }

  /**
   * Calculates the difference in scores in the status quo
   * @return  the difference in scores
   */
  public int calculateDiffScore()
  {
    int myScore = calculateScore(color);
    int theirScore = calculateScore(otherColor(color));
    return myScore - theirScore;
  }

  /**
   * Calculates the score of the color
   * @param c the color to be calculated
   * @return  the score of that color
   */
  public int calculateScore(Color c)
  {
    int sum = 0;
    for(int i = 0; i < 8; i++)
    {
      for(int j = 0; j < 8; j++)
      {
        Piece p = board.get(new Location(i, j));
        if(p != null && p.getColor().equals(c))
        {
          sum += p.getValue();
        }
      }
    }
    return sum;
  }

  /**
   * Gets the other color that is not the player's color
   * @param c the current player color
   * @return  the other color
   */
  private Color otherColor(Color c)
  {
    if(c.equals(Color.WHITE))
    {
      return Color.BLACK;
    }
    else
    {
      return Color.WHITE;
    }
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

}
