import java.util.Scanner;

public class Main {

	static int answer = 0;

	// 인접한 곳으로 이동 가능
	static int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();
		int K = sc.nextInt(); // 출발점과 도착점을 포함한 거리K
		sc.nextLine();

		// 한수의 현재 위치는 왼쪽 아래점
		int[] curPos = { R - 1, 0 };

		// 집의 위치는 오른쪽 상단
		int[] targetPos = { 0, C - 1 };

		// 지도를 입력 받음
		char[][] map = new char[R][C];
		for (int r = 0; r < R; r++) {
			map[r] = sc.nextLine().toCharArray();
		}

		// dfs 호출
		boolean[][] isVisited = new boolean[R][C];
		isVisited[curPos[0]][curPos[1]] = true; // 시작 위치는 이미 방문함

		// 시작점을 포함해서 카운팅하므로 curCnt는 1로 넘겨줌
		dfs(map, curPos, targetPos, 1, K, isVisited); //

		// 출력
		System.out.println(answer);
	}

	// R과 C의 최대값은 5이므로, dfs로도 충분히 가능
	public static void dfs(char[][] map, int[] curPos, int[] targetPos, int curCnt, int targetCnt, boolean[][] isVisited) {
    	// cnt가 target에 도달하면 더이상 탐색할 필요가 없음
    	if (curCnt == targetCnt) {
    		if (curPos[0] != targetPos[0] || curPos[1] != targetPos[1]) {
    			return;
    		} else {
    			answer++;
    			return;
    		}
    	}
    	
    	for (int[] dir : dirs) {
    		int nr = curPos[0] + dir[0];
    		int nc = curPos[1] + dir[1];
    		
    		// 인덱스 유효성 검사 + T일 경우 이동하지 못함 + 이미 방문한 곳은 이동하지 못함
    		if (nr < 0 || nc < 0 || nr >= map.length || nc >= map[0].length 
    				|| map[nr][nc] == 'T' || isVisited[nr][nc]) {
    			continue;
    		}
    		
    		isVisited[nr][nc] = true;
    		dfs(map, new int[] {nr, nc}, targetPos, curCnt + 1, targetCnt, isVisited);
    		
    		// 다른 방향을 순회할 때를 위해 isVisited[nr][nc] 초기화
    		isVisited[nr][nc] = false;
    	}
    }
}