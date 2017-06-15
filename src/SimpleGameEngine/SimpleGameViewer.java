package SimpleGameEngine;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.*;

public class SimpleGameViewer extends JFrame
{
   private static final JLabel SELECT = new JLabel("Please Select A Game", JLabel.CENTER);
   private SimpleGameController myController;

   private static Icon[] gameIcons;
   private static String[] gameNames;
   private static JButton[] gameButtons;

   JPanel panelTop, panelMid, panelLeft;

   SimpleGameViewer(SimpleGameController myController)
   {
      // set the global controller
      this.myController = myController;

      // get game names
      gameNames = myController.getGameNames();

      // setup game icons
      String[] iconFiles = myController.getGameIcons();
      gameIcons = new ImageIcon[myController.getNumGames()];
      for (int i = 0; i < myController.getNumGames(); i++)
      {
         gameIcons[i] = new ImageIcon(iconFiles[i]);
      }

      // method-ize this, because it's a lot of ugly code
      setAndConfigureMenuButtons();

      panelTop = new JPanel(new GridLayout(1, 1));
      setPanelVars(panelTop, "");
      add(panelTop, BorderLayout.NORTH);

      panelLeft = new JPanel(new GridLayout(3, 1));
      add(panelLeft, BorderLayout.WEST);
      setPanelVars(panelLeft, "Control");

      panelMid = new JPanel(new GridLayout(1, 3));
      setPanelVars(panelMid, "Game Area");
      add(panelMid, BorderLayout.CENTER);

      setSize(750, 680);
      setLocationRelativeTo(null);
      setResizable(false);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);

   }

   // this method clears the interface, and sets it to a new game.
   // for a new game
   void setNewGame()
   {
      clearPanels();
      int boardHW = myController.getCurrentBoardHW();
      panelTop.setLayout(new GridLayout(1, 1));
      panelLeft.setLayout(new GridLayout(3, 1));
      panelMid.setLayout(new GridLayout(boardHW, boardHW));
      refreshScreen();
   }

   // this method takes a 2d array of GamePieces and puts them on screen
   void refreshBoard(GamePiece[][] myBoard)
   {
      clearPanels();
      JLabel title = new JLabel(myController.getCurrentGameTitle(), JLabel.CENTER);
      panelTop.add(title);
      int boardHW = myController.getCurrentBoardHW();
      for (int y = 0; y < boardHW; y++)
      {
         for (int x = 0; x < boardHW; x++)
         {
            GamePiece thisPiece = myBoard[x][y];
            JComponent nextItem;
            if (thisPiece.isClickable)
            {
               nextItem = new ClickedButton("", thisPiece.icon);
               ((ClickedButton) nextItem).horiz = thisPiece.horiz;
               ((ClickedButton) nextItem).vert = thisPiece.vert;
               ((JButton) nextItem).addActionListener(myController);
            } 
            else
            {
               nextItem = new JLabel(thisPiece.icon);
            }
            panelMid.add(nextItem);
         }
      }
      configureMainMenuButton();
      configureSkipTurnButton();
      configureResetButton();
      refreshScreen();
   }

   // clears the screen and displays the game selection menu.
   void showSelectionMenu()
   {
      clearPanels();
      panelTop.add(SELECT);

      panelMid.setLayout(new GridLayout(2, myController.getNumGames()));
      // add the game icons
      for (int i = 0; i < gameButtons.length; i++)
      {
         panelMid.add(gameButtons[i]);
      }
      // add the game labels
      for (int i = 0; i < gameNames.length; i++)
      {
         JLabel label = new JLabel(gameNames[i], JLabel.CENTER);
         panelMid.add(label);
      }

      configureExitButton();

      refreshScreen();
   }

   // clears the panels
   private void clearPanels()
   {
      panelTop.removeAll();
      panelMid.removeAll();
      panelLeft.removeAll();
   }

   // redraws the screen
   private void refreshScreen()
   {
      panelLeft.setVisible(false);
      panelLeft.setVisible(true);
   }
   
   // sets up the panel so that the text is within the border
   private void setPanelVars(JPanel panel, String name)
   {
      TitledBorder border = new TitledBorder(name);
      border.setTitleJustification(TitledBorder.LEFT);
      border.setTitlePosition(TitledBorder.TOP);

      panel.setBorder(border);
      panel.setEnabled(true);
      panel.setVisible(true);
   }

   // function to create a "main menu" button with callback to controller
   private void configureMainMenuButton()
   {
      JButton button = new JButton("Main Menu");
      button.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            myController.mainMenu();
         }
      });
      panelLeft.add(button);
   }
   
   // function to create a "reset" button with callback to controller
   private void configureResetButton()
   {
      JButton button = new JButton("Reset");
      button.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            myController.resetGame();
         }
      });
      panelLeft.add(button);
   }

   // function to create a 'skip turn' button.
   private void configureSkipTurnButton()
   {
      JButton button = new JButton("Skip Turn");
      button.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            myController.skipTurn();
         }
      });
      button.setLayout(null);
      panelLeft.add(button);
   }

   // function to create an quit button with built in callback to controller
   private void configureExitButton()
   {
      JButton button = new JButton("Quit game");
      button.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            myController.quitGame();
         }
      });
      button.setLayout(null);
      panelLeft.add(button);
   }

   /*
    * this rather ugly looking method sets up the menu buttons. it builds a
    * listener for each, and that listener searches to tell which button got
    * pressed, then calls back to the controller to set the current game.
    */
   private void setAndConfigureMenuButtons()
   {
      // instantiate buttons with custom listeners
      gameButtons = new JButton[gameIcons.length];
      for (int i = 0; i < gameIcons.length; i++)
      {
         JButton button = new JButton("", gameIcons[i]);
         button.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent e)
            {
               // special listeners will callback to the controller
               // find the icon from the click
               int clickedGame = 0;
               for (int k = 0; k < gameIcons.length; k++)
               {
                  if (gameButtons[k] == e.getSource())
                  {
                     clickedGame = k;
                     break;
                  }
               }
               myController.setGame(clickedGame);
            }
         });
         gameButtons[i] = button;
      }
   }
}
