## P2178_미로탐색

---

### Insight
1. visit를 체크하는 배열을 2차원 배열로 만들어도 된다.
2. BFS 함수의 매개 변수를 2개로 하여도 괜찮다, 좌표 기반일 때는 2개로 두자 ex) BFS(int v) -> BFS(int x, int y)
3. 꼭 연관관계 그래프로 만들어야 하는건 아니다!
4. 좌표 관련 문제가 나올때 Tip
   ```java
   int[] dx = {0,1,0,-1};
   int[] dy = {1,0,-1,0};
   for(int k = 0; k < 4; k++){
       int x = now[0] + dx[k];
       int y = now[1] + dy[k];
   }
   ```
5. DFS, BFS를 돌면서 추가 정보를 저장하면서 돌려야 할 때
   ```java
   Queue<int[]> queue = new LinkedList<>(); // 위치, depth 저장
   queue.add(new int[]{node, 0});
   ```
6. 시간 복잡도를 줄이려면 for문을 돌면서 BFS를 호출 하지 말고 큐를 전역변수에 놓고 값을 넣은 다음 한번에 BFS를 돌려서 해결 (Ex.7569_토마토)