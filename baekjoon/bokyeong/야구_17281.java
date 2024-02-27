import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, ans;
	static int[][] scores;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		scores = new int[N + 1][10];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 9; j++) {
				scores[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 점수 초기화
		ans = Integer.MIN_VALUE;
		
		// 최초 순열
		List<Integer> result = new ArrayList<>();
		for (int i = 2; i <= 9; i++) {
			result.add(i);
		}

		do {
			result.add(3, 1); // 4번 타자 추가
			playGame(result);

			// 다음 순열을 구하기 위해 4번 타자 삭제
			result.remove(3);

		} while (nextPerm(result));
		
		System.out.println(ans);
	}

	public static void playGame(List<Integer> result) {
		int round = 1;
		int playerIdx = 0;	// result의 0번 인덱스에 있는 선수
		int totalScore = 0;
		
		while (round <= N) {
			
			int[] ground = new int[4];
			int out = 0;
			
			while (out < 3) {
				int score = scores[round][result.get(playerIdx)];
				
				if (score == 0) {
					out++;
					playerIdx = (playerIdx + 1) % result.size();
					continue;
				}
				
				// 선수들의 위치 조절
				ground[0] = result.get(playerIdx);
				for (int i = 3; i >= 0; i--) {
					if (ground[i] == 0) {
						continue;
					}
					
					int position = i + score;
					if (position >= 4) {
						totalScore++;
					} else {
						ground[position] = ground[i];
					}
					
					ground[i] = 0;
				}
				
				playerIdx = (playerIdx + 1) % result.size();
			}
			
			round++;
		}
		
		ans = Math.max(ans, totalScore);
	}

	public static boolean nextPerm(List<Integer> list) {
		int top = 0;
		for (int i = list.size() - 1; i > 0; i--) {
			if (list.get(i) > list.get(i - 1)) {
				top = i;
				break;
			}
		}

		if (top == 0) {
			return false;
		}

		int bigger = top;
		for (int i = list.size() - 1; i > top; i--) {
			if (list.get(i) > list.get(top - 1) && list.get(i) < list.get(bigger)) {
				bigger = i;
			}
		}

		swap(list, top - 1, bigger);

		// 삽입정렬
		for (int i = top + 1; i < list.size(); i++) {
			int idx = i;
			while (idx > top && list.get(idx) < list.get(idx - 1)) {
				swap(list, idx, idx - 1);
				idx--;
			}
		}

		return true;
	}

	public static void swap(List<Integer> list, int i, int j) {
		int temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}
}
