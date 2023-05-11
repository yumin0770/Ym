package edu.kh.project.board.model.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import edu.kh.project.board.model.dao.BoardDAO2;
import edu.kh.project.board.model.dto.Board;
import edu.kh.project.board.model.dto.BoardImage;
import edu.kh.project.board.model.exception.FileUploadException;
import edu.kh.project.common.utility.Util;

@Service //서비스하는 객체라는 걸 알려줌
public class BoardServiceImpl2 implements BoardService2 {

	@Autowired
	private BoardDAO2 dao;

	//게시글 삽입
	@Transactional(rollbackFor =  Exception.class)
	@Override
	public int boardInsert(Board board, List<MultipartFile> images, String webPath, String filePath) throws IllegalStateException, IOException {
		
		//0번.XSS 방지 처리
		board.setBoardContent(Util.XSSHandling(board.getBoardContent()));
		board.setBoardTitle(Util.XSSHandling(board.getBoardTitle()));
		
		//1.BORAD, INSERT 하기(제목,내용,작성자,게시판 코드) BORAD_IMG -> 프로시저
		//->boardNo(시퀀스 번호), 반환받기
		
		int boardNo = dao.boardInsert(board);
	
		//2. 게시글 삽입 성공 시
		// 업로드된 이미지가 있다면 BOARD_IMG 테이블에 삽입하는 DAO 호출
		if(boardNo > 0 ) { //게시글 삽입 성공 시
			
			//List<MultipartFile> images
			//->업로드된 파일이 담긴 객체 MulitpartFile이 5개 존재
			//-> 단, 업로드된 파일이 없어도 MulitpartFile 객체는 존재
			
			//images에 담겨있는 파일 중 실제 업로드된 파일만 분류하는 작업
			
			List<BoardImage> uploadList = new ArrayList<BoardImage>();
			
			for(int i=0; i<images.size(); i++) {
				
				//i번째 요소에 업로드한 파일이 있다면
				if(images.get(i) .getSize() > 0 ) { //파일이 있다
					
					BoardImage img = new BoardImage(); //있으면 uploadList에 옮겨 담음
					
					//img에 파일 정보를 담아서 uploadList에 추가
					img.setImagePath(webPath); //웹 접근 경로
					img.setBoardNo(boardNo); //게시글 번호
					img.setImageOrder(i); //이미지 순서
					
					String fileName = images.get(i).getOriginalFilename();
					
					img.setImageOriginal(fileName); //원본명
					
					img.setImageReName(Util.fileRename(fileName)); //변경명
					
					uploadList.add(img);
				}
			}//분류 for문 종료
			
			//분류 작업 후 uploadList가 비어있는 경우 / 비어있지 않은 경우(업로드한 파일 있다)
			//=업로드한 파일이 없다(글만 씀)
			
			//업로드한 파일 있다.
			if(!uploadList.isEmpty()) { //비어있지 않다
			
			//BOARD_IMG 테이블에 INSERT하는 DAO 호출 
				int result = dao.insertImageList(uploadList);
				//result == 삽입된 행의 개수  ==uploadfList.size()
				
				//삽입된 행의 개수와 uploadList의 개수가 같다면
				//==전체 insert 성공
				if(result == uploadList.size()) {
					//서버에 파일을 저장(transferTo())
					
					//images     : 실제 파일이 담긴 객체 리스트
					//				(업로드 안 된 인덱스는 빈칸)
					
					//uploadList : 업로드된 파일의 정보 (원본명, 변경명,순서,경로,게시글 번호)
					//순서 == images 업로드된 인덱스
					
					for(int i=0 ; i<uploadList.size(); i++){
						
						int index= uploadList.get(i).getImageOrder();
						
						//파일로 변환
						String rename =  uploadList.get(i).getImageReName();
						images.get(index).transferTo( new File(filePath + rename ));
						
					}
					
					
				} else { //일부 또는 전체 insert 실패
					
					//**웹 서비스 수행 중 1개라도 실패하면 전체 실패 간주
					// ->rollback 필요
					//	@Transactional(rollbackFor =  Exception.class)
					//->예외가 발생해야지만 롤백
					
					//[결론]
					//예외를 강제 발생시켜서 롤백을 해야한다
					//-> 사용자 정의 예외가 필요하다
					throw new FileUploadException(); //예외 강제 발생
				}
			}
		}
		return boardNo;
	}
	
	
	
	
}
