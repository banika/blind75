package practice.random;

import java.util.*;

/**
 * Created by Anindita Banik on 8/13/22.
 */
public class KthLargest {
//    PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
//    int k = 0;
//    public KthLargest(int k, int[] nums) {
//        for(int i:nums){
//            heap.add(i);
//        }
//        this.k = k;
//
//    }
//
//    public int add(int val) {
//        heap.add(val);
//        int i=0;
//        List<Integer> list = new ArrayList<>();
//        while(i<k-1){
//            list.add(heap.remove());
//            i++;
//        }
//        int kthNumber = heap.peek();
//        for(int j:list){
//            heap.add(j);
//        }
//        return kthNumber;
//    }

    private int k;
    private Queue<Integer> minHeap = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        minHeap.add(val);
        if (minHeap.size() > k)
            minHeap.poll();
        return minHeap.peek();
    }
    public static void main(String[] args) {
        KthLargest largest = new KthLargest(3, new int[]{4, 5, 8, 2});
        int number = largest.add(3);
        System.out.println(number);
    }
}
