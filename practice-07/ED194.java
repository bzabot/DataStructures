class ED194 {

    public static void reverse(MyStack<Integer> s, int n) {
        Integer[] r = new Integer[n];

        for (int i = 0; i < n; i++) {
            r[i] = s.pop();
        }
        for (int i = 0; i < n; i++) {
            s.push(r[i]);
        }

    }

}