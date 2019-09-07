// because the string itself will include the special character, so that we should sperate the string with special char together with recording the length
public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        // Corner cases
        if (strs == null || strs.size() == 0) {
            return new String("");
        }
        StringBuilder sb = new StringBuilder();
        for (String s: strs) {
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList<String>();
        int start = 0;
        while (start < s.length()) {
            // String,indexOf(character, position),get the first index of character starting from position
            int i = s.indexOf('#', start);
            // Integerc.valueOf(String), the property is String
            // String.substring(int startIndex, int endIndex);[startIndex,endIndex)
            int length = Integer.valueOf(s.substring(start,i));
            start = i + 1 + length;
            result.add(s.substring(i+1, start));
        }
        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));