package com.imc.game.gamer;

import com.imc.game.Selection;
import com.imc.game.exception.InvalidEntryException;

import org.apache.commons.lang3.StringUtils;

public abstract class Gamer {
  private final String playerName;

  public abstract Selection getSelection();

  public String getName() {
    return playerName;
  }

  protected Gamer(String name) {
    verifyIfNameIsValid(name);
    this.playerName = name;
  }

  private static void verifyIfNameIsValid(String name) {
    if (StringUtils.isEmpty(name) || !StringUtils.isAlphanumeric(name)) {
      throw new InvalidEntryException("Gamer name cannot be empty and allowed only alphanumeric characters");
    }
  }
}
