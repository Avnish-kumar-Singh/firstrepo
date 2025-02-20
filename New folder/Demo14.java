import java.util.Scanner;
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode x = new ListNode(0);
        x.next=head;
        ListNode y=x;
        while(head!=null && head.next!=null){
            ListNode first=head;
            ListNode second=head.next;

            first.next=second.next;
            second.next=first;
            y.next=second;
            
            y=first;
            head=first.next;
        }
        return x.next;
    }
}
public  class Demo14{
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the number of elements in the list:");
        int n=sc.nextInt();
        System.out.println("Enter the elements of the list:");
        ListNode head = new ListNode(sc.nextInt());
        ListNode temp=head;
        for(int i=1;i<n;i++){
            temp.next=new ListNode(sc.nextInt());
            temp=temp.next;
        }
        Solution s = new Solution();
        ListNode result = s.swapPairs(head);
        System.out.println("The list after swapping pairs is:");
        while(result!=null){
            System.out.print(result.val+" ");
            result=result.next;

        
    }
    sc.close();
}
}