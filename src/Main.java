import java.util.Collection;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node {
    public int freq;
    public Node rNode;
    public Node lNode;
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        HashMap<Character, Integer> fre = new HashMap<>();

        String str;
        str = sc.nextLine();

        for(int i=0; i<str.length(); i++) {
            char st = str.charAt(i);

            if(fre.containsKey(st))
                fre.put(st, fre.get(st)+1);
            else fre.put(st, 1);
        }

        Collection<Integer> values = fre.values();
        for (Integer value : values) {
            pq.add(value);
        }

            while (pq.size() >= 2) {
                Node n = new Node();

                n.lNode = pq.poll();
                n.rNode = pq.poll();
                n.freq = n.lNode.freq + n.rNode.freq;

                pq.add(n.freq);
            }
            System.out.println(pq.peek());
    }
}
