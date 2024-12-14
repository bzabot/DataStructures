import java.util.Scanner;

public class ED164 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int quant = s.nextInt();
        BSTree<String> t = new BSTree<String>();

        for (int i = 0; i < quant; i++)
            t.insert(s.next());

        System.out.println(t.numberNodes());

        s.close();
    }
}