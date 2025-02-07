import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Minefield minefield = new Minefield(10);



        boolean gameLoop = true;

        Scanner input = new Scanner(System.in);


        minefield.RevealMinefield();

        while (gameLoop) {
            minefield.PrintMinefield();
            System.out.println("What row would you like to uncover?");
            int row = input.nextInt() - 1;
            System.out.println("What column?");
            int col = input.nextInt() - 1;
            if (minefield.SquareHasMine(row, col)) {
                System.out.println("There was a mine there! You Lose!");
                gameLoop = false;
            } else {
                minefield.RevealSquare(row, col);
            }
        }

    }
}