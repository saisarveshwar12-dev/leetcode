import java.lang.String;
class Solution {
    public int mostWordsFound(String[] se) {
        int max = 0;

        for (int i = 0; i < se.length; i++) {

            String[] arr = se[i].split(" ");

            int count = arr.length;

            max = Math.max(max, count);
        }

        return max;
    }
}