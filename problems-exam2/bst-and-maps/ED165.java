import java.util.Arrays;
import java.util.Scanner;

public class ED165 {

    // static BSTree<Integer> numbers = new BSTree<>();

    // public static void main(String[] args) {

    // // Ler conjunto de números
    // Scanner s = new Scanner(System.in);
    // int size = s.nextInt();
    // for (int i = 0; i < size; i++) {
    // numbers.insert(s.nextInt());
    // }

    // s.close();
    // }

    // public static boolean check(int value) {
    // return check(numbers.getRoot(), value);
    // }
    // private static boolean check(BSTNode<Integer> n, int value){
    // if(n == null) return false;

    // if(value > n.getValue()) return check(n.getRight(), value);
    // if(value < n.getValue()) return check(n.getLeft(), value);

    // return true;
    // }

    static int[] numbers;

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        numbers = new int[s.nextInt()];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = s.nextInt();
        }

        Arrays.sort(numbers);

        int c = s.nextInt();
        for (int i = 0; i < c; i++) {
            int v = s.nextInt();
            if (check(v)) {
                System.out.println(v + ": sim");
            } else {
                System.out.println(v + ": nao");
            }

        }
        s.close();
    }

    public static boolean check(int value) {

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > value)
                return false;
            for (int j = i; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == value)
                    return true;
            }
        }
        return false;
    }

}