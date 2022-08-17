package practice.random;

import java.util.*;

/**
 * Created by Anindita Banik on 8/12/22.
 */
public class FindMedian {

    PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> big = new PriorityQueue<>();
    boolean even = true;

    public int addNum(int num) {
        if(even){
            big.offer(num);
            small.offer(big.poll());
        }
        else{
            small.offer(num);
            big.offer(small.poll());
        }
        even=!even;
        return findMedian();
    }

    public int findMedian() {
//        if(even){
//            return (small.peek());
//        }
//        else
            return small.peek();
    }

    List<Integer> list = new ArrayList<>();
    public Integer[] findMedians(int[] dataStream){
        for(int i=0;i<dataStream.length;i++){
            list.add(addNum(dataStream[i]));
        }
        return list.toArray(new Integer[0]);
    }

    public static void main(String[] args) {
        FindMedian fm = new FindMedian();
        int[] arr = new int[]{6,2,10,49,193,1};
        Integer[] result = fm.findMedians(arr);
        for(int i: result){
            System.out.print(i+",");
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */