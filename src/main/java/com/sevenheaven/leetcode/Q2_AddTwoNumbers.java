package com.sevenheaven.leetcode;

import com.sevenheaven.leetcode.associate.ListNode;

/**
 * Created by 7heaven on 16/4/30.
 */
public class Q2_AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //resultNode是返回结果的根节点
        ListNode resultNode = new ListNode((l1.val + l2.val) % 10);
        ListNode resultNext = new ListNode(0);

        //exceed用来判断是否需要进一位
        boolean exceed = l1.val + l2.val >= 10;

        if(l1.next != null || l2.next != null || exceed) resultNode.next = resultNext;

        while((l1 != null && l1.next != null) || (l2 != null && l2.next != null) || exceed){
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;

            //l1 l2值的和
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + (exceed ? 1 : 0);

            //仅保留个位数
            resultNext.val = sum % 10;

            exceed = sum >= 10;

            if((l1 != null && l1.next != null) || (l2 != null && l2.next != null) || exceed){
                resultNext.next = new ListNode(0);
                resultNext = resultNext.next;
            }
        }

        return resultNode;
    }
}
