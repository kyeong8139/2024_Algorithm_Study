import java.util.ArrayList;
import java.util.Scanner;

public class 트리의부모찾기_11725 {
	static int[] visited;
	static int N;
	static ArrayList<ArrayList<Integer>> list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		list = new ArrayList<>();
		N = sc.nextInt();
		for(int i = 0; i<N+1; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < N-1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		visited = new int[N+1];
		visited[1]=1;
		dfs(1);
		for(int i = 2; i<=N; i++) {
			System.out.println(visited[i]);
		}

	}
	public static void dfs(int idx) {
		for(int i = 0; i<list.get(idx).size(); i++) {
			if(visited[list.get(idx).get(i)]==0) {
				visited[list.get(idx).get(i)]=idx;
				dfs(list.get(idx).get(i));
			}
		}
		
	}

}
