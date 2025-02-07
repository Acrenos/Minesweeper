import java.util.Arrays;

public class GridSquare {

    private int xPosition;
    private int yPosition;
    private int adjacentMines;
    private boolean hasMine;
    private boolean revealed;

    public GridSquare(boolean hasMine, int xPosition, int yPosition) {
        this.hasMine = hasMine;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        revealed = false;
    }

    public boolean HasMine() {
        return hasMine;
    }

    public int GetAdjacentMines() {
        return adjacentMines;
    }

    public boolean IsRevealed() {
        return revealed;
    }

    public void SetRevealed(boolean revealed, GridSquare[][] gridSquares) {
        if (this.revealed == revealed) {
            return;
        }
        this.revealed = revealed;
        int xAdd = xPosition == 0 ? 1 : 0;
        int xMinus = xPosition == gridSquares[xPosition].length - 1 ? -1 : 0;
        int yAdd = yPosition == 0 ? 1 : 0;
        int yMinus = yPosition == gridSquares.length - 1 ? -1 : 0;
        if (adjacentMines == 0) {
            for (int i = xPosition - 1 + xAdd; i <= xPosition + 1 + xMinus; i++) {
                for (int x = yPosition - 1 + yAdd; x <= yPosition + 1 + yMinus; x++) {
                    if (!(x == xPosition && i == yPosition)) {
                        gridSquares[x][i].SetRevealed(true, gridSquares);
                    }

                }
            }
        }
    }

    public void FindAdjacentMines(GridSquare[][] gridSquares) {
        adjacentMines = 0;
        int xAdd = xPosition == 0 ? 1 : 0;
        int xMinus = xPosition == gridSquares[xPosition].length - 1 ? -1 : 0;
        int yAdd = yPosition == 0 ? 1 : 0;
        int yMinus = yPosition == gridSquares.length - 1 ? -1 : 0;
        for (int i = xPosition - 1 + xAdd; i <= xPosition + 1 + xMinus; i++) {
            for (int x = yPosition - 1 + yAdd; x <= yPosition + 1 + yMinus; x++) {
                if (gridSquares[x][i].HasMine()) {
                    adjacentMines++;
                }
            }
        }



    }




}
