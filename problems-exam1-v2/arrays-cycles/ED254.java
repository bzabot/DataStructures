import java.util.Scanner;

public class ED254 {
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {

        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            printY(s.nextInt());
        }
    }

    static void printY(int size) {
        // Os # ficam nas posições 0 + line e size - 1 - line
        for (int line = 0; line < size; line++) {
            if (line < size / 2) {
                for (int column = 0; column < size; column++) {
                    if (column == line || column == size - line - 1) {
                        System.out.print("#");
                    } else {
                        System.out.print(".");
                    }
                }
            } else {
                for (int column = 0; column < size; column++) {
                    if (column == size / 2)
                        System.out.print("#");
                    else
                        System.out.print(".");
                }
            }
            System.out.println();
        }
    }

}