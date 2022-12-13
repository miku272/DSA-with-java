public class FriendsPairingProblem {
    public static int friendsPairing(int n) {
        if (n == 1 || n == 2) {
            return n;
        }

        int singleChoice = friendsPairing(n - 1);
        int pairChoice = friendsPairing(n - 2);

        int pairWays = (n - 1) * pairChoice;

        int totalWays = singleChoice + pairWays;

        return totalWays;
    }

    public static void main(String[] args) {
        System.out.println(friendsPairing(3));
    }
}
