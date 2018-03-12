package cl.julio.gameoflife;

import cl.julio.gameoflife.domain.Cell;
import cl.julio.gameoflife.domain.Game;
import cl.julio.gameoflife.domain.Board;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Main {

    public static final String TITLE = "Game of life";
    private static final int SCALE = 20;
    public static final int REFRESH_SECONDS = 1 * 1000;
    private static final Component CENTER_POSITION = null;

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        int width = 10;
        int height = 10;
        Game game = new Game(random, width, height);

        Board board = new Board(game, SCALE);

        JFrame frame = new JFrame(TITLE);
        frame.setSize(width * (SCALE + 2), height * (SCALE + 5));
        frame.setLocationRelativeTo(CENTER_POSITION);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.getContentPane().add(board, BorderLayout.CENTER);
        frame.setVisible(true);

        while (true) {
            Thread.sleep(REFRESH_SECONDS);
            game.updateCells();
            board.repaint();
        }

    }

}
