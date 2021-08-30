/**
 * @author jianghao
 * 大数之和
 */
public class BigNumberSum {

  /**
   *  采用尾部求和的方式
   *  定义一个stringBuilder ,从尾部开始。（将两个字符的和 + 进位）%10放入sb
   *  最后翻转sb
   */
  public static String sum(String s, String t) {
    int i = s.length() - 1;
    int j = t.length() - 1;
    StringBuilder sb = new StringBuilder();
    // 进位
    int carry = 0;
    while (i >= 0 || j >= 0 || carry != 0) {
      int x = i < 0 ? 0 : s.charAt(i--) - '0';
      int y = j < 0 ? 0 : t.charAt(j--) - '0';
      int sum = x + y + carry;
      sb.append(sum % 10);
      carry = sum / 10;
    }
    return sb.reverse().toString();
  }

  public static void main(String[] args) {
    String s = "12367";
    String t = "89";
    System.out.println(sum(s, t));
  }
}
