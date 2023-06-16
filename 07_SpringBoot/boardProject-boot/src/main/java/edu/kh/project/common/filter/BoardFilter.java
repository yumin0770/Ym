package edu.kh.project.common.filter;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class BoardFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
			HttpServletRequest req =  (HttpServletRequest)request;
			HttpServletResponse resp = (HttpServletResponse)response;
			
			HttpSession session = req.getSession();
			
			// /board/1   			=> {"", "board", "1"}
			// /board2/1/insert     -> {"", "board2", "2", insert}
			// /board2/1/update     -> {"", "board2", "1", update}
			
			String[] arr =req.getRequestURI().split("/");
			
			try {
		
				String boardCode = arr[2];
				
			    List<Map<String, Object>> boardTypeList = (List<Map<String, Object>>)(req.getServletContext().getAttribute("boardTypeList"));
		         
		         for(Map <String,Object> boardType : boardTypeList) {
		            
		            if((boardType.get("BOARD_CODE") + "").equals(boardCode)) {
		               req.setAttribute("boardName", boardType.get("BOARD_NAME"));
		            }
		         }
				
			}catch(Exception e) {
			
			}
	
			chain.doFilter(request,response);
		
	}

}
