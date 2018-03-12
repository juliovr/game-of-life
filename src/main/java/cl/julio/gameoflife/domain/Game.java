package cl.julio.gameoflife.domain;

import java.util.Random;

public class Game {

    private final Random random;
    private Cell[][] cells;

    public Game(Random random, int width, int height) {
        this.random = random;
        this.cells = new Cell[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                cells[i][j] = getRandomCellState();
            }
        }
    }

    public Game(Cell[][] cells) {
        this.random = null;
        this.cells = cells;
    }

    public Cell[][] getCells() {
        return this.cells;
    }

    public Cell getRandomCellState() {
        return Cell.values()[random.nextInt(Cell.values().length)];
    }

    public void updateCells() {
        int n = cells.length;
        int m = cells[0].length;
        Cell[][] newCells = new Cell[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int liveNeighbours = Rules.getNumberOfLiveNeighbours(cells, i, j);
                newCells[i][j] = Rules.getNewState(cells[i][j], liveNeighbours);
            }
        }

        this.cells = newCells;
    }

}
