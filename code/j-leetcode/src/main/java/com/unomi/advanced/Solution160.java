package com.unomi.advanced;

import java.util.Objects;

public class Solution160 {

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
     * 反转
     * 错误
     * 改变了结构
     */
    public class WrongSolution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

            ListNode a = reverseLinkList(headA);
            ListNode b = reverseLinkList(headB);
            while (!Objects.equals(a, b)) {
                a = a.next;
                b = b.next;
                if (a == null || b == null) return null;
            }
            return a;


        }

        //无法反转，因为会得到完全相同的两条表
        public ListNode reverseLinkList(ListNode head) {
            ListNode cur = head;
            ListNode prev = null;
            while (true) {
                ListNode temp = cur.next;
                if (temp == null) break;
                cur.next = prev;
                prev = cur;
                cur = temp;
            }

            return cur;
        }

    }

    /**
     *
     */
    public class Solution {


        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            // 边界检查
            if (headA == null || headB == null) return null;

            ListNode pA = headA;
            ListNode pB = headB;

            // 两个指针开始遍历
            // 当 pA == pB 时，要么是找到了交点，要么是都走到了末尾 null
            while (pA != pB) {
                // 如果 pA 走到了尽头，就转到 headB 继续走
                pA = (pA == null) ? headB : pA.next;
                // 如果 pB 走到了尽头，就转到 headA 继续走
                pB = (pB == null) ? headA : pB.next;
            }

            return pA;
        }


    }
    //TODO Solution也可以使用哈希set


}
