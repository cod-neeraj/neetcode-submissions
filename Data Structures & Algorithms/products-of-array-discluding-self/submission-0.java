class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            int l = leftProduct(i, nums, left);
            left[i] = l;
            int r = rightProduct(n - i - 1, nums, right);
            right[n - i - 1] = r;
        }

        int[] pro = new int[n];
        for (int i = 0; i < n; i++) {
            pro[i] = left[i] * right[i];
        }
        return pro;
    }

    public int leftProduct(int i, int[] nums, int[] left) {
        if (i == 0)
            return 1;
        return left[i - 1] * nums[i - 1];
    }

    public int rightProduct(int i, int[] nums, int[] right) {
        if (i == nums.length - 1)
            return 1;
        return right[i + 1] * nums[i + 1];
    }
}
