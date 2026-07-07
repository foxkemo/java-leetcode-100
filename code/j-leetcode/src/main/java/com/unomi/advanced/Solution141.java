package com.unomi.advanced;


import java.util.HashSet;
import java.util.Objects;

public class Solution141 {

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
        public boolean hasCycle(ListNode head) {
            if (head == null) return false;
            HashSet<ListNode> set = new HashSet<>();
            ListNode cur = head;
            while (cur.next != null) {
                if (!set.add(cur)) return true;
                cur = cur.next;
            }
            return false;
        }

    }

    /**
     * 双指针
     * 1ms
     */
    public class Solution {
        public boolean hasCycle(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            if(head==null||head.next==null) return false;
            do {
                fast = fast.next;
                if(fast!=null) {
                    fast = fast.next;
                }else{
                    return false;
                }
                slow = slow.next;
                if(Objects.equals(fast,slow)) return true;
            } while (fast != null && slow != null);
            return false;
        }
    }

}
