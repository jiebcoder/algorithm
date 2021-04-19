import javax.swing.tree.TreeNode;
import java.util.*;

public class Test {
    public int StrToInt(String str) {
        int len = str.length();
        if (str == null || len == 0) {
            return 0;
        }
        int res = 0;
        boolean negative = false;
        int limit = -Integer.MAX_VALUE;  //注意
        int i = 0;
        char firstChar = str.charAt(0);
        if (firstChar < '0') {
            if (firstChar == '-') {
                negative = true;
                limit = Integer.MIN_VALUE;  //注意
            } else if (firstChar != '+') {
                return 0;
            }
            if (len == 1) {
                return 0;
            }
            i++;
        }
        while (i < len) {
            int digit = str.charAt(i++) - '0';
            if (digit < 0 || digit > 9) {
                return 0;
            }
            if (res < limit / 10) {  //注意
                return 0;
            }
            res *= 10;
            if (res < limit + digit) {  //注意
                return 0;
            }
            res -= digit;  //注意
        }
        return negative ? res : -res;
    }
}
