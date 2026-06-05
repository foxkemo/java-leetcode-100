package com.unomi.leetcode;

import java.util.*;


public class Code02 {
    static class Solution {

        public List<List<String>> groupAnagrams(String[] strs) {

            Map<List<Integer>, List<String>> map = new HashMap<>();

            for (String str : strs) {

                List<Integer> count =
                        new ArrayList<>(Collections.nCopies(26, 0));

                for (char c : str.toCharArray()) {

                    int idx = c - 'a';

                    count.set(
                            idx,
                            count.get(idx) + 1
                    );
                }

                map.computeIfAbsent(
                        count,
                        k -> new ArrayList<>()
                ).add(str);
            }

            return new ArrayList<>(map.values());
        }
    }
}
