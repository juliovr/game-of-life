package cl.julio.gameoflife.domain;

import java.util.Random;

public class Game {

    private final Random random;

    public Game(Random random) {
        this.random = random;
    }

    public Cell getRandomCellState() {
        return Cell.values()[random.nextInt(Cell.values().length)];
    }

    public int getNumberOfLiveNeighbours(Cell[][] cells, int i, int j) {
        int minIndexI = Math.max(i - 1, 0);
        int maxIndexI = Math.min(i + 1, cells.length - 1);

        int minIndexJ = Math.max(j - 1, 0);
        int maxIndexJ = Math.min(j + 1, cells[0].length - 1);

        int liveNeighbours = 0;

        for (int k = minIndexI; k <= maxIndexI; k++) {
            for (int l = minIndexJ; l <= maxIndexJ; l++) {
                if (k == i && l == j)
                    continue;

                if (cells[k][l] == Cell.ALIVE)
                    liveNeighbours++;
            }
        }

        return liveNeighbours;
    }

    public Cell[][] getNewCells(Cell[][] cells) {
        int n = cells.length;
        int m = cells[0].length;
        Cell[][] newCells = new Cell[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int liveNeighbours = getNumberOfLiveNeighbours(cells, i, j);
                newCells[i][j] = Rules.getNewState(cells[i][j], liveNeighbours);
            }
        }

        return newCells;
    }

}
