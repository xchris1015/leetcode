package BDFS.medium;

public class LC322 {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        int[] count = new int[amount + 1];
        count[0] = 0;
        return dfs(coins, amount, count);

    }

    private int dfs(int[] coins, int leftAmount, int[] count) {

        if (leftAmount == 0) {
            return 0;
        }

        if (leftAmount < 0) {
            return -1;
        }

        if (count[leftAmount] != 0) {
            return count[leftAmount];
        }

        int min = Integer.MAX_VALUE;

        for (int coin : coins) {
            int res = dfs(coins, leftAmount - coin, count);

            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }
        count[leftAmount] = min == Integer.MAX_VALUE ? - 1 : min;;
        return count[leftAmount];
    }
}
