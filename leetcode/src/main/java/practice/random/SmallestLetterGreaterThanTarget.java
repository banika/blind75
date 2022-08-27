package practice.random;

/**
 * Created by Anindita Banik on 8/21/22.
 */
public class SmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        int minGap = Integer.MAX_VALUE;
        int minIndex = 0;

        for(int i=0;i<letters.length;i++){
            int gap = letters[i]-target;
            if( gap > 0 && gap<minGap){
                minGap = gap;
                minIndex = i;
            }
        }

        return letters[minIndex];
    }

    public static void main(String[] args) {
        SmallestLetterGreaterThanTarget sl = new SmallestLetterGreaterThanTarget();
        char a = sl.nextGreatestLetter(new char[]{'e','e','e','n','n','n'}, 'd');
        System.out.println(a);
    }
}
