import java.util.HashMap;
import java.util.Map;

class LSA{
    public static void main(String[] args) {
        LSA lsa = new LSA();
        int[] test = new int[]{100,4,200,1,2,3};
        System.out.println(lsa.longSubsequence(test));
    }
    public int longSubsequence(int[] nums){
        Map<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        for(int num : nums){
            if(!map.containsKey(num)){
                int left = map.containsKey(num-1)? map.get(num-1):0;
                int right = map.containsKey(num+1)?map.get(num+1):0;
                int sum = left+right+1;
                ans = Math.max(ans, sum);
                map.put(num,sum);
                map.put(num-left,sum);
                map.put(num+right,sum);
            }
        }
        return ans;
    }
}