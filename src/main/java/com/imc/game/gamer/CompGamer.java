package com.imc.game.gamer;

import com.imc.game.Selection;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CompGamer extends Gamer {

  private static final List<Selection> selections = Collections.unmodifiableList(Arrays.asList(Selection.values()));

  private final Random randomNumberGenerator;

  public static CompGamer createWithName(String name) {
    return create(name, Long.valueOf(LocalDateTime.now().getNano()));
  }

  public static CompGamer create(String name, Long seed) {
    return new CompGamer(name, seed);
  }

  @Override
  public Selection getSelection() {
    return selections.get(randomNumberGenerator.nextInt(selections.size()));
  }

  private CompGamer(String playerName, Long seed) {
    super(playerName);
    this.randomNumberGenerator = new Random(seed);
  }
}
