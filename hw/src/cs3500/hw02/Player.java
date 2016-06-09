package cs3500.hw02;

import java.util.*;

public class Player {

  private int num;
  private List<Card> cards;
  private int score;

  public Player(int num, List<Card> cards, int score) {
    this.num = num;
    this.cards = cards;
    this.score = score;
  }


  /**
   * Override the existing method equal. It is supposed to be equal as long as two players have both
   * same number and cards.
   *
   * @param o give the other Card.
   * @return a boolean whether or not the two objects are equal
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Player player = (Player) o;

    if (num != player.num) return false;
    if (score != player.score) return false;
    return cards != null ? cards.equals(player.cards) : player.cards == null;

  }


  /**
   * Override the existing method hashcode.
   *
   * @return an unique number which identifies a Player
   */
  @Override
  public int hashCode() {
    int result = num;
    result = 31 * result + cards.hashCode();
    return result;
  }

  /**
   * get the cards {@code this} Player is holding.
   *
   * @return a list of cards
   */
  public List<Card> getCards() {
    return this.cards;
  }

  /**
   * get the number of  {@code this} Player.
   *
   * @return a number
   */
  public int getNum() {
    return this.num;
  }

  /**
   * get the scores  {@code this} Player has.
   *
   * @return a score
   */
  public int getScore() {
    return this.score;
  }

  /**
   * add 1 score.
   */
  public void addWin() {
    this.score++;
  }

}
