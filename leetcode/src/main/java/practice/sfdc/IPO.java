package practice.sfdc;

import java.util.PriorityQueue;

/**
 * Created by Anindita Banik on 8/18/22.
 */
public class IPO {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        PriorityQueue<Point> q1 = new PriorityQueue<>((a, b) -> (a.cap - b.cap));
        PriorityQueue<Point> q2 = new PriorityQueue<>((a, b) -> (b.pro - a.pro));
        for(int i = 0; i<Profits.length; i++){
            q1.add(new Point(Profits[i], Capital[i]));
        }
        for(int i = 0; i<k; i++){
            while(!q1.isEmpty() && q1.peek().cap<=W) q2.add(q1.poll());
            if(q2.size()==0) break;
            W += q2.poll().pro;
        }
        return W;
    }
    class Point{
        int pro;
        int cap;
        public Point(int p, int c){
            this.pro = p;
            this.cap = c;
        }
    }
}
