package cs3500.hw04;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.Reader;
import java.io.StringReader;
import java.util.*;

import cs3500.hw02.Card;
import cs3500.hw02.GenericCardGameModel;
import cs3500.hw02.GenericStandardDeckGame;
import cs3500.hw02.Player;
import cs3500.hw02.Suit;
import cs3500.hw02.Value;
import cs3500.hw03.CardGameModel;
import cs3500.hw03.WhistController;
import cs3500.hw03.WhistModel;


public class CardGameModelTest {
  //Card examples
  Card c1 = new Card(Value.ACE, Suit.CLUBS); // A♣
  Card c2 = new Card(Value.KING, Suit.CLUBS);// K♣
  Card c3 = new Card(Value.QUEEN, Suit.CLUBS);// Q♣
  Card c4 = new Card(Value.JACK, Suit.CLUBS);// J♣
  Card c5 = new Card(Value.TEN, Suit.CLUBS); // 10♣
  Card c6 = new Card(Value.NINE, Suit.CLUBS); //9♣
  Card c7 = new Card(Value.EIGHT, Suit.CLUBS);// 8♣
  Card c8 = new Card(Value.SEVEN, Suit.CLUBS);//7♣
  Card c9 = new Card(Value.SIX, Suit.CLUBS); //6♣
  Card c10 = new Card(Value.FIVE, Suit.CLUBS); //5♣
  Card c11 = new Card(Value.FOUR, Suit.CLUBS);//4♣
  Card c12 = new Card(Value.THREE, Suit.CLUBS);//3♣
  Card c13 = new Card(Value.DEUCE, Suit.CLUBS);//2♣
  Card c14 = new Card(Value.ACE, Suit.DIAMONDS);//A♦
  Card c15 = new Card(Value.KING, Suit.DIAMONDS);//K♦
  Card c16 = new Card(Value.QUEEN, Suit.DIAMONDS);//Q♦
  Card c17 = new Card(Value.JACK, Suit.DIAMONDS);//J♦
  Card c18 = new Card(Value.TEN, Suit.DIAMONDS);//10♦
  Card c19 = new Card(Value.NINE, Suit.DIAMONDS);//9♦
  Card c20 = new Card(Value.EIGHT, Suit.DIAMONDS);//8♦
  Card c21 = new Card(Value.SEVEN, Suit.DIAMONDS);//7♦
  Card c22 = new Card(Value.SIX, Suit.DIAMONDS);//6♦
  Card c23 = new Card(Value.FIVE, Suit.DIAMONDS);//5♦
  Card c24 = new Card(Value.FOUR, Suit.DIAMONDS);//4♦
  Card c25 = new Card(Value.THREE, Suit.DIAMONDS);//3♦
  Card c26 = new Card(Value.DEUCE, Suit.DIAMONDS);//2♦
  Card c27 = new Card(Value.ACE, Suit.HEARTS);//A♥
  Card c28 = new Card(Value.KING, Suit.HEARTS);//K♥
  Card c29 = new Card(Value.QUEEN, Suit.HEARTS);//Q♥
  Card c30 = new Card(Value.JACK, Suit.HEARTS);//J♥
  Card c31 = new Card(Value.TEN, Suit.HEARTS);//10♥
  Card c32 = new Card(Value.NINE, Suit.HEARTS);//9♥
  Card c33 = new Card(Value.EIGHT, Suit.HEARTS);//8♥
  Card c34 = new Card(Value.SEVEN, Suit.HEARTS);//7♥
  Card c35 = new Card(Value.SIX, Suit.HEARTS);//6♥
  Card c36 = new Card(Value.FIVE, Suit.HEARTS);//5♥
  Card c37 = new Card(Value.FOUR, Suit.HEARTS);//4♥
  Card c38 = new Card(Value.THREE, Suit.HEARTS);//3♥
  Card c39 = new Card(Value.DEUCE, Suit.HEARTS);//2♥
  Card c40 = new Card(Value.ACE, Suit.SPADES);//A♠
  Card c41 = new Card(Value.KING, Suit.SPADES);//K♠
  Card c42 = new Card(Value.QUEEN, Suit.SPADES);//Q♠
  Card c43 = new Card(Value.JACK, Suit.SPADES);//J♠
  Card c44 = new Card(Value.TEN, Suit.SPADES);//10♠
  Card c45 = new Card(Value.NINE, Suit.SPADES);//9♠
  Card c46 = new Card(Value.EIGHT, Suit.SPADES);//8♠
  Card c47 = new Card(Value.SEVEN, Suit.SPADES);//7♠
  Card c48 = new Card(Value.SIX, Suit.SPADES);//6♠
  Card c49 = new Card(Value.FIVE, Suit.SPADES);//5♠
  Card c50 = new Card(Value.FOUR, Suit.SPADES);//4♠
  Card c51 = new Card(Value.THREE, Suit.SPADES);//3♠
  Card c52 = new Card(Value.DEUCE, Suit.SPADES);//2♠

  // a standard deck
  List<Card> cards1 = new ArrayList<Card>(Arrays.asList(c1, c2, c3,
          c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15,
          c16, c17, c18, c19, c20, c21, c22, c23, c24, c25, c26,
          c27, c28, c29, c30, c31, c32, c33, c34, c35, c36, c37,
          c38, c39, c40, c41, c42, c43, c44, c45, c46, c47, c48, c49,
          c50, c51, c52));

  // a deck with 50 cards
  List<Card> cards2 = new ArrayList<Card>(Arrays.asList(c1, c2, c3,
          c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15,
          c16, c17, c18, c19, c20, c21, c22, c23, c24, c25, c26,
          c27, c28, c30, c31, c32, c33, c34, c35, c36, c37,
          c38, c39, c40, c41, c42, c43, c44, c45, c46, c48, c49,
          c50, c51, c52));

  // a deck with duplicated cards
  List<Card> cards3 = new ArrayList<Card>(Arrays.asList(c1, c2, c3,
          c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15,
          c16, c17, c18, c19, c20, c21, c22, c23, c24, c25, c26,
          c27, c28, c40, c30, c31, c32, c33, c34, c35, c36, c37,
          c38, c39, c40, c41, c42, c43, c44, c45, c46, c47, c48, c49,
          c50, c51, c52));

  // a disordered deck
  List<Card> cards4 = new ArrayList<Card>(Arrays.asList(c7, c45, c3,
          c40, c5, c6, c1, c8, c9, c29, c11, c12, c13, c14, c15,
          c16, c51, c18, c19, c20, c21, c31, c23, c24, c25, c26,
          c27, c28, c10, c30, c22, c32, c37, c34, c35, c36, c33,
          c38, c39, c4, c41, c42, c43, c44, c2, c46, c47, c48, c49,
          c50, c17, c52));

  // three players, player1
  List<Card> cards5 = new ArrayList<Card>(Arrays.asList(c1, c4, c7, c10, c13,
          c16, c19, c22, c25, c28, c31, c34, c37, c40, c43, c46, c49, c52));

  List<Card> cards8 = new ArrayList<Card>(Arrays.asList(c7, c40, c1, c29, c13,
          c16, c19, c31, c25, c28, c22, c34, c33, c4, c43, c46, c49, c52));

  // three players, player2
  List<Card> cards6 = new ArrayList<Card>(Arrays.asList(c2, c5, c8, c11, c14,
          c17, c20, c23, c26, c29, c32, c35, c38, c41, c44, c47, c50));

  List<Card> cards9 = new ArrayList<Card>(Arrays.asList(c45, c5, c8, c11, c14,
          c51, c20, c23, c26, c10, c32, c35, c38, c41, c44, c47, c50));

  // three players, player3
  List<Card> cards7 = new ArrayList<Card>(Arrays.asList(c3, c6, c9, c12, c15,
          c18, c21, c24, c27, c30, c33, c36, c39, c42, c45, c48, c51));

  List<Card> cards10 = new ArrayList<Card>(Arrays.asList(c3, c6, c9, c12, c15,
          c18, c21, c24, c27, c30, c37, c36, c39, c42, c2, c48, c17));


  //Players

  Player p1 = new Player(0, cards5, 0);
  Player p2 = new Player(1, cards6, 0);
  Player p3 = new Player(2, cards7, 0);
  Player p5 = new Player(0, cards8, 0);
  Player p6 = new Player(0, cards9, 0);
  Player p7 = new Player(0, cards10, 0);


  // A list of players
  List<Player> ps = new ArrayList<Player>(Arrays.asList(p1, p2, p3));
  List<Player> ps2 = new ArrayList<Player>(Arrays.asList(p5, p6, p7));

  //GameState

  String s1 = "Number of players: 3\n" +
          "Player 1: A♣, J♣, 8♣, 5♣, 2♣, Q♦, 9♦, 6♦, 3♦, K♥, 10♥, 7♥, 4♥, A♠, J♠, 8♠, 5♠, 2♠\n" +
          "Player 2: K♣, 10♣, 7♣, 4♣, A♦, J♦, 8♦, 5♦, 2♦, Q♥, 9♥, 6♥, 3♥, K♠, 10♠, 7♠, 4♠\n" +
          "Player 3: Q♣, 9♣, 6♣, 3♣, K♦, 10♦, 7♦, 4♦, A♥, J♥, 8♥, 5♥, 2♥, Q♠, 9♠, 6♠, 3♠\n";

  String s3 = "Number of players: 3\n" +
          "Player 1: A♣, J♣, 8♣, 2♣, Q♦, 9♦, 6♦, 3♦, K♥, Q♥, 10♥, 8♥, 7♥, A♠, J♠, 8♠, 5♠, 2♠\n" +
          "Player 2: 10♣, 7♣, 5♣, 4♣, A♦, 8♦, 5♦, 2♦, 9♥, 6♥, 3♥, K♠, 10♠, 9♠, 7♠, 4♠, 3♠\n" +
          "Player 3: K♣, Q♣, 9♣, 6♣, 3♣, K♦, J♦, 10♦, 7♦, 4♦, A♥, J♥, 5♥, 4♥, 2♥, Q♠, 6♠\n";

  String s4 = "Number of players: 4\n" +
          "Player 1: A♣, 10♣, 6♣, 2♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
          "Player 2: K♣, 9♣, 5♣, A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
          "Player 3: Q♣, 8♣, 4♣, K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
          "Player 4: J♣, 7♣, 3♣, Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n";

  String s5 = "Number of players: 3\n" +
          "Player 1: A♣, J♣, 8♣, 2♣, Q♦, 9♦, 6♦, 3♦, K♥, Q♥, 10♥, 8♥, 7♥, A♠, J♠, 8♠, 5♠, 2♠\n" +
          "Player 1: 10♣, 7♣, 5♣, 4♣, A♦, 8♦, 5♦, 2♦, 9♥, 6♥, 3♥, K♠, 10♠, 9♠, 7♠, 4♠, 3♠\n" +
          "Player 1: K♣, Q♣, 9♣, 6♣, 3♣, K♦, J♦, 10♦, 7♦, 4♦, A♥, J♥, 5♥, 4♥, 2♥, Q♠, 6♠\n";

  //Initialize a game
  GenericCardGameModel start = new GenericStandardDeckGame();
  GenericCardGameModel start1 = new GenericStandardDeckGame(ps);
  GenericCardGameModel start2 = new GenericStandardDeckGame(ps2);

  // Test Suit
  @Test
  public void testPrintSuitText() {
    assertEquals("♣",
            Suit.CLUBS.printSuitText());
  }

  @Test
  public void testPrintSuitNum() {
    assertEquals(18,
            Suit.CLUBS.printSuitNum());
  }

  //Test Value
  @Test
  public void testPrintValues() {
    assertEquals(14,
            Value.ACE.printValues());
  }

  @Test
  public void testPrintValue() {
    assertEquals("A",
            Value.ACE.printValueString());
  }

  //Test Card

  @Test
  public void testGetSuit() {
    assertEquals("♣",
            c1.getSuitText());
  }

  @Test
  public void testGetSuitNum() {
    assertEquals(18,
            c1.getSuitNum());
  }

  @Test
  public void testGetValue() {
    assertEquals(14,
            c1.getValues());
  }

  @Test
  public void testGetValueAsString() {
    assertEquals("A",
            c1.getValueString());
  }

  @Test
  public void testToString() {
    assertEquals("A♣",
            c1.toString());
  }

  //Test Player
  @Test
  public void testGetCards() {
    assertEquals(cards5,
            p1.getCards());
  }

  @Test
  public void testGetNum() {
    assertEquals(0,
            p1.getNum());
  }

  @Test
  public void testGetScore() {
    assertEquals(0,
            p1.getScore());
  }

  @Test
  public void testAddWin() {
    assertEquals(0,
            p1.getScore());
    p1.addWin();
    assertEquals(1,
            p1.getScore());
  }


  // Test getDeck
  @Test
  public void testGetDeck() {
    assertEquals(cards1,
            start.getDeck());
  }

  @Test
  public void testSizeOfDeck() {
    List<?> deck = start.getDeck();
    assertEquals(52, deck.size());
  }

  //Test the exception if a given deck does not contain 52 cards
  @Test(expected = IllegalArgumentException.class)
  public void testStartPlay1() {
    start.startPlay(5, cards2);
  }


  //Test the exception if a game with less 2 players
  @Test(expected = IllegalArgumentException.class)
  public void testStartPlay2() {
    start.startPlay(1, cards1);
  }


  @Test(expected = IllegalArgumentException.class)
  public void testStartPlay3() {
    start.startPlay(0, cards1);
  }

  //Test the exception if a given deck contain duplicated cards
  @Test(expected = IllegalArgumentException.class)
  public void testStartPlay4() {
    start.startPlay(5, cards3);
  }


  /*Test two cards with same suits but different value, and {@code this} card should be after
  *{@code other} Card
  */
  @Test
  public void testCompare1() {
    assertEquals(1,
            c2.compareTo(c1));
  }

  /*Test two cards with same suits but different value, and {@code this} card should be before
  *{@code other} Card
  */
  @Test
  public void testCompare2() {
    assertEquals(-1,
            c1.compareTo(c2));
  }

  /*Test two cards with same value but different suit, and {@code this} card should be after
  *{@code other} Card
  */
  @Test
  public void testCompare3() {
    assertEquals(1,
            c46.compareTo(c20));
  }

  /*Test two Cards with same value but different suit, and {@code this} card should be before
  *{@code other} Card
  */
  @Test
  public void testCompare4() {
    assertEquals(-1,
            c20.compareTo(c46));
  }

  /*Test two cards with both different suits and values, and {@code this} card should be after
  *{@code other} Card
  */
  @Test
  public void testCompare5() {
    assertEquals(1,
            c20.compareTo(c1));
  }

  /*Test two cards with both different suits and values, and {@code this} card should be before
  {@code other} Card
  */
  @Test
  public void testCompare6() {
    assertEquals(-1,
            c1.compareTo(c20));
  }

  //Test two same cards
  @Test
  public void testCompare7() {
    assertEquals(0,
            c1.compareTo(c1));
  }


  //Test getGameState
  @Test
  public void testGetGameState() {
    assertEquals(s1,
            start1.getGameState());
  }

  // If cards represented in correct order
  @Test
  public void testGetGameState1() {
    assertEquals(s5,
            start2.getGameState());
  }

  //Test startPlay through getGameState
  @Test
  public void testStartPlay() {
    start.startPlay(3, cards1);
    assertEquals(s1,
            start.getGameState());
  }

  //Test a game with three players
  @Test
  public void testGame() {
    List<Card> deck = start.getDeck();
    start.startPlay(3, deck);
    assertEquals(s1,
            start.getGameState());
  }

  //Test a game with four players
  @Test
  public void testGame1() {
    List<Card> deck = start.getDeck();
    start.startPlay(4, deck);
    assertEquals(s4,
            start.getGameState());
  }

  //Whether or not the cards are sorted after shuffling the deck
  @Test
  public void testGame2() {
    List<Card> deck = start.getDeck();
    Collections.swap(deck, 0, 6);
    Collections.swap(deck, 1, 44);
    Collections.swap(deck, 3, 39);
    Collections.swap(deck, 9, 28);
    Collections.swap(deck, 16, 50);
    Collections.swap(deck, 21, 30);
    Collections.swap(deck, 32, 36);
    start.startPlay(3, deck);
    assertEquals(s3,
            start.getGameState());
  }

  //revise homework 2
  @Test
  public void testGame3() {
    try {
      start.startPlay(0, cards1);
    } catch (IllegalArgumentException e) {
      start.getGameState();
    }
  }

  //WhistModelTest
  //GameState
  String s6 = "Number of players: 3\n" +
          "Player 1: A♣, J♣, 8♣, 5♣, 2♣, Q♦, 9♦, 6♦, 3♦, K♥, 10♥, 7♥, 4♥, A♠, J♠, 8♠, 5♠, 2♠\n" +
          "Player 2: K♣, 10♣, 7♣, 4♣, A♦, J♦, 8♦, 5♦, 2♦, Q♥, 9♥, 6♥, 3♥, K♠, 10♠, 7♠, 4♠\n" +
          "Player 3: Q♣, 9♣, 6♣, 3♣, K♦, 10♦, 7♦, 4♦, A♥, J♥, 8♥, 5♥, 2♥, Q♠, 9♠, 6♠, 3♠\n" +
          "Player 1 score: 0\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Turn: Player 1";

  String s7 = "Number of players: 3\n" +
          "Player 1: 2♠\n" +
          "Player 2: \n" +
          "Player 3: \n" +
          "Player 1 score: 17\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Game over. Player 1 won.";

  String s8 = "Number of players: 3\n" +
          "Player 1: A♣, J♣, 8♣, 5♣, 2♣, 9♦, 6♦, 3♦, K♥, 10♥, 7♥, 4♥, A♠, J♠, 8♠, 5♠, 2♠\n" +
          "Player 2: K♣, 10♣, 7♣, 4♣, A♦, J♦, 8♦, 5♦, 2♦, Q♥, 9♥, 6♥, 3♥, K♠, 10♠, 7♠, 4♠\n" +
          "Player 3: Q♣, 9♣, 6♣, 3♣, K♦, 10♦, 7♦, 4♦, A♥, J♥, 8♥, 5♥, 2♥, Q♠, 9♠, 6♠, 3♠\n" +
          "Player 1 score: 0\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Turn: Player 2";

  // Initialize WhistModel
  CardGameModel<Card> startW = new WhistModel();

  // Test isGameOver
  @Test
  public void testGameOver1() {
    assertTrue(startW.isGameOver());
  }

  @Test
  public void testGameOver2() {
    startW.startPlay(3, startW.getDeck());
    assertFalse(startW.isGameOver());
  }

  // Test getCurrentPlayer
  @Test
  public void testGetCurrentPlayer() {
    startW.startPlay(3, startW.getDeck());
    assertEquals(0, startW.getCurrentPlayer());
    startW.play(startW.getCurrentPlayer(), 0);
    assertEquals(1, startW.getCurrentPlayer());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetCurrentPlayer2() {
    List<Card> cardDeck = startW.getDeck();
    startW.startPlay(3, cardDeck);
    int n = 0;
    for (int i = 0; n < 51; i = (i + 1) % 3) {
      startW.play(i, 0);
      n++;
    }
    startW.getCurrentPlayer();
  }

  // Test Play
  //Not the current Player
  @Test(expected = IllegalArgumentException.class)
  public void testPlay() {
    List<Card> deck = startW.getDeck();
    startW.startPlay(3, deck);
    startW.play(1, 5);
  }

  // Not playing valid card
  @Test(expected = IllegalArgumentException.class)
  public void testPlay2() {
    List<Card> deck = startW.getDeck();
    startW.startPlay(3, deck);
    startW.play(0, 0);
    startW.play(1, 10);
  }

  //Can't play when the game is over
  @Test(expected = IllegalArgumentException.class)
  public void testPlay3() {
    List<Card> cardDeck = startW.getDeck();
    startW.startPlay(3, cardDeck);
    int n = 0;
    for (int i = 0; n < 51; i = (i + 1) % 3) {
      startW.play(i, 0);
      n++;
    }
    startW.play(0, 0);
  }

  // The card is out of the bound
  @Test(expected = IllegalArgumentException.class)
  public void testPlay4() {
    List<Card> deck = startW.getDeck();
    startW.startPlay(3, deck);
    startW.play(0, 30);
  }

  // Test play can correctly show who plays next
  @Test
  public void testPlay5() {
    StringBuilder sb = new StringBuilder();
    List<Integer> input = new ArrayList<Integer>();
    List<Card> cardDeck = startW.getDeck();
    startW.startPlay(4, cardDeck);
    assertEquals(0, startW.getCurrentPlayer());
    for (int i = 0; i < 11; i++) {
      input.add(10);
    }
    input.add(9);
    input.add(9);
    for (int i = 0; i < 13; i++) {
      input.add(0);
    }
    input.add(6);
    input.add(6);
    for (int i = 0; i < 12; i++) {
      input.add(0);
    }
    input.add(1);
    for (int i = 0; i < 4; i++) {
      input.add(0);
    }
    for (int i = 0; i < 3; i++) {
      input.add(1);
    }
    for (int i = 0; i < 4; i++) {
      input.add(0);
    }
    for (Integer i : input) {
      sb.append(startW.getCurrentPlayer());
      startW.play(startW.getCurrentPlayer(), i);
    }
    assertEquals("0123012301233012301230123012301212301230123023012301", sb.toString());
  }


  // Test GetGameState
  //start game
  @Test
  public void testNewGetGameState() {
    List<Card> deck = startW.getDeck();
    startW.startPlay(3, deck);
    assertEquals(s6,
            startW.getGameState());
  }

  // game is over
  @Test
  public void testGetGameState2() {
    List<Card> cardDeck = startW.getDeck();
    startW.startPlay(3, cardDeck);
    int n = 0;
    for (int i = 0; n < 51; i = (i + 1) % 3) {
      startW.play(i, 0);
      n++;
    }
    assertEquals(s7,
            startW.getGameState());
  }

  // In the game
  @Test
  public void testGetGameState3() {
    List<Card> deck = startW.getDeck();
    startW.startPlay(3, deck);
    startW.play(0, 5);
    assertEquals(s8,
            startW.getGameState());
  }

  //WhistControllerTest
  // Initialize WhistModel
  CardGameModel<Card> startW1 = null;

  // Game states
  String pl3 = "Number of players: 3\n" +
          "Player 1: A♣, J♣, 8♣, 5♣, 2♣, Q♦, 9♦, 6♦, 3♦, K♥, 10♥, 7♥, 4♥, A♠, J♠, 8♠, 5♠, 2♠\n" +
          "Player 2: K♣, 10♣, 7♣, 4♣, A♦, J♦, 8♦, 5♦, 2♦, Q♥, 9♥, 6♥, 3♥, K♠, 10♠, 7♠, 4♠\n" +
          "Player 3: Q♣, 9♣, 6♣, 3♣, K♦, 10♦, 7♦, 4♦, A♥, J♥, 8♥, 5♥, 2♥, Q♠, 9♠, 6♠, 3♠\n" +
          "Player 1 score: 0\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Turn: Player 1\n" +
          "Which card do you want to play?\n" +
          "Number of players: 3\n" +
          "Player 1: J♣, 8♣, 5♣, 2♣, Q♦, 9♦, 6♦, 3♦, K♥, 10♥, 7♥, 4♥, A♠, J♠, 8♠, 5♠, 2♠\n" +
          "Player 2: K♣, 10♣, 7♣, 4♣, A♦, J♦, 8♦, 5♦, 2♦, Q♥, 9♥, 6♥, 3♥, K♠, 10♠, 7♠, 4♠\n" +
          "Player 3: Q♣, 9♣, 6♣, 3♣, K♦, 10♦, 7♦, 4♦, A♥, J♥, 8♥, 5♥, 2♥, Q♠, 9♠, 6♠, 3♠\n" +
          "Player 1 score: 0\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Turn: Player 2\n" +
          "Which card do you want to play?\n" +
          "Number of players: 3\n" +
          "Player 1: J♣, 8♣, 5♣, 2♣, Q♦, 9♦, 6♦, 3♦, K♥, 10♥, 7♥, 4♥, A♠, J♠, 8♠, 5♠, 2♠\n" +
          "Player 2: 10♣, 7♣, 4♣, A♦, J♦, 8♦, 5♦, 2♦, Q♥, 9♥, 6♥, 3♥, K♠, 10♠, 7♠, 4♠\n" +
          "Player 3: Q♣, 9♣, 6♣, 3♣, K♦, 10♦, 7♦, 4♦, A♥, J♥, 8♥, 5♥, 2♥, Q♠, 9♠, 6♠, 3♠\n" +
          "Player 1 score: 0\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Turn: Player 3\n" +
          "Which card do you want to play?\n" +
          "Number of players: 3\n" +
          "Player 1: J♣, 8♣, 5♣, 2♣, Q♦, 9♦, 6♦, 3♦, K♥, 10♥, 7♥, 4♥, A♠, J♠, 8♠, 5♠, 2♠\n" +
          "Player 2: 10♣, 7♣, 4♣, A♦, J♦, 8♦, 5♦, 2♦, Q♥, 9♥, 6♥, 3♥, K♠, 10♠, 7♠, 4♠\n" +
          "Player 3: 9♣, 6♣, 3♣, K♦, 10♦, 7♦, 4♦, A♥, J♥, 8♥, 5♥, 2♥, Q♠, 9♠, 6♠, 3♠\n" +
          "Player 1 score: 1\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Turn: Player 1\n" +
          "Which card do you want to play?\n" +
          "Number of players: 3\n" +
          "Player 1: 8♣, 5♣, 2♣, Q♦, 9♦, 6♦, 3♦, K♥, 10♥, 7♥, 4♥, A♠, J♠, 8♠, 5♠, 2♠\n" +
          "Player 2: 10♣, 7♣, 4♣, A♦, J♦, 8♦, 5♦, 2♦, Q♥, 9♥, 6♥, 3♥, K♠, 10♠, 7♠, 4♠\n" +
          "Player 3: 9♣, 6♣, 3♣, K♦, 10♦, 7♦, 4♦, A♥, J♥, 8♥, 5♥, 2♥, Q♠, 9♠, 6♠, 3♠\n" +
          "Player 1 score: 1\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Turn: Player 2\n" +
          "Which card do you want to play?\n" +
          "Number of players: 3\n" +
          "Player 1: 8♣, 5♣, 2♣, Q♦, 9♦, 6♦, 3♦, K♥, 10♥, 7♥, 4♥, A♠, J♠, 8♠, 5♠, 2♠\n" +
          "Player 2: 7♣, 4♣, A♦, J♦, 8♦, 5♦, 2♦, Q♥, 9♥, 6♥, 3♥, K♠, 10♠, 7♠, 4♠\n" +
          "Player 3: 9♣, 6♣, 3♣, K♦, 10♦, 7♦, 4♦, A♥, J♥, 8♥, 5♥, 2♥, Q♠, 9♠, 6♠, 3♠\n" +
          "Player 1 score: 1\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Turn: Player 3\n" +
          "Which card do you want to play?\n" +
          "Number of players: 3\n" +
          "Player 1: 8♣, 5♣, 2♣, Q♦, 9♦, 6♦, 3♦, K♥, 10♥, 7♥, 4♥, A♠, J♠, 8♠, 5♠, 2♠\n" +
          "Player 2: 7♣, 4♣, A♦, J♦, 8♦, 5♦, 2♦, Q♥, 9♥, 6♥, 3♥, K♠, 10♠, 7♠, 4♠\n" +
          "Player 3: 6♣, 3♣, K♦, 10♦, 7♦, 4♦, A♥, J♥, 8♥, 5♥, 2♥, Q♠, 9♠, 6♠, 3♠\n" +
          "Player 1 score: 2\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Turn: Player 1\n" +
          "Which card do you want to play?\n" +
          "Number of players: 3\n" +
          "Player 1: 5♣, 2♣, Q♦, 9♦, 6♦, 3♦, K♥, 10♥, 7♥, 4♥, A♠, J♠, 8♠, 5♠, 2♠\n" +
          "Player 2: 7♣, 4♣, A♦, J♦, 8♦, 5♦, 2♦, Q♥, 9♥, 6♥, 3♥, K♠, 10♠, 7♠, 4♠\n" +
          "Player 3: 6♣, 3♣, K♦, 10♦, 7♦, 4♦, A♥, J♥, 8♥, 5♥, 2♥, Q♠, 9♠, 6♠, 3♠\n" +
          "Player 1 score: 2\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Turn: Player 2\n" +
          "Which card do you want to play?\n" +
          "Number of players: 3\n" +
          "Player 1: 5♣, 2♣, Q♦, 9♦, 6♦, 3♦, K♥, 10♥, 7♥, 4♥, A♠, J♠, 8♠, 5♠, 2♠\n" +
          "Player 2: 4♣, A♦, J♦, 8♦, 5♦, 2♦, Q♥, 9♥, 6♥, 3♥, K♠, 10♠, 7♠, 4♠\n" +
          "Player 3: 6♣, 3♣, K♦, 10♦, 7♦, 4♦, A♥, J♥, 8♥, 5♥, 2♥, Q♠, 9♠, 6♠, 3♠\n" +
          "Player 1 score: 2\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Turn: Player 3\n" +
          "Which card do you want to play?\n" +
          "Number of players: 3\n" +
          "Player 1: 5♣, 2♣, Q♦, 9♦, 6♦, 3♦, K♥, 10♥, 7♥, 4♥, A♠, J♠, 8♠, 5♠, 2♠\n" +
          "Player 2: 4♣, A♦, J♦, 8♦, 5♦, 2♦, Q♥, 9♥, 6♥, 3♥, K♠, 10♠, 7♠, 4♠\n" +
          "Player 3: 3♣, K♦, 10♦, 7♦, 4♦, A♥, J♥, 8♥, 5♥, 2♥, Q♠, 9♠, 6♠, 3♠\n" +
          "Player 1 score: 3\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Turn: Player 1\n" +
          "Which card do you want to play?\n" +
          "Number of players: 3\n" +
          "Player 1: 2♣, Q♦, 9♦, 6♦, 3♦, K♥, 10♥, 7♥, 4♥, A♠, J♠, 8♠, 5♠, 2♠\n" +
          "Player 2: 4♣, A♦, J♦, 8♦, 5♦, 2♦, Q♥, 9♥, 6♥, 3♥, K♠, 10♠, 7♠, 4♠\n" +
          "Player 3: 3♣, K♦, 10♦, 7♦, 4♦, A♥, J♥, 8♥, 5♥, 2♥, Q♠, 9♠, 6♠, 3♠\n" +
          "Player 1 score: 3\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Turn: Player 2\n" +
          "Which card do you want to play?\n" +
          "Number of players: 3\n" +
          "Player 1: 2♣, Q♦, 9♦, 6♦, 3♦, K♥, 10♥, 7♥, 4♥, A♠, J♠, 8♠, 5♠, 2♠\n" +
          "Player 2: A♦, J♦, 8♦, 5♦, 2♦, Q♥, 9♥, 6♥, 3♥, K♠, 10♠, 7♠, 4♠\n" +
          "Player 3: 3♣, K♦, 10♦, 7♦, 4♦, A♥, J♥, 8♥, 5♥, 2♥, Q♠, 9♠, 6♠, 3♠\n" +
          "Player 1 score: 3\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Turn: Player 3\n" +
          "Which card do you want to play?\n" +
          "Number of players: 3\n" +
          "Player 1: 2♣, Q♦, 9♦, 6♦, 3♦, K♥, 10♥, 7♥, 4♥, A♠, J♠, 8♠, 5♠, 2♠\n" +
          "Player 2: A♦, J♦, 8♦, 5♦, 2♦, Q♥, 9♥, 6♥, 3♥, K♠, 10♠, 7♠, 4♠\n" +
          "Player 3: K♦, 10♦, 7♦, 4♦, A♥, J♥, 8♥, 5♥, 2♥, Q♠, 9♠, 6♠, 3♠\n" +
          "Player 1 score: 4\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Turn: Player 1\n" +
          "Which card do you want to play?\n" +
          "Number of players: 3\n" +
          "Player 1: Q♦, 9♦, 6♦, 3♦, K♥, 10♥, 7♥, 4♥, A♠, J♠, 8♠, 5♠, 2♠\n" +
          "Player 2: A♦, J♦, 8♦, 5♦, 2♦, Q♥, 9♥, 6♥, 3♥, K♠, 10♠, 7♠, 4♠\n" +
          "Player 3: K♦, 10♦, 7♦, 4♦, A♥, J♥, 8♥, 5♥, 2♥, Q♠, 9♠, 6♠, 3♠\n" +
          "Player 1 score: 4\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Turn: Player 2\n" +
          "Which card do you want to play?\n" +
          "Number of players: 3\n" +
          "Player 1: Q♦, 9♦, 6♦, 3♦, K♥, 10♥, 7♥, 4♥, A♠, J♠, 8♠, 5♠, 2♠\n" +
          "Player 2: J♦, 8♦, 5♦, 2♦, Q♥, 9♥, 6♥, 3♥, K♠, 10♠, 7♠, 4♠\n" +
          "Player 3: K♦, 10♦, 7♦, 4♦, A♥, J♥, 8♥, 5♥, 2♥, Q♠, 9♠, 6♠, 3♠\n" +
          "Player 1 score: 4\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Turn: Player 3\n" +
          "Which card do you want to play?\n" +
          "Number of players: 3\n" +
          "Player 1: Q♦, 9♦, 6♦, 3♦, K♥, 10♥, 7♥, 4♥, A♠, J♠, 8♠, 5♠, 2♠\n" +
          "Player 2: J♦, 8♦, 5♦, 2♦, Q♥, 9♥, 6♥, 3♥, K♠, 10♠, 7♠, 4♠\n" +
          "Player 3: 10♦, 7♦, 4♦, A♥, J♥, 8♥, 5♥, 2♥, Q♠, 9♠, 6♠, 3♠\n" +
          "Player 1 score: 5\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Turn: Player 1\n" +
          "Which card do you want to play?\n" +
          "Number of players: 3\n" +
          "Player 1: 9♦, 6♦, 3♦, K♥, 10♥, 7♥, 4♥, A♠, J♠, 8♠, 5♠, 2♠\n" +
          "Player 2: J♦, 8♦, 5♦, 2♦, Q♥, 9♥, 6♥, 3♥, K♠, 10♠, 7♠, 4♠\n" +
          "Player 3: 10♦, 7♦, 4♦, A♥, J♥, 8♥, 5♥, 2♥, Q♠, 9♠, 6♠, 3♠\n" +
          "Player 1 score: 5\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Turn: Player 2\n" +
          "Which card do you want to play?\n" +
          "Number of players: 3\n" +
          "Player 1: 9♦, 6♦, 3♦, K♥, 10♥, 7♥, 4♥, A♠, J♠, 8♠, 5♠, 2♠\n" +
          "Player 2: 8♦, 5♦, 2♦, Q♥, 9♥, 6♥, 3♥, K♠, 10♠, 7♠, 4♠\n" +
          "Player 3: 10♦, 7♦, 4♦, A♥, J♥, 8♥, 5♥, 2♥, Q♠, 9♠, 6♠, 3♠\n" +
          "Player 1 score: 5\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Turn: Player 3\n" +
          "Which card do you want to play?\n" +
          "Number of players: 3\n" +
          "Player 1: 9♦, 6♦, 3♦, K♥, 10♥, 7♥, 4♥, A♠, J♠, 8♠, 5♠, 2♠\n" +
          "Player 2: 8♦, 5♦, 2♦, Q♥, 9♥, 6♥, 3♥, K♠, 10♠, 7♠, 4♠\n" +
          "Player 3: 7♦, 4♦, A♥, J♥, 8♥, 5♥, 2♥, Q♠, 9♠, 6♠, 3♠\n" +
          "Player 1 score: 6\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Turn: Player 1\n" +
          "Which card do you want to play?\n" +
          "Number of players: 3\n" +
          "Player 1: 6♦, 3♦, K♥, 10♥, 7♥, 4♥, A♠, J♠, 8♠, 5♠, 2♠\n" +
          "Player 2: 8♦, 5♦, 2♦, Q♥, 9♥, 6♥, 3♥, K♠, 10♠, 7♠, 4♠\n" +
          "Player 3: 7♦, 4♦, A♥, J♥, 8♥, 5♥, 2♥, Q♠, 9♠, 6♠, 3♠\n" +
          "Player 1 score: 6\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Turn: Player 2\n" +
          "Which card do you want to play?\n" +
          "Number of players: 3\n" +
          "Player 1: 6♦, 3♦, K♥, 10♥, 7♥, 4♥, A♠, J♠, 8♠, 5♠, 2♠\n" +
          "Player 2: 5♦, 2♦, Q♥, 9♥, 6♥, 3♥, K♠, 10♠, 7♠, 4♠\n" +
          "Player 3: 7♦, 4♦, A♥, J♥, 8♥, 5♥, 2♥, Q♠, 9♠, 6♠, 3♠\n" +
          "Player 1 score: 6\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Turn: Player 3\n" +
          "Which card do you want to play?\n" +
          "Number of players: 3\n" +
          "Player 1: 6♦, 3♦, K♥, 10♥, 7♥, 4♥, A♠, J♠, 8♠, 5♠, 2♠\n" +
          "Player 2: 5♦, 2♦, Q♥, 9♥, 6♥, 3♥, K♠, 10♠, 7♠, 4♠\n" +
          "Player 3: 4♦, A♥, J♥, 8♥, 5♥, 2♥, Q♠, 9♠, 6♠, 3♠\n" +
          "Player 1 score: 7\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Turn: Player 1\n" +
          "Which card do you want to play?\n" +
          "Number of players: 3\n" +
          "Player 1: 3♦, K♥, 10♥, 7♥, 4♥, A♠, J♠, 8♠, 5♠, 2♠\n" +
          "Player 2: 5♦, 2♦, Q♥, 9♥, 6♥, 3♥, K♠, 10♠, 7♠, 4♠\n" +
          "Player 3: 4♦, A♥, J♥, 8♥, 5♥, 2♥, Q♠, 9♠, 6♠, 3♠\n" +
          "Player 1 score: 7\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Turn: Player 2\n" +
          "Which card do you want to play?\n" +
          "Number of players: 3\n" +
          "Player 1: 3♦, K♥, 10♥, 7♥, 4♥, A♠, J♠, 8♠, 5♠, 2♠\n" +
          "Player 2: 2♦, Q♥, 9♥, 6♥, 3♥, K♠, 10♠, 7♠, 4♠\n" +
          "Player 3: 4♦, A♥, J♥, 8♥, 5♥, 2♥, Q♠, 9♠, 6♠, 3♠\n" +
          "Player 1 score: 7\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Turn: Player 3\n" +
          "Which card do you want to play?\n" +
          "Number of players: 3\n" +
          "Player 1: 3♦, K♥, 10♥, 7♥, 4♥, A♠, J♠, 8♠, 5♠, 2♠\n" +
          "Player 2: 2♦, Q♥, 9♥, 6♥, 3♥, K♠, 10♠, 7♠, 4♠\n" +
          "Player 3: A♥, J♥, 8♥, 5♥, 2♥, Q♠, 9♠, 6♠, 3♠\n" +
          "Player 1 score: 8\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Turn: Player 1\n" +
          "Which card do you want to play?\n" +
          "Number of players: 3\n" +
          "Player 1: K♥, 10♥, 7♥, 4♥, A♠, J♠, 8♠, 5♠, 2♠\n" +
          "Player 2: 2♦, Q♥, 9♥, 6♥, 3♥, K♠, 10♠, 7♠, 4♠\n" +
          "Player 3: A♥, J♥, 8♥, 5♥, 2♥, Q♠, 9♠, 6♠, 3♠\n" +
          "Player 1 score: 8\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Turn: Player 2\n" +
          "Which card do you want to play?\n" +
          "Number of players: 3\n" +
          "Player 1: K♥, 10♥, 7♥, 4♥, A♠, J♠, 8♠, 5♠, 2♠\n" +
          "Player 2: Q♥, 9♥, 6♥, 3♥, K♠, 10♠, 7♠, 4♠\n" +
          "Player 3: A♥, J♥, 8♥, 5♥, 2♥, Q♠, 9♠, 6♠, 3♠\n" +
          "Player 1 score: 8\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Turn: Player 3\n" +
          "Which card do you want to play?\n" +
          "Number of players: 3\n" +
          "Player 1: K♥, 10♥, 7♥, 4♥, A♠, J♠, 8♠, 5♠, 2♠\n" +
          "Player 2: Q♥, 9♥, 6♥, 3♥, K♠, 10♠, 7♠, 4♠\n" +
          "Player 3: J♥, 8♥, 5♥, 2♥, Q♠, 9♠, 6♠, 3♠\n" +
          "Player 1 score: 9\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Turn: Player 1\n" +
          "Which card do you want to play?\n" +
          "Number of players: 3\n" +
          "Player 1: 10♥, 7♥, 4♥, A♠, J♠, 8♠, 5♠, 2♠\n" +
          "Player 2: Q♥, 9♥, 6♥, 3♥, K♠, 10♠, 7♠, 4♠\n" +
          "Player 3: J♥, 8♥, 5♥, 2♥, Q♠, 9♠, 6♠, 3♠\n" +
          "Player 1 score: 9\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Turn: Player 2\n" +
          "Which card do you want to play?\n" +
          "Number of players: 3\n" +
          "Player 1: 10♥, 7♥, 4♥, A♠, J♠, 8♠, 5♠, 2♠\n" +
          "Player 2: 9♥, 6♥, 3♥, K♠, 10♠, 7♠, 4♠\n" +
          "Player 3: J♥, 8♥, 5♥, 2♥, Q♠, 9♠, 6♠, 3♠\n" +
          "Player 1 score: 9\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Turn: Player 3\n" +
          "Which card do you want to play?\n" +
          "Number of players: 3\n" +
          "Player 1: 10♥, 7♥, 4♥, A♠, J♠, 8♠, 5♠, 2♠\n" +
          "Player 2: 9♥, 6♥, 3♥, K♠, 10♠, 7♠, 4♠\n" +
          "Player 3: 8♥, 5♥, 2♥, Q♠, 9♠, 6♠, 3♠\n" +
          "Player 1 score: 10\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Turn: Player 1\n" +
          "Which card do you want to play?\n" +
          "Number of players: 3\n" +
          "Player 1: 7♥, 4♥, A♠, J♠, 8♠, 5♠, 2♠\n" +
          "Player 2: 9♥, 6♥, 3♥, K♠, 10♠, 7♠, 4♠\n" +
          "Player 3: 8♥, 5♥, 2♥, Q♠, 9♠, 6♠, 3♠\n" +
          "Player 1 score: 10\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Turn: Player 2\n" +
          "Which card do you want to play?\n" +
          "Number of players: 3\n" +
          "Player 1: 7♥, 4♥, A♠, J♠, 8♠, 5♠, 2♠\n" +
          "Player 2: 6♥, 3♥, K♠, 10♠, 7♠, 4♠\n" +
          "Player 3: 8♥, 5♥, 2♥, Q♠, 9♠, 6♠, 3♠\n" +
          "Player 1 score: 10\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Turn: Player 3\n" +
          "Which card do you want to play?\n" +
          "Number of players: 3\n" +
          "Player 1: 7♥, 4♥, A♠, J♠, 8♠, 5♠, 2♠\n" +
          "Player 2: 6♥, 3♥, K♠, 10♠, 7♠, 4♠\n" +
          "Player 3: 5♥, 2♥, Q♠, 9♠, 6♠, 3♠\n" +
          "Player 1 score: 11\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Turn: Player 1\n" +
          "Which card do you want to play?\n" +
          "Number of players: 3\n" +
          "Player 1: 4♥, A♠, J♠, 8♠, 5♠, 2♠\n" +
          "Player 2: 6♥, 3♥, K♠, 10♠, 7♠, 4♠\n" +
          "Player 3: 5♥, 2♥, Q♠, 9♠, 6♠, 3♠\n" +
          "Player 1 score: 11\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Turn: Player 2\n" +
          "Which card do you want to play?\n" +
          "Number of players: 3\n" +
          "Player 1: 4♥, A♠, J♠, 8♠, 5♠, 2♠\n" +
          "Player 2: 3♥, K♠, 10♠, 7♠, 4♠\n" +
          "Player 3: 5♥, 2♥, Q♠, 9♠, 6♠, 3♠\n" +
          "Player 1 score: 11\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Turn: Player 3\n" +
          "Which card do you want to play?\n" +
          "Number of players: 3\n" +
          "Player 1: 4♥, A♠, J♠, 8♠, 5♠, 2♠\n" +
          "Player 2: 3♥, K♠, 10♠, 7♠, 4♠\n" +
          "Player 3: 2♥, Q♠, 9♠, 6♠, 3♠\n" +
          "Player 1 score: 12\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Turn: Player 1\n" +
          "Which card do you want to play?\n" +
          "Number of players: 3\n" +
          "Player 1: A♠, J♠, 8♠, 5♠, 2♠\n" +
          "Player 2: 3♥, K♠, 10♠, 7♠, 4♠\n" +
          "Player 3: 2♥, Q♠, 9♠, 6♠, 3♠\n" +
          "Player 1 score: 12\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Turn: Player 2\n" +
          "Which card do you want to play?\n" +
          "Number of players: 3\n" +
          "Player 1: A♠, J♠, 8♠, 5♠, 2♠\n" +
          "Player 2: K♠, 10♠, 7♠, 4♠\n" +
          "Player 3: 2♥, Q♠, 9♠, 6♠, 3♠\n" +
          "Player 1 score: 12\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Turn: Player 3\n" +
          "Which card do you want to play?\n" +
          "Number of players: 3\n" +
          "Player 1: A♠, J♠, 8♠, 5♠, 2♠\n" +
          "Player 2: K♠, 10♠, 7♠, 4♠\n" +
          "Player 3: Q♠, 9♠, 6♠, 3♠\n" +
          "Player 1 score: 13\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Turn: Player 1\n" +
          "Which card do you want to play?\n" +
          "Number of players: 3\n" +
          "Player 1: J♠, 8♠, 5♠, 2♠\n" +
          "Player 2: K♠, 10♠, 7♠, 4♠\n" +
          "Player 3: Q♠, 9♠, 6♠, 3♠\n" +
          "Player 1 score: 13\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Turn: Player 2\n" +
          "Which card do you want to play?\n" +
          "Number of players: 3\n" +
          "Player 1: J♠, 8♠, 5♠, 2♠\n" +
          "Player 2: 10♠, 7♠, 4♠\n" +
          "Player 3: Q♠, 9♠, 6♠, 3♠\n" +
          "Player 1 score: 13\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Turn: Player 3\n" +
          "Which card do you want to play?\n" +
          "Number of players: 3\n" +
          "Player 1: J♠, 8♠, 5♠, 2♠\n" +
          "Player 2: 10♠, 7♠, 4♠\n" +
          "Player 3: 9♠, 6♠, 3♠\n" +
          "Player 1 score: 14\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Turn: Player 1\n" +
          "Which card do you want to play?\n" +
          "Number of players: 3\n" +
          "Player 1: 8♠, 5♠, 2♠\n" +
          "Player 2: 10♠, 7♠, 4♠\n" +
          "Player 3: 9♠, 6♠, 3♠\n" +
          "Player 1 score: 14\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Turn: Player 2\n" +
          "Which card do you want to play?\n" +
          "Number of players: 3\n" +
          "Player 1: 8♠, 5♠, 2♠\n" +
          "Player 2: 7♠, 4♠\n" +
          "Player 3: 9♠, 6♠, 3♠\n" +
          "Player 1 score: 14\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Turn: Player 3\n" +
          "Which card do you want to play?\n" +
          "Number of players: 3\n" +
          "Player 1: 8♠, 5♠, 2♠\n" +
          "Player 2: 7♠, 4♠\n" +
          "Player 3: 6♠, 3♠\n" +
          "Player 1 score: 15\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Turn: Player 1\n" +
          "Which card do you want to play?\n" +
          "Number of players: 3\n" +
          "Player 1: 5♠, 2♠\n" +
          "Player 2: 7♠, 4♠\n" +
          "Player 3: 6♠, 3♠\n" +
          "Player 1 score: 15\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Turn: Player 2\n" +
          "Which card do you want to play?\n" +
          "Number of players: 3\n" +
          "Player 1: 5♠, 2♠\n" +
          "Player 2: 4♠\n" +
          "Player 3: 6♠, 3♠\n" +
          "Player 1 score: 15\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Turn: Player 3\n" +
          "Which card do you want to play?\n" +
          "Number of players: 3\n" +
          "Player 1: 5♠, 2♠\n" +
          "Player 2: 4♠\n" +
          "Player 3: 3♠\n" +
          "Player 1 score: 16\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Turn: Player 1\n" +
          "Which card do you want to play?\n" +
          "Number of players: 3\n" +
          "Player 1: 2♠\n" +
          "Player 2: 4♠\n" +
          "Player 3: 3♠\n" +
          "Player 1 score: 16\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Turn: Player 2\n" +
          "Which card do you want to play?\n" +
          "Number of players: 3\n" +
          "Player 1: 2♠\n" +
          "Player 2: \n" +
          "Player 3: 3♠\n" +
          "Player 1 score: 16\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Turn: Player 3\n" +
          "Which card do you want to play?\n" +
          "Number of players: 3\n" +
          "Player 1: 2♠\n" +
          "Player 2: \n" +
          "Player 3: \n" +
          "Player 1 score: 17\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Game over. Player 1 won.";

  String pl4 = "Number of players: 4\n" +
          "Player 1: A♣, 10♣, 6♣, 2♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
          "Player 2: K♣, 9♣, 5♣, A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
          "Player 3: Q♣, 8♣, 4♣, K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
          "Player 4: J♣, 7♣, 3♣, Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
          "Player 1 score: 0\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Player 4 score: 0\n" +
          "Turn: Player 1\n" +
          "Which card do you want to play?\n" +
          "Number of players: 4\n" +
          "Player 1: 10♣, 6♣, 2♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
          "Player 2: K♣, 9♣, 5♣, A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
          "Player 3: Q♣, 8♣, 4♣, K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
          "Player 4: J♣, 7♣, 3♣, Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
          "Player 1 score: 0\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Player 4 score: 0\n" +
          "Turn: Player 2\n" +
          "Which card do you want to play?\n" +
          "Number of players: 4\n" +
          "Player 1: 10♣, 6♣, 2♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
          "Player 2: 9♣, 5♣, A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
          "Player 3: Q♣, 8♣, 4♣, K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
          "Player 4: J♣, 7♣, 3♣, Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
          "Player 1 score: 0\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Player 4 score: 0\n" +
          "Turn: Player 3\n" +
          "Which card do you want to play?\n" +
          "Number of players: 4\n" +
          "Player 1: 10♣, 6♣, 2♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
          "Player 2: 9♣, 5♣, A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
          "Player 3: 8♣, 4♣, K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
          "Player 4: J♣, 7♣, 3♣, Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
          "Player 1 score: 0\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Player 4 score: 0\n" +
          "Turn: Player 4\n" +
          "Which card do you want to play?\n" +
          "Number of players: 4\n" +
          "Player 1: 10♣, 6♣, 2♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
          "Player 2: 9♣, 5♣, A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
          "Player 3: 8♣, 4♣, K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
          "Player 4: 7♣, 3♣, Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
          "Player 1 score: 1\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Player 4 score: 0\n" +
          "Turn: Player 1\n" +
          "Which card do you want to play?\n" +
          "Number of players: 4\n" +
          "Player 1: 6♣, 2♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
          "Player 2: 9♣, 5♣, A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
          "Player 3: 8♣, 4♣, K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
          "Player 4: 7♣, 3♣, Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
          "Player 1 score: 1\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Player 4 score: 0\n" +
          "Turn: Player 2\n" +
          "Which card do you want to play?\n" +
          "Number of players: 4\n" +
          "Player 1: 6♣, 2♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
          "Player 2: 5♣, A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
          "Player 3: 8♣, 4♣, K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
          "Player 4: 7♣, 3♣, Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
          "Player 1 score: 1\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Player 4 score: 0\n" +
          "Turn: Player 3\n" +
          "Which card do you want to play?\n" +
          "Number of players: 4\n" +
          "Player 1: 6♣, 2♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
          "Player 2: 5♣, A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
          "Player 3: 4♣, K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
          "Player 4: 7♣, 3♣, Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
          "Player 1 score: 1\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Player 4 score: 0\n" +
          "Turn: Player 4\n" +
          "Which card do you want to play?\n" +
          "Number of players: 4\n" +
          "Player 1: 6♣, 2♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
          "Player 2: 5♣, A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
          "Player 3: 4♣, K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
          "Player 4: 3♣, Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
          "Player 1 score: 2\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Player 4 score: 0\n" +
          "Turn: Player 1\n" +
          "Which card do you want to play?\n" +
          "Number of players: 4\n" +
          "Player 1: 2♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
          "Player 2: 5♣, A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
          "Player 3: 4♣, K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
          "Player 4: 3♣, Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
          "Player 1 score: 2\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Player 4 score: 0\n" +
          "Turn: Player 2\n" +
          "Which card do you want to play?\n" +
          "Number of players: 4\n" +
          "Player 1: 2♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
          "Player 2: A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
          "Player 3: 4♣, K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
          "Player 4: 3♣, Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
          "Player 1 score: 2\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Player 4 score: 0\n" +
          "Turn: Player 3\n" +
          "Which card do you want to play?\n" +
          "Number of players: 4\n" +
          "Player 1: 2♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
          "Player 2: A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
          "Player 3: K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
          "Player 4: 3♣, Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
          "Player 1 score: 2\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Player 4 score: 0\n" +
          "Turn: Player 4\n" +
          "Which card do you want to play?\n" +
          "Number of players: 4\n" +
          "Player 1: 2♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
          "Player 2: A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
          "Player 3: K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
          "Player 4: Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
          "Player 1 score: 3\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Player 4 score: 0\n" +
          "Turn: Player 1\n" +
          "Which card do you want to play?\n" +
          "Number of players: 4\n" +
          "Player 1: J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
          "Player 2: A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
          "Player 3: K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
          "Player 4: Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
          "Player 1 score: 3\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Player 4 score: 0\n" +
          "Turn: Player 2\n" +
          "Which card do you want to play?\n" +
          "Number of players: 4\n" +
          "Player 1: J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
          "Player 2: 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
          "Player 3: K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
          "Player 4: Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
          "Player 1 score: 3\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Player 4 score: 0\n" +
          "Turn: Player 3\n" +
          "Which card do you want to play?\n" +
          "Number of players: 4\n" +
          "Player 1: J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
          "Player 2: 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
          "Player 3: 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
          "Player 4: Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
          "Player 1 score: 3\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Player 4 score: 0\n" +
          "Turn: Player 4\n" +
          "Which card do you want to play?\n" +
          "Number of players: 4\n" +
          "Player 1: J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
          "Player 2: 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
          "Player 3: 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
          "Player 4: 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
          "Player 1 score: 4\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Player 4 score: 0\n" +
          "Turn: Player 1\n" +
          "Which card do you want to play?\n" +
          "Number of players: 4\n" +
          "Player 1: 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
          "Player 2: 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
          "Player 3: 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
          "Player 4: 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
          "Player 1 score: 4\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Player 4 score: 0\n" +
          "Turn: Player 2\n" +
          "Which card do you want to play?\n" +
          "Number of players: 4\n" +
          "Player 1: 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
          "Player 2: 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
          "Player 3: 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
          "Player 4: 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
          "Player 1 score: 4\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Player 4 score: 0\n" +
          "Turn: Player 3\n" +
          "Which card do you want to play?\n" +
          "Number of players: 4\n" +
          "Player 1: 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
          "Player 2: 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
          "Player 3: 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
          "Player 4: 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
          "Player 1 score: 4\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Player 4 score: 0\n" +
          "Turn: Player 4\n" +
          "Which card do you want to play?\n" +
          "Number of players: 4\n" +
          "Player 1: 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
          "Player 2: 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
          "Player 3: 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
          "Player 4: 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
          "Player 1 score: 5\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Player 4 score: 0\n" +
          "Turn: Player 1\n" +
          "Which card do you want to play?\n" +
          "Number of players: 4\n" +
          "Player 1: 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
          "Player 2: 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
          "Player 3: 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
          "Player 4: 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
          "Player 1 score: 5\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Player 4 score: 0\n" +
          "Turn: Player 2\n" +
          "Which card do you want to play?\n" +
          "Number of players: 4\n" +
          "Player 1: 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
          "Player 2: 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
          "Player 3: 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
          "Player 4: 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
          "Player 1 score: 5\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Player 4 score: 0\n" +
          "Turn: Player 3\n" +
          "Which card do you want to play?\n" +
          "Number of players: 4\n" +
          "Player 1: 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
          "Player 2: 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
          "Player 3: A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
          "Player 4: 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
          "Player 1 score: 5\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Player 4 score: 0\n" +
          "Turn: Player 4\n" +
          "Which card do you want to play?\n" +
          "Number of players: 4\n" +
          "Player 1: 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
          "Player 2: 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
          "Player 3: A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
          "Player 4: K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
          "Player 1 score: 6\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Player 4 score: 0\n" +
          "Turn: Player 1\n" +
          "Which card do you want to play?\n" +
          "Number of players: 4\n" +
          "Player 1: Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
          "Player 2: 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
          "Player 3: A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
          "Player 4: K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
          "Player 1 score: 6\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Player 4 score: 0\n" +
          "Turn: Player 2\n" +
          "Which card do you want to play?\n" +
          "Number of players: 4\n" +
          "Player 1: Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
          "Player 2: J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
          "Player 3: A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
          "Player 4: K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
          "Player 1 score: 6\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Player 4 score: 0\n" +
          "Turn: Player 3\n" +
          "Which card do you want to play?\n" +
          "Number of players: 4\n" +
          "Player 1: Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
          "Player 2: J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
          "Player 3: 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
          "Player 4: K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
          "Player 1 score: 6\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Player 4 score: 0\n" +
          "Turn: Player 4\n" +
          "Which card do you want to play?\n" +
          "Number of players: 4\n" +
          "Player 1: Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
          "Player 2: J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
          "Player 3: 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
          "Player 4: 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
          "Player 1 score: 7\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Player 4 score: 0\n" +
          "Turn: Player 1\n" +
          "Which card do you want to play?\n" +
          "Number of players: 4\n" +
          "Player 1: 8♥, 4♥, K♠, 9♠, 5♠\n" +
          "Player 2: J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
          "Player 3: 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
          "Player 4: 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
          "Player 1 score: 7\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Player 4 score: 0\n" +
          "Turn: Player 2\n" +
          "Which card do you want to play?\n" +
          "Number of players: 4\n" +
          "Player 1: 8♥, 4♥, K♠, 9♠, 5♠\n" +
          "Player 2: 7♥, 3♥, Q♠, 8♠, 4♠\n" +
          "Player 3: 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
          "Player 4: 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
          "Player 1 score: 7\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Player 4 score: 0\n" +
          "Turn: Player 3\n" +
          "Which card do you want to play?\n" +
          "Number of players: 4\n" +
          "Player 1: 8♥, 4♥, K♠, 9♠, 5♠\n" +
          "Player 2: 7♥, 3♥, Q♠, 8♠, 4♠\n" +
          "Player 3: 6♥, 2♥, J♠, 7♠, 3♠\n" +
          "Player 4: 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
          "Player 1 score: 7\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Player 4 score: 0\n" +
          "Turn: Player 4\n" +
          "Which card do you want to play?\n" +
          "Number of players: 4\n" +
          "Player 1: 8♥, 4♥, K♠, 9♠, 5♠\n" +
          "Player 2: 7♥, 3♥, Q♠, 8♠, 4♠\n" +
          "Player 3: 6♥, 2♥, J♠, 7♠, 3♠\n" +
          "Player 4: 5♥, A♠, 10♠, 6♠, 2♠\n" +
          "Player 1 score: 8\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Player 4 score: 0\n" +
          "Turn: Player 1\n" +
          "Which card do you want to play?\n" +
          "Number of players: 4\n" +
          "Player 1: 4♥, K♠, 9♠, 5♠\n" +
          "Player 2: 7♥, 3♥, Q♠, 8♠, 4♠\n" +
          "Player 3: 6♥, 2♥, J♠, 7♠, 3♠\n" +
          "Player 4: 5♥, A♠, 10♠, 6♠, 2♠\n" +
          "Player 1 score: 8\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Player 4 score: 0\n" +
          "Turn: Player 2\n" +
          "Which card do you want to play?\n" +
          "Number of players: 4\n" +
          "Player 1: 4♥, K♠, 9♠, 5♠\n" +
          "Player 2: 3♥, Q♠, 8♠, 4♠\n" +
          "Player 3: 6♥, 2♥, J♠, 7♠, 3♠\n" +
          "Player 4: 5♥, A♠, 10♠, 6♠, 2♠\n" +
          "Player 1 score: 8\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Player 4 score: 0\n" +
          "Turn: Player 3\n" +
          "Which card do you want to play?\n" +
          "Number of players: 4\n" +
          "Player 1: 4♥, K♠, 9♠, 5♠\n" +
          "Player 2: 3♥, Q♠, 8♠, 4♠\n" +
          "Player 3: 2♥, J♠, 7♠, 3♠\n" +
          "Player 4: 5♥, A♠, 10♠, 6♠, 2♠\n" +
          "Player 1 score: 8\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Player 4 score: 0\n" +
          "Turn: Player 4\n" +
          "Which card do you want to play?\n" +
          "Number of players: 4\n" +
          "Player 1: 4♥, K♠, 9♠, 5♠\n" +
          "Player 2: 3♥, Q♠, 8♠, 4♠\n" +
          "Player 3: 2♥, J♠, 7♠, 3♠\n" +
          "Player 4: A♠, 10♠, 6♠, 2♠\n" +
          "Player 1 score: 9\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Player 4 score: 0\n" +
          "Turn: Player 1\n" +
          "Which card do you want to play?\n" +
          "Number of players: 4\n" +
          "Player 1: K♠, 9♠, 5♠\n" +
          "Player 2: 3♥, Q♠, 8♠, 4♠\n" +
          "Player 3: 2♥, J♠, 7♠, 3♠\n" +
          "Player 4: A♠, 10♠, 6♠, 2♠\n" +
          "Player 1 score: 9\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Player 4 score: 0\n" +
          "Turn: Player 2\n" +
          "Which card do you want to play?\n" +
          "Number of players: 4\n" +
          "Player 1: K♠, 9♠, 5♠\n" +
          "Player 2: Q♠, 8♠, 4♠\n" +
          "Player 3: 2♥, J♠, 7♠, 3♠\n" +
          "Player 4: A♠, 10♠, 6♠, 2♠\n" +
          "Player 1 score: 9\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Player 4 score: 0\n" +
          "Turn: Player 3\n" +
          "Which card do you want to play?\n" +
          "Number of players: 4\n" +
          "Player 1: K♠, 9♠, 5♠\n" +
          "Player 2: Q♠, 8♠, 4♠\n" +
          "Player 3: J♠, 7♠, 3♠\n" +
          "Player 4: A♠, 10♠, 6♠, 2♠\n" +
          "Player 1 score: 9\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Player 4 score: 0\n" +
          "Turn: Player 4\n" +
          "Which card do you want to play?\n" +
          "Number of players: 4\n" +
          "Player 1: K♠, 9♠, 5♠\n" +
          "Player 2: Q♠, 8♠, 4♠\n" +
          "Player 3: J♠, 7♠, 3♠\n" +
          "Player 4: 10♠, 6♠, 2♠\n" +
          "Player 1 score: 10\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Player 4 score: 0\n" +
          "Turn: Player 1\n" +
          "Which card do you want to play?\n" +
          "Number of players: 4\n" +
          "Player 1: 9♠, 5♠\n" +
          "Player 2: Q♠, 8♠, 4♠\n" +
          "Player 3: J♠, 7♠, 3♠\n" +
          "Player 4: 10♠, 6♠, 2♠\n" +
          "Player 1 score: 10\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Player 4 score: 0\n" +
          "Turn: Player 2\n" +
          "Which card do you want to play?\n" +
          "Number of players: 4\n" +
          "Player 1: 9♠, 5♠\n" +
          "Player 2: 8♠, 4♠\n" +
          "Player 3: J♠, 7♠, 3♠\n" +
          "Player 4: 10♠, 6♠, 2♠\n" +
          "Player 1 score: 10\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Player 4 score: 0\n" +
          "Turn: Player 3\n" +
          "Which card do you want to play?\n" +
          "Number of players: 4\n" +
          "Player 1: 9♠, 5♠\n" +
          "Player 2: 8♠, 4♠\n" +
          "Player 3: 7♠, 3♠\n" +
          "Player 4: 10♠, 6♠, 2♠\n" +
          "Player 1 score: 10\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Player 4 score: 0\n" +
          "Turn: Player 4\n" +
          "Which card do you want to play?\n" +
          "Number of players: 4\n" +
          "Player 1: 9♠, 5♠\n" +
          "Player 2: 8♠, 4♠\n" +
          "Player 3: 7♠, 3♠\n" +
          "Player 4: 6♠, 2♠\n" +
          "Player 1 score: 11\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Player 4 score: 0\n" +
          "Turn: Player 1\n" +
          "Which card do you want to play?\n" +
          "Number of players: 4\n" +
          "Player 1: 5♠\n" +
          "Player 2: 8♠, 4♠\n" +
          "Player 3: 7♠, 3♠\n" +
          "Player 4: 6♠, 2♠\n" +
          "Player 1 score: 11\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Player 4 score: 0\n" +
          "Turn: Player 2\n" +
          "Which card do you want to play?\n" +
          "Number of players: 4\n" +
          "Player 1: 5♠\n" +
          "Player 2: 4♠\n" +
          "Player 3: 7♠, 3♠\n" +
          "Player 4: 6♠, 2♠\n" +
          "Player 1 score: 11\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Player 4 score: 0\n" +
          "Turn: Player 3\n" +
          "Which card do you want to play?\n" +
          "Number of players: 4\n" +
          "Player 1: 5♠\n" +
          "Player 2: 4♠\n" +
          "Player 3: 3♠\n" +
          "Player 4: 6♠, 2♠\n" +
          "Player 1 score: 11\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Player 4 score: 0\n" +
          "Turn: Player 4\n" +
          "Which card do you want to play?\n" +
          "Number of players: 4\n" +
          "Player 1: 5♠\n" +
          "Player 2: 4♠\n" +
          "Player 3: 3♠\n" +
          "Player 4: 2♠\n" +
          "Player 1 score: 12\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Player 4 score: 0\n" +
          "Turn: Player 1\n" +
          "Which card do you want to play?\n" +
          "Number of players: 4\n" +
          "Player 1: \n" +
          "Player 2: 4♠\n" +
          "Player 3: 3♠\n" +
          "Player 4: 2♠\n" +
          "Player 1 score: 12\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Player 4 score: 0\n" +
          "Turn: Player 2\n" +
          "Which card do you want to play?\n" +
          "Number of players: 4\n" +
          "Player 1: \n" +
          "Player 2: \n" +
          "Player 3: 3♠\n" +
          "Player 4: 2♠\n" +
          "Player 1 score: 12\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Player 4 score: 0\n" +
          "Turn: Player 3\n" +
          "Which card do you want to play?\n" +
          "Number of players: 4\n" +
          "Player 1: \n" +
          "Player 2: \n" +
          "Player 3: \n" +
          "Player 4: 2♠\n" +
          "Player 1 score: 12\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Player 4 score: 0\n" +
          "Turn: Player 4\n" +
          "Which card do you want to play?\n" +
          "Number of players: 4\n" +
          "Player 1: \n" +
          "Player 2: \n" +
          "Player 3: \n" +
          "Player 4: \n" +
          "Player 1 score: 13\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Player 4 score: 0\n" +
          "Game over. Player 1 won.";

  String quit = "Number of players: 4\n" +
          "Player 1: A♣, 10♣, 6♣, 2♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
          "Player 2: K♣, 9♣, 5♣, A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
          "Player 3: Q♣, 8♣, 4♣, K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
          "Player 4: J♣, 7♣, 3♣, Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
          "Player 1 score: 0\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Player 4 score: 0\n" +
          "Turn: Player 1\n" +
          "Which card do you want to play?\n" +
          "Game quit prematurely.";

  String invalidIn = "Number of players: 4\n" +
          "Player 1: A♣, 10♣, 6♣, 2♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
          "Player 2: K♣, 9♣, 5♣, A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
          "Player 3: Q♣, 8♣, 4♣, K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
          "Player 4: J♣, 7♣, 3♣, Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
          "Player 1 score: 0\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Player 4 score: 0\n" +
          "Turn: Player 1\n" +
          "Which card do you want to play?\n" +
          "Try again. Invalid input: w\n" +
          "Which card do you want to play?\n";

  String invalidNum = "Number of players: 4\n" +
          "Player 1: A♣, 10♣, 6♣, 2♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
          "Player 2: K♣, 9♣, 5♣, A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
          "Player 3: Q♣, 8♣, 4♣, K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
          "Player 4: J♣, 7♣, 3♣, Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
          "Player 1 score: 0\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Player 4 score: 0\n" +
          "Turn: Player 1\n" +
          "Which card do you want to play?\n" +
          "Try again. Invalid input. your input card index is out of bound!\n" +
          "\n" +
          "Which card do you want to play?\n";

  //Test 3 players
  @Test
  public void testWhistController() {
    StringBuffer out = new StringBuffer();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 52; i++) {
      sb.append("0\n");
    }
    Reader in = new StringReader(sb.toString());
    WhistController whistController = new WhistController(in, out);
    try {
      whistController.playGame(startW, 3);
    } catch (IllegalArgumentException e) {
    }
    assertEquals(pl3, out.toString());
  }

  //Test 4 Players
  @Test
  public void testWhistController2() {
    StringBuffer out = new StringBuffer();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 52; i++) {
      sb.append("0\n");
    }
    Reader in = new StringReader(sb.toString());
    WhistController whistController = new WhistController(in, out);
    try {
      whistController.playGame(startW, 4);
    } catch (IllegalArgumentException e) {
    }
    assertEquals(pl4, out.toString());
  }

  //Test different winners

  //Player 2 is winner in a 4-player game
  @Test
  public void testWhistController3() {
    StringBuffer out = new StringBuffer();
    StringBuilder sb = new StringBuilder();
    sb.append("1\n0\n0\n0\n");
    for (int i = 0; i < 11; i++) {
      sb.append("0\n0\n0\n1\n");
    }
    sb.append("0\n0\n0\n0\n");
    Reader in = new StringReader(sb.toString());
    WhistController whistController = new WhistController(in, out);
    try {
      whistController.playGame(startW, 4);
    } catch (IllegalArgumentException e) {
    }
    String result = out.substring(out.lastIndexOf("\n") + 1);
    assertEquals("Game over. Player 2 won.", result.toString());
  }

  //Player 3 is winner in a 4-player game
  @Test
  public void testWhistController4() {
    StringBuffer out = new StringBuffer();
    StringBuilder sb = new StringBuilder();
    sb.append("1\n1\n0\n0\n");
    sb.append("0\n0\n1\n1\n");
    sb.append("0\n0\n0\n0\n");
    sb.append("1\n1\n0\n0\n");
    for (int i = 0; i < 8; i++) {
      sb.append("0\n0\n1\n1\n");
    }
    sb.append("0\n0\n0\n0\n");
    Reader in = new StringReader(sb.toString());
    WhistController whistController = new WhistController(in, out);
    try {
      whistController.playGame(startW, 4);
    } catch (IllegalArgumentException e) {
    }
    String result = out.substring(out.lastIndexOf("\n") + 1);
    assertEquals("Game over. Player 3 won.", result.toString());
  }

  //Player 4 is winner in a 4-player game
  @Test
  public void testWhistController5() {
    StringBuffer out = new StringBuffer();
    StringBuilder sb = new StringBuilder();
    sb.append("1\n1\n1\n0\n");
    for (int i = 0; i < 2; i++) {
      sb.append("0\n1\n1\n1\n");
      sb.append("0\n1\n0\n0\n");
      sb.append("1\n1\n0\n1\n");
    }
    for (int i = 0; i < 5; i++) {
      sb.append("0\n1\n1\n1\n");
    }
    sb.append("0\n0\n0\n0\n");

    Reader in = new StringReader(sb.toString());
    WhistController whistController = new WhistController(in, out);
    try {
      whistController.playGame(startW, 4);
    } catch (IllegalArgumentException e) {
    }
    String result = out.substring(out.lastIndexOf("\n") + 1);
    assertEquals("Game over. Player 4 won.", result.toString());
  }

  // More than one play is winner in a 4-player game
  @Test
  public void testWhistController6() {
    StringBuffer out = new StringBuffer();
    StringBuilder sb = new StringBuilder();
    sb.append("0\n1\n0\n0\n" +
            "1\n0\n0\n0\n" +
            "0\n0\n0\n0\n" +
            "1\n0\n0\n0\n" +
            "0\n0\n0\n1\n" +
            "0\n0\n0\n1\n" +
            "1\n1\n1\n1\n" +
            "0\n0\n0\n0\n" +
            "1\n0\n0\n0\n" +
            "0\n0\n0\n0\n" +
            "1\n0\n0\n0\n" +
            "0\n1\n1\n0\n" +
            "0\n0\n0\n0\n"
    );
    Reader in = new StringReader(sb.toString());
    WhistController whistController = new WhistController(in, out);
    try {
      whistController.playGame(startW, 4);
    } catch (IllegalArgumentException e) {
    }
    String result = out.substring(out.lastIndexOf("\n") + 1);
    assertEquals("Game over. Player 1, 2 won.", result.toString());
  }

  // Test IllegalArguementException from controller
  // The game model is null
  @Test(expected = IllegalArgumentException.class)
  public void testWhistController7() {
    StringBuffer out = new StringBuffer();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 52; i++) {
      sb.append("0\n");
    }
    Reader in = new StringReader(sb.toString());
    WhistController whistController = new WhistController(in, out);
    whistController.playGame(startW1, 3);
  }

  // The game players are less than 2
  @Test(expected = IllegalArgumentException.class)
  public void testWhistController8() {
    StringBuffer out = new StringBuffer();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 52; i++) {
      sb.append("0\n");
    }
    Reader in = new StringReader(sb.toString());
    WhistController whistController = new WhistController(in, out);
    whistController.playGame(startW, 0);
  }

  // Test quit game
  @Test
  public void testWhistController9() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("q\n0\n");
    WhistController whistController = new WhistController(in, out);
    try {
      whistController.playGame(startW, 4);
    } catch (IllegalArgumentException e) {
    }
    assertEquals(quit, out.toString());
  }

  @Test
  public void testWhistController10() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("53\n");
    WhistController whistController = new WhistController(in, out);
    try {
      whistController.playGame(startW, 4);
    } catch (NoSuchElementException e) {
    }
    assertEquals(invalidNum, out.toString());
  }

  //Other invalid input
  @Test
  public void testWhistController11() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("w\n");
    WhistController whistController = new WhistController(in, out);
    try {
      whistController.playGame(startW, 4);
    } catch (NoSuchElementException e) {
    }
    assertEquals(invalidIn, out.toString());
  }

  //WhistTrumpModel
  String gameState1 = "Number of players: 3\n" +
          "Player 1: A♣, J♣, 8♣, 5♣, 2♣, Q♦, 9♦, 6♦, 3♦, K♥, 10♥, 7♥, 4♥, A♠, J♠, 8♠, 5♠, 2♠\n" +
          "Player 2: K♣, 10♣, 7♣, 4♣, A♦, J♦, 8♦, 5♦, 2♦, Q♥, 9♥, 6♥, 3♥, K♠, 10♠, 7♠, 4♠\n" +
          "Player 3: Q♣, 9♣, 6♣, 3♣, K♦, 10♦, 7♦, 4♦, A♥, J♥, 8♥, 5♥, 2♥, Q♠, 9♠, 6♠, 3♠\n" +
          "Player 1 score: 0\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Turn: Player 1\n" +
          "Trump suit: ♣";
  String gameOver = "Number of players: 4\n" +
          "Player 1: \n" +
          "Player 2: \n" +
          "Player 3: \n" +
          "Player 4: \n" +
          "Player 1 score: 13\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Player 4 score: 0\n" +
          "Game over. Player 1 won.";
  String trumpQuit = "Number of players: 4\n" +
          "Player 1: A♣, 10♣, 6♣, 2♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
          "Player 2: K♣, 9♣, 5♣, A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
          "Player 3: Q♣, 8♣, 4♣, K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
          "Player 4: J♣, 7♣, 3♣, Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
          "Player 1 score: 0\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Player 4 score: 0\n" +
          "Turn: Player 1\n" +
          "Trump suit: ♣\n" +
          "Which card do you want to play?\n" +
          "Game quit prematurely.";
  String trumpErrorMessage1 = "Number of players: 4\n" +
          "Player 1: A♣, 10♣, 6♣, 2♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
          "Player 2: K♣, 9♣, 5♣, A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
          "Player 3: Q♣, 8♣, 4♣, K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
          "Player 4: J♣, 7♣, 3♣, Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
          "Player 1 score: 0\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Player 4 score: 0\n" +
          "Turn: Player 1\n" +
          "Trump suit: ♣\n" +
          "Which card do you want to play?\n" +
          "Try again. Invalid input. your input card index is out of bound!\n" +
          "\n" +
          "Which card do you want to play?\n";
  String trumpErrorMessage2 = "Number of players: 4\n" +
          "Player 1: A♣, 10♣, 6♣, 2♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
          "Player 2: K♣, 9♣, 5♣, A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
          "Player 3: Q♣, 8♣, 4♣, K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
          "Player 4: J♣, 7♣, 3♣, Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
          "Player 1 score: 0\n" +
          "Player 2 score: 0\n" +
          "Player 3 score: 0\n" +
          "Player 4 score: 0\n" +
          "Turn: Player 1\n" +
          "Trump suit: ♣\n" +
          "Which card do you want to play?\n" +
          "Try again. Invalid input: w\n" +
          "Which card do you want to play?\n";
  Comparator<Card> cardComparator = new CardComparator();
  CardGameModel TrumpModel = WhistModelCreator.create(WhistModelCreator.ModelType.TRUMP);
  CardGameModel NoTrumpModel = WhistModelCreator.create(WhistModelCreator.ModelType.NOTRUMP);

  //Test factory method
  @Test
  public void testCreator1() {
    assertTrue(TrumpModel instanceof WhistModel);
    assertTrue(TrumpModel instanceof WhistTrumpModel);
  }

  @Test
  public void testCreator2() {
    assertTrue(NoTrumpModel instanceof WhistModel);
    assertFalse(NoTrumpModel instanceof WhistTrumpModel);
  }


  // Test comparator
  @Test
  public void testCardCompare1() {
    assertEquals(-1, cardComparator.compare(c1, c2));
  }

  @Test
  public void testCardCompare2() {
    assertEquals(1, cardComparator.compare(c20, c4));
  }

  @Test
  public void testCardCompare3() {
    Card c1New = new Card(Value.ACE, Suit.CLUBS);
    assertEquals(0, cardComparator.compare(c1New, c1));
  }

  @Test
  public void testComparator() {
    List<Card> cardDeck = TrumpModel.getDeck();
    Collections.shuffle(cardDeck.subList(1, 51));
    List<?> deck = testComparatorHelper(cardDeck, new CardComparator());
    assertEquals(cards1, deck);
  }

  private <S, T extends Comparator<S>> List<S> testComparatorHelper(List<S> list, T comparator) {
    List<S> temp = new ArrayList<S>();
    for (S item : list) {
      temp.add(item);
    }
    Collections.sort(temp, comparator);
    return temp;
  }

  @Test
  public void testTrumpSuit1() {
    List<Card> cardDeck = TrumpModel.getDeck();
    TrumpModel.startPlay(3, cardDeck);
    String result = TrumpModel.getGameState();
    assertEquals("Trump suit: ♣", result.substring(result.lastIndexOf("\n") + 1));
  }

  //Give a another trump suit.
  @Test
  public void testTrumpSuit2() {
    List<Card> cardDeck = TrumpModel.getDeck();
    Collections.swap(cardDeck, 0, 50);
    TrumpModel.startPlay(3, cardDeck);
    String result = TrumpModel.getGameState();
    assertEquals("Trump suit: ♠", result.substring(result.lastIndexOf("\n") + 1));
  }

  //Test TrumpModel play
  //Test a player played a trump as well as the dominated Suit
  @Test
  public void testSameTrumps() {
    List<Integer> input = new ArrayList<Integer>();
    List<Card> cardDeck = TrumpModel.getDeck();
    TrumpModel.startPlay(3, cardDeck);
    for (int i = 0; i < 15; i++) {
      input.add(0);
    }
    for (Integer i : input) {
      TrumpModel.play(TrumpModel.getCurrentPlayer(), i);
    }
    assertEquals(0, TrumpModel.getCurrentPlayer());

    List<Integer> input1 = new ArrayList<Integer>();
    List<Card> cardDeck1 = NoTrumpModel.getDeck();
    NoTrumpModel.startPlay(3, cardDeck1);
    for (int i = 0; i < 15; i++) {
      input1.add(0);
    }
    for (Integer i : input1) {
      NoTrumpModel.play(NoTrumpModel.getCurrentPlayer(), i);
    }
    assertEquals(0, NoTrumpModel.getCurrentPlayer());

  }

  // Test zero player played trumps in a trick
  @Test
  public void testZeroTrumps() {
    TrumpModel.startPlay(3, TrumpModel.getDeck());
    TrumpModel.play(0, 5);
    TrumpModel.play(1, 4);
    TrumpModel.play(2, 4);
    assertEquals(1, TrumpModel.getCurrentPlayer());
    NoTrumpModel.startPlay(3, NoTrumpModel.getDeck());
    NoTrumpModel.play(0, 5);
    NoTrumpModel.play(1, 4);
    NoTrumpModel.play(2, 4);
    assertEquals(1, NoTrumpModel.getCurrentPlayer());
  }

  //Test only one player played a trump
  @Test
  public void testOneTrump() {
    List<Integer> input = new ArrayList<Integer>();
    List<Card> cardDeck = TrumpModel.getDeck();
    TrumpModel.startPlay(3, cardDeck);
    input.add(5);
    input.add(4);
    input.add(4);
    for (int i = 0; i < 3; i++) {
      input.add(4);
      input.add(4);
      input.add(5);
    }
    input.add(4);
    input.add(0);
    input.add(5);

    for (Integer i : input) {
      TrumpModel.play(TrumpModel.getCurrentPlayer(), i);
    }
    assertEquals(2, TrumpModel.getCurrentPlayer());

    List<Integer> input1 = new ArrayList<Integer>();
    List<Card> cardDeck1 = NoTrumpModel.getDeck();
    NoTrumpModel.startPlay(3, cardDeck1);
    input1.add(5);
    input1.add(4);
    input1.add(4);
    for (int i = 0; i < 3; i++) {
      input1.add(4);
      input1.add(4);
      input1.add(5);
    }
    input1.add(4);
    input1.add(0);
    input1.add(5);
    for (Integer i : input1) {
      NoTrumpModel.play(NoTrumpModel.getCurrentPlayer(), i);
    }
    assertEquals(1, NoTrumpModel.getCurrentPlayer());
  }

  //Test more than one players played trumps
  @Test
  public void testTwoTrump() {
    List<Integer> input = new ArrayList<Integer>();
    List<Card> cardDeck = TrumpModel.getDeck();
    TrumpModel.startPlay(3, cardDeck);
    input.add(5);
    input.add(4);
    input.add(4);
    for (int i = 0; i < 3; i++) {
      input.add(4);
      input.add(4);
      input.add(5);
    }
    input.add(4);
    input.add(0);
    input.add(0);

    for (Integer i : input) {
      TrumpModel.play(TrumpModel.getCurrentPlayer(), i);
    }
    assertEquals(0, TrumpModel.getCurrentPlayer());

    List<Integer> input1 = new ArrayList<Integer>();
    List<Card> cardDeck1 = NoTrumpModel.getDeck();
    NoTrumpModel.startPlay(3, cardDeck1);
    input1.add(5);
    input1.add(4);
    input1.add(4);
    for (int i = 0; i < 3; i++) {
      input1.add(4);
      input1.add(4);
      input1.add(5);
    }
    input1.add(4);
    input1.add(0);
    input1.add(0);
    for (Integer i : input1) {
      NoTrumpModel.play(NoTrumpModel.getCurrentPlayer(), i);
    }
    assertEquals(1, NoTrumpModel.getCurrentPlayer());
  }

  //Test get game state of trump if the game is not over
  @Test
  public void testTrumpGetGameState1() {
    List<Card> cardDeck = TrumpModel.getDeck();
    TrumpModel.startPlay(3, cardDeck);
    assertEquals(gameState1, TrumpModel.getGameState());
  }

  //Test get game state of trump if the game is over
  @Test
  public void testTrumpGetGameState2() {
    List<Card> cardDeck = TrumpModel.getDeck();
    TrumpModel.startPlay(4, cardDeck);
    int n = 0;
    for (int i = 0; n < 52; i = (i + 1) % 4) {
      TrumpModel.play(i, 0);
      n++;
    }
    assertEquals(gameOver, TrumpModel.getGameState());
  }
  //Test illegalArguement in play in WhistTrumpModel

  //Test the input card index out of the bound
  @Test(expected = IllegalArgumentException.class)
  public void testPlayInTrump1() {
    List<Card> deck = TrumpModel.getDeck();
    TrumpModel.startPlay(3, deck);
    TrumpModel.play(1, 30);
  }

  //Test the input card not the one with the dominated suit
  @Test(expected = IllegalArgumentException.class)
  public void testPlayInTrump2() {
    List<Card> deck = TrumpModel.getDeck();
    TrumpModel.startPlay(3, deck);
    TrumpModel.play(0, 0);
    TrumpModel.play(1, 6);
  }

  //Can't play when the game is over
  @Test(expected = IllegalArgumentException.class)
  public void testPlayInTrump3() {
    List<Card> cardDeck = TrumpModel.getDeck();
    TrumpModel.startPlay(3, cardDeck);
    int n = 0;
    for (int i = 0; n < 51; i = (i + 1) % 3) {
      TrumpModel.play(i, 0);
      n++;
    }
    TrumpModel.play(0, 0);
  }

  //Test control model is still working after we change the model to Trump model
  @Test
  public void testTrumpController1() {
    StringBuffer out = new StringBuffer();
    StringBuilder sb = new StringBuilder();
    sb.append("1\n1\n1\n0\n");
    for (int i = 0; i < 2; i++) {
      sb.append("0\n1\n1\n1\n");
      sb.append("0\n1\n0\n0\n");
      sb.append("1\n1\n0\n1\n");
    }
    for (int i = 0; i < 5; i++) {
      sb.append("0\n1\n1\n1\n");
    }
    sb.append("0\n0\n0\n0\n");

    Reader in = new StringReader(sb.toString());
    WhistController whistController = new WhistController(in, out);
    try {
      whistController.playGame(TrumpModel, 4);
    } catch (IllegalArgumentException e) {
    }
    String result = out.substring(out.lastIndexOf("\n") + 1);
    assertEquals("Game over. Player 4 won.", result.toString());
  }

  // Test IllegalArguementException from controller after we change the model to Trump model
  // The game model is null
  @Test(expected = IllegalArgumentException.class)
  public void testTrumpController2() {
    StringBuffer out = new StringBuffer();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 52; i++) {
      sb.append("0\n");
    }
    Reader in = new StringReader(sb.toString());
    WhistController whistController = new WhistController(in, out);
    whistController.playGame(null, 3);
  }

  // The game players are less than 2
  @Test(expected = IllegalArgumentException.class)
  public void testTrumpController3() {
    StringBuffer out = new StringBuffer();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 52; i++) {
      sb.append("0\n");
    }
    Reader in = new StringReader(sb.toString());
    WhistController whistController = new WhistController(in, out);
    whistController.playGame(TrumpModel, 0);
  }

  // Test quit game
  @Test
  public void testtestTrumpController3() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("q\n0\n");
    WhistController whistController = new WhistController(in, out);
    try {
      whistController.playGame(TrumpModel, 4);
    } catch (IllegalArgumentException e) {
    }
    assertEquals(trumpQuit, out.toString());
  }

  @Test
  public void testTrumpController4() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("53\n");
    WhistController whistController = new WhistController(in, out);
    try {
      whistController.playGame(TrumpModel, 4);
    } catch (NoSuchElementException e) {
    }
    assertEquals(trumpErrorMessage1, out.toString());
  }

  //Other invalid input
  @Test
  public void testTrumpController5() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("w\n");
    WhistController whistController = new WhistController(in, out);
    try {
      whistController.playGame(TrumpModel, 4);
    } catch (NoSuchElementException e) {
    }
    assertEquals(trumpErrorMessage2, out.toString());
  }
}

