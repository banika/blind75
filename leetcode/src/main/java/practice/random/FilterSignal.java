package practice.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Anindita Banik on 8/6/22.
 * Given frequencis, filterRanges return number of frequencies pass through all of the ranges
 */
public class FilterSignal {

    public int filterSignal(List<Integer> frequencies, List<List<Integer>> filterRanges){
        int count =0;

        for(int frequency: frequencies){
            boolean found = true;
            for(List<Integer> range: filterRanges){
                if(frequency<range.get(0) || frequency>range.get(1)) {
                    found = false;
                    break;
                }
            }
            if(found)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        FilterSignal fs = new FilterSignal();
        List<Integer> frequencies = Arrays.asList(8, 14, 15, 16, 21);

        List<Integer> range1 = Arrays.asList(10,17);
        List<Integer> range2 = Arrays.asList(13,15);
        List<Integer> range3 = Arrays.asList(13,17);

        List<List<Integer>> filterRanges = new ArrayList<>();
        filterRanges.add(range1);
        filterRanges.add(range2);
        filterRanges.add(range3);

        System.out.println(fs.filterSignal(frequencies, filterRanges));
    }
}
