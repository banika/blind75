package blind.interval;

import java.util.*;

/**
 * Created by Anindita Banik on 7/25/22.
 */
public class MinimumIntervalQuery {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int q:queries){
            for(int[] interval: intervals){
                for(int i=interval[0]; i<=interval[1]; i++){
                    if(q==i){
                        map.put(q, Math.min(map.getOrDefault(q,Integer.MAX_VALUE), (interval[1]-interval[0]+1)));
                    }
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int q:queries){
            list.add(map.getOrDefault(q,-1));
        }
        return list.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        MinimumIntervalQuery miq = new MinimumIntervalQuery();
        int[][] intervals = {{1,4},{2,4},{3,6},{4,4}};
        int[] query = {2,3,4,5};
        int[] res = miq.minInterval(intervals, query);
        Arrays.stream(res).forEach(System.out::print);
    }
}
