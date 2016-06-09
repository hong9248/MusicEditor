package cs3500.hw03;


import cs3500.hw02.GenericCardGameModel;

public interface CardGameModel<K> extends GenericCardGameModel<K> {

  /**
   * plays the card at index {@code cardIdx} in the set of cards for player number {@code playerNo}.
   * It is assumed that both player numbers and card indices begin with 0. It is further assumed
   * that players’ hands are sorted.
   *
   * @param playerNo the number of players participating a game
   * @param cardIdx  the index of card list
   */
  void play(int playerNo, int cardIdx);

  /**
   * Get the number of player whose turn it is to play
   *
   * @return the number of player whose turn it is to play
   * @throws IllegalArgumentException if the game has ended.
   */
  int getCurrentPlayer() throws IllegalArgumentException;

  /**
   * To determine whether or not the game ends
   *
   * @return true if the game is over, false otherwise.
   */
  boolean isGameOver();
}