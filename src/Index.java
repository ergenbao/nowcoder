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
    System.out.println(indexMap);
  }
}
