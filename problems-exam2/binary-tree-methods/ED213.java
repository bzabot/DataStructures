public class ED213 {
    public static String maxSum(BTree<Integer> t) {
        if (t == null || t.isEmpty())
            return "";

        return maxSumHelper(t.getRoot(), "");
    }

    private static String maxSumHelper(BTNode<Integer> node, String path) {
        if (node == null) {
            return path;
        }

        if (node.getLeft() == null && node.getRight() == null) {
            return path; // folha
        }

        String leftPath = "";
        String rightPath = "";
        int leftSum = 0, rightSum = 0;

        if (node.getLeft() != null) {
            leftPath = maxSumHelper(node.getLeft(), path + "E");
            leftSum = sumPath(node.getLeft());
        }

        if (node.getRight() != null) {
            rightPath = maxSumHelper(node.getRight(), path + "D");
            rightSum = sumPath(node.getRight());
        }

        return leftSum >= rightSum ? leftPath : rightPath;
    }

    private static int sumPath(BTNode<Integer> node) {
        if (node == null)
            return 0;
        return node.getValue() + sumPath(node.getLeft()) + sumPath(node.getRight());
    }
}