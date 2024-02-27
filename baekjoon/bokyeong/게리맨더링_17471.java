import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static int N, total, ans;
	static int[] person;
	static int[][] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		ans = Integer.MAX_VALUE;

		// 인구 입력
		person = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			person[i] = Integer.parseInt(st.nextToken());
			total += person[i];
		}

		// from, to
		graph = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());

			int adjCnt = Integer.parseInt(st.nextToken());
			for (int j = 0; j < adjCnt; j++) {
				int to = Integer.parseInt(st.nextToken());
				graph[i][to] = 1;
				graph[to][i] = 1;
			}
		}
		
		Set<Integer> set = new HashSet<>();
		set.add(1);

		getSection(set, 2);
		if (ans == Integer.MAX_VALUE) {
			ans = -1;
		}

		System.out.println(ans);
	}

	private static void getSection(Set<Integer> set, int depth) {
		if (depth > N) {
			getAns(set);
			return;
		}

		// 구역에 포함 시키지 않음
		getSection(set, depth + 1);

		// 구역에 포함 시킴
		Set<Integer> newSet = new HashSet<>();
		for (Integer num : set) {
			newSet.add(num);
		}
		newSet.add(depth);

		getSection(newSet, depth + 1);
	}

	private static void getAns(Set<Integer> set1) {
		HashSet<Integer> set2 = new HashSet<>();
		for (int i = 1; i <= N; i++) {
			set2.add(i);
		}

		for (int num : set1) {
			set2.remove(num);
		}

		if (set2.size() == 0) {
			return;
		}

		// set1 유효성 검사
		int[] arr = new int[set1.size()];
		int idx = 0;
		for (int num : set1) {
			arr[idx++] = num;
		}

		boolean[] isVisited = new boolean[N + 1];
		isVisited[arr[0]] = true;

		Stack<Integer> stack = new Stack<>();
		stack.push(arr[0]);
		while (!stack.isEmpty()) {
			int cur = stack.pop();

			for (int i = 1; i < arr.length; i++) {
				if (!isVisited[arr[i]] && graph[cur][arr[i]] == 1 && set1.contains(arr[i])) {
					isVisited[arr[i]] = true;
					stack.push(arr[i]);
				}
			}
		}

		for (int num : set1) {
			if (!isVisited[num]) {
				return;
			}
		}

		// set2 유효성 검사
		arr = new int[set2.size()];
		idx = 0;
		for (int num : set2) {
			arr[idx++] = num;
		}

		isVisited = new boolean[N + 1];
		isVisited[arr[0]] = true;

		stack = new Stack<>();
		stack.push(arr[0]);
		while (!stack.isEmpty()) {
			int cur = stack.pop();

			for (int i = 1; i < arr.length; i++) {
				if (!isVisited[arr[i]] && graph[cur][arr[i]] == 1 && set2.contains(arr[i])) {
					isVisited[arr[i]] = true;
					stack.push(arr[i]);
				}
			}
		}

		for (int num : set2) {
			if (!isVisited[num]) {
				return;
			}
		}

		int person1 = 0;
		for (int num : set1) {
			person1 += person[num];
		}

		int person2 = total - person1;
		ans = Math.min(Math.abs(person1 - person2), ans);
	}
}
