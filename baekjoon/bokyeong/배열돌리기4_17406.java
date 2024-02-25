import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K, ans;
	static int[][] rotationArray;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int[][] array = new int[N+1][M+1];
		for (int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 1; c <= M; c++) {
				array[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		rotationArray = new int[K][3];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			rotationArray[i][0] = Integer.parseInt(st.nextToken());
			rotationArray[i][1] = Integer.parseInt(st.nextToken());
			rotationArray[i][2] = Integer.parseInt(st.nextToken());
		}
		
		ans = Integer.MAX_VALUE;
		perm(array, 0, 0);
		
		System.out.println(ans);
	}
	
	static void perm(int[][] array, int depth, int visited) {
		if (depth == K) {
			int min = Integer.MAX_VALUE;
			for (int r = 1; r <= N; r++) {
				int temp = 0;
				for (int c = 1; c <= M; c++) {
					temp += array[r][c];
				}
				
				min = Math.min(min, temp);
			}
			
			ans = Math.min(ans, min);
		}
		
		for (int i = 0; i < rotationArray.length; i++) {
			if ((visited & (1 << i)) != 0) {
				continue;
			}
			
			int[][] newArray = rotate(array, i);
			perm(newArray, depth + 1, visited | 1 << i);
		}
	}
	
	static int[][] rotate(int[][] array, int idx) {
		int[][] newArray = new int[N+1][M+1];
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= M; c++) {
				newArray[r][c] = array[r][c];
			}
		}
		

		int r = rotationArray[idx][0];
		int c = rotationArray[idx][1];
		int s = rotationArray[idx][2];
		int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
		
		int startR = r-s;
		int startC = c-s;
		while(startR != r && startC != c) {
			int curR = startR;
			int curC = startC;
			
			int d = 0;
			while(d < 4) {
				int nr = curR + dirs[d][0];
				int nc = curC + dirs[d][1];
				
				if (nr < startR || nc < startC || nr >  r + r - startR || nc > c + c - startC) {
					d++;
					continue;
				}
				
				newArray[nr][nc] = array[curR][curC];
				curR = nr;
				curC = nc;
			}
			
			startR++;
			startC++;
		}
		
		return newArray;
	}
}
