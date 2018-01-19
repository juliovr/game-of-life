package cl.julio.gameoflife.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Random;

import static cl.julio.gameoflife.domain.Cell.ALIVE;
import static cl.julio.gameoflife.domain.Cell.DEAD;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class GameTest {

    @Mock
    private Random random;

    private Game game;

    @Before
    public void setUp() {
        game = new Game(random);
    }

    @Test
    public void checkRandomCellStateForAlive() {
        given(random.nextInt(Cell.values().length)).willReturn(0);

        assertThat(game.getRandomCellState(), is(ALIVE));
    }

    @Test
    public void checkRandomCellStateForDead() {
        given(random.nextInt(Cell.values().length)).willReturn(1);

        assertThat(game.getRandomCellState(), is(DEAD));
    }

    @Test
    public void checkLiveNeighbours() {
        Cell[][] cells = {
                { ALIVE, DEAD, DEAD, ALIVE },
                { DEAD, ALIVE, ALIVE, ALIVE},
                { DEAD, ALIVE, DEAD, ALIVE },
                { DEAD, ALIVE, ALIVE, ALIVE},
        };

        assertThat(game.getNumberOfLiveNeighbours(cells, 0, 0), is(1));
        assertThat(game.getNumberOfLiveNeighbours(cells, 0, 1), is(3));
        assertThat(game.getNumberOfLiveNeighbours(cells, 0, 2), is(4));
        assertThat(game.getNumberOfLiveNeighbours(cells, 0, 3), is(2));

        assertThat(game.getNumberOfLiveNeighbours(cells, 1, 0), is(3));
        assertThat(game.getNumberOfLiveNeighbours(cells, 1, 1), is(3));
        assertThat(game.getNumberOfLiveNeighbours(cells, 1, 2), is(5));
        assertThat(game.getNumberOfLiveNeighbours(cells, 1, 3), is(3));

        assertThat(game.getNumberOfLiveNeighbours(cells, 2, 0), is(3));
        assertThat(game.getNumberOfLiveNeighbours(cells, 2, 1), is(4));
        assertThat(game.getNumberOfLiveNeighbours(cells, 2, 2), is(8));
        assertThat(game.getNumberOfLiveNeighbours(cells, 2, 3), is(4));

        assertThat(game.getNumberOfLiveNeighbours(cells, 3, 0), is(2));
        assertThat(game.getNumberOfLiveNeighbours(cells, 3, 1), is(2));
        assertThat(game.getNumberOfLiveNeighbours(cells, 3, 2), is(4));
        assertThat(game.getNumberOfLiveNeighbours(cells, 3, 3), is(2));
    }

    @Test
    public void testBlockPattern() {
        Cell[][] cells = {
                {DEAD, DEAD, DEAD, DEAD},
                {DEAD, ALIVE, ALIVE, DEAD},
                {DEAD, ALIVE, ALIVE, DEAD},
                {DEAD, DEAD, DEAD, DEAD}
        };

        assertThat(game.getNewCells(cells), is(cells));
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

        assertThat(game.getNewCells(cells), is(cells));
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

        assertThat(game.getNewCells(cells), is(cells));
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

        assertThat(game.getNewCells(cells), is(cells));
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

        assertThat(game.getNewCells(cells), is(expectedCells));

        //inverse process
        assertThat(game.getNewCells(expectedCells), is(cells));
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

        assertThat(game.getNewCells(cells), is(expectedCells));

        //inverse process
        assertThat(game.getNewCells(expectedCells), is(cells));
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

        assertThat(game.getNewCells(cells), is(expectedCells));

        //inverse process
        assertThat(game.getNewCells(expectedCells), is(cells));
    }

}
