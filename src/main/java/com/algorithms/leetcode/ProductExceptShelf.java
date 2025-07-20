package com.algorithms.leetcode;

/**
 * Finding Prefix Product and Suffix Product
 * Similar to finding Prefix Sum Array, here we would intend to find the Prefix Product Array and
 * Suffix Product Array for our original array, i.e. pre[i] = pre[i - 1] * a[i - 1]
 * (yes, we multiply with a[i - 1] and not with a[i] on purpose) and similarly suff[i] = suff[i + 1] * a[i + 1].
 * Now, at any index i our final answer ans[i] would be given by ans[i] = pre[i] * suff[i]. Why?
 * Because the pre[i] * suff[i] contains product of every element before i and every element after i but not
 * the element at index i (and that is the reson why we excluded a[i] in our prefix and suffix product).
 *
 * The Time Complexity would be O(n), but we are now using Auxilary Space of O(n)
 */
public class ProductExceptShelf {
    public int[] solution(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] ans = new int[n];
        prefix[0] = 1;
        suffix[n-1] = 1;

        for(int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1] * nums[i-1];
        }
        for(int i = n -2; i >=0; i--){
            suffix[i] = suffix[i+1] * nums[i+1];
        }

        for(int i = 0; i < n ; i++) {
            ans[i] = prefix[i] * suffix[i];
        }

        return ans;
     }
}
