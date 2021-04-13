# Huffman-Coding
컴퓨터 알고리즘 6주차 팀과제
* 202001631 나병운 - 소개
* 201701643 고희수 - 소스코드
* 202001677 최종민 - 실행결과
* 이정수 - 마무리

* 각자 Branch를 생성하여 소스코드 업로드 하였습니다.

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
해시맵을 사용하여 빈도 수를 확인한다.(결과 출력 시 입력받은 문자열과 대조)

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
  루트노드를 시작으로 트리를 순회(traversal)하면서 0,1을 붙여 허프만 알고리즘을 적용한다.
  
  ------------------





## 실행결과

실행결과를 출력하기 위해 예시로 `\IJkkkJu79!!` 라는 문자열을 입력했다.

입력된 위의 문자열은 우선순위 큐를 이용해 완전이진트리를 구성한다.

<img width="191" alt="root left" src="https://user-images.githubusercontent.com/72187869/114439271-c2aec280-9c03-11eb-9a85-f968a30ce7dc.png">
<img width="176" alt="root right" src="https://user-images.githubusercontent.com/72187869/114439274-c4788600-9c03-11eb-8940-be78f189826f.png">

프로그램을 실행하면 다음과 같이 값이 들어가게 된다. 이를 그림으로 다시 도식화하면,

![Tree](https://user-images.githubusercontent.com/72187869/114495624-59599e80-9c59-11eb-997a-4ed62eee701e.jpg)

위의 그림과 같이 트리를 구성하게 되는데, 값을 가진 노드는 단말노드 뿐이다.

각 노드마다 왼쪽 자식노드에는 `0`을, 오른쪽 자식노드에는 `1`을 부여한다.

따라서 `0`과 `1`을 루트노드부터 단말노드까지 순서대로 읽어 이진코드를 얻었다.

>`!`: 000
`I`: 0010
`u`: 0011
`k`: 01
`9`: 1000
`\`: 1001
`7`: 101
`J`: 11

이를 입력한 문자열 순서대로 이진코드를 출력하면 다음과 같다.

> 1001 0010 11 01 01 01 11 0011 101 1000 000 000

<img width="338" alt="result" src="https://user-images.githubusercontent.com/72187869/114439206-b4f93d00-9c03-11eb-8831-099ea7b48d05.png">

---

