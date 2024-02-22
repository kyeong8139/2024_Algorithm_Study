import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		// 교실 배치
		int[][] classRoom = new int[N+1][N+1];
		
		// 학생들의 좋아하는 친구를 저장할 배열
		int[][] student = new int[(N*N)][5];
		for (int i = 0; i < student.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				student[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 학생의 위치를 저장할 배열
		int[][] positions = new int[N*N+1][2];
		int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		
		for (int i = 0; i < student.length; i++) {
			// 지금 학생 번호
			int cur = student[i][0];
			
			int max = 0;
			int[][] cnts = new int[N+1][N+1];
			for (int j = 1; j <= 4; j++) {
				int friendNum = student[i][j];
				
				int r = positions[friendNum][0];
				int c = positions[friendNum][1];
				
				if (r == 0) {
					continue;
				}
				
				// 좋아하는 친구의 상하좌우 빈자리에 cnt값을 더해주고 max를 갱신함
				for (int[] dir : dirs) {
					int nr = r + dir[0];
					int nc = c + dir[1];
					
					// 인덱스가 넘어가거나 빈자리가 아니면 넘어감
					if (nr < 1 || nc < 1 || nc > N || nr > N || classRoom[nr][nc] != 0) {
						continue;
					}
					
					cnts[nr][nc]++;
					max = Math.max(max, cnts[nr][nc]);
				}
			}
			
			int maxNearEmpty = -1;
			for (int r = 1; r <= N; r++) {
				for (int c = 1; c <= N; c++) {
					int nearEmpty = 0;
					if (cnts[r][c] == max && classRoom[r][c] == 0) {
						for (int[] dir : dirs) {
							int nr = r + dir[0];
							int nc = c + dir[1];
							
							if (nr < 1 || nc < 1 || nc > N || nr > N || classRoom[nr][nc] != 0) {
								continue;
							}
							
							nearEmpty++;
						}
						
						if (maxNearEmpty < nearEmpty) {
							positions[cur][0] = r;
							positions[cur][1] = c;
							maxNearEmpty = nearEmpty;
						}
					}
				}
			}
			
			classRoom[positions[cur][0]][positions[cur][1]] = cur;
		}
		
//		for (int r = 0; r <= N; r++) {
//			for (int c= 0; c <= N; c++) {
//				System.out.print(classRoom[r][c]);
//			}
//			System.out.println();
//		}
//		
//		for (int r = 1; r <= N*N; r++) {
//			System.out.println(positions[r][0] + " " + positions[r][1]);
//		}
		
		// 만족도 검사
		int ans = 0;
		for (int i = 0; i < student.length; i++) {
			int cur = student[i][0];
			int myR = positions[cur][0];
			int myC = positions[cur][1];
			
			int cnt = 0;
			for (int j = 1; j <= 4; j++) {
				int friendNum = student[i][j];
				
				int friendR = positions[friendNum][0];
				int friendC = positions[friendNum][1];
				
				if (Math.abs(myR-friendR) + Math.abs(myC-friendC) == 1) {
					cnt++;
				}
			}
			
			ans += (int) Math.pow(10, cnt-1);
		}
		
		System.out.println(ans);
	}
}
