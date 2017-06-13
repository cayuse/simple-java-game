package simpleGameEngine;

enum Marker { MT, EX, OH };

public interface simpleGameInterface
{
   public String getBoardBG();
   public String getExPiece();
   public String getOhPiece();
   public int getBoardHW();
   public String exPlayerName();
   public String ohPlayerName();
   public boolean move(int horiz, int vert);
   public Marker getCurrentPlayer();
   public boolean checkForWins(Marker player);
   public boolean getWinDimension(int x1, int y1, int x2, int y2);
   public void resetBoard();
   public void getScores(int xWins, int oWins);
   public Marker getMarkerAt(int horiz, int vert);
}
