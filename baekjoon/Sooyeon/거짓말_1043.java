import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 거짓말_1043 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] str = bf.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        String[] truth = bf.readLine().split(" ");
        int num = Integer.parseInt(truth[0]);
        int[] trueMan = new int[n];
        for(int i=1; i<=num; i++){
            trueMan[i-1] = Integer.parseInt(truth[i]);
        }
        int[] people = new int[n+1];
        for(int i=1; i<=n; i++){
            people[i] = i;
        }
        int[][] parties = new int[m][];
        for(int i=0; i<m; i++){
            String[] st = bf.readLine().split(" ");
            int pnum = Integer.parseInt(st[0]);
            int[] party = new int[pnum];
            for(int j=0; j<pnum; j++){
                party[j] = Integer.parseInt(st[j]);
            }
        }


    }
}