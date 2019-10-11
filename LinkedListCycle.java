import java.util.*;
class LinkedListCycle{
    static class ListNode {

        private int value;
        private ListNode next;
    
    
        public ListNode(int value) {
            this.value = value;
        }
    
        public ListNode getNext() {
            return next;
        }
    
        public ListNode next(ListNode next) {
            this.next = next;
            return this.next;
        }
    
        public ListNode next(int nextValue) {
            this.next = new ListNode(nextValue);
            return this.next;
        }
    }
    public static void main(String[] args) {

		ListNode head = new ListNode(1);
		ListNode second = head.next(2);
		ListNode third = second.next(3);
		ListNode fourth = third.next(4);
        ListNode fifth = fourth.next(second);
        // ListNode fifth = fourth.next(4);


        // System.out.println(containsCycle(head));
        // System.out.println(cycleEnter(head));
        List<int[]> ans = new ArrayList<>();
        int[] temp = new int[]{0,1};
        ans.add(temp);
        temp[0]=99;
        for(int[] asd : ans){
            System.out.print(asd[0]);
            System.out.print(asd[1]);
        }
	}

	private static boolean containsCycle(ListNode node){
        ListNode fast = node;
        ListNode slow = node;
        while(fast.next!=null && fast.next.next !=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return true;
            }
        }
		return false;
    }
    
    private static int cycleEnter(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        ListNode curNode = null;
        int length=0;
        int cycleLength=0;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            length++;
            if(slow==fast){
                curNode = slow;
                break;
            }
        }
        fast = head;
        while(fast!=curNode){
            fast=fast.next;
            curNode=curNode.next;
            cycleLength++;
        }
        return cycleLength;
    }
}