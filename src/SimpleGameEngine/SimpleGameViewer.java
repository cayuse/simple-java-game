package SimpleGameEngine;

import java.awt.*;
import javax.swing.*;

public class SimpleGameViewer extends JFrame
{
   private static final String MENU = "res/backgrounds/menu.png";
   private static final String BACKGROUND = "/res/backgrounds/background.png";
   BorderLayout myLayout = new BorderLayout();
   JPanel panelTop, panelMiddle, panelBottom;
   
   SimpleGameViewer()
   {
      setLayout(myLayout);

      panelTop = new JPanel( new GridLayout( 1,1 ) );
      //setPanelVars(pnlComputerHand, "Computer Hand");
      add(panelTop, BorderLayout.NORTH);

      panelMiddle = new JPanel(new GridLayout(3, 3));
      setPanelVars(pnlPlayArea, "Play Area");
      add(pnlPlayArea, BorderLayout.CENTER);

      panelBottom = new JPanel(new GridLayout(1, this.numCardsPerHand));
      setPanelVars(pnlHumanHand, "Human Hand");
      add(pnlHumanHand, BorderLayout.SOUTH);
      
   }
   
   void showSelectionScreen()
   {
      
   }
   
   void showSelectionMenu()
   {
      panelTop = null;
      panelMiddle = null;
      panelBottom = null;
      
      
   }

}
