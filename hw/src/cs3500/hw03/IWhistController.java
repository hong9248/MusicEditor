package cs3500.hw03;

import java.io.IOException;

public interface IWhistController {

  /**
   * It is supposed to distribute these cards in the specified order among the players in
   * round-robin fashion.
   *
   * @param numPlayers the number of players participating a game
   * @param game       a card game model
   */

  <K> void playGame(CardGameModel<K> game, int numPlayers);
}
