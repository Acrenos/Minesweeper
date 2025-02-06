import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Minefield minefield = new Minefield(10);

        minefield.PrintMinefield();

        boolean gameLoop = true;

        Scanner input = new Scanner(System.in);

        while (gameLoop) {
            System.out.println("What row would you like to uncover?");
            int row = input.nextInt();
            System.out.println("What column?");
            int col = input.nextInt();
            if (minefield.SquareHasMine(row, col)) {
                System.out.println("There was a mine there! You Lose!");
                gameLoop = false;
            } else {
                minefield.RevealSquare(row, col);
            }
        }

    }
}