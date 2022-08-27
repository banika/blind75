package practice.sfdc;

import java.util.HashMap;

/**
 * Created by Anindita Banik on 8/18/22.
 */
public class MinStickers {
    int minStickers = Integer.MAX_VALUE;
    public int minStickers(String[] stickers, String target) {
        backtrack(0,0,new HashMap<>(), stickers, target);
        return minStickers==Integer.MAX_VALUE?-1:minStickers;
    }

    private void backtrack(int pos, int noOfStickers, HashMap<Character, Integer> availableChars,
                           String[] stickers, String target) {
        if(noOfStickers>=minStickers) return;
        if(pos==target.length()){
            minStickers = Math.min(noOfStickers, minStickers);
            return;
        }
        Character c = target.charAt(pos);
        if(availableChars.containsKey(c) && availableChars.get(c) > 0){
            availableChars.put(c, availableChars.get(c)-1);
            backtrack(pos+1, noOfStickers, availableChars, stickers, target);
            availableChars.put(c, availableChars.get(c)+1);
        } else{
            for(String sticker:stickers){
                if(!sticker.contains(String.valueOf(c))) continue;
                for(char ch: sticker.toCharArray())
                    availableChars.put(ch, availableChars.getOrDefault(ch,0)+1);

                backtrack(pos, noOfStickers+1, availableChars, stickers, target);
                for(char ch: sticker.toCharArray())
                    availableChars.put(ch, availableChars.getOrDefault(ch,0)-1);
            }
        }
    }

}
