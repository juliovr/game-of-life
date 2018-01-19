package cl.julio.gameoflife.domain;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class RulesTest {

    @Test
    @Parameters({"0", "1"})
    public void anyLiveCellWithFewerThanTwoLiveNeighboursDies(int neighbours) {
        Cell newState = Rules.getNewState(Cell.ALIVE, neighbours);

        assertThat(newState, is(Cell.DEAD));
    }

    @Test
    @Parameters({"2", "3"})
    public void anyLiveCellWithTwoOrThreeLiveNeighboursLives(int neighbours) {
        Cell newState = Rules.getNewState(Cell.ALIVE, neighbours);

        assertThat(newState, is(Cell.ALIVE));
    }

    @Test
    @Parameters({"4", "5", "6"})
    public void anyLiveCellWithMoreThanThreeLiveNeighboursDies(int neighbours) {
        Cell newState = Rules.getNewState(Cell.ALIVE, neighbours);

        assertThat(newState, is(Cell.DEAD));
    }

    @Test
    @Parameters({"3"})
    public void anyDeadCellWithExactlyThreeLiveNeighboursBecomesALiveCell(int neighbours) {
        Cell newState = Rules.getNewState(Cell.DEAD, neighbours);

        assertThat(newState, is(Cell.ALIVE));
    }

    @Test
    @Parameters({"1", "2", "4", "5"})
    public void anyDeadCellWithLessOrMoreThanThreeLiveNeighboursRemainsDead(int neighbours) {
        Cell newState = Rules.getNewState(Cell.DEAD, neighbours);

        assertThat(newState, is(Cell.DEAD));
    }
}