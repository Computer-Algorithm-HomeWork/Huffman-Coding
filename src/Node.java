public class Node {
    public int frequency;
    public char alphabet;
    public Node left, right;

    public Node(int frequency, char alphabet) {
        this.frequency = frequency;
        this.alphabet = alphabet;
        left = right = null;
    }
}
