package cs3500.hw02;

public enum Suit {
  CLUBS("♣", 18),
  DIAMONDS("♦", 17),
  HEARTS("♥", 16),
  SPADES("♠", 15);

  public final String suitText;
  private final int suitNum;

  //Constructor
  Suit(String suitText, int suitNum) {
    this.suitText = suitText;
    this.suitNum = suitNum;
  }

  //Public method

  /**
   * Get a suit figure
   *
   * @return the figure of Suit
   */
  public String printSuitText() {
    return suitText;
  }

  /**
   * Get a Suit number
   *
   * @return the respective number
   */
  public int printSuitNum() {
    return suitNum;
  }
}

