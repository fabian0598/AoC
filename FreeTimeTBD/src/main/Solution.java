package main;

class Solution {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int nodeLength1 = getNodeLength(l1);
		int nodeLength2 = getNodeLength(l2);
		int neededSolutionLength = Math.max(nodeLength1, nodeLength2) + 1;
		ListNode rekursion1 = prolongeNodes(l1, neededSolutionLength);
		ListNode rekursion2 = prolongeNodes(l2, neededSolutionLength);
		ListNode solutionnode = rekursion(rekursion1, rekursion2).node;
		if (solutionnode.val == 0) {
			solutionnode = solutionnode.next;
		}
		return solutionnode;
	}
	private static NodePlusInt rekursion(ListNode i1, ListNode i2) {
		
		// Init needed Returns
		NodePlusInt solutionSet = new NodePlusInt();
		ListNode solutionNode = new ListNode();
		
		// RekursionBonus is needed if value exceeds 9 and needs to be taken a node before via rekursion
		int rekursionBonus = 0;
		
		// If Bottom of LinkedList is not reached
		if (!(i1.next == null && i2.next == null)) {
			NodePlusInt nodeIntRekursion = rekursion(i1.next, i2.next);
			rekursionBonus = nodeIntRekursion.value;
			solutionNode.next = nodeIntRekursion.node;
		}
		
		// Calculate Value of Node
		int sum = i1.val + i2.val + rekursionBonus;
		int over = 0;
		if (sum > 9) {
			over = 1;
			sum -= 10;
		}
		solutionNode.val = sum;
		
		// Define Return Values of Data Set
		solutionSet.value = over;
		solutionSet.node = solutionNode;
		return solutionSet;
	}

	public static void main(String[] args){
		ListNode test1 = new ListNode(2);
		ListNode test2 = new ListNode(0);
		ListNode test3 = addTwoNumbers(test1, test2);
		System.out.println(test3.val);
		System.out.println(test3.next.val);
		//System.out.println(test1.next.val);
	}
	private static int getNodeLength(ListNode l) {
		int lengthNode = 1; 
		while (l.next != null) {
			l = l.next;
			lengthNode++;
		}
		return lengthNode;
	}
	
	private static ListNode prolongeNodes(ListNode l, int addLength) {
		ListNode first = new ListNode(0);
		if (addLength > 0) {
			addLength--;
			first.next = prolongeNodes(l, addLength);
		} else {
			first = l;
		}
		return first;
		
	}

}