package cl.julio.gameoflife.domain;

import javax.swing.JComponent;
import java.awt.*;

public class Board extends JComponent {

    private final Game game;
    private int scale;

    public Board(Game game, int scale) {
        this.game = game;
        this.scale = scale;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.setColor(Color.BLACK);

        Cell[][] cells = game.getCells();

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if (cells[i][j] == Cell.ALIVE)
                    graphics.fillRect(j * scale, i * scale, scale, scale);
            }
        }

    }

}
