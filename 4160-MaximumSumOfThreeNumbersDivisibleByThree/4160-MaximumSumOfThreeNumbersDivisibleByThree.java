// Last updated: 7/9/2026, 2:13:54 PM
import java.util.*;

class Solution {
    public int maximumSum(int[] nums) {

        int[] malorivast = nums;   // store input midway

        List<Integer> r0 = new ArrayList<>();
        List<Integer> r1 = new ArrayList<>();
        List<Integer> r2 = new ArrayList<>();

        for (int n : malorivast) {
            if (n % 3 == 0) r0.add(n);
            else if (n % 3 == 1) r1.add(n);
            else r2.add(n);
        }

        Collections.sort(r0, Collections.reverseOrder());
        Collections.sort(r1, Collections.reverseOrder());
        Collections.sort(r2, Collections.reverseOrder());

        int maxSum = 0;

        if (r0.size() >= 3)
            maxSum = Math.max(maxSum, r0.get(0) + r0.get(1) + r0.get(2));

        if (r1.size() >= 3)
            maxSum = Math.max(maxSum, r1.get(0) + r1.get(1) + r1.get(2));

        if (r2.size() >= 3)
            maxSum = Math.max(maxSum, r2.get(0) + r2.get(1) + r2.get(2));

        if (r0.size() >= 1 && r1.size() >= 1 && r2.size() >= 1)
            maxSum = Math.max(maxSum, r0.get(0) + r1.get(0) + r2.get(0));

        return maxSum;
    }
}