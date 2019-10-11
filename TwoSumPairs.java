package goldman;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TwoSumPairs {
    public int findPair(int[] nums, int target){
        if (nums == null || nums.length == 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();//<value, freq>
        for(int i = 0; i < nums.length; i++){
//            if(map.containsKey(nums[i])){
//                map.put(nums[i], map.get(nums[i]) + 1);
//            }else{
//                map.put(nums[i], 1);
//            }
        	int count = map.getOrDefault(nums[i], 0);
        	map.put(nums[i], ++count);
        }
        System.out.println(map);
        int count = 0;
        for(int i : map.keySet()){
            if(map.containsKey(target - i)){
                count += (map.get(i) * map.get(target - i));
            }
        }
        return count/2;
    }

    public static void main(String[] args){
        int[] nums = {0, 1, 1, 1, 2, 2, 2};
        int target = 3;
        TwoSumPairs twoSum = new TwoSumPairs();
        System.out.println(twoSum.findPair(nums, target));
    }
}
