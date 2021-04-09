import java.util.*;
import java.io.*;

class Node{
    public char character; //문자
    public int frequency; // 빈도
    public Node left,right; //노드
}

class FrequencyComparator implements Comparator<Node>{ //우선순위 큐
    public int compare(Node a,Node b){
        int frequencyA=a.frequency;
        int frequencyB=b.frequency;
        return frequencyA-frequencyB; // 빈도 수 낮은 노드부터 출력
    }

}

public class huffman {
    public static PriorityQueue<Node> queue; //우선순위 큐
    public static HashMap<Object, String> charToCode = new HashMap<Object, String>(); //해시맵

    public static Node huffmanCoding(int n){
        for(int i=0;i<n-1;i++){
            Node z = new Node();
            z.right = queue.poll();
            z.left = queue.poll();
            z.frequency = z.right.frequency + z.left.frequency;
            queue.add(z); // 우선순위 큐로 삽입
        }
        return queue.poll();
    }


    public static void main(String[] args) {
        String text = new Scanner(System.in).next();
        HashMap<Character,Integer> dictionary = new HashMap<Character,Integer>(); // 빈도 수 확인

        for (int i=0; i<text.length();i++){
            char temp = text.charAt(i);

            if (dictionary.containsKey(temp))
                dictionary.put(temp,dictionary.get(temp)+1); // 이미 있다면 크기 증가
            else
                dictionary.put(temp,1);
        }

        queue = new PriorityQueue<Node>(100,new FrequencyComparator());
        int number = 0;

        for (Character c : dictionary.keySet()){
            Node temp = new Node();
            temp.character = c;
            temp.frequency = dictionary.get(c);
            queue.add(temp);
            number++;
        }

        Node root = huffmanCoding(number);

        traversal(root,new String()); // 변수 길이

        String result = new String(); // 실행결과 출력
        for (int i=0;i<text.length();i++)
            result = result + charToCode.get(text.charAt(i))+" ";

        System.out.println(result);


    }

    public static void traversal(Node n,String s){
        if (n==null)
            return;
        traversal(n.left,s+ "0");
        traversal(n.right,s+ "1");
        if (n.character!='\0'){
            System.out.println(n.character+ ":" +s);
            charToCode.put(n.character,s);
        }

    }
}