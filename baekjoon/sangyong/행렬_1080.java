import java.util.Scanner;

public class 행렬_1080 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] arr = new int[N * 2][M];
		String[] array = new String[N * 2];

		for (int r = 0; r < 2 * N; r++) { // 행렬 입력받기
			array[r] = sc.next();
			for (int c = 0; c < M; c++) {
				arr[r][c] = array[r].charAt(c) - '0';
			}
		}
		int count = 0;
		for (int r = 0; r < N - 2; r++) {// 0x0부분 부터 차례대로 일치하지 않을경우 1과 0을 바꿔줌
			for (int c = 0; c < M - 2; c++) {
				if (arr[r][c] != arr[r + N][c]) {
					count++;
					for (int dr = 0; dr < 3; dr++) {
						for (int dc = 0; dc < 3; dc++) {
							arr[r + dr][c + dc] = 1 - arr[r + dr][c + dc];
						}
					}
				}
			}
		}

		out: for (int r = 0; r < N; r++) { // 정답과 일치 하지 않으면 -1출력
			for (int c = 0; c < M; c++) {
				if (arr[r][c] != arr[r + N][c]) {
					count = -1;
					break out;
				}
			}
		}

		System.out.println(count);
	}
}
