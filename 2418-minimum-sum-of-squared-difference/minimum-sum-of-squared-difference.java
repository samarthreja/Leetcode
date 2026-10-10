
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long k = (long) k1 + k2;
        int[] diff = new int[n];
        int max = 0;
        long total = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            max = Math.max(max, diff[i]);
            total += diff[i];
        }

        if (k >= total) return 0;

        int l = 0, r = max;

        while (l < r) {
            int mid = l + (r - l) / 2;
            long need = 0;

            for (int d : diff)
                if (d > mid) need += d - mid;

            if (need <= k) r = mid;
            else l = mid + 1;
        }

        long ans = 0, used = 0;

        for (int d : diff) {
            int x = Math.min(d, l);
            used += d - x;
            ans += (long) x * x;
        }

        long rem = k - used;

        for (int d : diff) {
            if (rem == 0) break;
            if (d >= l && d > 0) {
                ans -= 2L * l - 1;
                rem--;
            }
        }

        return ans;
    }
}
