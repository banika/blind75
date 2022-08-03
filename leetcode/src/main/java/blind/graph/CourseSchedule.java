package blind.graph;

import java.util.*;

/**
 * Created by Anindita Banik on 7/17/22.
 *
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        //1. Init Map
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        HashMap<Integer, Set<Integer>> topoMap = new HashMap<>();

        //2. Build Map
        for(int i = 0; i < numCourses; i++) {
            inDegree.put(i, 0);
            topoMap.put(i, new HashSet<Integer>());
        }

        for(int[] pair : prerequisites) {
            int curCourse = pair[0], preCourse = pair[1];
            topoMap.get(preCourse).add(curCourse);  // put the child into it's parent's list
            inDegree.put(curCourse, inDegree.get(curCourse) + 1); // increase child inDegree by 1
        }

        //3. find course with 0 indegree
        Queue<Integer> queue = new LinkedList<>();
        for(Integer i: inDegree.keySet()){
            if(inDegree.get(i)==0)
                queue.add(i);
        }

        //3. find course with 0 indegree, minus one to its children's indegree, until all indegree is 0
        while(!queue.isEmpty()){
            numCourses--;
            int course = queue.poll();
            if(topoMap.containsKey(course)){
                for(Integer i:topoMap.get(course)){
                    inDegree.put(i, inDegree.get(i)-1);
                    if(inDegree.get(i)==0)
                        queue.add(i);
                }
            }
        }
        return numCourses==0;
    }
}
