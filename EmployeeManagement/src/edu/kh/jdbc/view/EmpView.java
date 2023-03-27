package edu.kh.jdbc.view;

import java.nio.file.spi.FileSystemProvider;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import edu.kh.jdbc.model.dto.Emp;
import edu.kh.jdbc.model.service.EmpService;

public class EmpView {
  
	private Scanner sc = new Scanner(System.in);
	
	private EmpService service = new EmpService();
	
	//** 모든 기능에는 예외상황에 따른 출력 구문 필수 작성 **
	//** 필요에 따라 DTO에 생성자 추가 **
	//** 메서드명, 출력 화면은 자유롭게 작성 **
	
	public void displayMenu() {
		
		int input = 0;
		
		do {
			
			try {
				System.out.println("\n*****************************\n");
				System.out.println("***** 사원 관리 프로그램*****");
				
				System.out.println("1. 재직중인 사원 전체 조회"); 
				// 현재 재직중인 사원의
				// 사번, 이름, 부서명, 직급명, 급여, 전화번호, 이메일
				// 직급코드 오름차순으로 조회
				
				
				System.out.println("2. 퇴직한 사원 전체 조회"); 
				// 현재 퇴직한 사원의
				// 사번, 이름, 전화번호, 이메일, 퇴사일을
				// 퇴사일 오름차순으로 조회
				
				
				System.out.println("3. 사번이 일치하는 사원 조회"); 
				// 사번을 입력 받아 일치하는 사원의  
				// 사번, 이름, 부서명, 직급명, 급여, 전화번호, 이메일, 입사일, 퇴직여부 조회
				// 단, 사번이 일치하는 사원이 없으면
				// "사번이 일치하는 사원이 없습니다" 출력
				
				
				System.out.println("4. 사원 정보 추가(INSERT)");
				// 사번(EMP_ID) -> SEQ_EMP_ID SEQUENCE 사용
				
				
				System.out.println("5. 사번으로 사원 정보 수정(UPDATE)");
				// 이메일, 전화번호, 급여, 보너스 수정
				// 단, 사번이 일치하는 사원이 없으면
				// "사번이 일치하는 사원이 없습니다" 출력

				
				System.out.println("6. 사번으로 사원 정보 삭제(DELETE)");
				// 사번을 입력 받아 일치하는 사원 삭제
				// - 사번을 입력 받은 후 정말 삭제할 것인지 Y/N을 입력 받아 
				//   Y인 경우에만 삭제, N인 경우 취소
				// - 사번이 일치하는 사원이 없으면
				//   "사번이 일치하는 사원이 없습니다" 출력
				
				
				System.out.println("7. 사번이 일치하는 사원 퇴직 처리");
				// - ENT_YN -> 'Y' , ENT_DATE -> SYSDATE로 수정
				
				// - 사번을 입력 받은 후 정말 퇴직 처리할 것인지 Y/N을 입력 받아 
				//   Y인 경우에만 퇴직 처리, N인 경우 취소
				
				// - 사번이 일치하지 않거나 이미 퇴직 처리된 사원이면
				//   "사번이 일치하는 않거나, 이미 퇴직된 사원입니다." 출력
				
				System.out.println("8. 가장 최근 입사한 사원 5명 조회");
				
				// 가장 최근(입사일이 늦은) 사원 5명의
				// 사번, 이름, 부서명, 입사일을
				// 입사일 내림차순으로 조회
				//서브쿼리
				
				
				System.out.println("9. 부서별 통계 조회"); 
				// 각 부서별
				// 부서명, 인원 수, 급여 평균
				// 부서코드 오름차순 조회
				//그룹바이
				
				// HINT.
				// - 별도의 DTO 작성 또는 
				//   Map(LinkedHashMap : key 순서가 유지되는 Map) 이용
				
				
				System.out.println("0. 프로그램 종료");
				
				
				System.out.print("메뉴 선택 >> ");
				input = sc.nextInt();
				sc.nextLine(); // 입력 버퍼 개행문자 제거
				
				
				switch(input) {
				case 1: selectAll(); break;
				case 2: quitAll(); break;
				case 3: selectOne(); break;
				case 4: insertOne(); break;
				case 5: updateOne(); break;
				case 6: deleteOne(); break;
				case 7: updateQuit(); break;
				case 8: topFive(); break;
				case 9: selectDepartment(); break;
				case 0: System.out.println("\n[프로그램을 종료합니다...]\n"); break;
				default: System.out.println("\n[메뉴에 존재하는 번호를 입력하세요.]\n");
				}
				
				
			}catch (InputMismatchException e) {
				System.out.println("\n[잘못된 입력입니다.]\n");
				sc.nextLine();
				input = -1;
			}
			
		}while(input != 0);
		
	}
	
	
	/**
	 * 재직중인 사원 전체 조회  	// 사번, 이름, 부서명, 직급명, 급여, 전화번호, 이메일
	 */
	private void selectAll() {
		
		System.out.println("[전체 사원 조회]");
		
		try {
		List<Emp> empList = service.selectAll();
		
		if(empList.isEmpty()) {
			System.out.println("조회 결과가 없습니다.");
			return;
		}
		for(Emp e :empList)
		System.out.printf("%d/ %s/ %s/ %s/ %d/ %s/ %s \n",
						e.getEmpId(),
						e.getEmpName(),
						e.getDepartmentTitle(),
						e.getJobName(),
						e.getSalary(),
						e.getPhone(),
						e.getEmail());
		
	
		}catch(SQLException e) {
			System.out.println("전체 사원 조회 중 예외 발생");
			e.printStackTrace();
		}
	
	}
	/**
	 * 퇴직한 전체 사원 조회 	// 사번, 이름, 전화번호, 이메일, 퇴사일을
	 */
	private void quitAll() {
		System.out.println("\n-----퇴직한 전체 사원 조회-----\n");
		
		try {
			List<Emp> empList = service.quitAll();
			
			if(empList.isEmpty()) {
				System.out.println("퇴직한 사원이 없습니다.");
			}
			for(Emp e :empList) {
				System.out.printf("%d /%s /%s /%s /%s \n,",
								e.getEmpId(),e.getEmpName(),e.getPhone(),e.getEmail(),e.getEntDate());
			}
			
		} catch (SQLException e) {
			System.out.println("퇴직한 사원 조회 시 예외가 발생했습니다.");
			e.printStackTrace();
		}
		
		
		}
		
		



	/**
	 * 	3. 사번이 일치하는 사원 조회 // 사번, 이름, 부서명, 직급명, 급여, 전화번호, 이메일, 입사일, 퇴직여부 조회
	 */
		private void selectOne() {
			
			System.out.println("[사번이 일치하는 사원 조회]");
			System.out.print("사원 번호 입력: ");
			int input = sc.nextInt();
			
			try {
				
			Emp emp  = service.selectOne(input);
			
			if(emp == null) {
				System.out.println("사번이 일치하는 사원이 없습니다.");
				return;
			} System.out.printf("%d/ %s/ %s/ %s/ %d/ %s/ %s/ %s/ %s",	
								emp.getEmpId(),
								emp.getEmpName(),
								emp.getDepartmentTitle(),
								emp.getJobName(),
								emp.getSalary(),
								emp.getPhone(),
								emp.getEmail(),
								emp.getEntDate(),
								emp.getEntYN());
			
			}catch(SQLException e){
				System.out.println("사원 조회 중 예외가 발생했습니다.");
				e.printStackTrace();
			}	
		}


	/**
	 * 4.사원 정보 추가 //insert > 결과 0,1 >result
	 */
	private void insertOne() {
			
			System.out.println("[사원 추가]");
			
			 System.out.print("이름 : ");
		     String empName = sc.next();
		     
		     System.out.print("주민등록번호 : ");
		     String empNo = sc.next();
		     
		     System.out.print("이메일 : ");
		     String email = sc.next();
		     
		     System.out.print("전화번호(-제외) : ");
		     String phone = sc.next();
		     
		     System.out.print("부서코드(D1~D9) : ");
		     String deptCode = sc.next();
		     
		     System.out.print("직급코드(J1~J7) : ");
		     String jobCode = sc.next();
		     
		     System.out.print("급여등급(S1~S6) : ");
		     String salLevel = sc.next();
		     
		     System.out.print("급여 : ");
		     int salary = sc.nextInt();
		     
		     System.out.print("보너스 : ");
		     double bonus = sc.nextDouble();
		     
		     System.out.print("사수번호 : ");
		     int managerId = sc.nextInt();
		     sc.nextLine();
			

		     Emp emp = new Emp(empName,empNo,email,phone,salary,deptCode,jobCode,salLevel,bonus,managerId);
		     
		     try {
			 		int result = service.insertOne(emp);
			 		
			 		if(result>0 ) { //성공 시
			 			System.out.println("[삽입 성공!!!]");
			 		
			 		}else {
			 			System.out.println("[삽입 실패...]");
			 		}
			 		
			 	} catch (SQLException e) {
			 		System.out.println("\n[사원 정보 삽입 중 예외 발생]\n");
			 		e.printStackTrace();
		 }
	}
		
		/**
		 * 5.사번으로 사원 정보 수정
		 */
		private void updateOne() {
			
			System.out.println("[사원 정보 수정]");
			
			System.out.print("사원 번호 : ");
			int input = sc.nextInt();
			sc.nextLine();
			
			
			try {
				Emp emp = service.selectOne(input);
			
			
			if(emp == null) {
				System.out.println("[사번이 일치하는 사원이 없습니다.]");
				return;
			}
			
			
			System.out.print("이메일 수정 : ");
			String email = sc.next();
			
			System.out.print("전화번호 수정 : ");
			String phone = sc.next();
			
			System.out.print("급여 수정 : ");
			int salary = sc.nextInt();
			
			System.out.print("보너스 수청 : ");
			double bonus = sc.nextDouble();
		

			emp = new Emp(); //앞에서 쓰다 남은거 재사용. //입력받은 정보를 객체에 담아서 서비스 전달
			
			emp.setEmpId(input);
			emp.setEmail(email);
			emp.setPhone(phone);
			emp.setSalary(salary);
			emp.setBonus(bonus);
		
			int result  = service.updateOne(emp);
		
				if(result>0) {
					System.out.println("수정 성공하였습니다.");
				}else {
					System.out.println("사번이 일치하는 사원이 없습니다.");
				}
			}catch (SQLException e) {
					System.out.println("사번을 추가하던 중 예외가 발생하였습니다.");
				e.printStackTrace();
			}
			
		}
		
		/**
		 * 6.사원 삭제
		 */
		public void deleteOne() {
			
			System.out.println("[사원 삭제 처리]");
			System.out.print("삭제할 사번 입력 : ");
			int input = sc.nextInt();
			
			try {
				int result = service.deleteOne(input);
				
				if(result>0) {
				System.out.println("[사원을 삭제하였습니다.]");
				}else 
				System.out.println("[일치하는 사원이 없습니다.]");
				
				} catch (SQLException e) {
				System.out.println("[사원을 삭제하던 중 예외가 발생하였습니다.]");
				e.printStackTrace();
			}	
		}
	
		/**
		 * 사번 입력 받아 퇴사 처리
		 */
		private void updateQuit() {
			
			System.out.println("[사번을 입력 받아 퇴사 처리]");
			System.out.print("사번 입력 : ");
			int input = sc.nextInt();
			
			System.out.println("정말로 퇴사 처리를 하시겠습니다? Y/N");
			int input2 =  sc.next().toUpperCase().charAt(0);
			
			
			if(input2 == 'N') {
				System.out.println("퇴사처리를 취소하겠습니다.");
			}
			if(input2 != 'Y') {
				System.out.println("사번이 일치하지 않거나,퇴직한 사원입니다.");
			}
		
			try {
				int result = service.updateQuit(input);
				
				
				String str = null;
				if(result>0 ) str = "퇴직처리가 되었습니다.";
					
				else str = "잘못 입력하셨습니다.";
				
				System.out.println(str);
		
				
				
			} catch (SQLException e) {
				System.out.println("퇴직 처리중 예외가 발생했습니다.");
				e.printStackTrace();
			}			
		}
		
		
		
		
	
		private void topFive() {
			
			System.out.println("가장 입사일이 늦은 사원 5명");
			
			try {
				List<Emp> empList = service.topFive();
				
				if(empList.isEmpty()) { 
					System.out.println("[사원이 존재하지 않습니다.]");
					return;
				}
				
				for(Emp emp : empList) {
					System.out.printf("%d / %s / %s /%s \n", 
								emp.getEmpId(),
								emp.getEmpName(), 
								emp.getDepartmentTitle(),
								emp.getHireDate());
				
				}
				} catch (SQLException e) {
				System.out.println("사원을 조회하던 중 예외가 발생했습니다.");
				e.printStackTrace();
			}
		}
		
		

	private void selectDepartment() {
		System.out.println("\n*****부서별 통계 조회*****\n");
		
		
		//DTO가 없을 때 Map을 사용하는 이유
		// 1.DTO를 작성하는게 코드 낭비인 경우
		// 2.DTO와 Map의 구조가 유사하기 때문에
		
//		Map<String,Object> map = new HashMap<>();
//		
//		map.put("empId", 200);
//		map.put("empName", "고길동");
//		
//		map.get("empId");
//		map.get("empName");
//		
//		List<Emp> empList;
//		
//		List<Map<String,Object>> mapList;
//		
//		
//		//tip. DTO의 필드의 Map의 Key라고 생각
//		
		
		//서비스 호출
		try {
			List<Map<String,Object>> mapList = service.selectDepartment();
			
			//조회 결과 출력
			
			//List에서 요소를 하나씩 순차 접근
			for(Map<String,Object> map: mapList) {
				
//				System.out.printf("%s/ %d /%d \n",
//									map.get("deptTitle"),
//									map.get("count"),
//									map.get("avg"));
				
				Set<String> set = map.keySet(); //map에서 key만 얻어와 반
								//-> deptTitle, count, avg 순서
				for(String key :  set) {
					System.out.print(map.get(key) +  " " );
					
				} System.out.println();//줄바꿈			
			}
			
		} catch (SQLException e) {
			System.out.println("[부서별 통계 조회 중 예외 발생]");
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
}
