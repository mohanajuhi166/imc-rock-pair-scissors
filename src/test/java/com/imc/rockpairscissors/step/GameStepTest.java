package com.imc.rockpairscissors.step;

import com.imc.game.Selection;
import com.imc.game.rules.GameRuleImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameStepTest {

  @Test
  public void testShouldValidateAllRulesExisits() {
    GameRuleImpl gameRule = GameRuleImpl.getInstance();
    for (Selection selection : Selection.values()) {
      Assertions.assertNotNull(gameRule.get(selection));
    }
  }

  @Test
  public void testShouldValidateCorrectRpsRules() {
    GameRuleImpl gameRule = GameRuleImpl.getInstance();

    Assertions.assertTrue(gameRule.get(Selection.ROCK).beats(Selection.SCISSORS));
    Assertions.assertFalse(gameRule.get(Selection.ROCK).beats(Selection.PAPER));
    Assertions.assertFalse(gameRule.get(Selection.ROCK).beats(Selection.ROCK));

    Assertions.assertTrue(gameRule.get(Selection.PAPER).beats(Selection.ROCK));
    Assertions.assertFalse(gameRule.get(Selection.PAPER).beats(Selection.SCISSORS));
    Assertions.assertFalse(gameRule.get(Selection.PAPER).beats(Selection.PAPER));

    Assertions.assertTrue(gameRule.get(Selection.SCISSORS).beats(Selection.PAPER));
    Assertions.assertFalse(gameRule.get(Selection.SCISSORS).beats(Selection.ROCK));
    Assertions.assertFalse(gameRule.get(Selection.SCISSORS).beats(Selection.SCISSORS));
  }


}
