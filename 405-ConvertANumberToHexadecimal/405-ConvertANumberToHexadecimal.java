// Last updated: 7/9/2026, 2:16:31 PM
class Solution {
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }

        char[] hex = {
            '0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
        };

        StringBuilder sb = new StringBuilder();

        while (num != 0) {
            sb.append(hex[num & 15]);
            num >>>= 4;
        }

        return sb.reverse().toString();
    }
}