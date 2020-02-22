import javax.swing.tree.TreeNode;
import java.util.*;

public class Test {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0)
            return res;
        char[] cs = str.toCharArray();
        Arrays.sort(cs);
        res.add(String.valueOf(cs));
        while (true) {
            int lIdx = cs.length - 1;
            int rIdx;
            while (lIdx >= 1 && cs[lIdx - 1] >= cs[lIdx]) {
                lIdx--;
            }
            if (lIdx == 0)
                break;
            rIdx = lIdx;
            while (rIdx < cs.length && cs[rIdx] > cs[lIdx - 1]) {
                rIdx++;
            }
            swap(cs, lIdx - 1, rIdx - 1);
            reverse(cs, lIdx);
            res.add(String.valueOf(cs));
        }
        return res;
    }

    private void swap(char[] cs, int i, int j) {
        char tmp = cs[i];
        cs[i] = cs[j];
        cs[j] = tmp;
    }

    private void reverse(char[] cs, int k) {
        if (cs == null || cs.length == 0)
            return;
        for (int i = 0; i < (cs.length - k) / 2; i++) {
            int m = k + i;
            int n = cs.length - 1 - i;
            if (m <= n)
                swap(cs, m, n);
        }
    }
}
