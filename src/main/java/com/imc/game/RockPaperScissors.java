package com.imc.game;

import com.imc.game.play.RockPairScissorsGameImpl;
import com.imc.game.gamer.CompGamer;
import com.imc.game.gamer.UserGamer;
import com.imc.game.rules.GameRuleImpl;
import com.imc.game.utils.InOutRunner;

import java.util.stream.IntStream;

public class RockPaperScissors {

    public static void start() {
        InOutRunner inOutRunner = new InOutRunner();
        inOutRunner.printWithNewLine("Welcome to the Game of --> Rock/Paper/Scissors");
        inOutRunner.printWithNewLine("");

        UserGamer userGamer = UserGamer.create(inOutRunner);
        CompGamer computerGamer = CompGamer.createWithName("computer");

        RockPairScissorsGameImpl game = RockPairScissorsGameImpl.builder()
                .firstGamer(userGamer)
                .secondGamer(computerGamer)
                .gameRule(GameRuleImpl.getInstance())
                .build();

        inOutRunner.printWithNewLine("");
        inOutRunner.print("Enter number of rounds: ");
        Integer rounds = inOutRunner.getInt();

        IntStream.range(1, rounds + 1).forEach(roundNumber -> {
            inOutRunner.printWithNewLine("");
            inOutRunner.printWithNewLine("Game #" + roundNumber + " of " + rounds);
            game.run(inOutRunner);
        });
    }

}
