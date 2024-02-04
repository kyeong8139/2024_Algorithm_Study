import java.util.Scanner;

public class 컴백홈_1189 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int W = sc.nextInt();
        int target = sc.nextInt();
        boolean[][] visited = new boolean[H][W];
        char[][] map = new char[H][W]; //맵 설정
        int x = 0;
        int y = H -1;
        int[] goal = { 0, W-1 };
        for(int i = 0; i < H; i++) {
            String str = sc.next();
            for(int j = 0; j < W; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        visited[y][x] = true;
        check(map,visited,x,y,goal,1,target);
        System.out.println(cnt);
    }
    static int cnt = 0; //총 목표치에 도달한 횟수를 누적

    public static void check(char[][] map,boolean[][] visited, int x, int y, int[] goal,int distance, int target) {
        int[] dy = {1,-1,0,0}; //이동방향
        int[] dx = {0,0,1,-1};
        if(distance==target && x == goal[1] && y == goal[0]) {
            cnt++;
            return;
        }
        for(int i = 0; i < 4; i++) { //방향외 종류만큼 반복
            int next_x = x + dx[i]; //다음위치를 설정
            int next_y = y + dy[i];
            if(next_x < 0 || next_x >= map[0].length || next_y < 0 || next_y >= map.length) { //다음위치가 맵 바깥이면 다시설정
                continue;
            }
            if(map[next_y][next_x]=='T') { //다음위치가 T면 다시설정
                continue;
            }
            if(visited[next_y][next_x]) { //다음위치가 이미 방문한 곳이면 다시설정
                continue;
            }
            visited[next_y][next_x] = true; //위에 모든조건 통과하면 다음위치를 방문 표시
            check(map,visited,next_x,next_y,goal,distance+1,target); //재귀에 돌입
            visited[next_y][next_x] = false; //방문했던 곳 다시 초기화
        }

    }
}
