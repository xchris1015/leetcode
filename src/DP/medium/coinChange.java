package DP.medium;

public class coinChange {

    public int coinChange(int[] coins, int amount) {

        // transation function f(x) = min{f(x - 1) + 1, f(x - 5) + 1, f(x - 7) + 1}

        if (amount == 0) {
            return 0;
        }

        // because start from 0, so we need to get amount + 1 to access amount
        int[] array = new int[amount + 1];
        array[0] = 0;

        for (int i = 1 ; i < amount + 1 ; i++ ) {
            array[i] = Integer.MAX_VALUE;

            for (int coin : coins) {
                // make sure the index would not be negative, and the get value is not invalid
                if (i >= coin && array[i - coin] != Integer.MAX_VALUE) {
                    array[i] = Math.min(array[i], array[i - coin] + 1);
                }

            }
        }

        if (array[amount] == Integer.MAX_VALUE) {
            return -1;
        }

        return array[amount];

    }
}
