/*
test cases:
0
20
12345
123
*/
// final should be written above.
class Solution {
    private static final String[] NUMBER = {"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen","Eighteen","Nineteen"};
    private static final String[] TIMES = {"Zero","Zero","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    private static final String[] THOUSANDS = {"","Thousand","Million", "Billion"};
    
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
       
        String result = "";
        int i = 0;
        
        while(num > 0) {
            if (num %1000 != 0) {
            	// add from the top
                result = helper(num%1000) + THOUSANDS[i] + " " + result;
            }
            num /= 1000;
            ++i;
        }
        // Delete the space in the front and in the end
        return result.trim();
    }
    
    private String helper(int num) {
        if (num == 0) {
            return "";
        } else if (num < 20) {
            return NUMBER[num] + " ";
        } else if (num < 100) {
            return TIMES[num / 10] + " " + helper(num % 10);
        } else {
            return NUMBER[num / 100] + " Hundred " + helper(num % 100);
        }
    }
}