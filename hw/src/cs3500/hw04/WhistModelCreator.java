package cs3500.hw04;

import cs3500.hw02.*;
import cs3500.hw03.*;

public class WhistModelCreator {
  public enum ModelType {TRUMP, NOTRUMP}

  ;

  /**
   * Produce a whist model, either a model with trump or without trump
   *
   * @param type the model type
   * @return a card game model
   */

  public static CardGameModel<Card> create(ModelType type) {
    switch (type) {
      case TRUMP:
        return new WhistTrumpModel();
      case NOTRUMP:
        return new WhistModel();
      default:
        throw new IllegalArgumentException("Invalid model type!");
    }
  }
}
