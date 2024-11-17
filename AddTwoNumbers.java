import utils.ListNode;

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new ListNode(0);
        ListNode node5 = new ListNode(0);
        ListNode node6 = new ListNode(9);
        node4.next = node5;
        node5.next = node6;

        // Print out result
        System.out.print("* Input1: ");
        printList(node1);

        System.out.print("* Input2: ");
        printList(node4);

        int repeat = 10000;
        System.out.print("* Output by Solution 1: ");
        long startTime1 = System.currentTimeMillis();
        for (int i = 0; i < repeat; i++) {
            var result1 = solution1(node1, node4);
        }
        //printList(result1);
        long timeTaken1 = System.currentTimeMillis() - startTime1;
        System.out.printf("* Execution time: %.6f (ms) %n\n", (double) timeTaken1);

        System.out.print("* Output by Solution 2: ");
        long startTime2 = System.currentTimeMillis();
        for (int j = 0; j < repeat; j++) {
            var result2 = solution2(node1, node4);
        }
        //printList(result2);
        long timeTaken2 = System.currentTimeMillis() - startTime2;
        System.out.printf("* Execution time: %.6f (ms) %n\n", (double) timeTaken2);

    }

    private static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            node = node.next;
            if (node != null) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }

    /*
    Runtime: 1 ms
    Memory : 44.56 MB
    On LeetCode, run on 06 Nov 2024 Wed
     */
    private static ListNode solution1(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode l3 = dummyHead;

        int carry = 0;
        while (l1 != null || l2 != null) {
            int l1Val = (l1 != null) ? l1.val : 0;
            int l2Val = (l2 != null) ? l2.val : 0;

            int currentSum = l1Val + l2Val + carry;
            carry = currentSum / 10;
            int lastDigit = currentSum % 10;

            ListNode newNode = new ListNode(lastDigit);
            l3.next = newNode;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            l3 = l3.next;
        }

        if (carry > 0) {
            ListNode newNode = new ListNode(carry);
            l3.next = newNode;
        }

        return dummyHead.next;
    }

    /*
    Runtime: 1 ms
    Memory : 44.27 MB
    On LeetCode, run on 06 Nov 2024 Wed
    */
    private static ListNode solution2(ListNode l1, ListNode l2) {
        ListNode output = new ListNode(0);
        ListNode dummy = output;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }

            dummy.next = new ListNode(carry % 10);
            carry = carry / 10;
            dummy = dummy.next;
        }
        return output.next;
    }

}
