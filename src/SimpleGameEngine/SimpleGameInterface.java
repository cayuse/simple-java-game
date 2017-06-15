package SimpleGameEngine;

enum Marker
{
   MT, EX, OH
}; // "Empty, x's, and o's: used to track what's on the board"

public interface SimpleGameInterface
{
   // this method should return a relative path to the game's select icon
   public String getGameIcon();

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
   // the model should automatically change players if a successful move
   // has been placed
   public boolean move(int horiz, int vert);

   // This method is so the controller can ask whose turn it is.
   public String getCurrentPlayer();

   // This method simply tells the game model to clear the board back
   // to the beginning state.
   public void resetBoard();

   // this method returns a marker at the specified x/y location.
   public GamePiece getPieceAt(int horiz, int vert);

   // this method returns a string representing the name of the game
   public String getGameTitle();
   
   // this method is used to forfeit a turn in a game.
   // not all games technically allow this to happen, but some require it (othello)
   // the game should return whether the switch was allowed or not
   public boolean forfeitTurn();
}
