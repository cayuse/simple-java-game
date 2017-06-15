package SimpleGameEngine;

import javax.swing.Icon;

public class GamePiece
{
   public Icon icon;
   public int horiz;
   public int vert;
   public boolean isClickable;

   GamePiece(int x, int y, boolean isClickable, Icon icon)
   {
      this.horiz = x;
      this.vert = y;
      this.isClickable = isClickable;
      this.icon = icon;
   }
}
