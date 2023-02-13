package edu.kh.control.loop.practice;

import java.util.Scanner;

public class ForPractice {

	public void practice1() {

		Scanner sc = new Scanner(System.in);

		System.out.print("1이상의 숫자를 입력하세요 :");
		int input = sc.nextInt();

		if (input >= 1) {
			for (int i = 1; i <= input; i++) {
				System.out.print(i + " ");
			}
		} else {
			System.out.print("1이상의 숫자를 입력해주세요.");
		}
	}

	public void practice2() {

		Scanner sc = new Scanner(System.in);

		System.out.print("1이상의 숫자를 입력하세요 :");
		int input = sc.nextInt();

		if (input >= 1) {
			for (int i = input; i >= 1; i--) {
				System.out.print( i + " ");
			} 
		} else {
			System.out.print("1이상의 숫자를 입력해주세요.");
		}
	}
	public void practice3() {

		Scanner sc = new Scanner(System.in);

		System.out.print("정수를 하나 입력해주세요: ");
		int input = sc.nextInt();
		int sum = 0;

		for(int i = 1 ; i <= input ; i++) {
			sum += i; 
		 System.out.print(i);

		 //i == input == 留�吏�留�
		 if(i != input) { //!= 留�吏�留��� ������
			 System.out.print( " + ");
		 }
		}
		System.out.println(" = " + sum);

	}
	public void practice4() {

		Scanner sc = new Scanner(System.in);

		System.out.print("첫번째 숫자 : ");
		int num1 = sc.nextInt();

		System.out.print("두번째 숫자 : ");
		int num2 = sc.nextInt();

		if( num1 >= 1 && num2 >= 1) {	
			for (int i = num1; i <= num2 ; i++) {
			System.out.print(i + " ");


		}} else {
			System.out.println("1이상의 숫자를 입력해주세요.");
		}
		}

	public void practice5() {

		Scanner sc = new Scanner(System.in);

		System.out.print("�レ�� : ");
		int dan = sc.nextInt();

		System.out.printf("===== %d단 =====",dan);
			for (int num = 1 ; num  <= 9 ; num ++) {
				System.out.printf("%d * %d = %2d \n", dan, num, dan * num);

			}
		}

	public void practice6() {

		Scanner sc = new Scanner(System.in);

		System.out.println("숫자: ");
		int dan = sc.nextInt();

		if (dan >= 2 && dan <= 9) {
			for(int i = dan; i <= 9; i++) {
				System.out.printf("=====  %d단===== \n",i);
                for (int num = 1 ; num  <= 9 ; num ++) {
				System.out.printf("%d * %d = %2d \n", i, num, i * num);
			}

		} }else
		System.out.println("2~9 사이 숫자만 입력해주세요.");
	}
    public void practice7() {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("�������� : ");
        int input = sc.nextInt();
        
        for (int i = 1; i <= input; i++) {
            for (int x = 1; x <= i; x++) {
                System.out.print("*");
            }
            System.out.println();
        }
 }
    
    public void practice8() {
    
        Scanner sc = new Scanner(System.in); 
    
        System.out.print("정수입력: ");
        int input = sc.nextInt();
    
        for (int i = input; i >= 1; i--) {
            for (int x = i; x >= 1; x--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    
    public void practice9() {
        Scanner sc = new Scanner(System.in);
    
        System.out.print("정수 입력 : "); 
        int dan	 = sc.nextInt();
    
                for(int i = dan; i <= 9; i++) {
                    System.out.printf("=====  %d단 ===== \n",i);
                    for (int num = 1 ; num  <= 9 ; num ++) {
                        System.out.printf("%d * %d = %2d \n", i, num, i * num);
                    }
                    System.out.println();
    
                }
            }
            
              

  
    
    public void practice10() {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수입력 : ");
        int input = sc.nextInt();
        
        for (int i = 0; i < 5; i++) { 
            for (int j = 0; j < i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 0; i < 4; i++) { 
            for (int j = 0; j < 4 - i; j++) {
                System.out.print("*");
            }
        }            System.out.println();
    }   
    public void practice11() {
    	  Scanner sc = new Scanner(System.in);
          System.out.print("정수입력 : ");
          int input = sc.nextInt();
          
        for(int row=1 ; row <=input ; row++) {
        	
//        	//빈칸 먼저 출력
//        	for(int col=input-row; col>=1; col--) {
//        		System.out.print(" ");
//        	}
//        	for(int col=1;col<=row*2-1; col++){
//        		System.out.print("*");
//        		
//        		
//        	} 
        	
        	for(int col=1; col<=input+row-1; col++) {
        		
        		if(input-row >= col) {
        			System.out.println(" ");
          		}else {
        			System.out.println("*");
        		} 	System.out.println();

        	}
        	
        }	
    	
    }
    
    public void practice12() {
    
    	 Scanner sc = new Scanner(System.in);
    	 int input = sc.nextInt();
    	
    	 for(int row=1; row<=input ; row++) {

    		 for(int col=1; col<=input; col++) {
    			 if(row==1 || row==input || col==1|| col==input) {
    				 System.out.println("*");
    			 }else {
    				 System.out.println(" ");
    			 }   			 
    		 }
    		 System.out.println(); //개행 
    	 }
    	
    }
    
    
    public void practice13() {
        Scanner sc = new Scanner(System.in);
        System.out.print("자연수 하나를 입력하세요: ");
        int input = sc.nextInt();
        
        int count = 1;
        for (int i = 1; i <= input; i++) {
            if (i % 2 == 0 || i % 3 == 0) {
                System.out.print(i + " ");
            
        } if (i % 2 == 0 && i % 3 == 0)
            count++;
        
    }System.out.println();
    System.out.printf("count: %d", count);  
      
   
}
        
}
    

