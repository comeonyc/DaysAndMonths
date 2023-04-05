package hot;

import java.util.*;

/**
 * @author: yc_comeon
 * @date: 2023/4/4
 * @description: TODO
 **/
public class ReconstructQueue_406 {
    /**
     * 先根据身高排序，身高一致根据前面有几个人排序
     *
     * 然后依次遍历插入
     * @param people
     * @return
     */
    public static int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length <= 1) {
            return people;
        }

        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }

                return o2[0] - o1[0];
            }
        });

        List<List<Integer>> list = new ArrayList<>();

        for (int[] ints : people) {
            int j = ints[1];
            list.add(j, new ArrayList<Integer>());
            list.get(j).add(ints[0]);
            list.get(j).add(ints[1]);
        }

        for (int i = 0; i < list.size(); i++) {
            people[i][0] = list.get(i).get(0);
            people[i][1] = list.get(i).get(1);
        }

        return people;
    }

    public static void main(String[] args) {
        System.out.println(reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}}));
    }
}
