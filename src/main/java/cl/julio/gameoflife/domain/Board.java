package cl.julio.gameoflife.domain;

import java.util.Random;

public class Board {

    private Cell[][] cells;

    public Board(int width, int height) {
        this.cells = new Cell[width][height];
    }



}
