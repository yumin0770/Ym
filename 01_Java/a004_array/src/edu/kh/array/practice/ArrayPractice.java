package edu.kh.array.practice;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class ArrayPractice {

	public void ex1(){
		
		int[] arr = new int[10];
		
		
		int sum = 0;
	
		for(int i=1; i<arr.length; i++) {
			System.out.print(i + " ");
								
			if(i%2!=0) {
				sum+=i;
				
			}
			

			} System.out.println();
		System.out.printf("짝수 번째 인덱스 합 : %d",sum);
		
		}	
			
	public void ex2() {
		
		int[] arr = new int [10];
		
		int sum = 0;
		
		for(int i=arr.length-1; i>0; i--) {
			System.out.print(i+ " ");
						
			if(i%2==0) {
				sum+=i;
				
			}
	
	
			} System.out.println();
		System.out.printf("홀수 번째 인덱스 합 : %d",sum);
		
		
		
	}
	public void ex3() {
		Scanner sc = new Scanner(System.in);
		
	System.out.print("양의 정수 : ");
	int input = sc.nextInt();
	
	int[] numberArr = new int[input];
	
	for(int i=1; i<= numberArr.length ;i++) {
	
	
		System.out.print(i + " ");
	}
	
	}
	public void ex4() {
		Scanner sc = new Scanner(System.in);
		

	
		int[] number = new int [5];
		int index = -1;
		
		for(int i=0; i<5;i++) {
			System.out.printf("입력 %d: ", i);
			number[i] = sc.nextInt();
		 

			
		} 		 
		 System.out.print("검색할 값 : ");
			int search = sc.nextInt();
	
			for(int i=0; i<=number.length-1; i++) {
				if(search ==number[i]) {
					index=i;
				
					
					
//					}		
				}
			}
				if(index < 0) {
					System.out.println("일치하는 값이 존재하지 않습니다.");
				}else{
					System.out.printf("인덱스 : %d " , index);
				}
			
		
	}
	public void ex5() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자열 : ");
		String charNum = sc.next();
		
		System.out.print("문자 : " );
		char inputChar = sc.next().charAt(0);
		
		System.out.printf("%s에 %s가 존재하는 위치(인덱스) :", charNum, inputChar);
		
		char[] charArr = new char[charNum.length()];
		int count = 0;
		
		for(int i=0; i<charArr.length;i++) {
			charArr[i] = charNum.charAt(i);
			if(charArr[i] == inputChar) {
					System.out.println(i + " ");
					count++;
			}
			
			
		} System.out.printf("\n %s 개수 : %d" ,inputChar , count );
		
	}
	public void ex6() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 : ");
		int input = sc.nextInt();
		
		int[] number = new int [input];
		int sum = 0;
		
		for(int i=0; i<number.length; i++) {
			System.out.printf("배열 %d에 인덱스 넣을 값 : ", i);
			int input2 = sc.nextInt();
			number[i]=input2;
			sum += input2;
			
			
		} 
		
		for(int i=0; i<number.length; i++) {
			System.out.print(number[i] + " ");
		}
		
		System.out.println();
		
		System.out.printf("총 합 : %d", sum);

		
	}
	

	public void ex7() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("주민등록번호(-포함):" );
		String input = sc.nextLine();
		
		char[] origin = new char[input.length()];
		
		for(int i=0; i<origin.length ;i++) {
			origin[i] = input.charAt(i);
			
		} char[] copy = new char[origin.length];
	
		for(int i=0; i<origin.length; i++) {
			if(i<=7) {
				copy[i] =origin[i];
			}else {
				copy[i]='*';
				
			} System.out.print(copy[i]);
		}
				
		
	}
	public void ex8() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수: ");
		int input = sc.nextInt();
		
		int[] num = new int [input];
		
		while(input<3 || input%2 == 0) {
			System.out.println("다시 입력하세요.");
			
			System.out.print("정수: ");
			input = sc.nextInt();
			
			 
	
	}
		
		 for(int i=1; i<num.length-2; i++) {
			 System.out.printf("%d, ",i);
			 
		 }
			
		 
		 for(int j=input-2; j>=1; j--) {
			 if (j==1) {
				 System.out.printf("%d",j);
			 }else {
				 System.out.printf("%d, ",j);
			 }
			 
				 
				
			
		}
			  
	}
	
	public void ex9() {
		
		int[] randomN = new int[10];
	
		System.out.print("발생한 난수 : ");
		for(int i=0 ; i<randomN.length; i++) {	
			 System.out.print((int)(Math.random()*10) + " ");
	
			}
	
}
	
	public void ex10() {
		
		int[] randomN = new int[11];
		
		int max = -1;
		int min = 11;
		
		
		
		System.out.print("발생한 난수 : ");
		for(int i=1 ; i<=10; i++) {	
			randomN[i]=(int)(Math.random()*10+1);

			System.out.print(randomN[i] + " ");
			
			 
		} for(int i=1 ; i<randomN.length; i++) {
				
			 	if(randomN[i] > max) {
					max = randomN[i];
			}		
					 
				if(randomN[i] < min) {
					min = randomN[i];
				
			} 
		}
				System.out.println();	
				System.out.printf("최대값 : %d\n",max);	
				System.out.printf("최소값 : %d",min);	
				
		
		
		}
    public void ex11() {
    	
    	int[] r = new int [10];
    	
    		for(int i=0; i<r.length;i++) {
    			r[i]=(int)(Math.random()*10+1);
    			for(int j=0;j<i;j++) {
    				if(r[i]==r[j]) {
    					i--;
    				}
    			}
    		}
    	for(int i=0; i<r.length; i++) {
    		System.out.print(r[i]+" ");
    	}
    	
    
    }					 

	public void ex12() {
		
		int[] r = new int [6];
    	
		for(int i=0; i<r.length;i++) {
			r[i]=(int)(Math.random()*6+1);
			for(int j=0;j<i;j++) {
				if(r[i]==r[j]) {
					i--;
					
					if(r[i]>r[j]) {
						int temp = i;
						r[i]=r[j];
						j=temp;
						
						System.out.print(j+" ");
					}
					
				}
			} 
		} 
		
		
{
		
	}
	

		
	}
	public void ex13() {
		
	}
	public void ex14() {
		
	}
	public void ex15() {
		
	}
	public void ex16() {
		
	}
	public void ex17() {
		
	}
	public void ex18() {
		
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
