package cl.julio.gameoflife.domain;

import org.junit.Test;

import static cl.julio.gameoflife.domain.Cell.ALIVE;
import static cl.julio.gameoflife.domain.Cell.DEAD;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GamePatternsTest {

    @Test
    public void testBlockPattern() {
        Cell[][] cells = {
                {DEAD, DEAD, DEAD, DEAD},
                {DEAD, ALIVE, ALIVE, DEAD},
                {DEAD, ALIVE, ALIVE, DEAD},
                {DEAD, DEAD, DEAD, DEAD}
        };

        Game game = new Game(cells);
        game.updateCells();

        assertThat(game.getCells(), is(cells));
    }

    @Test
    public void testBoatPattern() {
        Cell[][] cells = {
                {DEAD, DEAD, DEAD, DEAD, DEAD},
                {DEAD, ALIVE, ALIVE, DEAD, DEAD},
                {DEAD, ALIVE, DEAD, ALIVE, DEAD},
                {DEAD, DEAD, ALIVE, DEAD, DEAD},
                {DEAD, DEAD, DEAD, DEAD, DEAD}
        };

        Game game = new Game(cells);
        game.updateCells();

        assertThat(game.getCells(), is(cells));
    }

    @Test
    public void testLoafPattern() {
        Cell[][] cells = {
                {DEAD, DEAD, DEAD, DEAD, DEAD, DEAD},
                {DEAD, DEAD, ALIVE, ALIVE, DEAD, DEAD},
                {DEAD, ALIVE, DEAD, DEAD, ALIVE, DEAD},
                {DEAD, DEAD, ALIVE, DEAD, ALIVE, DEAD},
                {DEAD, DEAD, DEAD, ALIVE, DEAD, DEAD},
                {DEAD, DEAD, DEAD, DEAD, DEAD, DEAD}
        };

        Game game = new Game(cells);
        game.updateCells();

        assertThat(game.getCells(), is(cells));
    }

    @Test
    public void testBeehivePattern() {
        Cell[][] cells = {
                {DEAD, DEAD, DEAD, DEAD, DEAD, DEAD},
                {DEAD, DEAD, ALIVE, ALIVE, DEAD, DEAD},
                {DEAD, ALIVE, DEAD, DEAD, ALIVE, DEAD},
                {DEAD, DEAD, ALIVE, ALIVE, DEAD, DEAD},
                {DEAD, DEAD, DEAD, DEAD, DEAD, DEAD}
        };

        Game game = new Game(cells);
        game.updateCells();

        assertThat(game.getCells(), is(cells));
    }

    @Test
    public void testBlinkerPattern() {
        Cell[][] cells = {
                {DEAD, DEAD, DEAD, DEAD, DEAD},
                {DEAD, DEAD, DEAD, DEAD, DEAD},
                {DEAD, ALIVE, ALIVE, ALIVE, DEAD},
                {DEAD, DEAD, DEAD, DEAD, DEAD},
                {DEAD, DEAD, DEAD, DEAD, DEAD}
        };

        Cell[][] expectedCells = {
                {DEAD, DEAD, DEAD, DEAD, DEAD},
                {DEAD, DEAD, ALIVE, DEAD, DEAD},
                {DEAD, DEAD, ALIVE, DEAD, DEAD},
                {DEAD, DEAD, ALIVE, DEAD, DEAD},
                {DEAD, DEAD, DEAD, DEAD, DEAD}
        };

        Game game = new Game(cells);
        game.updateCells();

        assertThat(game.getCells(), is(expectedCells));

        //inverse process
        game.updateCells();
        assertThat(game.getCells(), is(cells));
    }

    @Test
    public void testBeaconPattern() {
        Cell[][] cells = {
                {DEAD, DEAD, DEAD, DEAD, DEAD, DEAD},
                {DEAD, ALIVE, ALIVE, DEAD, DEAD, DEAD},
                {DEAD, ALIVE, ALIVE, DEAD, DEAD, DEAD},
                {DEAD, DEAD, DEAD, ALIVE, ALIVE, DEAD},
                {DEAD, DEAD, DEAD, ALIVE, ALIVE, DEAD},
                {DEAD, DEAD, DEAD, DEAD, DEAD, DEAD}
        };

        Cell[][] expectedCells = {
                {DEAD, DEAD, DEAD, DEAD, DEAD, DEAD},
                {DEAD, ALIVE, ALIVE, DEAD, DEAD, DEAD},
                {DEAD, ALIVE, DEAD, DEAD, DEAD, DEAD},
                {DEAD, DEAD, DEAD, DEAD, ALIVE, DEAD},
                {DEAD, DEAD, DEAD, ALIVE, ALIVE, DEAD},
                {DEAD, DEAD, DEAD, DEAD, DEAD, DEAD}
        };

        Game game = new Game(cells);
        game.updateCells();

        assertThat(game.getCells(), is(expectedCells));

        //inverse process
        game.updateCells();
        assertThat(game.getCells(), is(cells));
    }

    @Test
    public void testToadPattern() {
        Cell[][] cells = {
                {DEAD, DEAD, DEAD, DEAD, DEAD, DEAD},
                {DEAD, DEAD, DEAD, DEAD, DEAD, DEAD},
                {DEAD, DEAD, ALIVE, ALIVE, ALIVE, DEAD},
                {DEAD, ALIVE, ALIVE, ALIVE, DEAD, DEAD},
                {DEAD, DEAD, DEAD, DEAD, DEAD, DEAD},
                {DEAD, DEAD, DEAD, DEAD, DEAD, DEAD}
        };

        Cell[][] expectedCells = {
                {DEAD, DEAD, DEAD, DEAD, DEAD, DEAD},
                {DEAD, DEAD, DEAD, ALIVE, DEAD, DEAD},
                {DEAD, ALIVE, DEAD, DEAD, ALIVE, DEAD},
                {DEAD, ALIVE, DEAD, DEAD, ALIVE, DEAD},
                {DEAD, DEAD, ALIVE, DEAD, DEAD, DEAD},
                {DEAD, DEAD, DEAD, DEAD, DEAD, DEAD}
        };

        Game game = new Game(cells);
        game.updateCells();

        assertThat(game.getCells(), is(expectedCells));

        //inverse process
        game.updateCells();
        assertThat(game.getCells(), is(cells));
    }

}
