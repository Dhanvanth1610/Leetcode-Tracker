// Last updated: 7/9/2026, 2:16:15 PM
class Solution {
    public String smallestGoodBase(String n) {
        long num = Long.parseLong(n);

        int maxM = (int)(Math.log(num) / Math.log(2));

        for (int m = maxM; m >= 2; m--) {
            long left = 2;
            long right = (long)Math.pow(num, 1.0 / m) + 1;

            while (left <= right) {
                long mid = left + (right - left) / 2;

                long sum = 1;
                long cur = 1;

                for (int i = 1; i <= m; i++) {
                    if (cur > num / mid) {
                        sum = num + 1;
                        break;
                    }
                    cur *= mid;
                    sum += cur;

                    if (sum > num) {
                        break;
                    }
                }

                if (sum == num) {
                    return String.valueOf(mid);
                } else if (sum < num) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return String.valueOf(num - 1);
    }
}