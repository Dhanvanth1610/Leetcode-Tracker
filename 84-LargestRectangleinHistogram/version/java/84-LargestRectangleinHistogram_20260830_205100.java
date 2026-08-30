// Last updated: 8/30/2026, 8:51:00 PM
1class Solution {
2    public int findMin(int[] nums) {
3        int left = 0;
4        int right = nums.length - 1;
5
6        while (left < right) {
7            int mid = left + (right - left) / 2;
8
9            if (nums[mid] < nums[right]) {
10                // Minimum is at mid or to the left
11                right = mid;
12            } 
13            else if (nums[mid] > nums[right]) {
14                // Minimum is to the right of mid
15                left = mid + 1;
16            } 
17            else {
18                // nums[mid] == nums[right]
19                right--;
20            }
21        }
22
23        return nums[left];
24    }
25}