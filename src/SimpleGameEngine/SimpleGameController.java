package SimpleGameEngine;

import java.awt.event.*;

public class SimpleGameController implements ActionListener
{
   private final static int NUMGAMES = 3; // how many games to implement
   private int currentGame = 0; // index to the currently running game.
   private SimpleGameViewer myViewer;
   private SimpleGameInterface[] myGames = new SimpleGameInterface[NUMGAMES];

   public SimpleGameController()
   {
      // instantiate all the games
      myGames[0] = new TTTModel();
      myGames[1] = new ConnectModel();
      myGames[2] = new OthelloModel();
   }

   // method to callback from viewer
   void setGame(int index)
   {
      // set currently active game
      currentGame = index;
      // reset the game
      myViewer.setNewGame();
      resetGame();
   }
   
   // method to reset the current game
   void resetGame()
   {
      myGames[currentGame].resetBoard();
      refreshGame();
   }

   // method to get the board model and pass it to the viewer for display
   void refreshGame()
   {
      int boardHW = myGames[currentGame].getBoardHW();
      GamePiece[][] myBoard = new GamePiece[boardHW][boardHW];
      for (int x = 0; x < boardHW; x++)
      {
         for (int y = 0; y < boardHW; y++)
         {
            myBoard[x][y] = myGames[currentGame].getPieceAt(x, y);
         }
      }

      myViewer.refreshBoard(myBoard);

   }

   // entry point to start execution.
   public void run()
   {
      // now that this object is instantiated, we can go back and
      // bring the viewer online, it needs access to this in order
      // to do call backs and get other information
      myViewer = new SimpleGameViewer(this); // allows for call-backs.
      myViewer.showSelectionMenu();

   }

   // method to quit the game and return to the main menu
   void mainMenu()
   {
      myViewer.showSelectionMenu();
   }

   // method to skip a turn
   void skipTurn()
   {
      if (myGames[currentGame].forfeitTurn())
      {
         refreshGame();
      }
   }

   // simple quit game method.
   // could potentially clean up or display
   // for now just exits
   public void quitGame()
   {
      System.exit(0);
   }

   public void actionPerformed(ActionEvent e)
   {
      ClickedButton btn = (ClickedButton) e.getSource();
      if (myGames[currentGame].move(btn.horiz, btn.vert))
      {
         refreshGame();
      }
   }

   /***************** Viewer Convenience Functions ****************************/
   // for the select screen, this will be used to display the game icons
   String[] getGameIcons()
   {
      String[] myGameIcons = new String[NUMGAMES];

      for (int i = 0; i < NUMGAMES; i++)
      {
         myGameIcons[i] = myGames[i].getGameIcon();
      }
      return myGameIcons;
   }

   // for the select screen, this will be used to display the game names
   String[] getGameNames()
   {
      String[] myGameNames = new String[NUMGAMES];
      for (int i = 0; i < NUMGAMES; i++)
      {
         myGameNames[i] = myGames[i].getGameTitle();
      }
      return myGameNames;
   }

   // returns the current game's board hegiht/width
   int getCurrentBoardHW()
   {
      return myGames[currentGame].getBoardHW();
   }

   // returns the current game's 'ex' name
   String getCurrentGameExName()
   {
      return myGames[currentGame].exPlayerName();
   }

   // returns the current game's 'oh' name
   String getCurrentGameOhName()
   {
      return myGames[currentGame].ohPlayerName();
   }

   // returns the current game's title
   String getCurrentGameTitle()
   {
      return myGames[currentGame].getGameTitle();
   }

   // returns the number of games
   int getNumGames()
   {
      return NUMGAMES;
   }

}
