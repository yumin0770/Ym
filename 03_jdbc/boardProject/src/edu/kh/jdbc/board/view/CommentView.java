package edu.kh.jdbc.board.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.jdbc.board.model.dao.CommentDAO;
import edu.kh.jdbc.board.model.dto.Board;
import edu.kh.jdbc.board.model.dto.Comment;
import edu.kh.jdbc.board.model.service.CommentService;
import edu.kh.jdbc.common.Session;
import edu.kh.jdbc.member.model.dto.Member;

public class CommentView {

	private Scanner sc = new Scanner(System.in);

	private CommentService commentService = new CommentService();

	/**
	 * 댓글 메뉴
	 * 
	 * @param boardNo(상세 조회 중인 게시글 번호)
	 */
	public void commentMenu(int boardNo) {

		int input = -1;

		try {
			System.out.println("\n=== 댓글 기능 ===\n");
			System.out.println("1) 댓글 등록");
			System.out.println("2) 댓글 수정");
			System.out.println("3) 댓글 삭제");

			System.out.println("0. 댓글 기능 종료");

			System.out.print("\n선택 : ");
			input = sc.nextInt();
			sc.nextLine();

			switch (input) {
			case 1: insertComment(boardNo);  break; // 댓글 등록
			
	            //!wq가 입력 될 때까지 댓글내용을 입력 받고 
	            // 내용, 게시글 번호, 로그인 회원 번호를 이용해 
	            // 댓글 삽입 서비스 호출
	            
	          case 2: updateComment(boardNo); break; // 댓글 수정
				// 댓글 번호를 입력 받아서
			// 1) 해당 댓글이 현재 게시글의 댓글이며
			//    로그인한 회원이 쓴 댓글이 맞는지 확인하는 서비스 호출
			
			// 2-1) 1번 결과가 맞지 않으면 
			//     "작성한 댓글만 수정할 수 있습니다" 출력
			
			// 2-2) !wq가 입력될 때 까지 내용 입력 후
			//		댓글번호, 내용을 이용해 댓글을 수정하는 서비스를 호출
			
			
	            case 3: deleteComment(); break; // 댓글 삭제
			// 댓글 번호를 입력 받아서
			// 1) 해당 댓글이 현재 게시글의 댓글이며
			//    로그인한 회원이 쓴 댓글이 맞는지 확인하는 서비스 호출
			
			// 2-1) 1번 결과가 맞지 않으면 
			//     "작성한 댓글만 수정할 수 있습니다" 출력
			
			// 2-2)맞으면  "정말로 삭제 하시 겠습니까?(Y/N) : "
			// 	Y 입력 시 : 삭제 서비스 호출(댓글번호)
			//  N 입력 시 : "취소되었습니다";
			
			
			 

			case 0:
				return;
			default:
				System.out.println("\n*** 메뉴 번호만 입력 해주세요 ***\n");
			}

		} catch (InputMismatchException e) {
			System.out.println("\n*** 입력 형식이 올바르지 않습니다***\n");
			sc.nextLine();
		}

	}
	
	
	public void insertComment(int boardNo) {
		
		//내용, 게시글 번호, 로그인 회원 번호를 이용해 
        // 댓글 삽입 서비스 호출
		System.out.println("\n===== 댓글 삽입 =====\n");
		System.out.println("댓글 내용 : ");
		
				StringBuffer sb = new StringBuffer();
				
				System.out.println("<!wq 입력 시 종료>");  //!wq 리눅스에서 쓰는 명령 후 저장 
				//특정 단어가 입력 될 때 까지 무한히 입력
				while(true) {
					String str = sc.nextLine();
					
					if(str.equals("!wq")) break;
					
					//append : 제일 뒤에 추가 //입력 받은 값을 제일 뒤에 추가한다.
					sb.append(str);
					sb.append("\n"); //줄바꿈을 추가
				}
	
		try {
		//게시글 수정 서비스 호출
		int result = commentService.insertComment(sb.toString(),boardNo,Session.loginMember.getMemberNo());
		
		if(result > 0 ) {
			System.out.println("\n=== 댓글이 삽입 되었습니다 ===\n");
		}else {
			System.out.println("\n*** 삽입 실패!! ***\n");
		}
		
		
	}catch(Exception e){
		System.out.println("예외 발생");
		e.printStackTrace();
	}
	
	}
	
	
	public void updateComment(int boardNo) {
	
		System.out.println("\n===== 댓글 수정 =====\n");
		System.out.print("댓글 번호 입력 : ");
		int commentNo = sc.nextInt();
		sc.nextLine();
	
		try {
		Comment comment = commentService.sameMember(commentNo);
		 
		if(Session.loginMember.getMemberNo() != comment.getMemberNo()) {
			System.out.println("\n작성한 댓글만 수정할 수 있습니다\n");
			return;
		 }
	
		System.out.print("댓글 수정할 내용 : ");
		
		//StringBuffer(가변성)
				StringBuffer sb = new StringBuffer();
				
				System.out.println("<!wq 입력 시 종료>");  //!wq 리눅스에서 쓰는 명령 후 저장 
				//특정 단어가 입력 될 때 까지 무한히 입력
				while(true) {
					String str = sc.nextLine();
					
					if(str.equals("!wq")) break;
					
					//append : 제일 뒤에 추가 //입력 받은 값을 제일 뒤에 추가한다.
					sb.append(str);
					sb.append("\n"); //줄바꿈을 추가
				}
			
			
				//게시글 수정 서비스 호출
				int result = commentService.updateComment(commentNo, sb.toString());
				
				if(result > 0 ) {
					System.out.println("\n=== 댓글이 수정 되었습니다 ===\n");
				}else {
					System.out.println("\n*** 수정 실패!! ***\n");
				}
				
				
			}catch(Exception e){
				System.out.println("예외 발생");
				e.printStackTrace();
			}
			 
		}
	
		public void  deleteComment() {
		
			System.out.println("\n===== 댓글 삭제 =====\n");
			System.out.print("댓글 번호 입력 : ");
			int commentNo = sc.nextInt();
			sc.nextLine();
		
			try {
			Comment comment = commentService.sameMember(commentNo);
			 
			if(Session.loginMember.getMemberNo() != comment.getMemberNo()) {
				System.out.println("\n작성한 댓글만 삭제 할 수 있습니다\n");
				return;
			 }
			
			while(true) {
				System.out.print("정말 삭제 하시겠습니까? (Y/N)");
				char check = sc.next().toUpperCase().charAt(0);

				
				if(check == 'N') {
					System.out.println("[삭제 취소]");
					return; //게시판 목록으로 돌아감
				}
				
				if(check != 'Y') {
					System.out.println("[잘못 입력하셨습니다]");
					continue; //처음으로 돌아감 while로 돌아감
				
			}
		
				break; //check == 'Y'인 경우 //while밖으로 나감
			}
			
					//게시글 삭제 서비스 호출
					int result = commentService.deleteComment(commentNo);
					
					if(result>0) {
						System.out.println("\n=== 삭제 되었습니다 ===\n");
					}else {
						System.out.println("\n*** 삭제 실패 ***\n");
					}
					
				
					
				}catch(Exception e){
					System.out.println("예외 발생");
					e.printStackTrace();
				}
				 
	}
	
	
	
}
