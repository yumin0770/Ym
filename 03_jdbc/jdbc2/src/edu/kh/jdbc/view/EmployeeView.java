package edu.kh.jdbc.view;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.jdbc.model.dto.Employee;
import edu.kh.jdbc.model.service.EmployeeService;

//값 입력.출력용 클래스
//사용자가 맞닿는 클래스 == User Interface(UI)
/**
 * @author user1
 *
 */
/**
 * @author user1
 *
 */
public class EmployeeView {
	private Scanner sc = new Scanner(System.in);
	
	private EmployeeService service = new EmployeeService();
	
	public void displayMenu() {
		
		int input = 0;
		
		do{
			
			try {
				System.out.println("------------------------------");
				System.out.println("---------사원 관리 프로그램--------");
				System.out.println("1.전체 사원 조회");//사번,이름,부서명,직급명,전화번호
												  //직급코드 오름차순
				System.out.println("2.사번이 일치하는 사원 조회"); //1명만 조회
				//사번,이름,부서명,직급명,전화번호 1행 조회
				
				System.out.println("3.이름 글자가 포함된 사원 검색"); //여러명 조회
				//사번,이름,부서명,직급명,전화번호 n행 조회
				//사번 오른 차순
				
				System.out.println("4.급여 범위 조회"); //최소,최대범위
				//사번,이름,부서명,직급명,급여 조회
				//급여 내림차순
				
				System.out.println("5.사원 정보를 추가");
				//INSERT,SEQUENCE 사용
				
				System.out.println("6.사번으로 사원 정보 수정");
				// 이메일, 전화번호, 급여 수정
				
				System.out.println("7.사번으로 사원 퇴사"); //삭제X 수정O
				//ENT_YN,ENT_DATE 수정
				
				System.out.println("8.사번으로 사원 정보 삭제");
				
				System.out.println("0.프로그램 종료");
				
				System.out.print("메뉴 선택>>");
				input =sc.nextInt();
				sc.nextLine(); //입력 버퍼 개행문자 제거
				
				switch(input) {
				case 1: selectAll(); break;
				case 2: selectOne(); break;
				case 3: selectName(); break;
				case 4: selectSalary(); break;
				case 5: break;
				case 6: break;
				case 7: break;
				case 8: break;
				case 0: System.out.println("\n[프로그램을 종료합니다.]\n");break;
				default : System.out.println("\n[메뉴에 존재하는 번호를 입력하세요.]\n");
				
				}
				
				
			} catch (InputMismatchException e) {
				System.out.println("\n[잘못된 입력입니다.]\n");
				sc.nextLine(); //입력 버퍼에 남아있는 문자열 제거
				input = -1; //while문이 종료되지 않게하기 위한 값 대입
			}
			
		}while (input != 0);
		
	}
	
	/**
	 * 전체 사원 조회
	 */
	private void selectAll() {
		//사번, 이름, 부서명, 직급명, 전화번호
		
		System.out.println("\n-----전체 사원 조회-----\n");
		
		try {
		//DB에서 전체 사원 정보를 조회화는 service
		//selectAll을 호출하여 결과 반환 받기
		
		List<Employee> empList = service.selectAll();
			
		//없을 때
		if(empList.isEmpty()) { //조회된 사원이 없을 경우
			System.out.println("[사원이 존재하지 않습니다.]");
			return;
		}
		
		//있을 때
		//향상된 for문을 이용해서 모든 사원 정보 출력
		for(Employee emp : empList) {
			System.out.printf("%d / %s / %s /%s /%s \n", 
						emp.getEmpId(),
						emp.getEmpName(), 
						emp.getDepartmentTitle(),
						emp.getJobName(),
						emp.getPhone());
		
			
		}
	//예외  -> 왜 뷰?? 입출력하는게 뷰에서 처리하기 위해서! ex) 예외 화면 나오게 <잘못 눌렀습니다!>이런거
	}catch (SQLException e) {
		System.out.println("\n[사원 전체 정보 조회 중 예외 발생]\n");	
		e.printStackTrace();
		
	}	
}
	
	private void selectOne() {
		
		System.out.println("\n----사번으로 사원 조회 (1명)----\n");

		System.out.print("사번 입력: ");
		int input = sc.nextInt();
		sc.nextLine();
		
	
			try {
				//service 메서드에 사번을 전달해서 사번이 일치하는 사원 정보를 반환
				Employee emp = service.selectOne(input);
				
				if(emp == null) { //조회 결과 없는 경우
					System.out.println("[일치하는 사번의 사원이 존재하지 않습니다.]");
					return;
					
				}
				
				//조회 결과가 있는 경우
				System.out.printf("%d / %s / %s /%s /%s \n", 
						emp.getEmpId(),
						emp.getEmpName(), 
						emp.getDepartmentTitle(),
						emp.getJobName(),
						emp.getPhone());

				
				
			} catch (SQLException e) {
				System.out.println("\n[사번으로 사원 조회 중 예외 발생]\n");	
				e.printStackTrace();
			}
			
	}

		
	private void selectName() {
		
		System.out.println("\n----이름에 글자가 포홤된 사원 조회----\n");
		
		//입력 : 동
		//200 / 선동일/ 총무부/대표/01099546325
	    // 213 / 하동운 / 없음 / 대리 / 01158456632 
		
		//입력 : 선동
		//200 / 선동일/ 총무부/대표/01099546325
		
		//입력 : a
		//[입력된 글자를 포함하는 이름의 사원이 없습니다.]
		
		//입력 : 동
		//(SQLException 발생)
		//[글자가 이름에 포함된 사원 조회 중 예외 발생.]
		
		
		
		System.out.print("사원 이름 입력: ");
		String input = sc.nextLine();

		
		try {
						
			List<Employee> empList = service.selectName(input);
				
			//없을 때
			if(empList.isEmpty()) { //조회된 사원이 없을 경우
				System.out.println("[입력된 글자를 포함하는 이름의 사원이 없습니다]");
				return;
			}
			
			//있을 때
			//향상된 for문을 이용해서 모든 사원 정보 출력
			for(Employee emp : empList) {
				System.out.printf("%d / %s / %s /%s /%s \n", 
							emp.getEmpId(),
							emp.getEmpName(), 
							emp.getDepartmentTitle(),
							emp.getJobName(),
							emp.getPhone());
			
				
			}
		//예외  -> 왜 뷰?? 입출력하는게 뷰에서 처리하기 위해서! ex) 예외 화면 나오게 <잘못 눌렀습니다!>이런거
		}catch (SQLException e) {
			System.out.println("\n[글자가 이름에 포함된 사원 조회 중 예외 발생.]\n");	
			e.printStackTrace();
			
		}	
		
	}
	
	public void selectSalary() {
		
		System.out.println("-----급여 범위 조회-----"); //최소,최대범위
		

		try {
						
			List<Employee> empList = service.selectSalary();
				
			//없을 때
	
			if(empList.isEmpty()) { //조회된 사원이 없을 경우
				System.out.println("[금액의 범위에 포함되지 않습니다.]");
				return;
			}
			
			//있을 때
			//향상된 for문을 이용해서 모든 사원 정보 출력
			//사번,이름,부서명,직급명,급여 조회
			for(Employee emp : empList) {
				System.out.printf("%d / %s / %s /%s /%d \n", 
							emp.getEmpId(),
							emp.getEmpName(), 
							emp.getDepartmentTitle(),
							emp.getJobName(),
							emp.getSalary());
			
				
			}
		//예외  -> 왜 뷰?? 입출력하는게 뷰에서 처리하기 위해서! ex) 예외 화면 나오게 <잘못 눌렀습니다!>이런거
		}catch (SQLException e) {
			System.out.println("\n[급여 정보 조회 중 예외 발생]\n");	
			e.printStackTrace();
			
		}	
	
	}
	
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

