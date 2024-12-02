class EX125{
    public static void main(String[] args) {
        System.out.println(isPalindrome());

    }

    public static boolean isPalindrome() {
        String s = "A man, a plan, a canal: Panamas";
        s = s.replace(" ", "").replaceAll("\\p{Punct}", "").toLowerCase();

        for(int i = 0, j = s.length() - 1; i<s.length()/2; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }
}