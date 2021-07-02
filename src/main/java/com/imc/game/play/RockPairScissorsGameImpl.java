package com.imc.game.play;

import com.imc.game.Selection;
import com.imc.game.gamer.Gamer;
import com.imc.game.rules.GameRule;
import com.imc.game.utils.InOutRunner;

import lombok.Builder;

import java.util.Optional;

@Builder
public class RockPairScissorsGameImpl implements RockPairScissorsGame {

    private final Gamer firstGamer;
    private final Gamer secondGamer;
    private final GameRule gameRule;

    @Override
    public Optional<Gamer> run(InOutRunner inOutRunner) {

        try {
            Selection firstGamerSelection = firstGamer.getSelection();
            Selection secondGamerSelection = secondGamer.getSelection();

            inOutRunner.printWithNewLine(firstGamer.getName() + " selected " + firstGamerSelection.name());
            inOutRunner.printWithNewLine(secondGamer.getName() + " selected " + secondGamerSelection.name());

            Optional<Gamer> roundWinner = Optional.empty();
            if (gameRule.get(firstGamerSelection).beats(secondGamerSelection)) {
                roundWinner = Optional.of(firstGamer);
            } else if (gameRule.get(secondGamerSelection).beats(firstGamerSelection)) {
                roundWinner = Optional.of(secondGamer);
            }

            if (roundWinner.isPresent()) {
                inOutRunner.printWithNewLine(roundWinner.get().getName() + " WINS!");
            } else {
                inOutRunner.printWithNewLine("It's a DRAW!");
            }

            return roundWinner;
        } catch (Exception e) {
            inOutRunner.printWithNewLine("Wrong input was given");
        }
        return Optional.empty();
    }
}
