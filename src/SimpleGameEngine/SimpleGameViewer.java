package SimpleGameEngine;

import java.awt.*;
import java.util.Random;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.event.*;

public class SimpleGameViewer extends JFrame
{
   private static final JLabel SELECT = 
         new JLabel( "Please Select A Game", JLabel.CENTER );
   private SimpleGameController myController;
   
   JPanel panelTop, panelMiddle, panelBottom;
   
   SimpleGameViewer(SimpleGameController myController)
   {
      CardTable myCardTable = new CardTable("Test", 2,7);
      myCardTable.setSize(800, 600);
      myCardTable.setLocationRelativeTo(null);
      myCardTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      myCardTable.setVisible(true);
   }
   /*
      // set the global controller
      this.myController = myController;
      BorderLayout myLayout = new BorderLayout();
      setLayout( myLayout );
      setSize( 800, 600 );
      setLocationRelativeTo( null );
      setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );      
      setVisible( true );
      
   }
   
   void showSelectionMenu()
   {
      removeAll();
      panelTop = null;
      panelMiddle = null;
      panelBottom = null;
      
      panelTop = new JPanel( new GridLayout( 1, 1 ) );
      panelTop.add(SELECT);
      setPanelVars(panelTop, "Menu");
      add( panelTop, BorderLayout.NORTH);
      
      panelMiddle = new JPanel( new GridLayout( 1, myController.getNumGames() ) );
      setPanelVars(panelMiddle, "List");
      add( panelMiddle, BorderLayout.CENTER );
      
   }
*/
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
}

//this class embodies the JPanels and Layout(s) needed, this is where all the cards and controls will be placed
class CardTable extends JFrame
{
public static final long serialVersionUID = 12;
static int MAX_CARDS_PER_HAND = 56;
static int MAX_PLAYERS = 2; // for now, we only allow 2 person games

private int numCardsPerHand;
private int numPlayers;

public JPanel pnlComputerHand, pnlHumanHand, pnlPlayArea;

// creates the play area for the game
CardTable(String title, int numCardsPerHand, int numPlayers)
{
   this.numPlayers = numPlayers;
   this.numCardsPerHand = numCardsPerHand;

   BorderLayout layout = new BorderLayout();
   setLayout(layout);

   pnlComputerHand = new JPanel(new GridLayout(1, this.numCardsPerHand));
   setPanelVars(pnlComputerHand, "Computer Hand");
   add(pnlComputerHand, BorderLayout.NORTH);

   pnlPlayArea = new JPanel(new GridLayout(3, 3));
   setPanelVars(pnlPlayArea, "Play Area");
   add(pnlPlayArea, BorderLayout.CENTER);

   pnlHumanHand = new JPanel(new GridLayout(1, this.numCardsPerHand));
   setPanelVars(pnlHumanHand, "Human Hand");
   add(pnlHumanHand, BorderLayout.SOUTH);
}

// sets up the panel so that the text is within the border
private void setPanelVars(JPanel panel, String name)
{
   TitledBorder border = new TitledBorder(name);
   border.setTitleJustification(TitledBorder.LEFT);
   border.setTitlePosition(TitledBorder.TOP);

   panel.setBorder(border);
   // panel.setMinimumHeight( 200);
   panel.setEnabled(true);
   panel.setVisible(true);
}
}