package com.imc.game.gamer;

import com.imc.game.Selection;
import com.imc.game.exception.InvalidEntryException;
import com.imc.game.exception.WrongSelectionException;
import com.imc.game.utils.InOutRunner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserGamerTest {

    @Mock
    private InOutRunner inOutRunner;

    @Test
    public void testShouldCreateHumanPlayerWithValidName() {
        UserGamer userGamer = newUserWithName("User");
        Assertions.assertEquals("User", userGamer.getName());
    }

    @Test
    public void testShouldThrowExceptionForUserrWithInvalidName() {
        Mockito.when(inOutRunner.getString()).thenReturn("");
        Assertions.assertThrows(InvalidEntryException.class, () -> UserGamer.create(inOutRunner));
    }

    @Test
    public void testShouldReturnValidChoiceForValidInput() {
        UserGamer userGamer = newUserWithName("User");

        Mockito.when(inOutRunner.getString()).thenReturn("rock");
        Assertions.assertEquals(Selection.ROCK, userGamer.getSelection());

        Mockito.when(inOutRunner.getString()).thenReturn("Paper");
        Assertions.assertEquals(Selection.PAPER, userGamer.getSelection());

        Mockito.when(inOutRunner.getString()).thenReturn("ScissorS");
        Assertions.assertEquals(Selection.SCISSORS, userGamer.getSelection());
    }

    @Test
    public void testShouldThrowExceptionForHumanPlayerWithInvalidChoice() {
        UserGamer userGamer = newUserWithName("User");

        Mockito.when(inOutRunner.getString()).thenReturn("UnUser");
        Assertions.assertThrows(WrongSelectionException.class, () -> userGamer.getSelection());
    }

    private UserGamer newUserWithName(String name) {
        Mockito.when(inOutRunner.getString()).thenReturn(name);
        return UserGamer.create(inOutRunner);
    }
}
