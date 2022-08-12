package blind;

import java.util.*;

/**
 * Created by Anindita Banik on 8/8/22.
 */
public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){ map.put(num, map.getOrDefault(num, 0) + 1); }

        Queue<Integer> heap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        for(int key : map.keySet()){ heap.add(key); }

        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < k; i++){
            ans.add(heap.poll());
        }

        return ans.stream().mapToInt(j->j).toArray();
    }
    public static void main(String[] args) {
        int[] array = new int[]{8,8,8,5,5,3,3,3,3};
        TopKFrequentElements find = new TopKFrequentElements();
        int [] result = find.topKFrequent(array, 2);
        Arrays.stream(result).forEach(System.out::println);
    }
}
