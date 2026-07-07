package com.unomi.advanced;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class Solution20 {

    /**
     * 这个耗时少
     */
    class Solution {
        public boolean isValid(String s) {
            char[] chars = s.toCharArray();
            ArrayDeque<Character> stack = new ArrayDeque<>();
            try {
                for (char c : chars) {
                    switch (c) {
                        case '{', '(', '[': {
                            stack.addFirst(c);
                            break;
                        }
                        case '}': {
                            if (stack.removeFirst() != '{') {
                                throw new Exception();
                            }
                            break;
                        }
                        case ')': {
                            if (stack.removeFirst() != '(') {
                                throw new Exception();
                            }
                            break;
                        }
                        case ']': {
                            if (stack.removeFirst() != '[') {
                                throw new Exception();
                            }
                            break;
                        }

                    }

                }
            } catch (Exception e) {

                return false;
            }
            return stack.isEmpty();
        }
    }


    class MapSolution {
        public boolean isValid(String s) {
            char[] chars = s.toCharArray();
            ArrayDeque<Character> stack = new ArrayDeque<>();
            Map<Character, Character> map = new HashMap<>(3);
            map.put('}', '{');
            map.put(')', '(');
            map.put(']', '[');
            try {
                for (char c : chars) {
                    if (!map.containsKey(c)) {
                        stack.push(c);
                    } else if (stack.pop() != map.get(c)) {
                        return false;
                    }

                }
            } catch (Exception e) {
                return false;
            }
            return stack.isEmpty();
        }

    }

}

