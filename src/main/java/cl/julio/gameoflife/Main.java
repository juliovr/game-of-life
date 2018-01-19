package cl.julio.gameoflife;

import cl.julio.gameoflife.domain.Cell;
import cl.julio.gameoflife.domain.Game;

import java.util.Random;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        int n = 10;

        Game game = new Game(new Random());

        Cell[][] cells = new Cell[n][n];

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = game.getRandomCellState();
            }
        }

        while (true) {
            clearScreen(n);
            printCells(cells);

            cells = game.getNewCells(cells);

            Thread.sleep(1000);
        }
    }

    public static void clearScreen(int nLines) {
        for (int i = 0; i < nLines; i++) {
            System.out.println();
        }
    }

    private static void printCells(Cell[][] cells) {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                printCell(cells[i][j]);
            }
            System.out.println();
        }
    }

    private static void printCell(Cell cellState) {
        if (cellState == Cell.ALIVE)
            System.out.print("0");
        else
            System.out.print("*");
    }

}
