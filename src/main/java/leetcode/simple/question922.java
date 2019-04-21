package leetcode.simple;

/*
    给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。

对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。

你可以返回任何满足上述条件的数组作为答案。
 */
public class question922 {
    public int[] sortArrayByParity2(int[] A) {
        int[] result = new int[A.length];
        int m = 0;
        int n = 1;
        for (int a : A ) {
            if (a % 2 == 0) {
                result[m] = a;
                m += 2;
            } else {
                result[n] = a;
                n += 2;
            }
        }
        return result;
    }
}
