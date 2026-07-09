// Last updated: 7/9/2026, 2:15:59 PM
class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");

        for (int i = 0; i < words.length; i++) {
            char[] arr = words[i].toCharArray();
            int left = 0, right = arr.length - 1;

            while (left < right) {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }

            words[i] = new String(arr);
        }

        return String.join(" ", words);
    }
}