// Last updated: 7/9/2026, 2:14:00 PM
class Solution {
    public int maxFreqSum(String s) {
        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        int maxVowel = 0;
        int maxConsonant = 0;

        for (int i = 0; i < 26; i++) {
            char ch = (char) (i + 'a');

            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                if (freq[i] > maxVowel) {
                    maxVowel = freq[i];
                }
            } else {
                if (freq[i] > maxConsonant) {
                    maxConsonant = freq[i];
                }
            }
        }

        return maxVowel + maxConsonant;
    }
}
