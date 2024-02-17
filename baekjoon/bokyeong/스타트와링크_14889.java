import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 능력치 입력
		int N = Integer.parseInt(st.nextToken());
		int[][] person = new int[N + 1][N + 1];
		for (int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 1; c <= N; c++) {
				person[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		boolean[] isSeleted = new boolean[N + 1];
		for (int i = N; i > N / 2; i--) {
			isSeleted[i] = true;
		}

		int ans = Integer.MAX_VALUE;
		do {
			int startSum = 0;
			int linkSum = 0;
			for (int i = 1; i <= N; i++) {
				if (isSeleted[i]) {
					for (int j = 1; j <= N; j++) {
						if (isSeleted[j]) {
							startSum += person[i][j];
						}
					}
					continue;
				}

				for (int j = 1; j <= N; j++) {
					if (!isSeleted[j]) {
						linkSum += person[i][j];
					}
				}
				continue;
			}

			ans = Math.min(ans, Math.abs(startSum - linkSum));

		} while (nextComb(isSeleted));
		
		System.out.println(ans);
	}

	public static boolean nextComb(boolean[] isSelected) {
		int top = 1;
		for (int i = isSelected.length - 1; i > 1; i--) {
			if (isSelected[i] && !isSelected[i - 1]) {
				top = i;
				break;
			}
		}

		if (top == 1) {
			return false;
		}

		isSelected[top - 1] = true;
		isSelected[top] = false;
		
		// 삽입 정렬
		for (int i = top + 2; i < isSelected.length; i++) {
			if (isSelected[i]) {
				continue;
			}
			
			int idx = i - 1;
			while (idx > top && isSelected[idx]) {
				isSelected[idx + 1] = true;
				idx--;
			}
			
			isSelected[idx+1] = false;
		}
		
		return true;
	}
}
