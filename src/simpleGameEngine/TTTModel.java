package simpleGameEngine;

public class TTTModel implements simpleGameInterface
{
   static final int BOARDHW = 3;
   static final String BOARD   = "res/boards/tttboard.png";
   static final String EXPIECE = "res/pieces/tttex.png";
   static final String OHPIECE = "res/pieces/tttoh.png";
   
   private Marker currentPlayer;
   private Marker[][] board = new Marker[BOARDHW][BOARDHW];
   
   // default constructor, clears the board and sets the player.
   TTTModel()
   {
      resetBoard();
      currentPlayer = Marker.EX;
   }
   // This method should return a relative path to the game's board image
   public String getBoardBG()
   {
      return BOARD;
   }
   
   // this method returns a relative path to the game's 'ex' piece image
   public String getExPiece()
   {
      return EXPIECE;
   }
   
   // this method returns a relative path to the game's 'oh' piece image
   public String getOhPiece()
   {
      return OHPIECE;
   }
   
   // this game returns a number height/width
   // all games are built with square boards, if the game doesn't have a square
   // space (connect 4 e.g.) then the model has to deal with that.
   public int getBoardHW()
   {
      return BOARDHW;
   }
   
   // This returns a string to be used to describe the "ex" player
   // e.g. white, red, X
   public String exPlayerName()
   {
      return "X";
   }
   
   // This returns a string to be used to describe the "oh" player
   // e.g. black, O
   public String ohPlayerName()
   {
      return "O";
   }
   
   // This method takes the horiz/vert location of the attempted move
   // and returns true or false if the move was legal/placed
   public boolean move(int horiz, int vert)
   {
      if ( board[horiz][vert] == Marker.MT )
      {
         board[horiz][vert] = currentPlayer;
         switchPlayers();
         return true;
      }
      else
      {
         return false;
      }
   }
   
   // This method is so the controller can ask whose turn it is.
   public Marker getCurrentPlayer()
   {
      return currentPlayer;   
   }
   
   // This method asks the model to check if there was a victory condition
   public boolean checkForWins(Marker player)
   {
      return false;
   }
   
   // This method simply tells the game model to clear the board back
   // to the beginning state.
   public void resetBoard()
   {
      for (int i = 0; i < BOARDHW; i++)
      {
         for (int k = 0; k< BOARDHW; k++)
            board[i][k] = Marker.MT;
      }
   }
   
   // this method returns a marker at the specified x/y location.
   public Marker getMarkerAt(int horiz, int vert)
   {
      return board[horiz][vert];
   }
   
   // simple private method to switch the active player
   private void switchPlayers()
   {
      if (currentPlayer == Marker.EX)
      {
         currentPlayer = Marker.OH;
      }
      else
      {
         currentPlayer = Marker.EX;
      }
   }

}
