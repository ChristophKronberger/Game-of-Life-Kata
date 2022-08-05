import org.example.GameOfLife;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameOfLifeTest {

    @Test
    void test(){
        assertFalse(false);
    }

    @Test
    void isCellAlive() {

        int[][] board = {
                {0,0,0},
                {0,1,0},
                {1,0,1}
        };

        GameOfLife gof = new GameOfLife(board);

        assertTrue(gof.isCellAlive(1, 1));
        assertFalse(gof.isCellAlive(0,0));
    }

    @Test
    void numOfNeighbours() {
        int[][] board = {
                {0,0,0},
                {0,1,0},
                {1,0,1}
        };

        GameOfLife gof = new GameOfLife(board);

        assertEquals(2, gof.getNumberOfNeighbours(1,1));
        assertEquals(1, gof.getNumberOfNeighbours(0,1));


    }

    @Test
    void numOfNeighbours1() {
        int[][] board = {
                {0,0,0,0,0,0},
                {0,0,1,0,0,0},
                {0,0,1,0,0,0},
                {0,0,0,0,1,0},
                {0,0,0,0,1,0},
                {0,0,1,1,0,0}
        };
        GameOfLife gof = new GameOfLife(board);

        assertEquals(2, gof.getNumberOfNeighbours(5,4));
        assertEquals(4, gof.getNumberOfNeighbours(4,3));
        assertEquals(0, gof.getNumberOfNeighbours(0,0));
        assertEquals(1, gof.getNumberOfNeighbours(0,3));
    }

    @Test
    void stateNextRound() {
        int[][] board = {
                {0,1,0},
                {1,1,1},
                {0,1,1}
        };
        GameOfLife gof = new GameOfLife(board);

        assertFalse(gof.nextState(1, 2));
        assertTrue(gof.nextState(0, 0));
    }
}
