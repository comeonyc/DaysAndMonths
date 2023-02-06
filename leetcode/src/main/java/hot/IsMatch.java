package hot;

/**
 * @author: yc_comeon
 * @date: 2023/2/6
 * @description: TODO
 **/
public class IsMatch {
    public static void main(String[] args) {
        System.out.println(isMatch("aaa", "a*a"));
    }

    public static boolean isMatch(String s, String p) {
        return true;
    }

    public static boolean isMatch(String s, String p, int i, int j) {
        if (i == s.length() && j == p.length()) {
            return true;
        }

        boolean nextStar = j + 1 < p.length() && '*' == p.charAt(j + 1);
        if (i < s.length() && j < p.length() && (s.charAt(i) == p.charAt(j) || '.' == p.charAt(j))) {
            if (nextStar) {
                return isMatch(s, p, i, j + 2) || isMatch(s, p, i + 1, j + 2) || isMatch(s, p, i + 1, j);
            } else {
                return isMatch(s, p, i + 1, j + 1);
            }
        } else if (nextStar) {
            return isMatch(s, p, i, j + 2);
        } else {
            return false;
        }
    }
}
