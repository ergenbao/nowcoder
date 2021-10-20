import java.util.*;

/**
 * 二叉树根节点到叶子节点和为指定值的路径
 */
public class PathSum {
//  // key 是当前节点，value 是parent节点
//  Map<TreeNode, TreeNode> prefixMap = new HashMap<>();
//
//  /**
//   * 宽度优先遍历二叉树
//   * 一个队列存储节点，另一个队列存储 根节点到当前节点的路径和
//   * 如果当前节点时叶子节点，同时路径和 = 预期，则记录当前路径和
//   */
//  public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
//    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
//    if (root == null) {
//      return res;
//    }
//    LinkedList<TreeNode> nodeQueue = new LinkedList<>();
//    LinkedList<Integer> sumQueue = new LinkedList<>();
//    nodeQueue.addFirst(root);
//    sumQueue.addFirst(root.val);
//    while (!nodeQueue.isEmpty()) {
//      TreeNode node = nodeQueue.removeLast();
//      // val 为 从根节点到node节点的路径和
//      int val = sumQueue.removeLast();
//      // 叶子节点
//      if (node.left == null && node.right == null) {
//        // 根节点到叶子节点累加和 == sum
//        if (val == sum) {
//          res.add(getPath(node));
//        }
//      }
//      if (node.left != null) {
//        prefixMap.put(node.left, node);
//        nodeQueue.addFirst(node.left);
//        sumQueue.addFirst(val + node.left.val);
//      }
//      if (node.right != null) {
//        prefixMap.put(node.right, node);
//        nodeQueue.addFirst(node.right);
//        sumQueue.addFirst(val+node.right.val);
//      }
//    }
//    return res;
//  }
//
//  /**
//   *  返回根节点到叶子节点的路径
//   */
//  private ArrayList<Integer> getPath(TreeNode node) {
//    ArrayList<Integer> res = new ArrayList<>();
//    while (node != null) {
//      res.add(node.val);
//      node = prefixMap.get(node);
//    }
//    Collections.reverse(res);
//    return res;
//  }


  // 用于保存结果
  ArrayList<ArrayList<Integer>> res = new ArrayList<>();

  /**
   * 采用dfs的方式，线序遍历二叉树
   * 先判断根节点到当前的路径和是否 == sum。等于直接返回
   * 不等于再判断左右子树
   */
  public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
    dfs(root, new ArrayList<>(), sum);
    return res;
  }

  private void dfs(TreeNode node, ArrayList<Integer> temp, int sum) {
    if (node == null) {
      return;
    }
    temp.add(node.val);
    if (node.left == null && node.right == null && node.val == sum) {
      res.add(temp);
      return;
    }
    // 这里需要从新new一次。不然递归时会有影响
    dfs(node.left, new ArrayList<>(temp), sum - node.val);
    dfs(node.right, new ArrayList<>(temp), sum - node.val);
  }
}
