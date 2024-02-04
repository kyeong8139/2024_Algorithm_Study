import java.util.Scanner;

public class 컴백홈_1189 {
	static Scanner sc = new Scanner(System.in);
	static int R = sc.nextInt();
	static int C = sc.nextInt();
	static int K = sc.nextInt();
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,-1,0,1};
	static int result = 0; // 결과값 담는 변수
	static int count = 1; // 몇번 이동했는지 세는 변수
	static String[] array = new String[R]; // 입력값 줄 단위로 받는 변수
	static char[][] arr = new char[R][C]; // array배열 1글자씩 담는 변수
	
	public static void main(String[] args) {
		for (int r = 0; r < R; r++) { // 배열 입력 받기
			array[r] = sc.next();
			for (int c = 0; c < C; c++) {
				arr[r][c] = array[r].charAt(c);
			}
		}
		int r = R-1;
		int c = 0;
		arr[r][c] = ',';
		result = solution(r,c,result,count); 
		System.out.println(result);
		
	}
	
	static int solution(int r, int c, int result,int count) {
		if(r == 0 && c == C-1) {
			if(count == K)
				result++;
			return result;
		}
		for(int d=0; d<4; d++) { // 델타 배열 사용
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr<0 || nc<0 || nr>=R ||nc>=C || arr[nr][nc] != '.')
				continue;
			arr[nr][nc] = ',';
			count++;
			result = solution(nr, nc, result, count);
			count--;
			arr[nr][nc] = '.';
			
		}
		return result;
	}
}
