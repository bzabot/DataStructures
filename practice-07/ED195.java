public class ED195 {

    public static void main(String[] args) {
        System.out.println(balanced("[[[]]]")); // true
        System.out.println(balanced("(([]))")); // true
        System.out.println(balanced("[([)])]")); // false
        System.out.println(balanced("(([")); // false
        System.out.println(balanced("[[()]]")); // true
    }

    public static boolean balanced(String s) {
        MyStack<Character> stack = new LinkedListStack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // Se for parenteses ou colchete de abertura, empilha
            if (c == '(' || c == '[') {
                stack.push(c);
            }
            // Se for fechamento, verifica
            else if (c == ')' || c == ']') {
                // Pilha não pode estar vazia (não há abertura correspondente)
                if (stack.isEmpty()) {
                    return false;
                }

                // Verifica se o topo corresponde ao fechamento
                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // Pilha deve estar vazia no final
        return stack.isEmpty();
    }
}
