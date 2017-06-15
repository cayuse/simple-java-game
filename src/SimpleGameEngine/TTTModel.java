package SimpleGameEngine;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class TTTModel implements SimpleGameInterface
{
   static final int BOARDHW = 3;
   static final String TITLE = "Tic Tac Toe";
   static final String ICON = "res/icons/ttt.png";
   static final Icon MTPIECE = new ImageIcon("res/pieces/tttmt.png");
   static final Icon EXPIECE = new ImageIcon("res/pieces/tttex.png");
   static final Icon OHPIECE = new ImageIcon("res/pieces/tttoh.png");

   private Marker currentPlayer;
   private Marker[][] board = new Marker[BOARDHW][BOARDHW];

   // default constructor, clears the board and sets the player.
   TTTModel()
   {
      resetBoard();
   }

   /*********************** Interface Methods ********************************/

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
      if (board[horiz][vert] == Marker.MT)
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
   public String getCurrentPlayer()
   {
      if (currentPlayer == Marker.EX)
      {
         return exPlayerName();
      }
      return ohPlayerName();
   }


   // This method simply tells the game model to clear the board back
   // to the beginning state.
   public void resetBoard()
   {
      for (int i = 0; i < BOARDHW; i++)
      {
         for (int k = 0; k < BOARDHW; k++)
            board[i][k] = Marker.MT;
      }
      currentPlayer = Marker.EX;
   }

   // this method returns a marker at the specified x/y location.
   public GamePiece getPieceAt(int horiz, int vert)
   {
      if (board[horiz][vert] == Marker.MT)
      {
         return new GamePiece(horiz, vert, true, MTPIECE);
      } 
      else if (board[horiz][vert] == Marker.EX)
      {
         return new GamePiece(horiz, vert, false, EXPIECE);
      }
      return new GamePiece(horiz, vert, false, OHPIECE);
   }

   public String getGameTitle()
   {
      return TITLE;
   }

   public String getGameIcon()
   {
      return ICON;
   }
   
   public boolean forfeitTurn()
   {
      return false;
   }
   /************************ END INTERFACE ***********************************/
   
   /************************ Private Methods *********************************/
   
   // simple private method to switch the active player
   public void switchPlayers()
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
