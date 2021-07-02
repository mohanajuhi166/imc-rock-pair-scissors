package com.imc.game;

import com.imc.game.exception.WrongSelectionException;
import org.apache.commons.lang3.StringUtils;

public enum Selection {
  ROCK, PAPER, SCISSORS;

  public static Selection fromString(String selection) {
    if (StringUtils.equalsIgnoreCase(ROCK.name(), selection)) {
      return ROCK;
    } else if(StringUtils.equalsIgnoreCase(PAPER.name(), selection)) {
      return PAPER;
    } else if(StringUtils.equalsIgnoreCase(SCISSORS.name(), selection)) {
      return SCISSORS;
    } else {
      throw new WrongSelectionException(selection + " doesn't match any provided selections");
    }
  }
}
