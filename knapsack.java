
class knapsack{
    public static int knap(int[] weights, int[] values, int sum){
        int[][] dp = new int[weights.length+1][sum+1];
        for(int i=1;i<=values.length;i++){
            for(int j=1;j<=sum;j++){
                if(weights[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weights[i-1]]+values[i-1]);
                }
            }
        }

        return dp[weights.length][sum];
    }
    public static void main(String[] args) {
        int[] weights = new int[] {2,2,6,5,4};
        int[] values = new int[] {6,3,5,4,6};
        System.out.print(knap(weights,values,10));
    }
}