package SimpleGameEngine;


import javax.swing.Icon;
import javax.swing.JButton;

public class ClickedButton extends JButton
{
   public int horiz = -1;
   public int vert = -1;
   
   ClickedButton(String str, Icon icon)
   {
      super(str, icon);
   }
}
