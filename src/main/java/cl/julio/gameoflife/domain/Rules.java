package cl.julio.gameoflife.domain;

/**
 * Any live cell with fewer than two live neighbours dies, as if caused by
 * underpopulation.
 *
 * Any live cell with two or three live neighbours lives on to the next
 * generation.
 *
 * Any live cell with more than three live neighbours dies, as if by
 * overpopulation.
 *
 * Any dead cell with exactly three live neighbours becomes a live cell, as if
 * by reproduction.
 *
 * @author julio
 *
 */
public class Rules {

    private Rules() {
        // static class
    }

    public static Cell getNewState(Cell currentState, int liveNeighbours) {
        if (currentState == Cell.ALIVE)
            return liveNeighbours < 2 || liveNeighbours > 3 ? Cell.DEAD : Cell.ALIVE;

        if (currentState == Cell.DEAD && liveNeighbours == 3)
            return Cell.ALIVE;

        return currentState;
    }

}

