# PS 에서 자주 나오는 Java 문법

## 문자열 

### 문자열 입력
- 콘솔 입력 시 사용
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
terms[i].split(" ")[0], terms[i].split(" ")[1]
```

## 배열

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

### 궁금 한점

- 2차원 배열 선언 vs 2차원 List 선언