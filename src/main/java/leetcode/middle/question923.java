package leetcode.middle;

/*
    给定一个整数数组 A，以及一个整数 target 作为目标值，
    返回满足 i < j < k 且 A[i] + A[j] + A[k] == target 的元组 i, j, k 的数量。
    由于结果会非常大，请返回 结果除以 10^9 + 7 的余数
 */
public class question923 {
    public int threeSumMulti(int[] A, int target) {
        int kMaxN = 100;
        int mod = (int)Math.pow(10,9) + 7;
        long[] c = new long[kMaxN + 1];
        for (int i = 0; i < A.length;i++){
            c[A[i]]++;
        }
        long ans = 0;
        for (int i = 0;i <= target;i++){
            for (int j = i;j <= target;j++){
                int k = target - i - j;
                if (k < 0 || k > c.length || k < j) continue;
                if (i < 0 || i > 100 || j < 0 || j > 100 || k < 0 || k > 100) continue;
                if (i == j && j == k) {
                    ans += (c[i] - 2) * (c[i] - 1) * c[i] / 6;
                }
                else if (i == j && j != k)
                    ans += c[i] * (c[i] - 1) / 2 * c[k];
                else if (i != j && j == k)
                    ans += c[i] * (c[j] - 1) * c[j] / 2;
                else
                    ans += c[i] * c[j] * c[k];
            }
        }
        return (int)(ans % mod);
    }
}
