import java.awt.Color;
import java.util.*;

/**
 * The abstract class that represents a piece of the chess game
 *
 * @author David Feng
 * @version 29 May 2018
 */

public abstract class Piece
{
	//the board this piece is on
	private Board board;

	//the location of this piece on the board
	private Location location;

	//the color of the piece
	private Color color;

	//the file used to display this piece
	private String imageFileName;

	//the approximate value of this piece in a game of chess
	private int value;

	/**
	 * Constructs a new Piece with the given attributes.
	 * @param col       the color of the piece
	 * @param fileName  the name of the file for the piece
	 * @param val       the value of the piece
	 */
	public Piece(Color col, String fileName, int val)
	{
		color = col;
		imageFileName = fileName;
		value = val;
	}

	/**
	 * returns the board this piece is on
	 * @return the board
	 */
	public Board getBoard()
	{
		return board;
	}

	/**
	 * returns the location of this piece on the board
	 * @return  the location
	 */
	public Location getLocation()
	{
		return location;
	}

	/**
	 * returns the color of this piece
	 * @return  the color
	 */
	public Color getColor()
	{
		return color;
	}

	/**
	 * returns the name of the file used to display this piece
	 * @return  the name of the file
	 */
	public String getImageFileName()
	{
		return imageFileName;
	}

	/**
	 * returns a number representing the relative value of this piece
	 * @return  the value of the piece
	 */
	public int getValue()
	{
		return value;
	}

	/**
	 * Puts this piece into a board. If there is another piece at the given
	 * location, it is removed. <br />
	 * Precondition: (1) This piece is not contained in a grid (2)
	 * <code>loc</code> is valid in <code>gr</code>
	 * @param brd the board into which this piece should be placed
	 * @param loc the location into which the piece should be placed
	 */
	public void putSelfInGrid(Board brd, Location loc)
	{
		if (board != null)
			throw new IllegalStateException(
					"This piece is already contained in a board.");

		Piece piece = brd.get(loc);
		if (piece != null)
			piece.removeSelfFromGrid();
		brd.put(loc, this);
		board = brd;
		location = loc;
	}

	/**
	 * Removes this piece from its board.
	 * @Precondition: This piece is contained in a board
	 */
	public void removeSelfFromGrid()
	{
		if (board == null)
			throw new IllegalStateException(
					"This piece is not contained in a board.");
		if (board.get(location) != this)
			throw new IllegalStateException(
					"The board contains a different piece at location "
							+ location + ".");

		board.remove(location);
		board = null;
		location = null;
	}

	/**
	 * Moves this piece to a new location. If there is another piece at the
	 * given location, it is removed. <br />
	 * Precondition: (1) This piece is contained in a grid (2)
	 * <code>newLocation</code> is valid in the grid of this piece
	 * @param newLocation the new location
	 */
	public void moveTo(Location newLocation)
	{
		if (board == null)
			throw new IllegalStateException("This piece is not on a board.");
		if (board.get(location) != this)
			throw new IllegalStateException(
					"The board contains a different piece at location "
							+ location + ".");
		if (!board.isValid(newLocation))
			throw new IllegalArgumentException("Location " + newLocation
					+ " is not valid.");

		if (newLocation.equals(location))
			return;
		board.remove(location);
		Piece other = board.get(newLocation);
		if (other != null)
			other.removeSelfFromGrid();
		location = newLocation;
		board.put(location, this);
	}

	/**
	 * Checks if a certain destination is valid
	 * @param dest  the destination to be checked
	 * @return  true    if the dest is valid
	 *                  false otherwise
	 */
	public boolean isValidDestination(Location dest)
	{
		int x = dest.getRow();
		int y = dest.getCol();
		if(board.isValid(dest))
		{
			Piece temp = board.get(dest);
			if(temp == null )
			{
				return true;
			}
			if(color.equals(Color.BLACK) && temp.getColor().equals(Color.WHITE))
			{
				return true;
			}
			if(color.equals(Color.WHITE) && temp.getColor().equals(Color.BLACK))
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * Gets the destinations of the piece
	 * @return  the destinations
	 */
	public abstract ArrayList<Location> destinations();

	/**
	 * Sweeps in the direction that is specified
	 * @param dests adds the locations to dests
	 * @param direction the direction to be swept
	 */
	public void sweep(ArrayList<Location> dests, int direction)
	{
		int r = getLocation().getRow();
		int c = getLocation().getCol();
		if(direction == Location.NORTH)
		{
			for (int i = 1; i < 8; i++)
			{
				Location loc = new Location(r, c-i);
				if(isValidDestination(loc))
				{
					dests.add(loc);
				}
				else
				{
					break;
				}
				Piece temp = board.get(loc);
				if(temp != null)
				{
					break;
				}
			}
		}
		if(direction == Location.SOUTH)
		{
			for (int i = 1; i < 8; i++)
			{
				Location loc = new Location(r, c+i);
				if(isValidDestination(loc))
				{
					dests.add(loc);
				}
				else
				{
					break;
				}
				Piece temp = board.get(loc);
				if(temp != null)
				{
					break;
				}
			}
		}
		if(direction == Location.WEST)
		{
			for (int i = 1; i < 8; i++)
			{
				Location loc = new Location(r-i, c);
				if(isValidDestination(loc))
				{
					dests.add(loc);
				}
				else
				{
					break;
				}
				Piece temp = board.get(loc);
				if(temp != null)
				{
					break;
				}
			}
		}
		if(direction == Location.EAST)
		{
			for (int i = 1; i < 8; i++)
			{
				Location loc = new Location(r+i, c);
				if(isValidDestination(loc))
				{
					dests.add(loc);
				}
				else
				{
					break;
				}
				Piece temp = board.get(loc);
				if(temp != null)
				{
					break;
				}
			}
		}
		if(direction == Location.NORTHEAST)
		{
			for (int i = 1; i < 8; i++)
			{
				Location loc = new Location(r+i, c-i);
				if(isValidDestination(loc))
				{
					dests.add(loc);
				}
				else
				{
					break;
				}
				Piece temp = board.get(loc);
				if(temp != null)
				{
					break;
				}
			}
		}
		if(direction == Location.NORTHWEST)
		{
			for (int i = 1; i < 8; i++)
			{
				Location loc = new Location(r-i, c-i);
				if(isValidDestination(loc))
				{
					dests.add(loc);
				}
				else
				{
					break;
				}
				Piece temp = board.get(loc);
				if(temp != null)
				{
					break;
				}
			}
		}
		if(direction == Location.SOUTHEAST)
		{
			for (int i = 1; i < 8; i++)
			{
				Location loc = new Location(r+i, c+i);
				if(isValidDestination(loc))
				{
					dests.add(loc);
				}
				else
				{
					break;
				}
				Piece temp = board.get(loc);
				if(temp != null)
				{
					break;
				}
			}
		}
		if(direction == Location.SOUTHWEST)
		{
			for (int i = 1; i < 8; i++)
			{
				Location loc = new Location(r-i, c+i);
				if(isValidDestination(loc))
				{
					dests.add(loc);
				}
				else
				{
					break;
				}
				Piece temp = board.get(loc);
				if(temp != null)
				{
					break;
				}
			}
		}
	}

}