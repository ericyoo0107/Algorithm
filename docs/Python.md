# 파이썬

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
  
## 문자열

---

- 덧셈(+)로 문자열 연결 가능
  ```python
  a = "hello"
  b = "world"
  c = a + b
  print(c) # helloworld
  ```

- 문자열은 특정 인덱스 변경 불가능


## 튜플

---

- 최단 경로 알고리즘에서 (비용, 노드번호)로 묶어서 튜플 사용한다 

