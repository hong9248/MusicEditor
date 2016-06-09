package cs3500.hw02;

import java.util.*;

public class GenericStandardDeckGame implements GenericCardGameModel<Card> {

  protected List<Player> state = new ArrayList<Player>();

  public GenericStandardDeckGame() {
  }

  public GenericStandardDeckGame(List<Player> state) {
    this.state = state;
  }

  @Override
  public List<Card> getDeck() {
    List<Card> deck = new ArrayList<Card>();
    for (Suit s : Suit.values()) {
      for (Value v : Value.values()) {
        Card c = new Card(v, s);
        deck.add(c);
      }
    }
    return deck;
  }

  /**
   * A deck is invalid if it does not have 52 cards, or if there are duplicate cards, or if there
   * are invalid cards (invalid {@code suit} or invalid number). Here, we don't have to check if
   * there are invalid cards because we used enum for Suit and Value and have already defined all
   * the valid value and suit.
   *
   * @param cardDeck the entire deck of relevant cards
   * @return the result of whether or not the given deck is invalid.
   */
  private boolean isDeckInvalid(List<Card> cardDeck) {
    return cardDeck.size() != 52 || this.isDuplicated(cardDeck);
  }

  /**
   * A deck is invalid if there are duplicate cards.
   *
   * @param cardDeck the entire deck of relevant cards
   * @return the result of whether or not the given deck is duplicated.
   */
  private boolean isDuplicated(List<Card> cardDeck) {
    Set<Card> set = new HashSet<Card>(cardDeck);
    return set.size() < cardDeck.size();
  }

  @Override
  public void startPlay(int numPlayers, List<Card> deck) throws IllegalArgumentException {
    if (numPlayers <= 1) {
      throw new IllegalArgumentException("Illegal number of players");
    } else if (this.isDeckInvalid(deck)) {
      throw new IllegalArgumentException("Illegal deck");
    } else {
      this.startPlayHelp(numPlayers, deck);
    }
  }

  /**
   * It is supposed to distribute a given valid deck of cards in the specified order among the
   * players in round-robin fashion.
   *
   * @param numPlayers the number of players participating a game
   * @param cardDeck   the entire deck of relevant cards
   */
  private void startPlayHelp(int numPlayers, List<Card> cardDeck) {
    //Empty state
    for (int i = 0; i < numPlayers; i++) {
      List<Card> playerCards = new ArrayList<Card>();
      Player player = new Player(i, playerCards, 0);
      for (int n = i; n < cardDeck.size(); n = n + numPlayers) {
        Card c = cardDeck.get(n);
        playerCards.add(c);
      }
      state.add(player);
    }
  }

  @Override
  public String getGameState() {
    StringBuilder s = new StringBuilder();
    s.append("Number of players: " + state.size() + "\n");
    s.append(this.getGameStateHelp());
    return s.toString();
  }

  /**
   * To print out a string that contains the all cards that each of player is holding
   *
   * @return contains the entire state of the game.
   */
  private String getGameStateHelp() {
    StringBuilder s = new StringBuilder();
    int i = 0;
    for (Player p : state) {
      s.append(printPlayer(p) + "\n");
      i++;
    }
    return s.toString();
  }

  /**
   * Print out {@code this} player's {@code this.cards} as follows: Player {@code num}: cards in
   * sorted order (printed as a comma-separated list).
   *
   * @param p is going to be printed out
   * @return a String that contains {@code this} player's entire cards
   */
  private String printPlayer(Player p) {
    // create a copy of the cards
    List<Card> cardsCopy = new ArrayList<Card>();
    for (Card c : p.getCards()) {
      cardsCopy.add(c);
    }
    Collections.sort(cardsCopy);
    Player sortedPlayer = new Player(p.getNum(), cardsCopy, p.getScore());
    StringBuilder sb = new StringBuilder();
    int num = p.getNum() + 1;
    sb.append("Player " + num + ": ");
    int i = 0;
    for (Card c : sortedPlayer.getCards()) {
      if (i == p.getCards().size() - 1) {
        sb.append(c.toString());
      } else {
        sb.append(c.toString() + ", ");
        i++;
      }
    }
    return sb.toString();
  }
}
