/**
 * 链表节点
 */
public class ListNode {
  public int val;
  public ListNode next;

  public ListNode(int x) {
    val = x;
  }

  public static ListNode getTestNode() {
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
    ListNode node5 = new ListNode(5);
    ListNode node6 = new ListNode(6);
    ListNode node7 = new ListNode(7);
    ListNode node8 = new ListNode(8);
    ListNode node9 = new ListNode(9);

    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    node5.next = node6;
    node6.next = node7;
    node7.next = node8;
    node8.next = node9;
    return node1;
  }

  public void printNode() {
    ListNode node = this;
    while (node != null) {
      System.out.print(node.val + "  ");
      node = node.next;
    }
  }
}
