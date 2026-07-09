// Last updated: 7/9/2026, 2:16:44 PM
class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] prefix = new long[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        return mergeSort(prefix, 0, prefix.length - 1, lower, upper);
    }

    private int mergeSort(long[] prefix, int left, int right, int lower, int upper) {
        if (left >= right) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        int count = mergeSort(prefix, left, mid, lower, upper)
                  + mergeSort(prefix, mid + 1, right, lower, upper);

        int l = mid + 1;
        int r = mid + 1;

        for (int i = left; i <= mid; i++) {
            while (l <= right && prefix[l] - prefix[i] < lower) {
                l++;
            }
            while (r <= right && prefix[r] - prefix[i] <= upper) {
                r++;
            }
            count += r - l;
        }

        long[] temp = new long[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (prefix[i] <= prefix[j]) {
                temp[k++] = prefix[i++];
            } else {
                temp[k++] = prefix[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = prefix[i++];
        }

        while (j <= right) {
            temp[k++] = prefix[j++];
        }

        System.arraycopy(temp, 0, prefix, left, temp.length);

        return count;
    }
}