import java.util.HashMap;
import java.util.Map;

/**
 * @author jianghao
 * @desc 目录类
 */
public class Index {
  public static void main(String[] args) {
    Map<String, Object> indexMap = new HashMap<>();
    indexMap.put("NC1-大数加法", BigNumberSum.class);
    indexMap.put("NC2-重排链表", ReorderList.class);
    indexMap.put("NC3-链表中环的入口节点", EntryNodeOfLoop.class);
    indexMap.put("NC4-判断链表中是否有环", HasCycle.class);
    indexMap.put("NC5-二叉树根节点到叶子节点的所有路径和", SumNumbers.class);
    System.out.println(indexMap);
  }
}
