package goldman;

import java.util.Set;

public class SecondSmall {
    public int secondSmall(int[] nums){
        int first, second, size = nums.length;
        if(nums.length < 2)
            return 0;

        first = second = Integer.MAX_VALUE;
        //loop

        for(int i = 0; i< nums.length; i++){
            //if cur smaller than first
            if(nums[i] < first){
                second = first;
                first = nums[i];
            }else if(nums[i] < second && nums[i] > first){//Current smaller than second but larger than first
                second = nums[i];
            }
        }

        if(second == Integer.MAX_VALUE)
            return 0;
        return second;
    }

    public static void main(String[] args){
        int[] nums = {6, 3, 5, 2, 4};
        SecondSmall secondSmall = new SecondSmall();
        System.out.println(secondSmall.secondSmall(nums));
    }
}
