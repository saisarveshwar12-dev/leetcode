class Solution {
    public String stoneGameIII(int[] st) {

        int n = st.length;
        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {

            int sum = 0;
            dp[i] = Integer.MIN_VALUE;

            for (int j = i; j < Math.min(i + 3, n); j++) {

                sum += st[j];

                dp[i] = Math.max(dp[i], sum - dp[j + 1]);
            }
        }

        if (dp[0] > 0)
            return "Alice";

        if (dp[0] < 0)
            return "Bob";

        return "Tie";
    }
}