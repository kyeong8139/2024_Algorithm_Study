import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Belt {
	int life;
	boolean hasRobot;
	
	public Belt(int life, boolean hasRobot) {
		this.life = life;
		this.hasRobot = hasRobot;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int length = 2 * N;
		Belt[] belts = new Belt[length];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 2 * N; i++) {
			belts[i] = new Belt(Integer.parseInt(st.nextToken()), false);
		}

		int ans = 1;
		int start = 0; // 올리는 위치
		int end = N - 1; // 내리는 위치

		while (true) {
			// 벨트 회전
			start = (length + start - 1) % length;
			end = (length + end - 1) % length;
			
			belts[end].hasRobot = false;	// 내리는 칸에 도착하면 내림
			
			// 로봇 이동
			for (int i = 1; i <= N-1; i++) {
				int cur = (length + end - i) % length;
				int next = (cur + 1) % length;
				
				if (!belts[cur].hasRobot || belts[next].hasRobot || belts[next].life == 0) {
					continue;
				}
				
				belts[cur].hasRobot = false;
				belts[next].hasRobot = true;
				belts[next].life--;
			}
			belts[end].hasRobot = false;	// 내리는 칸에 도착하면 내림
			
			// 로봇 올림
			if (belts[start].life != 0) {
				belts[start].hasRobot = true;
				belts[start].life--;
			}
			
			int cnt = 0;
			for (int i = 0; i < length; i++) {
				if (belts[i].life == 0) {
					cnt++;
				}
			}
			
			if (cnt >= K) {
				break;
			}
			
			ans++;
		}

		System.out.println(ans);
	}
}
