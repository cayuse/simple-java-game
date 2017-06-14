package SimpleGameEngine;

import javax.swing.Icon;

public class GamePiece
{
   public Icon icon;
   public int x;
   public int y;
   public boolean isClickable;

   GamePiece(int x, int y, boolean isClickable, Icon icon)
   {
      this.x = x;
      this.y = y;
      this.isClickable = isClickable;
      this.icon = icon;
   }
}
