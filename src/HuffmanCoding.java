import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class HuffmanCoding {
    public HashMap<Character, Integer> frequency = new HashMap<>();
    public Node HuffmanTree = null;

    public void countAlphabet(String src) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(src));
            String s;

            while ((s = in.readLine()) != null) {
                for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);
                    if (frequency.containsKey(c)) frequency.put(c, frequency.get(c) + 1);
                    else frequency.put(c, 1);
                }
            }
            in.close();
        } catch (IOException e) {
            System.err.println(e);
            System.exit(1);
        }
    }

    public void makeTree() {
        Heap heap = new Heap();

        if (frequency.isEmpty())
            return;

        for (char key : frequency.keySet())
            heap.insert(new Node(frequency.get(key), key));

        while (true) {
            Node leftChild = heap.extractMinNode();
            Node rightChild = heap.extractMinNode();

            HuffmanTree = new Node(leftChild.frequency + rightChild.frequency, '.');

            HuffmanTree.left = leftChild;
            HuffmanTree.right = rightChild;

            if (heap.isEmpty())
                return;

            heap.insert(HuffmanTree);
        }
    }

    public void printEachCharacterCode(Node htRoot, int[] trace, int top) {
        if (htRoot.left != null) {
            trace[top] = 0;
            printEachCharacterCode(htRoot.left, trace, top + 1);
        }

        if (htRoot.right != null) {
            trace[top] = 1;
            printEachCharacterCode(htRoot.right, trace, top + 1);
        }

        if (htRoot.left == null && htRoot.right == null) {
            System.out.print(htRoot.alphabet + "(빈도 수: " + htRoot.frequency + "): ");
            printArr(trace, top);
        }
    }

    public void printArr(int[] arr, int top) {
        for (int i = 0; i < top; i++)
            System.out.print(arr[i]);
        System.out.println("");
    }

    public void printFrequency() {
        System.out.println("----- 각 문자의 빈도수 -----");
        for (char key : frequency.keySet())
            System.out.println("key: " + key + ", freq: " + frequency.get(key));
        System.out.println("-------------------------");
    }
}
