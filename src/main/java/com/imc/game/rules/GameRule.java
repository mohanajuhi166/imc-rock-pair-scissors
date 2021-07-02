package com.imc.game.rules;

import com.imc.game.Selection;
import com.imc.game.utils.AppliedStep;

public interface GameRule {
  AppliedStep get(Selection selection);
}
