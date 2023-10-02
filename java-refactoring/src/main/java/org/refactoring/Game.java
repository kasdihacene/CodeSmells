package org.refactoring;

import java.util.Objects;

public class Game {
    private Player.PlayerSymbol theCurrentPlayer;
    private Board board = new Board();

    // Rename variable to express the intention
    // Create value object to wrap primitives (Primitive obsession)
    public void play(char symbol, int x, int y, Player.PlayerSymbol playerSymbol) throws Exception {

        isFirstMoveAllowed(playerSymbol);
        hasPlayerAlreadyPlayed(playerSymbol);
        isAllowedPosition(x, y);

        // update game state
        // Extract method
        theCurrentPlayer = playerSymbol;
        board.AddTileAt(symbol,playerSymbol, x, y);
    }

    private void isAllowedPosition(int x, int y) throws Exception {
        if (board.TileAt(x, y).Symbol != ' ') { // Apply Tell don't ask principal + avoid exposing the state of the object + extract method intention
            throw new Exception("Invalid position");
        }
    }

    private void hasPlayerAlreadyPlayed(Player.PlayerSymbol playerSymbol) throws Exception {
        //if not first move but player repeated
        if (playerSymbol.equals(theCurrentPlayer)) { // Wrap the behavior in the value type - playerToken.isAs(lastPlayerToken)
            throw new Exception("Invalid next player");
        }
    }

    private void isFirstMoveAllowed(Player.PlayerSymbol playerSymbol) throws Exception {
        if (Objects.isNull(theCurrentPlayer)) {
            //if player is X
            if (playerSymbol.equals(Player.PlayerSymbol.PLAYER_O)) {
                throw new Exception("Invalid first player");
            }
        }
    }

    // Feature Envy - class uses methods and properties of another class
    public char getWinner() {
        return board.getCompletedCombination();
    }

}

