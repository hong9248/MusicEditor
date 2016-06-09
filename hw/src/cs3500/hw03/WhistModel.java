package cs3500.hw03;

import cs3500.hw02.*;

import java.util.*;


public class WhistModel extends GenericStandardDeckGame implements CardGameModel<Card> {
  protected int currentPlayerNo = 0;
  protected boolean trickStart = false;
  protected int dominatedSuit = -1;
  protected Card maxCard;
  protected int winner;
  protected List<Card> allCards = new ArrayList<Card>();
  protected int numOfPlayers = 0;

  public WhistModel() {
  }

  @Override
  public void startPlay(int numPlayers, List<Card> deck) throws IllegalArgumentException {
    this.numOfPlayers = numPlayers;
    super.startPlay(numPlayers, deck);
  }

  @Override
  public void play(int playerNo, int cardIdx) {
    if (playerNo != currentPlayerNo) {
      throw new IllegalArgumentException("Not your turn!");
    }

    if ((cardIdx < 0) || (cardIdx >= state.get(currentPlayerNo).getCards().size())) {
      throw new IllegalArgumentException("your input card index is out of bound!");
    }

    if (isGameOver()) {
      throw new IllegalArgumentException("the game is over. " +
              "Please start a new game!");
    }

    Player currentPlayer = state.get(playerNo);
    Card currentCard = currentPlayer.getCards().get(cardIdx);
    int currentSuit = currentCard.getSuitNum();
    int currentCardNumber = currentCard.getValues();

    if (!trickStart) {
      dominatedSuit = currentSuit;
      maxCard = currentCard;
      winner = playerNo;
      trickStart = true;
    } else {
      if (currentSuit != dominatedSuit) {
        if (ifHave(dominatedSuit)) {
          throw new IllegalArgumentException("Please give a card with " +
                  "the dominated suit!");
        }
      } else {
        if (maxCard.getValues() < currentCardNumber) {
          maxCard = currentCard;
          winner = playerNo;
        }
      }
    }
    currentPlayer.getCards().remove(cardIdx);
    allCards.add(currentCard);

    if (allCards.size() == numOfPlayers) {
      state.get(winner).addWin();
      trickStart = false;
      currentPlayerNo = winner;
      allCards = new ArrayList<Card>();
      numOfPlayers = 0;
      for (Player p : state) {
        if (!p.getCards().isEmpty()) {
          numOfPlayers++;
        }
      }
    } else {
      currentPlayerNo = (playerNo + 1) % state.size();
    }
  }

  protected boolean ifHave(int suit) {
    boolean i = false;
    List<Card> cards = state.get(currentPlayerNo).getCards();
    for (Card c : cards) {
      i |= c.getSuitNum() == suit;
    }
    return i;
  }

  @Override
  public int getCurrentPlayer() throws IllegalArgumentException {
    if (this.isGameOver()) {
      throw new IllegalArgumentException("Sorry, the game is over. Nobody can play the game.");
    }
    Player currentCardsInHand = state.get(currentPlayerNo);
    while (currentCardsInHand.getCards().isEmpty()) {
      currentPlayerNo = (currentPlayerNo + 1) % state.size();
      currentCardsInHand = state.get(currentPlayerNo);
    }
    return this.currentPlayerNo;
  }

  @Override
  public boolean isGameOver() {
    return numOfPlayers < 2;
  }

  @Override
  public String getGameState() {
    StringBuilder super_result = new StringBuilder(super.getGameState());
    super_result.append(this.printWins() + this.specialMessage());
    return super_result.toString();
  }

  /**
   * To print out a string that contains how many hands won each of player has
   *
   * @return contains all wins of each player
   */

  private String printWins() {
    StringBuilder s = new StringBuilder();
    for (int i = 0; i < state.size(); i++) {
      int num = i + 1;
      s.append("Player " + num + " score: ");
      s.append(state.get(i).getScore() + "\n");
    }
    return s.toString();
  }

  /**
   * To print out a string that contains whose turn it is now if the game is still going on or who
   * won the game finally if the game is over.
   *
   * @return contains all wins of each player
   */

  private String specialMessage() {
    if (isGameOver()) {
      String X = finalWinner();
      return "Game over. Player " + X + "won.";
    } else {
      return "Turn: Player " + Integer.toString(getCurrentPlayer() + 1);
    }
  }

  /**
   * To find the player who won the game finally
   *
   * @return the number of player who won the game
   */

  private String finalWinner() {
    StringBuilder s = new StringBuilder();
    List<Integer> wins = new ArrayList<Integer>();
    for (Player p : state) {
      int win = p.getScore();
      wins.add(win);
    }

    int max = Collections.max(wins);

    List<Player> winners = new ArrayList<Player>();
    for (Player p : state) {
      if (p.getScore() == max) {
        winners.add(p);
      }
    }
    int i = 0;
    for (Player w : winners) {
      int playerNo = w.getNum() + 1;
      if (i == winners.size() - 1) {
        s.append(playerNo + " ");
      } else {
        s.append(playerNo + ", ");
        i++;
      }
    }
    return s.toString();
  }
}


