package hot;

import java.util.*;

/**
 * @author: yc_comeon
 * @date: 2023/3/28
 * @description: TODO
 **/
public class LeastInterval_621 {
    public static void main(String[] args) {
        System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}, 2));
    }

    public static int leastInterval(char[] tasks, int n) {
        if (n == 0) {
            return tasks.length;
        }
        Map<Character, Integer> maps = new HashMap<>();
        for (char task : tasks) {
            maps.put(task, maps.getOrDefault(task, 0) + 1);
        }

        int num = 0;
        List<Character> window = new ArrayList<>(n);
        while (!maps.isEmpty()) {
            Optional<Map.Entry<Character, Integer>> min = maps.entrySet().stream().filter(x -> !window.contains(x.getKey())).max(Comparator.comparingInt(Map.Entry::getValue));
            if (min.isPresent()) {
                Character task = min.get().getKey();
                window.add(task);
                if (maps.get(task) > 1) {
                    maps.put(task, maps.get(task) - 1);
                } else {
                    maps.remove(task);
                }
            } else {
                window.add('#');
            }
            System.out.println(window.get(window.size() - 1));

            if (window.size() > n) {
                window.remove(0);
            }
            num++;
        }
        return num;
    }

}
