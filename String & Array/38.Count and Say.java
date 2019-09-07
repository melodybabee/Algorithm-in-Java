class Solution {
    public String countAndSay(int n) {
        // Corner cases
        if (n == 0) return "";
        if (n == 1) return "1";
        String str = countAndSay(n - 1);
        int count = 0;
        int slow = 0;
        // when need change String or create the new String, user charArray or StringBuilder
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); ++i) {
            // record the num of the same characters
            if (str.charAt(i) == str.charAt(slow)) {
                ++count;
                continue;
            } else {
                // StringBuilder can append().append()
                sb.append(count).append(str.charAt(slow));
                count = 1;
                slow = i;
            }
        }
        if (count == 0) ++count;
        sb.append(count).append(str.charAt(slow));
        return sb.toString();
    }
}