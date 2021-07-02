package com.imc.game.rules;

import com.google.common.collect.ImmutableMap;
import com.imc.game.Selection;
import com.imc.game.exception.NotAvailableException;
import com.imc.game.utils.AppliedStep;

import java.util.Map;

public class GameRuleImpl implements GameRule {

    private final Map<Selection, AppliedStep> step;

    private static GameRuleImpl gameRule = new GameRuleImpl();

    public static GameRuleImpl getInstance() {
        return gameRule;
    }

    private GameRuleImpl() {
        this.step = ImmutableMap.of(
                Selection.ROCK, opponent -> opponent == Selection.SCISSORS,
                Selection.PAPER, opponent -> opponent == Selection.ROCK,
                Selection.SCISSORS, opponent -> opponent == Selection.PAPER
        );
    }

    @Override
    public AppliedStep get(Selection selection) {
        if (!step.containsKey(selection)) {
            throw new NotAvailableException("NA step for selection " + selection.name());
        }
        return step.get(selection);
    }

}
