import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt(); // 시작점
		
		// 간선 정보를 담을 리스트 생성
		List<ArrayList<Integer>> nodes = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			nodes.add(new ArrayList<Integer>());
		}
		
		// 양방향 간선 정보 입력
		for (int i = 0; i < M; i++) {
			int node = sc.nextInt();
			int next = sc.nextInt();
			
			List<Integer> line = nodes.get(node);
			int idx = 0;
			for (int j = 0; j < line.size(); j++) {
				if (line.get(j) > next) {
					idx++;
				} else {
					break;
				}
			}
			line.add(idx, next);
			
			line = nodes.get(next);
			idx = 0;
			for (int j = 0; j < line.size(); j++) {
				if (line.get(j) > node) {
					idx++;
				} else {
					break;
				}
			}
			line.add(idx, node);
		}
		
		boolean[] isVisited = new boolean[N + 1];
		
		//dfs
		Stack<Integer> stack = new Stack<>();
		
		int cur = V;
		stack.push(cur);
		while (!stack.isEmpty()) {
			
			cur = stack.pop();
			if (isVisited[cur]) {
				continue;
			}
			
			isVisited[cur] = true;
			System.out.print(cur + " ");
			
			for (int i = 0; i < nodes.get(cur).size(); i++) {
				if (!isVisited[nodes.get(cur).get(i)]) {
					stack.push(nodes.get(cur).get(i));
				}
			}
		}
		System.out.println();
		
		
		//bfs
		Arrays.fill(isVisited, false);
		Queue<Integer> queue = new LinkedList<>();
		
		cur = V;
		queue.offer(cur);
		while (!queue.isEmpty()) {
			
			cur = queue.poll();
			if (isVisited[cur]) {
				continue;
			}
			
			isVisited[cur] = true;
			System.out.print(cur + " ");

			for (int i = nodes.get(cur).size() - 1; i >= 0 ; i--) {
				if (!isVisited[nodes.get(cur).get(i)]) {
					queue.offer(nodes.get(cur).get(i));
				}
			}
		}
		
	}
