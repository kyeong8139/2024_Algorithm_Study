import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[][] graph = new int[N][N];
		int[][] answer = new int[N][N];
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				graph[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<Integer> queue = new ArrayDeque<>();
		for (int v = 0; v < N; v++) {
			
			// 거리가 1인 인접정점을 queue에 넣음
			for (int i = 0; i < N; i++) {
				if (graph[v][i] == 1) {
					queue.offer(i);
				}
			}
			
			while(!queue.isEmpty()) {
				int cur = queue.poll();
				answer[v][cur] = 1;
				
				for (int i = 0; i < N; i++) {
					
					// 인접해있으면서 탐색하지 않은 경로일 경우
					if (graph[cur][i] == 1 && answer[v][i] == 0) {
						queue.offer(i);
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				sb.append(answer[r][c]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
}