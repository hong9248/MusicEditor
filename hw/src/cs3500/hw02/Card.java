package cs3500.hw02;

//Represent a standard card
public class Card implements Comparable<Card> {

  public Suit suit;
  private Value value;

  // One card consist of a value and a suit
  public Card(Value value, Suit suit) {
    this.value = value;
    this.suit = suit;
  }

  /**
   * Override the existing method equal. It is supposed to be equal as long as two cards have both
   * same suit and value.
   *
   * @param obj give the other Card.
   * @return a boolean whether or not the two objects are equal
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true; // Fast path

    if (!(obj instanceof Card)) return false; // Fast path
    Card that = (Card) obj;

    return this.value == that.value && this.suit == that.suit;
  }

  /**
   * Override the existing method hashcode.
   *
   * @return an unique number which identifies a Card
   */
  @Override
  public int hashCode() {
    int result = suit.hashCode();
    result = 31 * result + value.hashCode();
    return result;
  }

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
  public int compareTo(Card other) {
    if (this.getSuitNum() - other.getSuitNum() > 0) {
      return -1;
    }
    if (this.getSuitNum() - other.getSuitNum() < 0) {
      return 1;
    } else {
      if (this.getValues() - other.getValues() > 0) {
        return -1;
      }
      if (this.getValues() - other.getValues() < 0) {
        return 1;
      } else {
        return 0;
      }
    }
  }

  /**
   * Get a value in the enum
   *
   * @return a value in String
   */
  public String getSuitText() {
    return suit.printSuitText();
  }

  /**
   * Get a value in the enum
   *
   * @return a suit in integer
   */
  public int getSuitNum() {
    return suit.printSuitNum();
  }

  /**
   * Get a value in the enum
   *
   * @return a value in integer
   */
  public int getValues() {
    return value.printValues();
  }

  /**
   * Get a value in the enum
   *
   * @return a value in String
   */
  public String getValueString() {
    return value.printValueString();
  }

  /**
   * Show a card in strings
   *
   * @return a card in strings
   */
  public String toString() {
    return this.getValueString() + this.getSuitText();
  }


}

