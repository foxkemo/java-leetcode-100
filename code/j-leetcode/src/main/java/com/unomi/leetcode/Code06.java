package com.unomi.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Code06 {

    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Set<List<Integer>> result = new HashSet<>();


            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) break;
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                int left = i + 1, right = nums.length - 1;
                while (left < right) {
                    if (nums[right] < 0 ) break;
                    if (nums[i] + nums[left] + nums[right] == 0) {
                        result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        left++;
                        right--;
                    } else if (nums[i] + nums[left] + nums[right] < 0) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
            return result.stream().toList();
        }
    }
}
