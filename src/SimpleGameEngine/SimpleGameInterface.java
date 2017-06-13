package SimpleGameEngine;

enum Marker { MT, EX, OH };

public interface SimpleGameInterface
{
   // this method should return a relative path to the game's select icon
   public String getGameIcon();
   
   // This method should return a relative path to the game's board image
   public String getBoardBG();
   
   // this method returns a relative path to the game's 'ex' piece image
   public String getExPiece();
   
   // this method returns a relative path to the game's 'oh' piece image
   public String getOhPiece();
   
   // this game returns a number height/width
   // all games are built with square boards, if the game doesn't have a square
   // space (connect 4 e.g.) then the model has to deal with that.
   public int getBoardHW();
   
   // This returns a string to be used to describe the "ex" player
   // e.g. white, red, X
   public String exPlayerName();
   
   // This returns a string to be used to describe the "oh" player
   // e.g. black, O
   public String ohPlayerName();
   
   // This method takes the horiz/vert location of the attempted move
   // and returns true or false if the move was legal/placed
   public boolean move(int horiz, int vert);
   
   // This method is so the controller can ask whose turn it is.
   public Marker getCurrentPlayer();
   
   // This method asks the model to check if there was a victory condition
   public boolean checkForWins(Marker player);
   
   // This method simply tells the game model to clear the board back
   // to the beginning state.
   public void resetBoard();
   
   // this method returns a marker at the specified x/y location.
   public Marker getMarkerAt(int horiz, int vert);
   
   // this method returns a string representing the name of the game
   public String getGameTitle();
}
