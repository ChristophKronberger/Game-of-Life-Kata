package org.example;

public class GameOfLife {


    private final int[][] board;


    public GameOfLife(int[][] board) {
        this.board = board;
    }

    public boolean isCellAlive(int x, int y) {
        return board[x][y] == 1;
    }

    /*
    A living cell with fewer than two neighbors dies.
    A living cell with more than three neighbors dies.
    A living cell with two or three neighbors lives.
    A dead cell with exactly three neighbors becomes alive.
     */
    public boolean nextState(int x, int y){
        int numberOfneighbours = getNumberOfNeighbours(x,y);
        if(isCellAlive(x,y)){
            return numberOfneighbours >= 2 && numberOfneighbours <= 3;
        }else {
            if(numberOfneighbours == 3) return true;
        }
        return true;
    }
    public int getNumberOfNeighbours(int x, int y){
        return checkLeft(x, y) + checkRight(x, y)+ checkBottom(x,y) + checkTop(x,y) +checkDiagonal(x,y);
    }

    private int checkRight(int x, int y) {
        try{
            return board[x][y+1];
        }catch (ArrayIndexOutOfBoundsException ignored){
            return 0;
        }
    }

    private int checkLeft(int x, int y) {
        try{
            return board[x][y-1];
        }catch (ArrayIndexOutOfBoundsException ignored){
            return 0;
        }
    }

    private int checkBottom(int x, int y) {
        try{
            return board[x+1][y];
        }catch (ArrayIndexOutOfBoundsException ignored){
            return 0;
        }
    }

    private int checkTop(int x, int y) {
        try{
            return board[x-1][y];
        }catch (ArrayIndexOutOfBoundsException ignored){
            return 0;
        }
    }

    private int checkDiagonal(int x, int y) {
      return bottomLeft(x,y) + bottomRight(x,y) + topLeft(x,y) + topRight(x,y);
    }


    private int bottomLeft(int x, int y){

        try {
            return board[x + 1][y - 1];
        } catch (ArrayIndexOutOfBoundsException i) {
            return 0;
        }

    }
    private int bottomRight(int x, int y){
        try{
            return board[x+1][y+1];
        }catch (ArrayIndexOutOfBoundsException ignored){
            return 0;
        }
    }
    private int topLeft(int x, int y){
        try{
            return board[x-1][y-1];
        }catch (ArrayIndexOutOfBoundsException ignored){
            return 0;
        }
    }
    private int topRight(int x, int y){
        try{
            return board[x-1][y+1];
        }catch (ArrayIndexOutOfBoundsException ignored){
            return 0;
        }
    }



}
