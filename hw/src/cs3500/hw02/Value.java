package cs3500.hw02;

public enum Value {
  ACE(14, "A"), KING(13, "K"), QUEEN(12, "Q"), JACK(11, "J"),
  TEN(10, "10"), NINE(9, "9"), EIGHT(8, "8"), SEVEN(7, "7"),
  SIX(6, "6"), FIVE(5, "5"), FOUR(4, "4"), THREE(3, "3"),
  DEUCE(2, "2");

  private final int values;
  private final String valueString;

  //Constructor
  Value(int values, String valueString) {
    this.values = values;
    this.valueString = valueString;
  }

  //Public method

  /**
   * Get the number of a value
   *
   * @return a value in int
   */
  public int printValues() {
    return values;
  }

  /**
   * Get a defied String value
   *
   * @return a value in String
   */
  public String printValueString() {
    return valueString;
  }

}

