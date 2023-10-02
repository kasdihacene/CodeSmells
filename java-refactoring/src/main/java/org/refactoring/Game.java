package org.refactoring;

public class Game {
    private char _lastSymbol = ' ';
    private Board _board = new Board();

    // Rename variable to express the intention
    // Create value object to wrap primitives (Primitive obsession)
    public void Play(char symbol, int x, int y) throws Exception {
        //if first move
        if (_lastSymbol == ' ') { // extract method expressing the intention + rename variable
            //if player is X
            if (symbol == 'O') {
                throw new Exception("Invalid first player");
            }
        }
        //if not first move but player repeated
        else if (symbol == _lastSymbol) { // Wrap the behavior in the value type - playerToken.isAs(lastPlayerToken)
            throw new Exception("Invalid next player");
        }
        //if not first move but play on an already played tile
        else if (_board.TileAt(x, y).Symbol != ' ') { // Apply Tell don't ask principal + avoid exposing the state of the object + extract method intention
            throw new Exception("Invalid position");
        }

        // update game state
        // Extract method
        _lastSymbol = symbol;
        _board.AddTileAt(symbol, x, y);
    }

    // Feature Envy - class uses methods and properties of another class
    public char Winner() {
        //if the positions in first row are taken
        // Extract method for validating the first row and guess the winner
        // Ask Tile to get result instead of asking for the data
        // Message chain - too many dots
        if (_board.TileAt(0, 0).Symbol != ' ' &&
                _board.TileAt(0, 1).Symbol != ' ' &&
                _board.TileAt(0, 2).Symbol != ' ') {
            //if first row is full with same symbol
            if (_board.TileAt(0, 0).Symbol ==
                    _board.TileAt(0, 1).Symbol &&
                    _board.TileAt(0, 2).Symbol == _board.TileAt(0, 1).Symbol) {
                return _board.TileAt(0, 0).Symbol;
            }
        }

        //if the positions in first row are taken
        // Extract method for validating the first row and guess the winner
        if (_board.TileAt(1, 0).Symbol != ' ' &&
                _board.TileAt(1, 1).Symbol != ' ' &&
                _board.TileAt(1, 2).Symbol != ' ') {
            //if middle row is full with same symbol
            if (_board.TileAt(1, 0).Symbol ==
                    _board.TileAt(1, 1).Symbol &&
                    _board.TileAt(1, 2).Symbol ==
                            _board.TileAt(1, 1).Symbol) {
                return _board.TileAt(1, 0).Symbol;
            }
        }

        //if the positions in first row are taken
        // Extract method for validating the first row and guess the winner
        if (_board.TileAt(2, 0).Symbol != ' ' &&
                _board.TileAt(2, 1).Symbol != ' ' &&
                _board.TileAt(2, 2).Symbol != ' ') {
            //if middle row is full with same symbol
            if (_board.TileAt(2, 0).Symbol ==
                    _board.TileAt(2, 1).Symbol &&
                    _board.TileAt(2, 2).Symbol ==
                            _board.TileAt(2, 1).Symbol) {
                return _board.TileAt(2, 0).Symbol;
            }
        }

        // Return value object instead of primitive
        return ' ';
    }
}

