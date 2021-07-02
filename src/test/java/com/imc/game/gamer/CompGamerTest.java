package com.imc.game.gamer;


import com.imc.game.Selection;
import com.imc.game.exception.InvalidEntryException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CompGamerTest {

    @Test
    public void testShouldCreateGamerWithValidName() {
        Gamer computerGamer = CompGamer.createWithName("computer");
        Assertions.assertEquals("computer", computerGamer.getName());
    }

    @Test
    public void testShouldThrowExceptionWhenUsingInvalidName() {
        Assertions.assertThrows(InvalidEntryException.class, () -> CompGamer.createWithName("my-gamer"));
    }

    @Test
    public void testShouldThrowExceptionWhenUsingEmptyName() {
        Assertions.assertThrows(InvalidEntryException.class, () -> CompGamer.createWithName(""));
    }

    @Test
    public void testShouldThrowExceptionWhenUsingNullName() {
        Assertions.assertThrows(InvalidEntryException.class, () -> CompGamer.createWithName(null));
    }

    @Test
    public void testShouldReturnValidChoice() {
        CompGamer computerBot = CompGamer.create("computer", 0L);
        Assertions.assertEquals(Selection.ROCK, computerBot.getSelection());
        Assertions.assertEquals(Selection.PAPER, computerBot.getSelection());
        Assertions.assertEquals(Selection.PAPER, computerBot.getSelection());
        Assertions.assertEquals(Selection.SCISSORS, computerBot.getSelection());
    }

}
