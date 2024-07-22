class Solution {
    public int solution(String name) {
        int answer = 0;
        int n = name.length();
        
        // 상하 조작 횟수 계산
        for (int i = 0; i < n; i++) {
            char c = name.charAt(i);
            answer += Math.min(c - 'A', 'Z' - c + 1);
        }
        
        // 좌우 조작 횟수 계산
        int minMove = n - 1; // 기본적인 경우 (맨 끝까지 가는 경우)
        
        for (int i = 0; i < n; i++) {
            int next = i + 1;
            // 연속된 A의 끝을 찾는다.
            while (next < n && name.charAt(next) == 'A') {
                next++;
            }
            // 현재 위치까지 이동 후 다시 뒤로 돌아가는 경우와 비교
            minMove = Math.min(minMove, i + n - next + Math.min(i, n - next));
        }
        
        answer += minMove;
        
        return answer;
    }

}
