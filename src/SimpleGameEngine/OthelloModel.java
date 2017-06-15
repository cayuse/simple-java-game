package SimpleGameEngine;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class OthelloModel implements SimpleGameInterface
{
   static final int BOARDHW = 8;
   static final String TITLE = "Othello";
   static final String ICON = "res/icons/othello.png";
   static final Icon MTPIECE = new ImageIcon("res/pieces/othellomt.png");
   static final Icon OHPIECE = new ImageIcon("res/pieces/othellooh.png");
   static final Icon EXPIECE = new ImageIcon("res/pieces/othelloex.png");

   private Marker currentPlayer;
   private Marker[][] board = new Marker[BOARDHW][BOARDHW];

   // default constructor, clears the board and sets the player.
   OthelloModel()
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
      return "Black";
   }

   // This returns a string to be used to describe the "oh" player
   // e.g. black, O
   public String ohPlayerName()
   {
      return "White";
   }

   // This method takes the horiz/vert location of the attempted move
   // and returns true or false if the move was legal/placed
   public boolean move(int horiz, int vert)
   {
      System.out.println(horiz);
      System.out.println(vert);
      boolean legit = false;
      legit = checkMoveDirections(horiz, vert);
      if (legit)
      {
         board[horiz][vert] = currentPlayer;
         switchPlayers();
      }
      return legit;
   }
   
   // this method will call a series of recursive functions. We can safely
   // use recursion here, because the maximum depth is 8 for this game
   // and it just makes a lot of sense to do so
   private boolean checkMoveDirections(int horiz, int vert)
   {
      boolean legit = false;
      // check the imed space, if it's opposite, then follow path
      if ((vert - 1 >=0) && board[horiz][vert-1] == getOtherPlayer())
      {
         legit = checkUp(horiz, vert - 1) || legit;
      }
      if ((vert + 1 < BOARDHW) && board[horiz][vert + 1] == getOtherPlayer())
      {
         legit = checkDown(horiz, vert + 1) || legit;
      }
      if ((horiz -1 >= 0) && board[horiz -1 ][vert] == getOtherPlayer())
      {
         legit = checkLeft(horiz - 1, vert) || legit;
      }
      if ((horiz + 1 < BOARDHW) && board[horiz + 1][vert] == getOtherPlayer())
      {
         legit = checkRight(horiz + 1, vert) || legit;
      }
      if((horiz - 1 >= 0) && (vert -1 >=0) 
            && board[horiz - 1][vert - 1] == getOtherPlayer())
      {
         legit = checkUL(horiz - 1, vert - 1) || legit;
      }
      if((horiz + 1 < BOARDHW) && (vert -1 >= 0) 
            && board[horiz + 1][vert - 1] == getOtherPlayer())
      {
         legit = checkUR(horiz + 1, vert - 1) || legit;
      }
      if((horiz -1 >= 0) && (vert +1 < BOARDHW) 
            && board[horiz - 1][vert + 1] == getOtherPlayer())
      {
         legit = checkDL(horiz - 1, vert + 1) || legit;
      }
      if((horiz + 1 < BOARDHW) && (vert + 1 < BOARDHW) 
            && board[horiz + 1][vert + 1] == getOtherPlayer())
      {
         legit = checkDR(horiz + 1, vert + 1) || legit;
      }
      return legit;
   }
   
   private boolean checkUp(int horiz, int vert)
   {
      if (vert < 0)
      {
         return false;
      }
      if (board[horiz][vert] == Marker.MT)
      {
         return false;
      }
      // if we are traversing in a direction and find another similar piece
      // we can flip those
      if (board[horiz][vert] == currentPlayer)
      {
         return true;
      }
      // the recursive call
      if (checkUp(horiz, vert - 1))
      {
         board[horiz][vert] = currentPlayer;
         return true;
      }
      return false;
   }
   
   private boolean checkDown(int horiz, int vert)
   {
      if (vert >= BOARDHW)
      {
         return false;
      }
      if (board[horiz][vert] == Marker.MT)
      {
         return false;
      }
      // if we are traversing in a direction and find another similar piece
      // we can flip those
      if (board[horiz][vert] == currentPlayer)
      {
         return true;
      }
      // the recursive call
      if (checkDown(horiz, vert + 1))
      {
         board[horiz][vert] = currentPlayer;
         return true;
      }
      return false;
   }
   
   private boolean checkLeft(int horiz, int vert)
   {
      if (horiz < 0)
      {
         return false;
      }
      if (board[horiz][vert] == Marker.MT)
      {
         return false;
      }
      // if we are traversing in a direction and find another similar piece
      // we can flip those
      if (board[horiz][vert] == currentPlayer)
      {
         return true;
      }
      // the recursive call
      if (checkLeft(horiz - 1, vert))
      {
         board[horiz][vert] = currentPlayer;
         return true;
      }
      return false;
   }
   
   private boolean checkRight(int horiz, int vert)
   {
      if (horiz >= BOARDHW)
      {
         return false;
      }
      if (board[horiz][vert] == Marker.MT)
      {
         return false;
      }
      // if we are traversing in a direction and find another similar piece
      // we can flip those
      if (board[horiz][vert] == currentPlayer)
      {
         return true;
      }
      // the recursive call
      if (checkRight(horiz + 1, vert))
      {
         board[horiz][vert] = currentPlayer;
         return true;
      }
      return false;
   }
   
   boolean checkUL(int horiz, int vert)
   {
      if (horiz < 0 || vert < 0)
      {
         return false;
      }
      if (board[horiz][vert] == Marker.MT)
      {
         return false;
      }
      // if we are traversing in a direction and find another similar piece
      // we can flip those
      if (board[horiz][vert] == currentPlayer)
      {
         return true;
      }
      // the recursive call
      if (checkUL(horiz -1, vert - 1))
      {
         board[horiz][vert] = currentPlayer;
         return true;
      }
      return false;
   }
   
   boolean checkUR(int horiz, int vert)
   {
      if (horiz >= BOARDHW || vert < 0)
      {
         return false;
      }
      if (board[horiz][vert] == Marker.MT)
      {
         return false;
      }
      // if we are traversing in a direction and find another similar piece
      // we can flip those
      if (board[horiz][vert] == currentPlayer)
      {
         return true;
      }
      // the recursive call
      if (checkUR(horiz + 1, vert -1))
      {
         board[horiz][vert] = currentPlayer;
         return true;
      }
      return false;
   }
   
   boolean checkDL(int horiz, int vert)
   {
      if (horiz < 0 || vert >= BOARDHW)
      {
         return false;
      }
      if (board[horiz][vert] == Marker.MT)
      {
         return false;
      }
      // if we are traversing in a direction and find another similar piece
      // we can flip those
      if (board[horiz][vert] == currentPlayer)
      {
         return true;
      }
      // the recursive call
      if (checkDL(horiz -1, vert +1))
      {
         board[horiz][vert] = currentPlayer;
         return true;
      }
      return false;
   }
   boolean checkDR(int horiz, int vert)
   {
      if (horiz >= BOARDHW || vert >= BOARDHW)
      {
         return false;
      }
      if (board[horiz][vert] == Marker.MT)
      {
         return false;
      }
      // if we are traversing in a direction and find another similar piece
      // we can flip those
      if (board[horiz][vert] == currentPlayer)
      {
         return true;
      }
      // the recursive call
      if (checkDR(horiz +1, vert +1))
      {
         board[horiz][vert] = currentPlayer;
         return true;
      }
      return false;
   }

   // This method is so the controller can ask whose turn it is.
   public Marker getCurrentPlayer()
   {
      return currentPlayer;
   }
   
   // this method is useful for checking the board
   // it simply lets us figure out the opposite marker
   private Marker getOtherPlayer()
   {
      if (currentPlayer == Marker.OH)
      {
         return Marker.EX;
      }
      else
      {
         return Marker.OH;
      }
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
      // Special Setup for Othello
      board[3][3] = Marker.OH;
      board[3][4] = Marker.EX;
      board[4][3] = Marker.EX;
      board[4][4] = Marker.OH;

      currentPlayer = Marker.OH;
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
      switchPlayers();
      return true;
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
