package study2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class softeer_플레이페어암호 {
	
	static char[] message;
	static char[] key;
	static char[][] playfair;
	static int[][] index;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		message = sc.next().toCharArray();
		key = sc.next().toCharArray();
		playfair = new char[5][5];
		
		boolean[] alpha = new boolean[26];
		
		// playfair 만들기
		int idx = 0;
		o : for(int r = 0; r < 5; r++) {
			for(int c = 0; c < 5; c++) {

				while(idx != key.length && alpha[key[idx] - 'A']) {
					idx++;
				}
				if(idx == key.length) break o; 
				
				playfair[r][c] = key[idx];
				alpha[key[idx] - 'A'] = true;
				
			}
			
		}
		
		for(int r = 0; r < 5; r++) {
			for (int c = 0; c < 5; c++) {
				if(playfair[r][c] == '\u0000') {
					for(int i = 0; i < 26; i++) {
						if(i == 9) continue;
						if(!alpha[i]) playfair[r][c] = (char) (i + 'A');
						break;
					}
				}
			}
		}
		
		// message 쪼개기
		List<char[]> list = new ArrayList<>();
		
		int idx2 = 0;
		while(idx2 < message.length) {
			char[] temp = new char[2];
			if(idx2 == message.length - 1) {
				temp[0] = message[idx2];
				temp[1] = 'X';
				list.add(temp);
				break;
			}
			
			
			if(message[idx2] == message[idx2 + 1]) {
				if(message[idx2] == 'X') {
					temp[0] = 'X';
					temp[1] = 'Q';
				} else {
					temp[0] = message[idx2];
					temp[1] = 'X';
				}
				idx2++;
			} else {
				temp[0] = message[idx2];
				temp[1] = message[idx2 + 1];
				idx2 += 2;
			}
			
			list.add(temp);
		}
		
		for(int i = 0; i < list.size(); i++) {
			index = new int[2][2];
			boolean isRow = false;
			boolean isCol = false;
			// 가로 체크
			isRow = checkRow(list.get(i));
			// 세로 체크
			if(isRow) {
				
			} else {
				isCol = checkCol(list.get(i));
			}
			
		}
		
		
		for(char[] i : list) {
			System.out.println(Arrays.toString(i));
		}
		
		
	}
	
	public static boolean checkRow(char[] arr) {
		
		for(int r = 0; r < 5; r++) {
			boolean flag1 = false;
			boolean flag2 = false;
			for(int c = 0; c < 5; c++) {
				if(!flag2 && playfair[r][c] == arr[0]) {
					index[0][0] = r;
					index[0][1] = c;
					flag1 = true;
				}
				else if(flag2 && playfair[r][c] == arr[0]) {
					index[1][0] = r;
					index[1][1] = c;
					return true;
				}
				
				if(!flag1 && playfair[r][c] == arr[0]) {
					index[0][0] = r;
					index[0][1] = c;
					flag2 = true;
				}
				else if(flag1 && playfair[r][c] == arr[0]) {
					index[1][0] = r;
					index[1][1] = c;
					return true;
				}
			}
		}
		
		return false;
	}
	
	public static boolean checkCol(char[] arr) {
		
		for(int c = 0; c < 5; c++) {
			boolean flag1 = false;
			boolean flag2 = false;
			for(int r = 0; r < 5; r++) {
				if(!flag2 && playfair[r][c] == arr[0]) {
					index[0][0] = r;
					index[0][1] = c;
					flag1 = true;
				}
				else if(flag2 && playfair[r][c] == arr[0]) {
					index[1][0] = r;
					index[1][1] = c;
					return true;
				}
				
				if(!flag1 && playfair[r][c] == arr[0]) {
					index[0][0] = r;
					index[0][1] = c;
					flag2 = true;
				}
				else if(flag1 && playfair[r][c] == arr[0]) {
					index[1][0] = r;
					index[1][1] = c;
					return true;
				}
			}
		}
		
		return false;
	}
	
}
