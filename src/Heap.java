import java.util.ArrayList;
import java.util.Collections;

public class Heap {
    public ArrayList<Node> tree = new ArrayList<>();

    public Heap() {
        tree.add(null);
    }

    public void insert(Node n) {
        tree.add(n);

        int child = tree.size() - 1;
        int parent = child / 2;

        while (parent >= 1 && tree.get(child).frequency < tree.get(parent).frequency) {
            Collections.swap(tree, child, parent);

            child = parent;
            parent = child / 2;
        }
    }

    public boolean isEmpty() {
        return (tree.size() <= 1);
    }

    public Node extractMinNode() {
        if (isEmpty())
            return null;

        Node Min = tree.get(1);
        int top = tree.size() - 1;

        tree.set(1, tree.get(top));
        tree.remove(top);

        int parent = 1;
        int left = parent * 2;
        int right = parent * 2 + 1;

        while (left < tree.size() - 1) {
            int target;
            if (right > tree.size() - 1) {
                if (tree.get(left).frequency >= tree.get(parent).frequency)
                    break;
                target = left;
            } else {
                if (tree.get(left).frequency >= tree.get(parent).frequency && tree.get(right).frequency >= tree.get(parent).frequency)
                    break;
                target = (tree.get(left).frequency < tree.get(right).frequency) ? left : right;
            }

            Collections.swap(tree, target, parent);

            parent = target;
            left = parent * 2;
            right = parent * 2 + 1;
        }
        return Min;
    }
}
