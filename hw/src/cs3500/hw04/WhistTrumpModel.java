package cs3500.hw04;

import cs3500.hw02.*;

import java.util.*;

import cs3500.hw03.*;

public class WhistTrumpModel extends WhistModel {
  private Suit trumpSuit;

  public WhistTrumpModel() {
    super();
  }

  @Override
  public void startPlay(int numPlayers, List<Card> deck) throws IllegalArgumentException {
    trumpSuit = deck.get(0).suit;
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
        if (currentSuit == trumpSuit.printSuitNum()) {
          if (maxCard.getSuitNum() == trumpSuit.printSuitNum() &&
                  maxCard.getValues() < currentCardNumber) {
            maxCard = currentCard;
            winner = playerNo;
          } else {
            maxCard = currentCard;
            winner = playerNo;
          }
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

  @Override
  public String getGameState() {
    StringBuilder super_result = new StringBuilder(super.getGameState());
    if (!isGameOver()) {
      super_result.append("\nTrump suit: " + this.trumpSuit.printSuitText());
    }
    return super_result.toString();
  }
}
