package tiendm.codefight.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InterviewLinkedList {
	static class ListNode<T> {
		ListNode(T x) {
			value = x;
		}

		T value;
		ListNode<T> next;
	}

	ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {
		ListNode<Integer> head = new ListNode<Integer>(0);
		head.next = l;
		ListNode<Integer> current = head;
		while (current != null) {
			ListNode<Integer> next = current.next;
			while (next != null && (int) next.value == k) {
				next = next.next;
			}
			current.next = next;
			current = next;
		}
		return head.next;
	}

	boolean isListPalindrome(ListNode<Integer> l) {
		ListNode<Integer> cur = l;
		Stack<Integer> stack = new Stack<>();
		while (cur != null) {
			stack.push(cur.value);
			cur = cur.next;
		}
		ListNode<Integer> check = l;
		while (check != null) {
			if (check.value.intValue() != stack.pop().intValue()) {
				return false;
			}
			check = check.next;
		}
		return true;
	}

	ListNode<Integer> addTwoHugeNumbers(ListNode<Integer> a, ListNode<Integer> b) {
		String s1 = getStrNum(a);
		String s2 = getStrNum(b);
		String s = "";
		int i = s1.length() - 1;
		int j = s2.length() - 1;
		int noted = 0;
		int n = 0;
		while (i >= 0 || j >= 0) {
			int n1 = 0, n2 = 0;
			if (i >= 0) {
				n1 = s1.charAt(i--) - '0';
			}
			if (j >= 0) {
				n2 = s2.charAt(j--) - '0';
			}
			n = n1 + n2 + noted;
			if (n > 9) {
				s = "" + (n % 10) + s;
				noted = 1;
			} else {
				s = "" + n + s;
				noted = 0;
			}
		}
		if (n > 9 && noted == 1) {
			s = "0001" + s;
		}
		int idx = 0;
		ListNode<Integer> l = new ListNode<Integer>(0);
		ListNode<Integer> cur = l;
		while (idx + 4 <= s.length()) {
			ListNode<Integer> next = new ListNode<Integer>(Integer.parseInt(s.substring(idx, idx + 4)));
			cur.next = next;
			cur = next;
			idx += 4;
		}
		return l.next;
	}

	private String getStrNum(ListNode<Integer> l) {
		String s = "";
		ListNode<Integer> cur = l;
		while (cur != null) {
			s += String.format("%04d", cur.value);
			cur = cur.next;
		}
		return s;
	}

	ListNode<Integer> mergeTwoLinkedLists(ListNode<Integer> l1, ListNode<Integer> l2) {
		ListNode<Integer> l = new ListNode<Integer>(0);
		ListNode<Integer> cur = l;
		ListNode<Integer> cur1 = l1;
		ListNode<Integer> cur2 = l2;
		while (cur1 != null || cur2 != null) {
			if (cur1 == null) {
				ListNode<Integer> next = new ListNode<Integer>(cur2.value);
				cur.next = next;
				cur = next;
				cur2 = cur2.next;
			} else if (cur2 == null) {
				ListNode<Integer> next = new ListNode<Integer>(cur1.value);
				cur.next = next;
				cur = next;
				cur1 = cur1.next;
			} else {
				if (cur1.value < cur2.value) {
					ListNode<Integer> next = new ListNode<Integer>(cur1.value);
					cur.next = next;
					cur = next;
					cur1 = cur1.next;
				} else {
					ListNode<Integer> next = new ListNode<Integer>(cur2.value);
					cur.next = next;
					cur = next;
					cur2 = cur2.next;
				}
			}
		}
		return l.next;
	}

	ListNode<Integer> reverseNodesInKGroups(ListNode<Integer> l, int k) {
		if (k == 1)
			return l;
		ListNode<Integer> cur = l;
		ListNode<Integer> lNew = new ListNode<Integer>(0);
		ListNode<Integer> curNew = lNew;
		Stack<Integer> stack = new Stack<>();
		while (cur != null) {
			stack.add(cur.value);
			cur = cur.next;
			if (stack.size() == k) {
				while (!stack.isEmpty()) {
					ListNode<Integer> next = new ListNode<Integer>(stack.pop());
					curNew.next = next;
					curNew = next;
				}
			}
		}
		Stack<Integer> stackNew = new Stack<>();
		if (stack.size() < k) {
			while (!stack.isEmpty()) {
				stackNew.add(stack.pop());
			}
		} else {
			stackNew = stack;
		}
		while (!stackNew.isEmpty()) {
			ListNode<Integer> next = new ListNode<Integer>(stackNew.pop());
			curNew.next = next;
			curNew = next;
		}
		return lNew.next;
	}

	ListNode<Integer> rearrangeLastN(ListNode<Integer> l, int n) {
		if (n == 0)
			return l;
		List<Integer> list = new ArrayList<>();
		ListNode<Integer> cur = l;
		while (cur != null) {
			list.add(cur.value);
			cur = cur.next;
		}
		int size = list.size();
		if (n >= size)
			return l;
		ListNode<Integer> lNew = new ListNode<Integer>(0);
		ListNode<Integer> curNew = lNew;
		for (int i = size - n; i < size; i++) {
			ListNode<Integer> next = new ListNode<Integer>(list.get(i));
			curNew.next = next;
			curNew = next;
		}
		for (int i = 0; i < size - n; i++) {
			ListNode<Integer> next = new ListNode<Integer>(list.get(i));
			curNew.next = next;
			curNew = next;
		}
		return lNew.next;
	}

	public static void main(String[] args) {
		InterviewLinkedList i = new InterviewLinkedList();
		ListNode<Integer> b = new ListNode<Integer>(1);
		ListNode<Integer> b2 = new ListNode<Integer>(2);
		ListNode<Integer> b3 = new ListNode<Integer>(3);
		ListNode<Integer> b4 = new ListNode<Integer>(4);
		ListNode<Integer> b5 = new ListNode<Integer>(5);
		// ListNode<Integer> b6 = new ListNode<Integer>(6);
		// ListNode<Integer> b7 = new ListNode<Integer>(7);
		// ListNode<Integer> b8 = new ListNode<Integer>(8);
		// ListNode<Integer> b9 = new ListNode<Integer>(9);
		// ListNode<Integer> b10 = new ListNode<Integer>(10);
		// ListNode<Integer> b11 = new ListNode<Integer>(11);
		b.next = b2;
		b2.next = b3;
		b3.next = b4;
		b4.next = b5;
		// b5.next = b6;
		// b6.next = b7;
		// b7.next = b8;
		// b8.next = b9;
		// b9.next = b10;
		// b10.next = b11;
		System.out.println(i.reverseNodesInKGroups(b, 2));
	}
}
