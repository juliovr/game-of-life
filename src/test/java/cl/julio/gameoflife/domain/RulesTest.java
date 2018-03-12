package cl.julio.gameoflife.domain;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static cl.julio.gameoflife.domain.Cell.ALIVE;
import static cl.julio.gameoflife.domain.Cell.DEAD;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class RulesTest {

    @Test
    @Parameters({"0", "1"})
    public void anyLiveCellWithFewerThanTwoLiveNeighboursDies(int neighbours) {
        Cell newState = Rules.getNewState(ALIVE, neighbours);

        assertThat(newState, is(DEAD));
    }

    @Test
    @Parameters({"2", "3"})
    public void anyLiveCellWithTwoOrThreeLiveNeighboursLives(int neighbours) {
        Cell newState = Rules.getNewState(ALIVE, neighbours);

        assertThat(newState, is(ALIVE));
    }

    @Test
    @Parameters({"4", "5", "6"})
    public void anyLiveCellWithMoreThanThreeLiveNeighboursDies(int neighbours) {
        Cell newState = Rules.getNewState(ALIVE, neighbours);

        assertThat(newState, is(DEAD));
    }

    @Test
    @Parameters({"3"})
    public void anyDeadCellWithExactlyThreeLiveNeighboursBecomesALiveCell(int neighbours) {
        Cell newState = Rules.getNewState(DEAD, neighbours);

        assertThat(newState, is(ALIVE));
    }

    @Test
    @Parameters({"1", "2", "4", "5"})
    public void anyDeadCellWithLessOrMoreThanThreeLiveNeighboursRemainsDead(int neighbours) {
        Cell newState = Rules.getNewState(DEAD, neighbours);

        assertThat(newState, is(DEAD));
    }

    @Test
    public void checkLiveNeighbours() {
        Cell[][] cells = {
                { ALIVE, DEAD, DEAD, ALIVE },
                { DEAD, ALIVE, ALIVE, ALIVE},
                { DEAD, ALIVE, DEAD, ALIVE },
                { DEAD, ALIVE, ALIVE, ALIVE},
        };

        assertThat(Rules.getNumberOfLiveNeighbours(cells, 0, 0), is(1));
        assertThat(Rules.getNumberOfLiveNeighbours(cells, 0, 1), is(3));
        assertThat(Rules.getNumberOfLiveNeighbours(cells, 0, 2), is(4));
        assertThat(Rules.getNumberOfLiveNeighbours(cells, 0, 3), is(2));

        assertThat(Rules.getNumberOfLiveNeighbours(cells, 1, 0), is(3));
        assertThat(Rules.getNumberOfLiveNeighbours(cells, 1, 1), is(3));
        assertThat(Rules.getNumberOfLiveNeighbours(cells, 1, 2), is(5));
        assertThat(Rules.getNumberOfLiveNeighbours(cells, 1, 3), is(3));

        assertThat(Rules.getNumberOfLiveNeighbours(cells, 2, 0), is(3));
        assertThat(Rules.getNumberOfLiveNeighbours(cells, 2, 1), is(4));
        assertThat(Rules.getNumberOfLiveNeighbours(cells, 2, 2), is(8));
        assertThat(Rules.getNumberOfLiveNeighbours(cells, 2, 3), is(4));

        assertThat(Rules.getNumberOfLiveNeighbours(cells, 3, 0), is(2));
        assertThat(Rules.getNumberOfLiveNeighbours(cells, 3, 1), is(2));
        assertThat(Rules.getNumberOfLiveNeighbours(cells, 3, 2), is(4));
        assertThat(Rules.getNumberOfLiveNeighbours(cells, 3, 3), is(2));
    }

}