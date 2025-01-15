# PS 에서 자주 나오는 Java 문법

## 문자열 

### 문자열 입력
```java
Scanner scanner = new Scanner(System.in);
String str1 = scanner.next();
String str2 = scanner.nextLine();
double v = scanner.nextDouble();
int i = scanner.nextInt();
```
- 콘솔 입력 시 사용
- next()는 공백이 나올때 까지 읽음, nextLine()은 띄어쓰기 나올때 까지 읽음

## 배열
```java
int[] arr = new int[10];
Arrays.fill(arr,Integer.MAX_VALUE);
```
- 특정 값으로 배열 채울수 있음

### 궁금 한점

- 2차원 배열 선언 vs 2차원 List 선언