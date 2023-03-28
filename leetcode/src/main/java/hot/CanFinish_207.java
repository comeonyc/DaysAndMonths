package hot;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: yc_comeon
 * @date: 2023/3/27
 * @description: TODO
 **/
public class CanFinish_207 {
    public static void main(String[] args) {
        System.out.println(canFinish(5, new int[][]{{1, 4}, {2, 4}, {3, 1}, {3, 2}}));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> dag = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            dag.putIfAbsent(prerequisite[0], new HashSet<>());
            dag.get(prerequisite[0]).add(prerequisite[1]);
        }

        Set<Integer> visited = new HashSet<>(numCourses);
        for (Map.Entry<Integer, Set<Integer>> entry : dag.entrySet()) {
            int key = entry.getKey();

            if (visited.contains(key)) {
                continue;
            }

            if (dfs(dag, key, visited)) {
                return false;
            }
        }

        return true;
    }

    public static boolean dfs(Map<Integer, Set<Integer>> dag, Integer cur, Set<Integer> flag) {
        if (flag.contains(cur)) {
            return true;
        }

        if (!dag.containsKey(cur)) {
            return false;
        }

        flag.add(cur);
        for (Integer dep : dag.get(cur)) {
            if (flag.contains(dep)) {
                continue;
            }
            if (dfs(dag, dep, flag)) {
                return true;
            }
        }
        return false;
    }
}
