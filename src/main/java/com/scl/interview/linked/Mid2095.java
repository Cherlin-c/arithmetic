package com.scl.interview.linked;

/**
 * 删除链表的中间节点
 *
 * @author : scl
 * @date :  9/9/2023
 */
public class Mid2095 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 4, 7, 1, 2, 6};
        ListNode listNode = new ListNode(nums[0]);
        ListNode listNode2 = listNode;
        for (int i = 1; i < nums.length; i++) {
            listNode.next = new ListNode(nums[i]);
            listNode = listNode.next;
        }
        System.out.println("deleteMiddle(listNode) = " + deleteMiddle(listNode2));
    }

    /*
    给你一个链表的头节点 head 。删除 链表的 中间节点 ，并返回修改后的链表的头节点 head 。
    长度为 n 链表的中间节点是从头数起第 ⌊n / 2⌋ 个节点（下标从 0 开始），其中 ⌊x⌋ 表示小于或等于 x 的最大整数。
    对于 n = 1、2、3、4 和 5 的情况，中间节点的下标分别是 0、1、1、2 和 2 。

    示例 1：
    输入：head = [1,3,4,7,1,2,6]
    输出：[1,3,4,1,2,6]
    解释：
    上图表示给出的链表。节点的下标分别标注在每个节点的下方。
    由于 n = 7 ，值为 7 的节点 3 是中间节点，用红色标注。
    返回结果为移除节点后的新链表。
    示例 2：
    输入：head = [1,2,3,4]
    输出：[1,2,4]
    解释：
    上图表示给出的链表。
    对于 n = 4 ，值为 3 的节点 2 是中间节点，用红色标注。
    示例 3：
    输入：head = [2,1]
    输出：[2]
    解释：
    上图表示给出的链表。
    对于 n = 2 ，值为 1 的节点 1 是中间节点，用红色标注。
    值为 2 的节点 0 是移除节点 1 后剩下的唯一一个节点。

    提示：
    链表中节点的数目在范围 [1, 105] 内
    1 <= Node.val <= 105
    */

    public static ListNode deleteMiddle(ListNode head) {
        ListNode head2 = head;
        ListNode head3 = head;
        int size = 0;
        while (head != null) {
            head = head.next;
            size++;
        }
        if (size <= 1) {
            return head;
        }
        int i = size / 2;
        for (int j = 0; j < i - 1; j++) {
            head2 = head2.next;
        }
        head2.next = head2.next.next;
        return head3;

    }

    /**
     * 快慢指针
     **/
    public static ListNode deleteMiddle2(ListNode head) {
        if (head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = head;

        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = pre.next.next;
        return head;

    }
}