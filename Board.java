import java.awt.Color;
import java.util.ArrayList;

/**
 * Represesents a rectangular game board, containing Piece objects.
 * @author David Feng
 * @version 29 May 2018
 */

public class Board extends BoundedGrid<Piece>
{

    /**
     * Constructs a new Board with the given dimensions
     */
    public Board()
    {
        super(8, 8);
    }

    /**
     * @Precondition:  move has already been made on the board
     * @Postcondition: piece has moved back to its source,
     *                and any captured piece is returned to its location
     * @param move   the move to undo
     */
    public void undoMove(Move move)
    {
        Piece piece = move.getPiece();
        Location source = move.getSource();
        Location dest = move.getDestination();
        Piece victim = move.getVictim();

        piece.moveTo(source);

        if (victim != null)
            victim.putSelfInGrid(piece.getBoard(), dest);
    }

    /**
     * Returns all possible moves for one color
     * @param color the color to be tested
     * @return  all possible moves for that color
     */
    public ArrayList<Move> allMoves(Color color)
    {
        ArrayList<Piece> arr = new ArrayList<Piece>();
        ArrayList<Move> finalArr = new ArrayList<Move>();
        for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                Location loc = new Location(i, j);
                Piece temp = get(loc);
                if (temp != null && temp.getColor().equals(color))
                {
                    arr.add(temp);
                }
            }
        }
        for (int i = 0; i < arr.size(); i++)
        {
            Piece p = arr.get(i);
            ArrayList<Location> temp = p.destinations();
            for(int j = 0; j < temp.size(); j++)
            {
                Move move = new Move(p, temp.get(j));
                finalArr.add(move);
            }
        }
        return finalArr;
    }

    /**
     * Checks if the board still has a king that is black
     * @return  true if it does
     *                  false otherwise
     */
    public boolean hasBlackKing()
    {
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                Piece p = get(new Location(i, j));
                if(p instanceof King)
                {
                    if(p.getColor().equals(Color.BLACK))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Checks if the board still has a king that is white
     * @return  true if it does
     *                  false otherwise
     */
    public boolean hasWhiteKing()
    {
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                Piece p = get(new Location(i, j));
                if(p instanceof King)
                {
                    if(p.getColor().equals(Color.WHITE))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Executes the actual move
     * @param move the move to be executed
     */
    public void executeMove(Move move)
    {
        Location loc = move.getDestination();
        Piece p = move.getPiece();
        p.moveTo(loc);
    }
}