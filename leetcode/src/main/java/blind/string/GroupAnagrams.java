package blind.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Anindita Banik on 7/31/22.
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {

        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for(String str: strs){
            char[] table = new char[26];
            for(char c:str.toCharArray()){
                table[c-'a']++;
            }
            String keyStr = String.valueOf(table);
            if(!map.containsKey(keyStr))
                map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
