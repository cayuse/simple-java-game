package SimpleGameEngine;

import java.awt.event.*;

public class SimpleGameController implements ActionListener
{
   private final static int numGames = 3; // how many games to implement
   private int currentGame = 0; // index to the currently running game.
   private SimpleGameViewer myViewer = new SimpleGameViewer();
   private SimpleGameInterface[] myGames = new SimpleGameInterface[numGames];
   
   
   public SimpleGameController()
   {
      // instantiate all the games
      myGames[0] = new TTTModel();
      myGames[1] = new ConnectModel();
      myGames[3] = new OthelloModel();
      
      
      
   }
   
   // entry point to start execution.
   public void run()
   {
      
   }
   
   public void actionPerformed(ActionEvent e)
   {
      
   }
   
   
   
   /*****************Viewer Convenience Functions ****************************/
   // for the select screen, this will be used to display the game icons
   String[] getGameIcons()
   {
      String[] myGameIcons = new String[numGames];

      for (int i = 0; i < numGames; i++)
      {
         myGameIcons[i] = myGames[i].getGameIcon();
      }
      return myGameIcons;
   }
   // returns the current game's board image location
   String getCurrentBoard()
   {
      return myGames[currentGame].getBoardBG();
   }
   
   // returns the current game's 'ex' image location
   String getCurentExPiece()
   {
      return myGames[currentGame].getExPiece();
   }
   
   // returns the current game's 'oh' image location
   String getCurrentOhPiece()
   {
      return myGames[currentGame].getOhPiece();
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


}
