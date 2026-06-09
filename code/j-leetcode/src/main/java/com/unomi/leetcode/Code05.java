package com.unomi.leetcode;

import java.util.*;

public class Code05 {
   static  class Solution {
        public int maxArea(int[] height) {
            int left = 0;
            int right = height.length - 1;
            int maxArea = 0;

            while (left < right) {
                // 1. 计算当前面积
                // 宽度是 right - left
                // 高度取决于两边较短的那一个
                int currentHeight = Math.min(height[left], height[right]);
                int currentArea = (right - left) * currentHeight;

                // 2. 更新最大值
                maxArea = Math.max(maxArea, currentArea);

                // 3. 核心逻辑：移动较短的那一侧
                if (height[left] < height[right]) {
                    left++;
                } else {
                    right--;
                }
            }

            return maxArea;
        }
    }

}
