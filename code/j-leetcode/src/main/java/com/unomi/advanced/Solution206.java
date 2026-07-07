package com.unomi.advanced;




public class Solution206 {

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

    public class Solution {

        /**
         * o2n solution ：遍历n次 每次遍历i-n个元素
         * 还有一种构造环形链表，然后移动n次，也是o2n
         * @param head
         * @return
         */
        public ListNode reverseList1(ListNode head) {
            ListNode cur = head;
            if (cur == null || cur.next == null) {
                return cur;
            }
            ListNode resultStart = null;
            while (cur.next != null) {
                cur = cur.next;
            }
            resultStart = cur;

            ListNode curLast = resultStart;
            for (cur = head; cur.next != null; cur = cur.next) {
                ListNode start = head;
                while (start.next != curLast) {
                    start = start.next;
                }
                curLast.next = start;
                curLast = curLast.next;
            }
            curLast.next=null;
            return resultStart;
        }


        public ListNode reverseList(ListNode head) {
            ListNode prev = null; // 指向当前节点的前一个
            ListNode cur = head;  // 指向当前正在处理的节点

            while (cur != null) {
                ListNode nextTemp = cur.next; // 1. 先把“家”后面的路记下来
                cur.next = prev;              // 2. 把当前的“箭头”指向反方向

                // 3. 整体向后移动一位
                prev = cur;
                cur = nextTemp;
            }

            return prev; // 最后 prev 会停在原链表的尾部，也就是新链表的头部
        }

    }

}
