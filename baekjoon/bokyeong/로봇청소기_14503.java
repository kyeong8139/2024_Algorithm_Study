import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] room = new int[N][M];

		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int ans = 0;
		int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
		while (true) {
			if (room[r][c] == 0) {
				room[r][c] = -1; // 청소한 방은 -1로 갱신
				ans++;
				continue;
			}

			boolean goBack = true;
			for (int[] dir : dirs) {
				int nr = r + dir[0];
				int nc = c + dir[1];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M || room[nr][nc] != 0) {
					continue;
				}

				goBack = false;
				break;
			}

			if (goBack) {
				int nr = r - dirs[d][0];
				int nc = c - dirs[d][1];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M || room[nr][nc] == 1) {
					break;
				}

				r = nr;
				c = nc;
				continue;
			}

			d = (dirs.length + d - 1) % dirs.length;
			int nr = r + dirs[d][0];
			int nc = c + dirs[d][1];

			if (nr < 0 || nc < 0 || nr >= N || nc >= M || room[nr][nc] != 0) {
				continue;
			}
			r = nr;
			c = nc;
		}

		System.out.println(ans);
	}
}
