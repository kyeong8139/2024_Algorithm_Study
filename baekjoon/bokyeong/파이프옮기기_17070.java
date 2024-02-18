import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int[][] map = new int[N+1][N+1];
		for (int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 1; c <= N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs(map, 1, 2, 0);
		System.out.println(ans);
	}
	
	// status 가로 0 세로 1 대각선 2
	public static void bfs (int[][] map, int r, int c, int status) {
		if (r == N && c == N) {
			ans++;
			return;
		}
		
		// 가로
		if (status != 1) {
			int nr = r;
			int nc = c + 1;
			if (nc <= N && map[nr][nc] == 0) {
				bfs(map, nr, nc, 0);
			}
		}
		
		// 세로
		if (status != 0) {
			int nr = r + 1;
			int nc = c;
			if (nr <= N && map[nr][nc] == 0) {
				bfs(map, nr, nc, 1);
			}
		}
		
		// 대각선
		int nr = r + 1;
		int nc = c + 1;
		if (nr <= N && nc <= N && map[nr][nc] == 0 && map[r][nc] == 0 && map[nr][c] == 0) {
			bfs(map, nr, nc, 2);
		}
	}
}
