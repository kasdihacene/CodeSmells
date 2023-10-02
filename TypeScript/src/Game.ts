export class org.refactoring.Game {
    private _lastSymbol: string = ' ';
    private _board: org.refactoring.Board = new org.refactoring.Board();

    public Play(symbol: string, x: number, y: number) : void {
        //if first move
        if (this._lastSymbol == ' ') {
            //if player is X
            if (symbol == 'O') {
                throw new Error("Invalid first player");
            }
        }
        //if not first move but player repeated
        else if (symbol == this._lastSymbol) {
            throw new Error("Invalid next player");
        }
        //if not first move but play on an already played tile
        else if (this._board.TileAt(x, y).Symbol != ' ') {
            throw new Error("Invalid position");
        }

        // update game state
        this._lastSymbol = symbol;
        this._board.AddTileAt(symbol, x, y);
    }

    public Winner() : string {
        //if the positions in first row are taken
        if (this._board.TileAt(0, 0)!.Symbol != ' ' &&
                this._board.TileAt(0, 1)!.Symbol != ' ' &&
                this._board.TileAt(0, 2)!.Symbol != ' ') {
            //if first row is full with same symbol
            if (this._board.TileAt(0, 0)!.Symbol ==
                    this._board.TileAt(0, 1)!.Symbol &&
                    this._board.TileAt(0, 2)!.Symbol == this._board.TileAt(0, 1)!.Symbol) {
                return this._board.TileAt(0, 0)!.Symbol;
            }
        }

        //if the positions in first row are taken
        if (this._board.TileAt(1, 0)!.Symbol != ' ' &&
                this._board.TileAt(1, 1)!.Symbol != ' ' &&
                this._board.TileAt(1, 2)!.Symbol != ' ') {
            //if middle row is full with same symbol
            if (this._board.TileAt(1, 0)!.Symbol ==
                    this._board.TileAt(1, 1)!.Symbol &&
                    this._board.TileAt(1, 2)!.Symbol ==
                            this._board.TileAt(1, 1)!.Symbol) {
                return this._board.TileAt(1, 0)!.Symbol;
            }
        }

        //if the positions in first row are taken
        if (this._board.TileAt(2, 0)!.Symbol != ' ' &&
                this._board.TileAt(2, 1)!.Symbol != ' ' &&
                this._board.TileAt(2, 2)!.Symbol != ' ') {
            //if middle row is full with same symbol
            if (this._board.TileAt(2, 0)!.Symbol ==
                    this._board.TileAt(2, 1)!.Symbol &&
                    this._board.TileAt(2, 2)!.Symbol ==
                            this._board.TileAt(2, 1)!.Symbol) {
                return this._board.TileAt(2, 0)!.Symbol;
            }
        }

        return ' ';
    }
}

interface org.refactoring.Tile
{
    X: number;
    Y: number;
    Symbol: string;
}

class org.refactoring.Board
{
    private _plays : org.refactoring.Tile[] = [];

    constructor()
    {
        for (let i = 0; i < 3; i++)
        {
            for (let j = 0; j < 3; j++)
            {
                const tile : org.refactoring.Tile = {X :i, Y:j, Symbol:" "};
                this._plays.push(tile);
            }
        }
    }

    public TileAt(x:  number, y: number): org.refactoring.Tile {
        return this._plays.find((t:org.refactoring.Tile) => t.X == x && t.Y == y)!
    }

    public AddTileAt(symbol: string, x: number, y: number) : void
    {
        const tile : org.refactoring.Tile = {X :x, Y:y, Symbol:symbol};

        this._plays.find((t:org.refactoring.Tile) => t.X == x && t.Y == y)!.Symbol = symbol;
    }
}