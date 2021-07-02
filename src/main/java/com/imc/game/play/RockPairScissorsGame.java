package com.imc.game.play;

import com.imc.game.gamer.Gamer;
import com.imc.game.utils.InOutRunner;

import java.util.Optional;

public interface RockPairScissorsGame {
  Optional<Gamer> run(InOutRunner inOutRunner);
}
