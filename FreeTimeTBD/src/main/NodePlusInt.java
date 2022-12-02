package main;

public class NodePlusInt {
	int value;
	ListNode node;
	NodePlusInt() {}
	NodePlusInt(ListNode node) { this.node = node; }
	NodePlusInt(int value, ListNode node) { this.value = value; this.node = node; }
}
