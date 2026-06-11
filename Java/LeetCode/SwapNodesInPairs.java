public class SwapNodesInPairs {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = first.next;

            // Swap nodes
            first.next = second.next;
            second.next = first;
            prev.next = second;

            // Move to next pair
            prev = first;
        }

        return dummy.next;
    }

    // Utility method to print list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) {
                System.out.print(" -> ");
            }
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SwapNodesInPairs solution = new SwapNodesInPairs();

        // Example: [1,2,3,4]
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4))));

        System.out.print("Original List: ");
        printList(head);

        ListNode result = solution.swapPairs(head);

        System.out.print("After Swapping: ");
        printList(result);
    }
}
