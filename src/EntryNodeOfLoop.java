/**
 * 链表中环的入口节点
 */
public class EntryNodeOfLoop {

  /**
   * 思路:
   * 1、设置快慢指针，都从链表头出发，快指针每次走两步，慢指针一次走一步，假如有环，一定相遇于环中某点（结论1）.
   * 2、接着让两个指针分别从相遇点和链表头出发，两者都改为每次走一步，最终相遇于环入口（结论2）。
   * <p>
   * 以下是两个结论的证明：
   * 结论1证明：设置快慢指针fast和slow，fast每次走两步，low每次走一步。假如有环，两者一定在环中相遇。（因为low指针一旦进环，可以看作是fast指针在追slow指针，因为fast指针每次走两步，slow指针每次走一步，所以最后一定能追上（相遇））
   * 结论2证明：假设：1、链表头到环入口长度为——a。2、环入口到相遇点长度为——b。 3、相遇点到环入口长度为——c。简图见 : src/picture/链表环入口.jpeg
   * 则相遇时，快指针路程为：a+（b+c）k+b，k>=1，其中b+c为环的长度，k为环的圈数。满指针的路程为：a+b.而快指针所走的路程是满指针的二倍。所以有：
   * （a+b）*2=a+（b+c）k+b。化简得：a=（k-1）（b+c）+c。即链表头到环入口的距离=相遇点到环入口的距离+（k-1）圈数环长度。所以两个指针分别从链表头和相遇点出发，最后一定相遇于环入口。
   */
  public ListNode entryNodeOfLoop(ListNode head) {
    if (head == null){
      return null;
    }
    // 定义快慢指针
    ListNode fast = head;
    ListNode slow = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      // 如果有环，相遇于环中某点
      if (slow == fast) {
        break;
      }
    }
    // 如果没有换，return null
    if (slow.next == null || fast.next.next == null) {
      return null;
    }
    // 如果有环，两个指针分别从链表头和相遇点出发，最终必定在环入口相遇
    fast = head;
    while (fast != slow) {
      fast = fast.next;
      slow = slow.next;
    }
    return fast;
  }
}
