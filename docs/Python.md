# 파이썬

## 입출력

---

### 입력

- `input()` : 입력받기
- `map()` : 리스트의 각 요소에 함수를 적용
- `list(map(int, input().split()))` : 공백으로 구분된 정수 입력받고 리스트로 변환
- `a, b = map(int, input().split())` : 공백으로 구분된 정수 입력받고 a, b에 각각 저장
- `sys.stdin.readline()` : 입력받기 (속도 빠름), 이진탐색, 정렬, 그래프 관련 문제에서 자주 사용함
- `grid = [list(map(int, input().strip())) for _ in range(N)]`
  - 2차원 배열을 간히 입력 받을수 있음 

### 출력

- `print()` : 출력하기
- `print(a, b)` : a, b를 공백으로 구분하여 출력
- `print(a, end=' ')` : a를 출력하고 줄바꿈 하지 않음


## 리스트

---

### 내장 함수
- `list.append(x)` : 리스트에 x 추가
- `list.insert(i, x)` : 리스트 i번째에 x 삽입
- `list.count(x)` : 리스트에서 x의 개수 반환
- `list.index(x)` : 리스트에서 x의 인덱스 반환
- `list.sort()` : 리스트 정렬 (오름차순)
- `list.sort(reverse=true)` : 리스트 정렬 (내림차순)
- `list.reverse()` : 리스트 역순 정렬
- `list.pop()` : 리스트 마지막 요소 삭제
- `list.pop(i)` : 리스트 i번째 요소 삭제
- `list.remove(x)` : 리스트에서 x값 삭제

### 리스트 컴프리헨션
- 리스트 안에 if, for문 넣어서 리스트 초기화 가능
    ```python
    a = [i for i in range(10) if i % 2 == 0]
    print(a) # [0, 2, 4, 6, 8]
    ```
- N * M 2차원 리스트 초기화
    ```python
    a = [[0] * M for _ in range(N)]
    print(a) # [[0, 0, 0], [0, 0, 0], [0, 0, 0]]
    ```

### 깊은 복사 할때 
- 아얘 새로운 리스트를 만들어야 할때
  ```python
    import copy

    list = []
    temp = copy.deepcopy(list)
  ```


## 수 (Count)

---

### 소숫점 표현
```python
a = 0.3 + 0.6
print(a)
```
- 결과 : 0.89999
- 해결 방법 : round(a, 1) 로 반올림

### 나누기 연산자
- 파이썬에선 나눠진 결과를 실수로 반환
- ex) 10/3 = 3.333
- 해결 방법 : //를 이용해서 몫만 반환
- ex) 10//3 = 3
  

## 쓸만한 내장 함수

---

- eval() : 문자열을 실제 코드처럼 실행해 준다
  ```python
  a = eval("1 + 2")
  print(a) # 3
  ```

- maxPos2에서 가장 작은 row 고르기
  ```python
  minRow = min(row for column, row in maxPos2)
  ```
  
- friendCount 2차원 배열에서 가장 큰 row 고르기
  ```python
  maxValue = max(max(row) for row in friendCount)
  ```
- sort()


## 문자열

---
- `ord("A")` 로 String을 아스키 코드로 변환 가능

- 덧셈(+)로 문자열 연결 가능
  ```python
  a = "hello"
  b = "world"
  c = a + b
  print(c) # helloworld
  ```

- 문자열은 특정 인덱스 변경 불가능

## 사전 자료형 (Dictionary)

---

- 사전 자료형은 키와 값으로 이루어져 있다.
    ```python
    a = {'A': 1, 'B': 2, 'C': 3}
    print(a['A']) # 1
    ```

### 내장 함수

- dict.keys() : 키만 가져오기
  ```python
    dict = {"apple": 3, "banana": 5, "cherry": 2}
    for key in dict.keys():
        print(key) # apple, banana, cherry
  ```

- dict.values() : 값만 가져오기
  ```python
    dict = {"apple": 3, "banana": 5, "cherry": 2}
    for value in dict.values():
        print(value) # 3,5,2
  ```
  
- dict.items() : 값만 가져오기
  ```python
    dict = {"apple": 3, "banana": 5, "cherry": 2}
    for value in dict.items():
        print(value) # ('apple', 3), ('banana', 5), ('cherry', 2)
  ```


## 함수

---

- global 변수 사용하기 : 함수 안에서 전역변수를 사용하려면 global 키워드를 사용해야 한다.
  ```python
  a = 0
  def func():
      global a
      a = 1
  ```
  
- 파이썬에서는 함수 반환 값 이 여러개일 수 있다.
  ```python
  def func():
      return 1, 2, 3
  a, b, c = func()
  print(a, b, c) # 1 2 3
  ```


## 튜플

---

- 최단 경로 알고리즘(다익스트라)에서 (비용, 노드번호)로 묶어서 튜플 사용한다 


## 집합 (Set)

---

- 집합 자료형은 중복을 허용하지 않는다.
  ```python
  data = set([1, 1, 2, 2, 3, 4, 5])
  print(data) # {1, 2, 3, 4, 5}
  ```
- 합집합, 교집합, 차집합을 지원한다.
  ```python
  a = {1, 2, 3}
  b = {3, 4, 5}
  
  c = a & b # 교집합
  c = a | b # 합집합
  c = a - b # 차집합
  ```
