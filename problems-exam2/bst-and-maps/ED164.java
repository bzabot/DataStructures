import java.util.Scanner;

public class ED164 {
    public static void main(String[] args) {
        // Declarações
        Scanner s = new Scanner(System.in);
        BSTree<String> names = new BSTree<>();

        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            names.insert(s.next());
        }
        System.out.println(names.numberNodes());
        s.close();
    }

}