/**
 * 判断链表中是否有环
 */
public class HasCycle {
  /**
   * 定义快慢指针，快指针每次走两步，慢指针每次走一步，如果优化，两个指针必定相遇
   */
  public boolean hasCycle(ListNode head){
    // 非空校验
    if (head == null){
      return false;
    }
    ListNode fast = head;
    ListNode slow = head;
    while (fast.next != null && fast.next.next != null){
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast){
        return true;
      }
    }
    return false;
  }
}
