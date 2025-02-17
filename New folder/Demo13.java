import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return merge(lists, 0, lists.length - 1);
    }

    ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        int mid = l + (r - l) / 2;
        ListNode l1 = merge(lists, l, mid);
        ListNode l2 = merge(lists, mid + 1, r);
        return mergeTwoLists(l1, l2);
    }

    ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode x = new ListNode(0);
        ListNode y = x;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                y.next = l1;
                l1 = l1.next;
            } else {
                y.next = l2;
                l2 = l2.next;
            }
            y = y.next;
        }
        if (l1 != null) y.next = l1;
        if (l2 != null) y.next = l2;
        return x.next;
    }
}

public class Demo13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of lists:");
        int n = sc.nextInt();
        ListNode[] List = new ListNode[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter the number of elements in list " + (i + 1) + ":");
            int m = sc.nextInt();
            System.out.println("Enter the elements of list " + (i + 1) + ":");
            ListNode head = new ListNode(sc.nextInt());
            ListNode temp = head;
            for (int j = 1; j < m; j++) {
                temp.next = new ListNode(sc.nextInt());
                temp = temp.next;
            }
            List[i] = head;
        }

        Solution solution = new Solution();
        ListNode mergedList = solution.mergeKLists(List);

        System.out.println("Merged sorted list:");
        printList(mergedList);

        sc.close();
    }

    
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
