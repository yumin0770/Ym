package edu.kh.array.practice;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import java.util.Arrays;
import java.util.Random;

public class ArrayPractice {

	public void ex1() {

		int[] arr = new int[10];

		int sum = 0;

		for (int i = 1; i < arr.length; i++) {
			System.out.print(i + " ");

			if (i % 2 != 0) {
				sum += i;

			}

		}
		System.out.println();
		System.out.printf("짝수 번째 인덱스 합 : %d", sum);

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
		System.out.print(" 검색할 값 : ");
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

//  3이상인 홀수를 입력 받아 배열의 중간까지는 1부터 1씩 증가하여 오름차순으로 값을 넣고,
//	중간 이후부터 끝까지는 1씩 감소하여 내림차순으로 값을 넣어 출력하세요.
//	단, 입력한 정수가 홀수가 아니거나 3 미만일 경우 “다시 입력하세요”를 출력하고
//	다시 정수를 받도록 하세요.
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

//	10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고
//	1~10 사이의 난수를 발생시켜 중복된 값이 없게 배열에 초기화한 후 출력하세요.
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

					break;

				}
			}

		}
		Arrays.sort(r);

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
		String answer = "";

		System.out.print("문자열에 있는 문자 : ");

		for (int i = 0; i < arr.length; i++) {
			arr[i] = str.charAt(i);

		}
		for (int i = 0; i < arr.length; i++) {
			if (str.indexOf(str.charAt(i)) == i)
				answer += str.charAt(i);
			
		}
		System.out.println(answer);
		String[] arr2 = new String[answer.length()];
	
		
		for(int i=0;i<=arr2.length-1;i++) {
			count++;
		}
		
	
		System.out.printf("문자 개수 : %d ", count);

	}

	public void ex14() {
		Scanner sc = new Scanner(System.in);
		
		//1) next(): 한 단어 (띄어쓰기, 엔터를 만나면 입력 종료)
		//	 nextLine() :한 문장(엔터 만나면 입력 종료)
		
		//2) 스캐너 입력 버퍼와 nextXXXX의 의미
		
		//입력 => 입력 버퍼에 저장 -> nextXXX() 통해 버퍼 내용을 읽어옴
		
		//                 입력 버퍼             nextXXX()          후처리
		//nextLine() :   hello world(엔터) -> hello world(엔터) ->엔터 제거
		
		//nextInt() :      100(엔터)        -> 100
		//(다음 정수)
		//** net(), nextDouble(), nextInt() 등
		// 모두 입력 버퍼에서 (엔터)를 제외하고 내용만 읽어옴 **
		
//		System.out.println("--------------------------------------");
//		System.out.println("nextInt() : ");
//		int a =sc.nextInt();
//		// 100  //입력버퍼 [ (엔터) ]
//		
//		System.out.println("nextLine() : "); // 입력버퍼 : [a b c (엔터)]ㄴ 
//		String s = sc.nextLine();
//		
//		//a b c //입력버퍼 : [ ]
//		
//		System.out.println("종료");
//		
		//nextInt() 이후 입력 버퍼에 남아있는 (엔터) 때문에
		//다음 nextLine() 수행 시 버퍼에 남아있는 (엔터)를 읽어버리기 때문에
		// 추가적인 입력을 시도하지 못하고 다음 코드로 넘어가는 문제 발생.
		
		//[해결방법]
		//입력을 위한 nextLine() 수행 전
		//입력버퍼에서 (엔터)를 제거
		// -> 빈 공간에 sc.nextLine() 구문을 한 번 작성하면 (엔터)가 제거됨
		
		
		//1. 첫 배열 크기 지정
		System.out.print("배열의 크기를 입력하세요 : ");
		int size = sc.nextInt(); //입력 버퍼에 개행문자(엔터)가 남음
		sc.nextLine(); //입력 버퍼에 남은 개행문자(엔터) 제거

		//2.첫배열 생성
		String[] books = new String[size];
		
		//3.첫 배열에 저장할 문자열 입력 받기
		
		for (int i = 0; i < books.length; i++) {
			System.out.println((i+1) + "번째 문자열 : ");
			books[i]=sc.nextLine(); //입력 버퍼에서 다음 엔터까지 읽어옴
		}
		
			//4. n이 입력될 때 까지 무한 반복 -> n 입력 시 break
			while(true) {
				System.out.println("더 값을 입력하시겠습니까?(Y/N) : ");
				char ch = sc.nextLine().charAt(0);
				
				if(ch== 'N') {
					break;
					
				}
				//5.더 입력 받을 개수 입력
				System.out.println("더 입력하고 싶은 개수 : ");
				int addSize = sc.nextInt();
				sc.nextLine(); //입력 버퍼 개행문자 제거
				
				//6.기존 배열보다 늘어난 개수만큼 큰 새 배열 생성
				String newBooks[] = new String[books.length + addSize];
				
				//7.깊은 복사를 통해 기존 배열 내용을 새 배열로 복사
				System.arraycopy(books, 0, newBooks, 0, books.length);
				
				//8.새 배열의 빈칸 부터 새로운 입력을 받아서 저장
				for(int i=books.length; i<newBooks.length; i++) {
					System.out.println((i+1)+"번째 문자열 : ");
					newBooks[i] = sc.nextLine();
		
					
				}
				//9.기존 참조배열 books에 newBooks의 주소를 얕은 복사
				books = newBooks;
							
	
			} //while 종료
			//10.배열에 저장된 모든 값 출력
			System.out.println(Arrays.toString(books));
			
		}

	

	public void ex15() {

		String[][] str = new String[3][3];

		for (int row = 0; row < str.length; row++) {
			for (int col = 0; col < str[row].length; col++)
				System.out.print("(" + row + "," + col + ")");
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
		
		//1. 4헹 4열 2차원 배열 생성
		int[][] arr = new int [4][4];
		
		int columnTotal = arr.length - 1;
		int rowTotal = arr.length - 1;
	
		
		for(int row =0; row<arr.length;row++) {
			for(int col  =0; col<arr.length;col++) {
				if (row != rowTotal && col!= columnTotal) {
				arr[row][col] = (int)(Math.random() * 10 + 1);	
				
			
				arr[row][columnTotal] += arr[row][col];
				arr[rowTotal][col] += arr[row][col];
				arr[rowTotal][columnTotal] += arr[row][col];
				
				}
				System.out.printf("%4d",arr[row][col]);
			                    
			}
			System.out.println();
	}
}
		  /* 실습문제 18
	    4행 4열 2차원 배열을 생성하여 0행 0열부터 2행 2열까지는 1~10까지의 임의의 정수 값 저장 후
	    아래의 내용처럼 처리하세요.
	    [실행 화면]
	     9  3  7 19
	     3  6  9 18
	     6 10 10 26
	    18 19 26 63
	     */
//	   public void practice18() {
//	      
//	      // 1. 4행 4열 2차원 배열 생성
//	      int[][] arr = new int[4][4];
//	      
//	      final int LAST_ROW_INDEX = arr.length - 1; // 행 마지막 인덱스
//	      final int LAST_COL_INDEX = arr[0].length - 1; // 열 마지막 인덱스
//	      
//	      // 2. 0행 0열 ~ 2행 2열까지 1~10 사이 난수 대입
//
//	      Random random = new Random();
////	      random.nextInt(); 0이상 1미만 정수
//	      
//	      for(int row=0 ; row < LAST_ROW_INDEX ; row++) {
//	         for(int col=0 ; col < LAST_COL_INDEX ; col++) {
//	            arr[row][col] = random.nextInt(10) + 1;
//	            
//	            // 3행 3열에 발생된 난수 모두 누적
//	            arr[LAST_ROW_INDEX][LAST_COL_INDEX] += arr[row][col];
//	            
//	            // 난수 대입과 동시에 해당 행/열의 끝에 누적
//	            arr[row][LAST_COL_INDEX] += arr[row][col]; // 각 행 마지막 열에 누적
//	            arr[LAST_ROW_INDEX][col] += arr[row][col]; // 각 열 마지막 행에 누적
//	         }
//	      }
//	      
//	      // 출력용 2중 for문
//	      for(int row=0 ; row <= LAST_ROW_INDEX ; row++) {
//	         for(int col=0 ; col <= LAST_COL_INDEX ; col++) {
//	            System.out.printf("%3d", arr[row][col]);
//	         }
//	         System.out.println();
//	      }
//	   }

	public void ex19() {

		Scanner sc = new Scanner(System.in);
	
		System.out.print("행 크기 : ");
		int input = sc.nextInt();
		System.out.print("열 크기 : ");
		int input2 = sc.nextInt();
		
		
		int[][] arr = new int[input][input2];
		
		if (input < 1 || input > 10 ) {
			System.out.println("반드시 1~10 사이의 정수를 입력해야 합니다.");
			
		}else if(input2 < 1 || input2 > 10 ) {
			
			System.out.println("반드시 1~10 사이의 정수를 입력해야 합니다.");
			
		}else {
			
				for (int row = 0; row < arr.length; row++) {
				for (int col = 0; col < arr[row].length; col++) {
					arr[row][col] = (int)(Math.random() *26+65);	
					
					System.out.print((char) arr[row][col] + " ");
				}
				System.out.println();
			}
		}
	}
	

	public void ex20() {
		
		Scanner sc = new Scanner(System.in);
		
		
		char ch ='a';
		
		System.out.print("행 크기 : ");
		int input = sc.nextInt();
		
		char[][] arr = new char[input][];
		
		for(int i=0; i<=arr.length; i++) {
			System.out.printf("%d열의 크기 : ", i);
			int input2 = sc.nextInt();
			
			arr[input] = new char[input2];
			
		
			for(int alp=0; alp<arr.length; alp++) {
				arr[alp][input2] =	ch++;
			}
		}
		
		
		
			for(int row=0; row<=arr.length; row++) {
				for(int col=0; col<=arr.length;col++) {
					System.out.print([row][col] + " ");
				}
				
			}
		
		
		
		
 
	}

	public void ex21() {
//		1차원 문자열 배열에 학생 이름 초기화되어 있다.
//		3행 2열 짜리 2차원 문자열 배열 2개를 새로 선언 및 할당하여
//		학생 이름을 2차원 배열에 순서대로 저장하고 아래와 같이 출력하시오.
//		(첫 번째 2차원 배열이 모두 저장된 경우 두 번째 2차원 배열에 저장 진행)
//		String[] students = {"강건강", "남나나", "도대담", "류라라", "문미미", "박보배",
//	"송성실", "윤예의", "진재주", "차천축", "피풍표", "홍하하"};

		
		
		
		
		
	      
	}

	public void ex22() {

	}

	public void ex23() {

	}

	public void ex24() {

	}
}
