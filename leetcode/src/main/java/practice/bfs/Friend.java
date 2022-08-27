package practice.bfs;

import java.util.*;

/**
 * Created by Anindita Banik on 8/25/22.
 */

public class Friend {
    public int id;
    public List<Friend> friendsList;

    public boolean checkForConnection(Friend exampleFriend) {
        //In this function, check to see if you have any (no matter how distant) connection to the friend object passed in
        Queue<Friend> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(this);
        visited.add(this.id);

        for(Friend friend:this.friendsList){
            queue.add(friend);
        }
        while(!queue.isEmpty()){
            Friend temp = queue.poll();
            if(temp.id==exampleFriend.id)
                return true;

            for(Friend friend: temp.friendsList){
                if(!visited.contains(friend)){
                    visited.add(friend.id);
                    queue.add(friend);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Friend A = new Friend();
        A.id=1;

        Friend B = new Friend();
        B.id=2;

        A.friendsList = Arrays.asList(new Friend[]{B});

        Friend C = new Friend();
        C.id=3;
        C.friendsList = new ArrayList<>();

        Friend D = new Friend();
        D.id=4;
        //D.friendsList = new ArrayList<>();

        B.friendsList = Arrays.asList(new Friend[]{C});

        C.friendsList = Arrays.asList(new Friend[]{D});

        Boolean result = A.checkForConnection(D);
        System.out.println(result);
    }
}
