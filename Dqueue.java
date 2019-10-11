import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

class Dqueue{
    public static void main(String[] args) {
        Deque<Integer> q = new ArrayDeque<>();
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.addFirst(1);
        q.addLast(2);
        int[] nums = new int[] {1,3,-1,-3,5,3,6,7};
        Dqueue dq = new Dqueue();
        int[] test = dq.maxWindow(nums, 3);
        for(int temp : test){
            System.out.print(temp);
        }
        // System.out.print(q);
    }
    public int[] maxWindow(int[] nums, int k){
        if(nums==null || k==0) return nums;
        int[] ans = new int[nums.length-k+1];
        Deque<Integer> q = new LinkedList<>();
        int index = 0;
        for(int i=0;i<nums.length;i++){
            while(!q.isEmpty() && q.peek()<i-k+1){
                q.poll();
            }
            while(!q.isEmpty() && nums[i]>nums[q.peekLast()]){
                q.pollLast();
            }
            q.offer(i);
            if(i>=k-1){
                ans[index++] = nums[q.peek()];
            }
        }
        return ans;
    }
}