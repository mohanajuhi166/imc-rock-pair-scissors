package com.imc.game.utils;

import com.imc.game.Selection;

import java.util.function.Predicate;

public interface AppliedStep extends Predicate<Selection> {

  default boolean beats(Selection selection) {
    return test(selection);
  }

}
