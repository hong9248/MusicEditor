package cs3500.hw03;

import java.io.*;
import java.util.*;

import cs3500.hw02.Card;
import cs3500.hw04.WhistTrumpModel;


public class WhistController implements IWhistController {
  private Readable in;
  private Appendable out;

  public WhistController(Readable rd, Appendable ap) {
    in = rd;
    out = ap;
  }

  public static void main(String[] args) {
    InputStreamReader reader = new InputStreamReader(System.in);
    WhistController app = new WhistController(reader, System.out);
    CardGameModel<Card> game = new WhistTrumpModel();
    app.playGame(game, 4);
  }

  @Override
  public <K> void playGame(CardGameModel<K> game, int numPlayers) {
    //Set a game
    Scanner scan = new Scanner(in);
    if (game == null || numPlayers < 2) {
      throw new IllegalArgumentException("\nSorry, invalid inputs!");
    }
    //Start the game
    game.startPlay(numPlayers, game.getDeck());
    try {
      out.append(game.getGameState());
    } catch (IOException e) {
      e.printStackTrace();
    }
    // In the game
    while (!game.isGameOver()) {
      try {
        out.append("\nWhich card do you want to play?\n");
      } catch (IOException e) {
        e.printStackTrace();
      }
      int indexId;
      while (!scan.hasNext()) {
        scan.next();
      }
      String inPut = scan.next();
      try {
        indexId = Integer.parseInt(inPut);
      } catch (NumberFormatException e) {
        switch (inPut) {
          case "q":
            try {
              out.append("Game quit prematurely.");
            } catch (IOException ex) {
              ex.printStackTrace();
            }
            return;
          default:
            try {
              out.append("Try again. Invalid input: " + inPut);
            } catch (IOException ex) {
              ex.printStackTrace();
            }
            continue;
        }
      }
      try {
        game.play(game.getCurrentPlayer(), indexId);
      } catch (IllegalArgumentException e) {
        try {
          out.append("Try again. Invalid input. " + e.getMessage() + "\n");
        } catch (IOException ex) {
          ex.printStackTrace();
        }
        continue;
      }
      try {
        out.append(game.getGameState());
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    scan.close();
  }
}
