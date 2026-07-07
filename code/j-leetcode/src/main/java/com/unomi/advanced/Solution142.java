package com.unomi.advanced;

import java.util.HashSet;
import java.util.Objects;

public class Solution142 {


    private class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * Hash Set Solution
     * Space On
     * Time On
     * 5mm
     */
    public class Solution1 {
        public ListNode detectCycle(ListNode head) {
            if (head == null) return null;
            HashSet<ListNode> set = new HashSet<>();
            ListNode cur = head;
            while (cur.next != null) {
                if (!set.add(cur)) return cur;
                cur = cur.next;
            }
            return null;
        }
    }


    /**
     * 1mm
     * 快慢指针
     */
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            if (head == null || head.next == null) return null;
            do {
                fast = fast.next;
                if (fast != null) {
                    fast = fast.next;
                } else {
                    return null;
                }
                slow = slow.next;
                if (Objects.equals(fast, slow)) {
                    ListNode a = head;
                    ListNode b = slow;
                    while (!Objects.equals(a, b)) {
                        a = a.next;
                        b = b.next;
                    }
                    return a;
                }
            } while (fast != null);
            return null;
        }
    }


}


