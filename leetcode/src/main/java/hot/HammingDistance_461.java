package hot;

/**
 * @author: yc_comeon
 * @date: 2023/4/2
 * @description: TODO
 **/
public class HammingDistance_461 {

    public static int hammingDistance(int x, int y) {
        int count = 0;
        while (x > 0 || y > 0) {
            if (x % 2 != y % 2) {
                count++;
            }
            x = x > 0 ? x >> 1 : 0;
            y = y > 0 ? y >> 1 : 0;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
    }
}
