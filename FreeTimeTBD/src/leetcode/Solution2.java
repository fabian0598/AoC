package leetcode;

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

class Solution2 {
	
	public static void main(String[] args) {
		ListNode test = new ListNode(0);
		ListNode test1 = new ListNode(1);
		ListNode test2 = new ListNode(2);
		ListNode test3 = new ListNode(3);
		ListNode test4 = new ListNode(4);
		ListNode test5 = new ListNode(5);
		test.next = test1;
		test1.next = test2;
		test2.next = test3;
		test3.next = test4;
		printNodeList(reverseKGroup(test, 2));
		
	}
	
    public static ListNode reverseKGroup(ListNode head, int k) {
    	int listLength = getNodeLength(head);
    	ListNode newHead = new ListNode();
        int segments = (listLength - listLength % k) / k;
        while (segments >= 1) {
        	//System.out.println(i);
        	newHead = reverseNodes(getNode(head, (segments - 1) * k), k);
        	if(segments != 1) {
        		getNode(head, ((segments - 1) * k) - 1).next = newHead;
        	}
        	segments--;
        }
        return newHead;
    }
    
    public static ListNode getNode(ListNode head, int index) {
    	ListNode startingNode = head;
    	while(index > 0) {
    		startingNode = startingNode.next;
    		index--;
    	}
    	return startingNode;
    }
    
    public static ListNode reverseNodes(ListNode head, int length) {
    	ListNode lastSave = getNode(head, length);
    	ListNode newHead = getNode(head, length - 1);
    	System.out.println("Last Save:");
    	System.out.println(lastSave.val);
    	for (int i = length - 1; i >= 1; i--) {
    		System.out.println("Head i:");
    		System.out.println(getNode(head, i).val);
    		System.out.println("Head i-1:");
    		System.out.println(getNode(head,i - 1).val);
    		getNode(head, i).next = getNode(head, i - 1);
    	}
    	head.next = lastSave;
    	return newHead;
    }
    
    private static int getNodeLength(ListNode l) {
		int lengthNode = 1; 
		while (l.next != null) {
			l = l.next;
			lengthNode++;
		}
		return lengthNode;
	}
    
    private static void printNodeList(ListNode l) {
    	while(l != null) {
    		System.out.println("PrintNodeList:");
    		System.out.println(l.val);
    		l = l.next;
    	}
	}
}