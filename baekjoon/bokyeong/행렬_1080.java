import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] map = new int[N][M];
		int[][] goal = new int [N][M];
		sc.nextLine();
		
		// map 입력받음
		for (int r = 0; r < N; r++) {
			String temp = sc.nextLine();
			for (int c = 0; c < M; c++) {
				map[r][c] = temp.charAt(c) - '0';
			}
		}
		
		// goal 입력받음
		for (int r = 0; r < N; r++) {
			String temp = sc.nextLine();
			for (int c = 0; c < M; c++) {
				goal[r][c] = temp.charAt(c) - '0';
			}
		}
		
		// map[r][c]와 goal[r][c]가 일치하지 않으면 3x3 행렬을 뒤집음
		int cnt = 0;
		for (int r = 0; r < N - 2; r++) {
			for (int c = 0; c < M - 2; c++) {
				if (map[r][c] != goal[r][c]) {
					switchMap(map, r, c);
					cnt++;
				}
			}
		}
		
		// 최종 결과를 확인해서 일치하지 않으면 결과값을 -1로 바꿈
		outer : for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] != goal[r][c]) {
					cnt = -1;
					break outer;
				}
			}
		}
		
		System.out.println(cnt);
	}
	
	public static void switchMap(int[][] map, int row, int col) {
		for (int r = row; r <= row + 2; r++) {
			for (int c = col; c <= col + 2; c++) {
				// xor 연산 : map[r][c]가 1이면 0, 0이면 1이 됨 
				map[r][c] = map[r][c]^1;
			}
		}
	}
}
