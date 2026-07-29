class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (coins.length == 1 && coins[0] == amount) {
            return 1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int result = minCoin(coins, amount, map);
        if (result == Integer.MAX_VALUE) {
            return -1;
        }
        else {
            return result;
        }
    }
    private int minCoin(int[] coins, int amount, Map<Integer, Integer> map) {
        if (amount < 0) {
            return Integer.MAX_VALUE;
        }
        if (amount == 0) {
            return 0;
        }
        if (map.containsKey(amount)) {
            return map.get(amount);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int coinCount = minCoin(coins, amount - coins[i], map);
            if (coinCount == Integer.MAX_VALUE) {
                continue;
            }
            min = Math.min(min, coinCount + 1);
        }
        map.put(amount, min);
        return min;
    }
}
