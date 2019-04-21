package leetcode.middle;

/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 (you may want to display this pattern in a fixed font for better legibility)
  P   A   H   N
  A P L S I I G
  Y   I   R
 */
public class Question6 {
    public static void main(String args[]) {
        String s = "abcde";
        String x = convert(s, 4);
    }
    /* Other Solution */
    public String convert2(String s, int numRows) {

        if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }
    /* My Solution */
    private static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        char[] result = new char[s.length()];
        int[] cols = new int[numRows];

        int sum = 0;
        int length = s.length();
        int numV = length / (2 * (numRows - 1));
        int numRemain = length % (2 * (numRows - 1));
        for (int i=0; i<numRows; i++) {
            int oneOrZero = numRemain > i ? 1 : 0;
            if (i==0 || i==numRows-1) {
                cols[i] = numV + oneOrZero + sum;
            } else {
                int t = numRemain >= numRows + numRows - i - 1 ? 1 : 0;
                cols[i] = numV * 2 + oneOrZero + t + sum;
            }
            sum = cols[i];
        }

        int row = 0;
        int[] indexForBias = new int[numRows];
        boolean direction = true;
        for (int j=0; j<s.length(); j++) {
            char c = s.charAt(j);
            int bias = row==0? 0:cols[row-1];
            int resultIndex = bias + indexForBias[row];
            result[resultIndex] = c;

            indexForBias[row] += 1;
            if (direction) {
                row++;
            } else {
                row--;
            }
            if (row==0 && !direction) {
                direction = true;
            } else if (row==numRows-1 && direction) {
                direction = false;
            }
        }

        for (int k=0; k<numRows; k++) {
            System.out.println(cols[k]);
        }
        return new String(result);
    }
}
