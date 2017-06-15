package SimpleGameEngine;


import javax.swing.Icon;
import javax.swing.JButton;

public class ClickedButton extends JButton
{
   public static int horiz = -1;
   public static int vert = -1;
   
   ClickedButton(String str, Icon icon)
   {
      super(str, icon);
   }
}
