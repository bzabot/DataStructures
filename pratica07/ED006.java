import java.util.Scanner;

public class ED006 {
    public static void main(String[] args) {
        Scanner std = new Scanner(System.in);

        int casos = std.nextInt();
        std.nextLine();

        for (int i = 0; i < casos; i++) {
            Game g = new Game(std);
            String[] phrase = g.words();

            CircularLinkedList<String> names = g.namesCircularList();

            while (names.size() > 1) {
                names = g.elimination(phrase, names);
            }

            System.out.println(g.res(names.getFirst()));

        }

        std.close();

    }
}

class Game {
    private Scanner scn;

    Game(Scanner std) {
        scn = std;
    }

    public String[] words() {
        return scn.nextLine().split(" ");
    }

    public CircularLinkedList<String> namesCircularList() {
        CircularLinkedList<String> names = new CircularLinkedList<>();
        String[] lineNames = scn.nextLine().split(" ");
        for (int i = 1; i < Integer.parseInt(lineNames[0]) + 1; i++) {
            names.addLast(lineNames[i]);
        }
        return names;
    }

    public CircularLinkedList<String> elimination(String[] phrase, CircularLinkedList<String> names) {
        for (String word : phrase) {
            names.rotate();
        }
        names.removeLast();
        return names;
    }

    public String res(String loser) {
        String ans = "";

        if (loser.equals("Carlos")) {
            ans += "O Carlos nao se livrou";
        } else {
            ans += "O Carlos livrou-se (coitado do " + loser + "!)";
        }

        return ans;
    }

}