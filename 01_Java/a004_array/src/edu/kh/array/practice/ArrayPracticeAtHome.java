package edu.kh.array.practice;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class ArrayPracticeAtHome {

	public void ex1() {

		int[] arr = new int [10];
		
		int sum = 0;
		
		for(int i=1; i<arr.length;i++ ) {
			
		}
	}

	public void ex2() {

		int[] arr = new int[10];

		int sum = 0;

		for (int i = arr.length - 1; i > 0; i--) {
			System.out.print(i + " ");

			if (i % 2 == 0) {
				sum += i;

			}

		}
		System.out.println();
		System.out.printf("홀수 번째 인덱스 합 : %d", sum);

	}

	public void ex3() {
		Scanner sc = new Scanner(System.in);

		System.out.print("양의 정수 : ");
		int input = sc.nextInt();

		int[] numberArr = new int[input];

		for (int i = 1; i <= numberArr.length; i++) {

			System.out.print(i + " ");
		}

	}

	public void ex4() {
		Scanner sc = new Scanner(System.in);

		int[] number = new int[5];
		int index = -1;

		for (int i = 0; i < 5; i++) {
			System.out.printf("입력 %d: ", i);
			number[i] = sc.nextInt();

		}
		System.out.print("검색할 값 : ");
		int search = sc.nextInt();

		for (int i = 0; i <= number.length - 1; i++) {
			if (search == number[i]) {
				index = i;

//					}		
			}
		}
		if (index < 0) {
			System.out.println("일치하는 값이 존재하지 않습니다.");
		} else {
			System.out.printf("인덱스 : %d ", index);
		}

	}

	public void ex5() {

		Scanner sc = new Scanner(System.in);

		System.out.print("문자열 : ");
		String charNum = sc.next();

		System.out.print("문자 : ");
		char inputChar = sc.next().charAt(0);

		System.out.printf("%s에 %s가 존재하는 위치(인덱스) :", charNum, inputChar);

		char[] charArr = new char[charNum.length()];
		int count = 0;

		for (int i = 0; i < charArr.length; i++) {
			charArr[i] = charNum.charAt(i);
			if (charArr[i] == inputChar) {
				System.out.println(i + " ");
				count++;
			}

		}
		System.out.printf("\n %s 개수 : %d", inputChar, count);

	}

	public void ex6() {

		Scanner sc = new Scanner(System.in);
		System.out.print("정수 : ");
		int input = sc.nextInt();

		int[] number = new int[input];
		int sum = 0;

		for (int i = 0; i < number.length; i++) {
			System.out.printf("배열 %d에 인덱스 넣을 값 : ", i);
			int input2 = sc.nextInt();
			number[i] = input2;
			sum += input2;

		}

		for (int i = 0; i < number.length; i++) {
			System.out.print(number[i] + " ");
		}

		System.out.println();

		System.out.printf("총 합 : %d", sum);

	}

	public void ex7() {
		Scanner sc = new Scanner(System.in);

		System.out.print("주민등록번호(-포함):");
		String input = sc.nextLine();

		char[] origin = new char[input.length()];

		for (int i = 0; i < origin.length; i++) {
			origin[i] = input.charAt(i);

		}
		char[] copy = new char[origin.length];

		for (int i = 0; i < origin.length; i++) {
			if (i <= 7) {
				copy[i] = origin[i];
			} else {
				copy[i] = '*';

			}
			System.out.print(copy[i]);
		}

	}

	public void ex8() {
		Scanner sc = new Scanner(System.in);

		System.out.print("정수: ");
		int input = sc.nextInt();

		int[] num = new int[input];

		while (input < 3 || input % 2 == 0) {
			System.out.println("다시 입력하세요.");

			System.out.print("정수: ");
			input = sc.nextInt();

		}

		for (int i = 1; i < num.length - 2; i++) {
			System.out.printf("%d, ", i);

		}

		for (int j = input - 2; j >= 1; j--) {
			if (j == 1) {
				System.out.printf("%d", j);
			} else {
				System.out.printf("%d, ", j);
			}

		}

	}

	public void ex9() {

		int[] randomN = new int[10];

		System.out.print("발생한 난수 : ");
		for (int i = 0; i < randomN.length; i++) {
			System.out.print((int) (Math.random() * 10) + " ");

		}

	}

	public void ex10() {

		int[] randomN = new int[11];

		int max = -1;
		int min = 11;

		System.out.print("발생한 난수 : ");
		for (int i = 1; i <= 10; i++) {
			randomN[i] = (int) (Math.random() * 10 + 1);

			System.out.print(randomN[i] + " ");

		}
		for (int i = 1; i < randomN.length; i++) {

			if (randomN[i] > max) {
				max = randomN[i];
			}

			if (randomN[i] < min) {
				min = randomN[i];

			}
		}
		System.out.println();
		System.out.printf("최대값 : %d\n", max);
		System.out.printf("최소값 : %d", min);

	}

	public void ex11() {

		int[] r = new int[10];

		for (int i = 0; i < r.length; i++) {
			r[i] = (int) (Math.random() * 10 + 1);
			for (int j = 0; j < i; j++) {
				if (r[i] == r[j]) {
					i--;
				}
			}
		}
		for (int i = 0; i < r.length; i++) {
			System.out.print(r[i] + " ");
		}

	}

	public void ex12() {

		int[] r = new int[6];

		for (int i = 0; i < r.length; i++) {
			r[i] = (int) (Math.random() * 45 + 1);
			for (int j = 0; j < i; j++) {
				if (r[i] == r[j]) {
					i--;

				}
			}

		}
		for (int i = 0; i < r.length; i++) {
			for (int j = 1; j < r.length; j++) {
				if (r[i] > r[j]) {
					int tmp = r[i];
					r[i] = r[j];
					r[j] = tmp;

				}

			}
		}
		for (int i = 0; i < 6; i++) {
			System.out.print(r[i] + " ");
		}

	}
//	문자열을 입력 받아 문자열에 어떤 문자가 들어갔는지 배열에 저장하고
//	문자의 개수와 함께 출력하세요. (중복 제거)
//
//	[실행 화면]
//	문자열 : application
//	문자열에 있는 문자 : a, p, l, i, c, t, o, n
//	문자 개수 : 8
//		

	public void ex13() {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자열 : ");
		String str = sc.nextLine();
		
		char[] arr = new char[str.length()];
		int count = 0;

		System.out.print("문자열에 있는 문자 : ");

		for (int i = 0; i < arr.length; i++) {
			arr[i] = str.charAt(i);
			
			boolean flag = true;
		
			for (int j = 0; j < i; j++) {
				if (arr[j] == arr[i])
					flag = false;
			}
			
			if (flag) {
				if (i == 0)
					System.out.print(arr[i]);
				else
					System.out.print(", " + arr[i]);
	                
				count++;
			}
		}

		System.out.println("\n문자 개수 : " + count);
		
		sc.close();
	}

	public void ex14() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("배열의 크기를 입력하세요 : ");
		String[] arr = new String[sc.nextInt()];
		sc.nextLine();
		
		int index = 0;
		
		while (true) {
			for (int i = index; i < arr.length; i++) {
				System.out.print(i + 1 + "번째 문자열 : ");
				arr[i] = sc.nextLine();
			}
			
			index = arr.length;

			System.out.print("더 값을 입력하시겠습니까?(Y/N) : ");
			char plus = sc.next().charAt(0);

			if (plus == 'Y' || plus == 'y') {
				System.out.print("더 입력하고 싶은 개수 : ");
				String[] arr2 = new String[arr.length + sc.nextInt()];
				sc.nextLine();
				
				System.arraycopy(arr, 0, arr2, 0, arr.length);
				arr = arr2;
				
			} else if (plus == 'N' || plus == 'n') {
				System.out.println(Arrays.toString(arr));
				break;
				
			} else {
				System.out.println("잘못 입력하셨습니다.");
				continue;
			}

		}
		
		sc.close();
	}

	

	public void ex15() {
		String[][] arr = new String[3][3];
	
	for (int row = 0; row < arr.length; row++) {
		for (int col = 0; col < arr[row].length; col++)
			System.out.print("(" + row + ", " + col + ")");
		System.out.println();
	}
}
	

	public void ex16() {
		
		int[][] arr = new int[4][4];
	
	int num = 1;
	
	for (int row = 0; row < arr.length; row++) {
		for (int col = 0; col < arr[row].length; col++) {
			arr[row][col] = num++;
			System.out.printf("%2d ", arr[row][col]);
		}
		System.out.println();
	}
}



	public void ex17() {
		int[][] arr = new int[4][4];
	
	int num = 16;
	
	for (int row = 0; row < arr.length; row++) {
		for (int col = 0; col < arr[row].length; col++) {
			arr[row][col] = num--;
			System.out.printf("%2d ", arr[row][col]);
		}
		System.out.println();
	}
}

	public void ex18() {
		
		Scanner sc = new Scanner(System.in);
		
		int[][] arr = new int[4][4];
		
		final int RowFinal = arr.length - 1;
		final int ColFinal = arr[0].length - 1;
		
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[row].length; col++) {
				if (row != RowFinal && col != ColFinal) {
					arr[row][col] = (int)(Math.random() * 10 + 1);
					
					arr[row][ColFinal] += arr[row][col];
					arr[RowFinal][col] += arr[row][col];
					arr[RowFinal][ColFinal] += arr[row][col];
				}
				System.out.printf("%4d ", arr[row][col]);
			}
			System.out.println();
		}
		
		sc.close();
	}

	public void ex19() {

	}

	public void ex20() {

	}

	public void ex21() {

	}

	public void ex22() {

	}

	public void ex23() {

	}

	public void ex24() {

	}
}
