package tiendm.codefight.challenge.nov;

public class HeightOfBST {
  int heightOfBST(int[] values) {
    class Node {
      int value;
      Node left;
      Node right;
      int heght;

      public Node(int value, Node left, Node right, int heght) {
        this.value = value;
        this.left = left;
        this.right = right;
        this.heght = heght;
      }

      @Override
      public String toString() {
        return "Node [value=" + value + ", heght=" + heght + "]";
      }

    }
    if (values.length <= 1)
      return values.length;
    int max = 0;
    Node root = new Node(values[0], null, null, 1);
    max = 1;
    for (int i = 1; i < values.length; i++) {
      int v = values[i];
      Node cur = root;
      while ((v <= cur.value && cur.left != null) || (v > cur.value && cur.right != null)) {
        cur = v <= cur.value ? cur.left : cur.right;
      }
      Node newNode = new Node(v, null, null, cur.heght + 1);
      max = Math.max(newNode.heght, max);
      if (v <= cur.value) {
        cur.left = newNode;
      } else {
        cur.right = newNode;
      }
    }
    return max;
  }

  public static void main(String[] args) {
    HeightOfBST h = new HeightOfBST();
    int[] x = {34, 96, -73, 10, -98, 25};
    System.out.println(h.heightOfBST(x));
  }
}
