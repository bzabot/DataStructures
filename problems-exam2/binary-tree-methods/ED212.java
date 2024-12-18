public class ED212 {

    // --------------------------------------------------------

    // Devolver a soma por nível
    public static int[] sumLevels(BTree<Integer> t) {
        int[] sum = new int[t.depth() + 1];
        sumLevels(t.getRoot(), 0, sum);
        return sum;
    }

    private static void sumLevels(BTNode<Integer> t, int cLevel, int[] sum) {
        if (t != null)
            sum[cLevel] += t.getValue();

        if (t.getLeft() != null) {
            sumLevels(t.getLeft(), cLevel + 1, sum);
        }
        if (t.getRight() != null) {

            sumLevels(t.getRight(), cLevel + 1, sum);
        }
    }
}