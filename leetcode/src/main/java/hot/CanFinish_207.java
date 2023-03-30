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

    /**
     * 拓扑排序，图的搜索
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> dag = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            dag.putIfAbsent(prerequisite[0], new HashSet<>());
            dag.get(prerequisite[0]).add(prerequisite[1]);
        }

        int[] visited = new int[numCourses];
        for (Map.Entry<Integer, Set<Integer>> entry : dag.entrySet()) {
            int key = entry.getKey();

            if (visited[key] == 2) {
                continue;
            }

            if (dfs(dag, key, visited)) {
                return false;
            }
        }

        return true;
    }

    public static boolean dfs(Map<Integer, Set<Integer>> dag, Integer cur, int[] visited) {
        visited[cur] = 1;
        if (!dag.containsKey(cur)) {
            visited[cur] = 2;
            return false;
        }
        for (int index : dag.get(cur)) {
            if (visited[index] == 0) {
                if (dfs(dag, index, visited)) {
                    return true;
                }
            } else if (visited[index] == 1) {
                return true;
            }

        }
        visited[cur] = 2;
        return false;
    }
}
