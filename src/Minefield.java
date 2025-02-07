public class Minefield {

    GridSquare[][] minefield;

    public Minefield(int size) {
        minefield = new GridSquare[size][size];
        InstantiateGridSquares();
    }

    private void InstantiateGridSquares() {
        for (int i = 0; i < minefield.length; i++) {
            for (int x = 0; x < minefield[i].length; x++) {
                minefield[i][x] = new GridSquare((int)(Math.random() * 5) == 1, x, i);
            }
        }
        for (GridSquare[] gridSquares : minefield) {
            for (GridSquare gridSquare : gridSquares) {
                gridSquare.FindAdjacentMines(minefield);
            }
        }
    }

    public boolean SquareHasMine(int x, int y) {
        return minefield[x][y].HasMine();
    }

    public void RevealSquare(int x, int y) {
        minefield[x][y].SetRevealed(true, minefield);
    }

    public void PrintMinefield() {
        for (GridSquare[] row : minefield) {
            for (GridSquare gridSquare : row) {
                if (gridSquare.IsRevealed()) {
                    System.out.print(" " + gridSquare.GetAdjacentMines() + " ");
                } else {
                    System.out.print(" - ");
                }
            }
            System.out.println();
        }
    }

    public void RevealMinefield() {
        for (GridSquare[] row : minefield) {
            for (GridSquare gridSquare : row) {
                if (gridSquare.HasMine()) {
                    System.out.print(" # ");
                } else {
                    System.out.print(" " + gridSquare.GetAdjacentMines() + " ");
                }
            }
            System.out.println();
        }
    }

    public boolean CheckWin() {
        for (GridSquare[] row: minefield) {
            for (GridSquare gridSquare : row) {
                if (!gridSquare.HasMine() && !gridSquare.IsRevealed()) {
                    return false;
                }
            }
        }
        return true;
    }


}
