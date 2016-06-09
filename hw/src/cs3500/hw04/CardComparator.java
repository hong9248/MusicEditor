package cs3500.hw04;

import java.util.*;

import cs3500.hw02.Card;

public class CardComparator implements Comparator<Card> {

  /**
   * Compare two cards and check which one should be put before the other. The order is alphabetical
   * order of suits (i.e., clubs, diamonds, hearts, spades). Within each suit, cards should be
   * ordered in descending order by number with aces being highest (A, K, Q, J, 10, ..., 2).
   *
   * @return an integer that represents the result of the two-card comparison. -1: {@code this} is
   * before {@code other} 1: {@code this} is after {@code other ) 0: The same cards. The order does
   * not matter.
   */
  @Override
  public int compare(Card card1, Card card2) {
    if (card1.getSuitNum() - card2.getSuitNum() > 0) {
      return -1;
    }
    if (card1.getSuitNum() - card2.getSuitNum() < 0) {
      return 1;
    } else {
      if (card1.getValues() - card2.getValues() > 0) {
        return -1;
      }
      if (card1.getValues() - card2.getValues() < 0) {
        return 1;
      } else {
        return 0;
      }
    }
  }
}
