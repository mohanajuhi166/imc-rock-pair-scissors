package com.imc.game.gamer;


import com.imc.game.Selection;
import com.imc.game.utils.InOutRunner;

public class UserGamer extends Gamer {

  private final InOutRunner inOutRunner;

  public static UserGamer create(InOutRunner inOutRunner) {
    inOutRunner.printWithNewLine("Lets Start The Game");
    inOutRunner.print("Enter your name: ");
    String name = inOutRunner.getString();
    return new UserGamer(name, inOutRunner);
  }

  private UserGamer(String name, InOutRunner inOutRunner) {
    super(name);
    this.inOutRunner = inOutRunner;
  }

  @Override
  public Selection getSelection() {
    inOutRunner.print("Choose your move --> Rock, Paper, Scissors: ");
    String userChoice = inOutRunner.getString();
    return Selection.fromString(userChoice);
  }
}
