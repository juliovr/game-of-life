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

    public static final int HEIGHT = 10;
    public static final int WIDTH = 10;
    public static final int INDEX_FOR_ALIVE_CELL = 0;
    public static final int INDEX_FOR_DEAD_CELL = 1;

    @Mock
    private Random random;


    @Test
    public void checkRandomCellStateForAlive() {
        given(random.nextInt(Cell.values().length)).willReturn(INDEX_FOR_ALIVE_CELL);

        Game game = new Game(random, WIDTH, HEIGHT);

        assertThat(game.getRandomCellState(), is(ALIVE));
    }

    @Test
    public void checkRandomCellStateForDead() {
        given(random.nextInt(Cell.values().length)).willReturn(INDEX_FOR_DEAD_CELL);

        Game game = new Game(random, WIDTH, HEIGHT);

        assertThat(game.getRandomCellState(), is(DEAD));
    }

    @Test
    public void checkAliveCellsRandomAssignInInitialization() {
        given(random.nextInt(Cell.values().length)).willReturn(INDEX_FOR_ALIVE_CELL);

        Game game = new Game(random, WIDTH, HEIGHT);

        Cell[][] cells = game.getCells();

        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                assertThat(cells[i][j], is(ALIVE));
            }
        }
    }

    @Test
    public void checkDeadCellsRandomAssignInInitialization() {
        given(random.nextInt(Cell.values().length)).willReturn(INDEX_FOR_DEAD_CELL);

        Game game = new Game(random, WIDTH, HEIGHT);

        Cell[][] cells = game.getCells();

        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                assertThat(cells[i][j], is(DEAD));
            }
        }
    }

}
