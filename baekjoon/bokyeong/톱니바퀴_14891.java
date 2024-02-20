import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		char[][] gear = new char[5][8];
		for (int i = 1; i <= 4; i++) {
			gear[i] = sc.next().toCharArray();
		}

		int K = sc.nextInt();
		for (int k = 0; k < K; k++) {
			int num = sc.nextInt();
			int dir = sc.nextInt();

			// leftIdx + 1 부터 회전
			int leftIdx = num - 1;
			int cur = gear[num][6];
			while (leftIdx >= 1) {
				if (gear[leftIdx][2] == cur) {
					break;
				}
				cur = gear[leftIdx--][6];
			}

			// rightIdx 전까지 회전
			int rightIdx = num + 1;
			cur = gear[num][2];
			while (rightIdx <= 4) {
				if (gear[rightIdx][6] == cur) {
					break;
				}
				cur = gear[rightIdx++][2];
			}

			int step = 1;
			rotate(gear, num, dir);
			while (num - step > leftIdx || num + step < rightIdx) {
				dir *= -1;

				if (num - step > leftIdx) {
					rotate(gear, num - step, dir);
				}

				if (num + step < rightIdx) {
					rotate(gear, num + step, dir);
				}

				step++;
			}
		}

		int ans = 0;
		for (int i = 1; i <= 4; i++) {
			ans += (gear[i][0] - '0') * Math.pow(2, i - 1);
		}

		System.out.println(ans);
	}

	// 1은 시계방향, -1은 반시계방향
	public static void rotate(char[][] gear, int num, int dir) {
		if (dir == 1) {
			char[] newGear = new char[8];
			for (int i = 0; i < 8; i++) {
				newGear[i] = gear[num][(8 + i - 1) % 8];
			}
			gear[num] = newGear;
		}

		if (dir == -1) {
			char[] newGear = new char[8];
			for (int i = 0; i < 8; i++) {
				newGear[i] = gear[num][(i + 1) % 8];
			}
			gear[num] = newGear;
		}
	}
}
