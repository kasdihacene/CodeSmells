<?php

namespace TicTacToe;

class org.refactoring.Board
{
    /** @var org.refactoring.Tile[] */
    private $plays;

    public function __construct()
    {
        for ($i = 0; $i < 3; $i++) {
            for ($j = 0; $j < 3; $j++) {
                $tile = new org.refactoring.Tile();
                $tile->x = $i;
                $tile->y = $j;
                $tile->symbol = ' ';
                $this->plays[] = $tile;
            }
        }
    }

    public function tileAt(int $x, int $y): org.refactoring.Tile
    {
        foreach ($this->plays as $t) {
            if ($t->x == $x && $t->y == $y){
                return $t;
            }
        }
        return null;
    }

    public function addTileAt(string $symbol, int $x, int $y): void
    {
        $newTile = new org.refactoring.Tile();
        $newTile->x = $x;
        $newTile->y = $y;
        $newTile->symbol = $symbol;

        $this->tileAt($x, $y)->symbol = $symbol;
    }
}
