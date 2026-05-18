public class AddTwoNumbers {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // Dummy node to simplify result list creation
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        int carry = 0;

        // Continue until both lists are finished
        // and there is no carry left
        while (l1 != null || l2 != null || carry != 0) {

            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            int sum = x + y + carry;

            // Update carry
            carry = sum / 10;

            // Create node with last digit
            current.next = new ListNode(sum % 10);

            // Move current pointer
            current = current.next;

            // Move input pointers if possible
            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }

        // Return actual head (skip dummy node)
        return dummy.next;
    }
}