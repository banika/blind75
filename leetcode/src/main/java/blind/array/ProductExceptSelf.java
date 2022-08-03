package blind.array;

/**
 * Created by Anindita Banik on 7/19/22.
 */
public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums){
        int[] result = new int[nums.length];

        int left =1, right =1;
        //{1,2,3,4};
        //1,1,2,6

        for(int i=0;i<nums.length;i++){
            result[i] = left;
            left *=nums[i];
        }

        for(int i=nums.length-1; i>=0; i--){
            result[i] *= right;
            right *=nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        ProductExceptSelf productExceptSelf = new ProductExceptSelf();
        int[] array = {1,2,3,4};
        int[] result = productExceptSelf.productExceptSelf(array);
        System.out.println(result);
    }
}
