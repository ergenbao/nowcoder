/**
 * 重排链表
 */
public class ReorderList {

  /**
   * 先利用快慢指针，找到链表的中间节点
   * 反转后半部分的链表
   * 再将前后半部分合并
   */
  public static void reorderList(ListNode head) {
    // 需要长度至少为3
    if (head == null || head.next == null || head.next.next == null) {
      return;
    }
    // 快慢指针找到中间位置
    ListNode slow = head;
    ListNode fast = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    // 反转后半部分
    ListNode second = slow.next;
    second = reverseList(second);
    // 前、后半段分离
    slow.next = null;

    // 再将前后半段合并
    ListNode first = head;
    ListNode next1, next2;
    while (second != null) {
      next1 = first.next;
      next2 = second.next;

      first.next = second;
      second.next = next1;

      first = next1;
      second = next2;
    }
  }

  // 反转列表
  private static ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode next = null;
    while (head != null) {
      next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }
    return prev;
  }

  public static void main(String[] args) {
    ListNode testNode = ListNode.getTestNode();
    reorderList(testNode);
    testNode.printNode();
  }
}
