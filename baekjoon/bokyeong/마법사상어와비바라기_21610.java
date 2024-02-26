import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][N];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<int[]> cloud = new ArrayDeque<>();
		cloud.add(new int[] {N-2, 0});
		cloud.add(new int[] {N-2, 1});
		cloud.add(new int[] {N-1, 0});
		cloud.add(new int[] {N-1, 1});
		
		int[][] dirs = {{0, 0}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int step = Integer.parseInt(st.nextToken());
			
			while (!cloud.isEmpty()) {
				int[] cur = cloud.poll();
				
				int nr = ((N * step) + cur[0] + (dirs[d][0] * step)) % N;
				int nc = ((N * step) + cur[1] + (dirs[d][1] * step)) % N;
				
				map[nr][nc]++;
				map[nr][nc] *= -1;	// 구름이 사라진 경우 음수로 표시
			}
			
			// 물복사 마법
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] >= 0) {
						continue;
					}
					
					int cnt = 0;
					for (int i = 2; i < dirs.length; i += 2) {
						int nr = r + dirs[i][0];
						int nc = c + dirs[i][1];
						
						if (nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] == 0) {
							continue;
						}
						
						cnt++;
					}
					
					map[r][c] -= cnt;
				}
			}
			
			// 구름 생성
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] >= 2) {
						cloud.add(new int[] {r, c});
						map[r][c] -= 2;
					}
					
					// 구름이 사라진 자리 표시 초기화
					if (map[r][c] < 0) {
						map[r][c] *= -1;
					}
				}
			}
		}
		
		int ans = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				ans += map[r][c];
			}
		}
		
		System.out.println(ans);
	}
}
