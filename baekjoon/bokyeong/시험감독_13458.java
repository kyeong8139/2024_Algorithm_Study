import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] room = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			room[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		long ans = 0;
		for (int i = 0; i < N; i++) {
			int cur = room[i];
			
			// 총감독관
			cur -= B;
			ans++;
			
			// 부감독관
			if (cur > 0) {
				ans += cur / C + (cur%C == 0 ? 0 : 1);
			}
		}
		
		System.out.println(ans);
	}
}
