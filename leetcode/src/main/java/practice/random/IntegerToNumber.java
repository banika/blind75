package practice.random;

/**
 * Created by Anindita Banik on 8/24/22.
 */
public class IntegerToNumber {
    String[] belowTen = {"","One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] belowTwenty = {"Ten","Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] belowHundred = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty","Ninety"};

    public String numberToWords(int num) {
        String result = helper(num);
        return result;
    }

    public String helper(int num){
        if(num==0) return "";
        else if(num<10) return belowTen[num];
        else if(num<20) return belowTwenty[num-10];
        else if(num<100) return belowHundred[(num/10)]+" "+helper(num%10);
        else if(num<1000) return helper(num/100)+" Hundred "+helper(num%100);
        else if(num<1000000) return helper(num/1000)+" Thousand "+helper(num%1000);
        else if (num < 1000000000) return helper(num/1000000) + " Million " +  helper(num % 1000000);
        else return helper(num/1000000000) + " Billion " + helper(num % 1000000000);
    }

    public static void main(String[] args) {
        IntegerToNumber iton = new IntegerToNumber();
        String result = iton.numberToWords(90900);
        System.out.println(result);
    }
}
