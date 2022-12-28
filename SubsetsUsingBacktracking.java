public class SubsetsUsingBacktracking {
    public static void findSubsets(String str, String ans, int index) {
        if (index == str.length()) {
            System.out.print(ans + " ");
            return;
        }

        // For yes choice
        findSubsets(str, ans + str.charAt(index), index + 1);

        // For no choice
        findSubsets(str, ans, index + 1);
    }

    public static void main(String[] args) {
        String str = "abc";

        findSubsets(str, "", 0);
    }
}
