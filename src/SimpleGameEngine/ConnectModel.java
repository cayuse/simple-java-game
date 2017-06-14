package SimpleGameEngine;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ConnectModel implements SimpleGameInterface
{
   static final int BOARDHW = 7;
   static final String TITLE = "Connect Four";
   static final String ICON = "res/icons/connect.png";
   static final Icon MTPIECE = new ImageIcon("res/pieces/connectmt.png");
   static final Icon EXPIECE = new ImageIcon("res/pieces/connectex.png");
   static final Icon OHPIECE = new ImageIcon("res/pieces/connectoh.png");
   static final Icon BLANK = new ImageIcon("res/pieces/connectblank.png");


   private Marker currentPlayer;
   private Marker[][] board = new Marker[BOARDHW][BOARDHW];

   // default constructor, clears the board and sets the player.
   ConnectModel()
   {
      resetBoard();
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
      return "Yellow";
   }

   // This returns a string to be used to describe the "oh" player
   // e.g. black, O
   public String ohPlayerName()
   {
      return "Red";
   }

   // This method takes the horiz/vert location of the attempted move
   // and returns true or false if the move was legal/placed
   public boolean move(int horiz, int vert)
   {
      return false;
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
         for (int k = 0; k < BOARDHW; k++)
            board[i][k] = Marker.MT;
      }
   }

   // this method returns a marker at the specified x/y location.
   // connect4 hase a unique piece that no other game has
   public GamePiece getPieceAt(int horiz, int vert)
   {
      if (vert == 0)
      {
         return new GamePiece(horiz, vert, false, BLANK);
      }
      else if (board[horiz][vert] == Marker.MT)
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

   // simple private method to switch the active player
   private void switchPlayers()
   {
      if (currentPlayer == Marker.EX)
      {
         currentPlayer = Marker.OH;
      } else
      {
         currentPlayer = Marker.EX;
      }
   }

}
