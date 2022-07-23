package problems.leetcode;

public class AddTwoNumbers {

    /*
        https://leetcode.com/problems/add-two-numbers/
     */

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // not a very good solution
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode current1 = l1;
        int num1 = 0;
        int num1Index = 0;
        while(current1.next != null){
            num1 += Math.pow(10, num1Index) * current1.val;
            num1Index++;
            current1 = current1.next;
        }
        num1 += Math.pow(10, num1Index) * current1.val;

        ListNode current2 = l2;
        int num2 = 0;
        int num2Index = 0;
        while(current2.next != null){
            num2 += Math.pow(10, num2Index) * current2.val;
            num2Index++;
            current2 = current2.next;
        }
        num2 += Math.pow(10, num2Index) * current2.val;

        int sum = num1 + num2;

        System.out.println(sum);

        char[] sumChars = String.valueOf(sum).toCharArray();

        ListNode sumNode = null;
        ListNode currentEndSumNode = null;

        for(int i = sumChars.length - 1; i >= 0; i--){
            int val = Integer.parseInt(String.valueOf(sumChars[i]));

            if(sumNode == null){
                sumNode = new ListNode(val);
                currentEndSumNode = sumNode;
            } else {
                currentEndSumNode.next = new ListNode(val);
                currentEndSumNode = currentEndSumNode.next;
            }
        }

        return sumNode;
    }

    public static void main(String[] args) {
        //addTwoNumbers(new ListNode(2, new ListNode(4, new ListNode(3))), new ListNode(5, new ListNode(6, new ListNode(4))));
        //addTwoNumbers(new ListNode(4, new ListNode(4, new ListNode(300000000))), new ListNode(5, new ListNode(6, new ListNode(4))));
    }

}
