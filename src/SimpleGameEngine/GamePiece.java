package SimpleGameEngine;

import javax.swing.Icon;

public class GamePiece
{
   public Icon icon;
   public int horiz = 0;
   public int vert;
   public boolean isClickable;

   GamePiece(int horiz, int vert, boolean isClickable, Icon icon)
   {
      this.horiz = horiz;
      this.vert = vert;
      this.isClickable = isClickable;
      this.icon = icon;
   }
}
