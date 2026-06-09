package com.unomi.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Code03 {



static class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int result = 0;
//        Arrays.stream(nums).forEach(
//                set::add
//        );

        for (int num : nums) {
            set.add(num);
        }

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currentSize = 1;
                int currentNum = num;
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentSize++;
                }
                result = Math.max(result, currentSize);
            }

        }
        return result;
    }


    public int longestConsecutive2(int[] nums) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(nums).forEach(
                each -> {
                    map.put(each, 1);
                }
        );
        int max = Arrays.stream(nums).max().orElse(0);
        int min = Arrays.stream(nums).min().orElse(0);
        for (int i = min; i <= max; i++) {

            if (!map.containsKey(i)) {
                continue;
            }
            int now = 1;
            for (int j = i + 1; j <= max; j++) {
                if (map.containsKey(j)) {
                    now++;
                } else {
                    break;
                }
            }
            if (now > result) result = now;

        }

        return result;
    }
}
}