/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode temp=head;
        int a=-1,b=-1,max=0,min=Integer.MAX_VALUE,i=1;
        while(temp.next!=null&&temp.next.next!=null){
            int prev=temp.val;
            int curr=temp.next.val;
            int next=temp.next.next.val;
            if((curr > prev && curr > next)||(curr < prev && curr < next)){
                if(a==-1)a=i;
                if(b!=-1)min=Math.min(min,i-b);
                b=i;
                max=b-a;
            }

            temp=temp.next;
            i++;
        }
        if (a == -1 || a == b) {
            return new int[]{-1, -1};
        }
    return new int[]{min,max};    
    }
}