import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class RGB거리_1149 {
	static int N, colourCost[][], minSum;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		colourCost = new int[N][3];
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<3;j++) {
				colourCost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		minSum = Integer.MAX_VALUE;
		for(int i=0;i<3;i++) {
			colourSum(1, i, colourCost[0][i]);
		}
		System.out.println(minSum);
	}
	
	static void colourSum(int depIdx, int lastIdx, int sum) {
		if(minSum <= sum) {
			return;
		}
		
		if(depIdx == N) {
			minSum = sum;
			return;
		}
		
		for(int i=0;i<3;i++) {
			if(i!=lastIdx) {
				colourSum(depIdx+1, i, sum+colourCost[depIdx][i]);
			}
		}
	}
}
