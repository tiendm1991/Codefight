package tiendm.codefight.interview;

public class InterviewTree {

	class Tree<T> {
		Tree(T x) {
			value = x;
		}

		T value;
		Tree<T> left;
		Tree<T> right;
	}

	boolean hasPathWithGivenSum(Tree<Integer> t, int s) {
		if (t == null) {
			return false;
		}
		Tree<Integer> left = t.left;
		Tree<Integer> right = t.right;
		if (left == null && right == null && t.value == s) {
			return true;
		}
		return (left != null && hasPathWithGivenSum(left, s - t.value))
				|| (right != null && hasPathWithGivenSum(right, s - t.value));
	}

	public static void main(String[] args) {
		InterviewTree i = new InterviewTree();
		System.out.println(i);
	}
}
