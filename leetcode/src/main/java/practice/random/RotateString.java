package practice.random;

/**
 * Created by Anindita Banik on 8/10/22.
 */
public class RotateString {
    public boolean rotateString(String s, String goal) {
        if(s==null || goal==null || s.length()!=goal.length())
            return false;
        if(s.equals(goal))
            return true;
        int count =0;
        String source = s;
        while(count<s.length()){
            String rotatedString = leftRotate(source);
            if(rotatedString.equals(goal))
                return true;
            count++;
            source = rotatedString;
        }
        return false;
    }

    //abc ==> bca
    public String leftRotate(String s) {
        char[] charArr = new char[s.length()];
        if(s==null || s.length()==0)
            return "";
        int i = 1;
        char temp = s.charAt(0);
        while(i<s.length()){
            charArr[i-1]=s.charAt(i);
            i++;
        }
        charArr[i-1] = temp;
        return String.valueOf(charArr);
    }

    public static void main(String[] args) {
        RotateString rs = new RotateString();
        String rotatedStr = rs.leftRotate("abc");
        System.out.println(rotatedStr);

        boolean flag = rs.rotateString("abcde", "cdeab");
        System.out.println(flag);
    }
}
