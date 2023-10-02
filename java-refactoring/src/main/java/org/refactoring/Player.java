package org.refactoring;

public class Player {

    private final PlayerSymbol player;

    public Player(PlayerSymbol player) {
        this.player = player;
    }

    enum PlayerSymbol{
        PLAYER_X,
        PLAYER_O
    }
}
