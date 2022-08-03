package blind.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Anindita Banik on 7/31/22.
 */
public class EncodeDecodeStrings {
    public String encode1(List<String> strs) {
        StringBuffer out = new StringBuffer();
        for (String s : strs)
            out.append(s.replace("#", "##")).append(" # ");
        return out.toString();
    }

    public List<String> decode1(String s) {
        List strs = new ArrayList();
        String[] array = s.split(" # ", -1);
        for (int i=0; i<array.length-1; ++i)
            strs.add(array[i].replace("##", "#"));
        return strs;
    }

    public String encode(List<String> strs) {
        StringBuffer sb = new StringBuffer();
        for(String str: strs){
            sb.append(str.replace("#","##")).append(" # ");
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        String[] strs = s.split(" # ");
        List<String> strList = new ArrayList<>();
        for(int i=0;i<strs.length-1;i++){
            strList.add(strs[i].replace("##","#"));
        }
        return strList;
    }
    public static void main(String[] args) {
        EncodeDecodeStrings eds = new EncodeDecodeStrings();
        String out = eds.encode(Arrays.asList("Hello","World"));
        System.out.println(out);

        List<String> outList = eds.decode(out);
        System.out.println(outList);
    }

}
