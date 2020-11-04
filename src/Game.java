import java.awt.Color;
/**
 * The game method that is the driver class
 *
 * @author David Feng
 * @version 29 May 2018
 */
public class Game
{
  /**
   * The main method runs the game
   *
   * @param args  the actual code of the method
   */
  public static void main(String[] args)
  {
    Board board = new Board();
    // Black King
    King blackKing = new King(Color.BLACK, "black_king.gif");
    blackKing.putSelfInGrid(board, new Location (0,4));
    // Black Rooks
    Rook blackRook1 = new Rook(Color.BLACK, "black_rook.gif");
    blackRook1.putSelfInGrid(board, new Location(0,0));
    Rook blackRook2 = new Rook(Color.BLACK, "black_rook.gif");
    blackRook2.putSelfInGrid(board, new Location(0,7));
    // Black Knights
    Knight blackKnight1 = new Knight(Color.BLACK, "black_knight.gif");
    blackKnight1.putSelfInGrid(board, new Location(0,1));
    Knight blackKnight2 = new Knight(Color.BLACK, "black_knight.gif");
    blackKnight2.putSelfInGrid(board, new Location(0,6));
    // Black Pawns
    Pawn blackPawn1 = new Pawn(Color.BLACK, "black_pawn.gif");
    blackPawn1.putSelfInGrid(board, new Location(1,0));
    Pawn blackPawn2 = new Pawn(Color.BLACK, "black_pawn.gif");
    blackPawn2.putSelfInGrid(board, new Location(1,1));
    Pawn blackPawn3 = new Pawn(Color.BLACK, "black_pawn.gif");
    blackPawn3.putSelfInGrid(board, new Location(1,2));
    Pawn blackPawn4 = new Pawn(Color.BLACK, "black_pawn.gif");
    blackPawn4.putSelfInGrid(board, new Location(1,3));
    Pawn blackPawn5 = new Pawn(Color.BLACK, "black_pawn.gif");
    blackPawn5.putSelfInGrid(board, new Location(1,4));
    Pawn blackPawn6 = new Pawn(Color.BLACK, "black_pawn.gif");
    blackPawn6.putSelfInGrid(board, new Location(1,5));
    Pawn blackPawn7 = new Pawn(Color.BLACK, "black_pawn.gif");
    blackPawn7.putSelfInGrid(board, new Location(1,6));
    Pawn blackPawn8 = new Pawn(Color.BLACK, "black_pawn.gif");
    blackPawn8.putSelfInGrid(board, new Location(1,7));
    // Black Bishops
    Bishop blackBishop1 = new Bishop(Color.BLACK, "black_bishop.gif");
    blackBishop1.putSelfInGrid(board, new Location(0,2));
    Bishop blackBishop2 = new Bishop(Color.BLACK, "black_bishop.gif");
    blackBishop2.putSelfInGrid(board, new Location(0,5));
    // Black Queen
    Queen blackQueen = new Queen(Color.BLACK, "black_queen.gif");
    blackQueen.putSelfInGrid(board, new Location(0,3));
    // White King
    King whiteKing = new King(Color.WHITE, "white_king.gif");
    whiteKing.putSelfInGrid(board, new Location(7,4));
    // White Rooks
    Rook whiteRook1 = new Rook(Color.WHITE, "white_rook.gif");
    whiteRook1.putSelfInGrid(board, new Location(7,0));
    Rook whiteRook2 = new Rook(Color.WHITE, "white_rook.gif");
    whiteRook2.putSelfInGrid(board, new Location(7,7));
    // White Knights
    Knight whiteKnight1 = new Knight(Color.WHITE, "white_knight.gif");
    whiteKnight1.putSelfInGrid(board, new Location(7,1));
    Knight whiteKnight2 = new Knight(Color.WHITE, "white_knight.gif");
    whiteKnight2.putSelfInGrid(board, new Location(7,6));
    // White Pawns
    Pawn whitePawn1 = new Pawn(Color.WHITE, "white_pawn.gif");
    whitePawn1.putSelfInGrid(board, new Location(6,0));
    Pawn whitePawn2 = new Pawn(Color.WHITE, "white_pawn.gif");
    whitePawn2.putSelfInGrid(board, new Location(6,1));
    Pawn whitePawn3 = new Pawn(Color.WHITE, "white_pawn.gif");
    whitePawn3.putSelfInGrid(board, new Location(6,2));
    Pawn whitePawn4 = new Pawn(Color.WHITE, "white_pawn.gif");
    whitePawn4.putSelfInGrid(board, new Location(6,3));
    Pawn whitePawn5 = new Pawn(Color.WHITE, "white_pawn.gif");
    whitePawn5.putSelfInGrid(board, new Location(6,4));
    Pawn whitePawn6 = new Pawn(Color.WHITE, "white_pawn.gif");
    whitePawn6.putSelfInGrid(board, new Location(6,5));
    Pawn whitePawn7 = new Pawn(Color.WHITE, "white_pawn.gif");
    whitePawn7.putSelfInGrid(board, new Location(6,6));
    Pawn whitePawn8 = new Pawn(Color.WHITE, "white_pawn.gif");
    whitePawn8.putSelfInGrid(board, new Location(6,7));
    // White Bishops
    Bishop whiteBishop1 = new Bishop(Color.WHITE, "white_bishop.gif");
    whiteBishop1.putSelfInGrid(board, new Location(7,2));
    Bishop whiteBishop2 = new Bishop(Color.WHITE, "white_bishop.gif");
    whiteBishop2.putSelfInGrid(board, new Location(7,5));
    // White Queen
    Queen whiteQueen = new Queen(Color.WHITE, "white_queen.gif");
    whiteQueen.putSelfInGrid(board, new Location(7,3));
    BoardDisplay display = new BoardDisplay(board);
    HumanPlayer player = new HumanPlayer(board, "Me", Color.WHITE, display);
    SmartestPlayer player2 = new SmartestPlayer(board, "Dylan", Color.BLACK);
    Move m = player.nextMove();
    display.setColor(m.getDestination(), Color.GREEN);
    play(board, display, player, player2);
  }

  /**
   * Gets the next turn in the game
   *
   * @param board the board that is being used
   * @param display the display of the game
   * @param player  the player that is getting the next turn
   */
  public static void nextTurn(Board board, BoardDisplay display, Player player)
  {
    display.setTitle(player.getName());
    Move move = player.nextMove();
    board.executeMove(move);
    display.clearColors();
    display.setColor(move.getSource(), Color.GREEN);
    display.setColor(move.getDestination(), Color.GREEN);
    try
    {
      Thread.sleep(500);
    }
    catch(InterruptedException e)
    {
      //nothing
    }
  }

  /**
   * Plays the actual game
   *
   * @param board the board that is being played on
   * @param display the display that is used
   * @param white the player that has the white pieces
   * @param black the player with the black pieces
   */
  public static void play(Board board, BoardDisplay display, Player white, Player black)
  {
    while(board.hasBlackKing() && board.hasWhiteKing())
    {
      nextTurn(board, display, white);
      if(board.hasWhiteKing() && board.hasBlackKing())
      {
        nextTurn(board, display, black);
      }
    }
    System.out.println("Game over!");
  }
}
