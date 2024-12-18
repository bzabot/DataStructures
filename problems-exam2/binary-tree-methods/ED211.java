
public class ED211 {

    // --------------------------------------------------------

    // Contar o número de pares

    public static int countEven(BTree<Integer> t) {
        return countEven(t.getRoot());
    }

    private static int countEven(BTNode<Integer> t) {
        if (t == null)
            return 0;
        if (t.getValue() % 2 == 0) {
            return 1 + countEven(t.getLeft()) + countEven(t.getRight());
        } else {
            return 0 + countEven(t.getLeft()) + countEven(t.getRight());
        }
    }

}