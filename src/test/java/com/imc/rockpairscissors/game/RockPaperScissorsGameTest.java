package com.imc.rockpairscissors.game;


import com.imc.game.Selection;
import com.imc.game.gamer.Gamer;
import com.imc.game.play.RockPairScissorsGameImpl;
import com.imc.game.rules.GameRule;
import com.imc.game.utils.InOutRunner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class RockPaperScissorsGameTest {

  @Mock
  private Gamer firstGamer;

  @Mock
  private Gamer secondGamer;

  @Mock
  private GameRule gameRule;

  @Mock
  private InOutRunner inOutRunner;

  @Test
  public void testShouldReturnFirstGamerAsWinner() {
    Mockito.when(firstGamer.getSelection()).thenReturn(Selection.ROCK);
    Mockito.when(secondGamer.getSelection()).thenReturn(Selection.SCISSORS);

    Mockito.when(gameRule.get(Mockito.eq(Selection.ROCK))).thenReturn((arg) -> true);

    Optional<Gamer> winner = rockPairScissorsGame().run(inOutRunner);

    Assertions.assertTrue(winner.isPresent());
    Assertions.assertEquals(firstGamer, winner.get());
  }

  @Test
  public void testShouldReturnSecondGamer() {
    Mockito.when(firstGamer.getSelection()).thenReturn(Selection.ROCK);
    Mockito.when(secondGamer.getSelection()).thenReturn(Selection.PAPER);

    Mockito.when(gameRule.get(Mockito.eq(Selection.ROCK))).thenReturn((arg) -> false);
    Mockito.when(gameRule.get(Mockito.eq(Selection.PAPER))).thenReturn((arg) -> true);

    Optional<Gamer> winner = rockPairScissorsGame().run(inOutRunner);

    Assertions.assertTrue(winner.isPresent());
    Assertions.assertEquals(secondGamer, winner.get());
  }

  @Test
  public void testShouldReturnEmptyResultOnDraw() {
    Mockito.when(firstGamer.getSelection()).thenReturn(Selection.ROCK);
    Mockito.when(secondGamer.getSelection()).thenReturn(Selection.ROCK);

    Mockito.when(gameRule.get(Mockito.eq(Selection.ROCK))).thenReturn((arg) -> false);

    Optional<Gamer> winner =rockPairScissorsGame().run(inOutRunner);

    Assertions.assertFalse(winner.isPresent());
  }

  private RockPairScissorsGameImpl rockPairScissorsGame() {
    return RockPairScissorsGameImpl.builder()
        .firstGamer(firstGamer)
        .secondGamer(secondGamer)
        .gameRule(gameRule)
        .build();
  }
}
