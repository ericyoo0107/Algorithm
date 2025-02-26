# PS 에서 자주 나오는 Java 문법

## 문자열 

- 콘솔로 문자열 입력
```java
Scanner scanner = new Scanner(System.in);
String str1 = scanner.next();
String str2 = scanner.nextLine();
double v = scanner.nextDouble();
int i = scanner.nextInt();
// next()는 공백이 나올때 까지 읽음, nextLine()은 띄어쓰기 나올때 까지 읽음
```

- 문자열 나누기
```java
// String[] terms = {"A 6", "B 12", "C 3"};
HashMap termMap = new HashMap<>();
termMap.put(terms[i].split(" ")[0], terms[i].split(" ")[1]); 
// -> A:6, B:12, C:3
```

- char 에서 int 로 변경
```java
int num = Character.getNumericValue(line.charAt(j));
```


## 배열

- 2차원 ArrayList 만들기
```java
// dfs, bfs 인접 리스트 만들때 사용 가능
ArrayList<ArrayList<Integer>> a = new ArrayList<>();
```

- 특정 값으로 배열 채울수 있음
```java
int[] arr = new int[10];
Arrays.fill(arr, Integer.MAX_VALUE);
```

- Array에서 List 만들기
```java
List<String> friendList = Arrays.stream(friends).toList();
```

- 배열 복사 하기
```java
int[] newAnswer = Arrays.copyOfRange(answer, 0, num);
```

## 수학

- 제곱 연산 하기 : `Math.pow()`
```java
A += Math.pow((target%10), P);
```


### 궁금 한점

- 2차원 배열 선언 vs 2차원 List 선언