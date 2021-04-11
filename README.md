# Huffman-Coding
컴퓨터 알고리즘 6주차 팀과제
* 나병운 - 소개
* 고희수 - 소스코드
* 최종민 - 실행결과
* 이정수 - 마무리

## 허프만 코딩(Huffman-Coding)
**허프만 코딩**은 문자의 빈도 또는 확률정보를 이용하여 통계적으로 압축하는 방법이다.

입력 파일에 대해 각 문자의 출현 빈도수에 기반을 둔 이진트리를 만들어서 파일에 빈번히 나타나는 문자에는 짧은 이진 코드를 할당하고, 드물게 나타나는 문자에는 긴 이진 코드를 할당한다. **(이러한 이진 코드를 허프만 코드라고 한다)**

### 접두부 특성(prefix property)

**허프만 코딩**으로 변환시킨 문자 코드들 사이에는 접두부 특성이 존재한다.

각 문자에 부여된 이진 코드가 다른 문자에 부여된 이진 코드의 접두부(prefix)가 되지 않는다는 것을 의미한다.
```ex)
a -> 101
b -> 1, 10, 101은 부여 불가능
```
이때문에 코드와 코드 사이를 구분할 필요가 없다.

예를들어 `101#10#1#111#0#...` 에서 '#' 가 인접한 코드를 구분 짖고 있는데, 허프만 코딩에서는 이러한 특별한 코드가 필요없다.











-----------------------

## 주요 소스코드

```java
for(int i=0;i<n-1;i++){  
    Node z = new Node();  
  z.right = queue.poll();  
  z.left = queue.poll();  
  z.frequency = z.right.frequency + z.left.frequency;  
  queue.add(z); // 우선순위 큐로 삽입  
}  
return queue.poll();
```
문자열을 입력받은 뒤 빈도 수가 1 이상인 문자를 우선순위 큐에 삽입한다.

```java
HashMap<Character,Integer> dictionary = new HashMap<Character,Integer>(); // 빈도 수 확인
```
해시맵을 사용하여 빈도 수를 확인한다.

```java
for (Character c : dictionary.keySet()){  // 우선순위 큐 삽입
    Node temp = new Node();  
  temp.character = c;  
  temp.frequency = dictionary.get(c);  
  queue.add(temp);  // 빈도 수 확인하여 우선순위를 산정 
  number++;  
}
```
빈도수가 저장된 노드들을 우선순위 큐에 삽입한다.

```java
String result = new String(); // 실행결과 출력  
for (int i=0;i<text.length();i++)  
    result = result + charToCode.get(text.charAt(i))+" ";  
  
System.out.println(result);
```
결과를 출력한다.

```java
public static void traversal(Node n,String s){  
    if (n==null)  
        return;  
  traversal(n.left,s+ "0");  
  traversal(n.right,s+ "1");  
 if (n.character!='\0'){  
        System.out.println(n.character+ ":" +s);  
  charToCode.put(n.character,s);
  ```
  루트노드를 시작으로 트리를 순회하면서 허프만 알고리즘이 적용된다.
  
  ------------------

