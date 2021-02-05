

public class Climbing_Stairs {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1; //[1]
        dp[2] = 2; // [1,1], [2]
        dp[3] = 4; // [1,1,1], [1,2], [2,1], [3]
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }

    public static void main(String[] args){
        int n = 8;
        Climbing_Stairs climbing_stairs = new Climbing_Stairs();
        System.out.println(climbing_stairs.climbStairs(n));
    }

}
