package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import etc.Database;
import vo.MemberInfo;

@WebServlet("/member/join")
public class Join extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트가 전달한 파라미터에서 회원 정보를 꺼냄
		
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		
		// 파라미터 검증
		// 1. 아이디 값이 비어있는지
		// 2. 비밀번호 값이 비어있는지 확인
		// 3. 이름 값이 비어잇는지 확인
		// 4. 아이디의 길이, 비밀번호의 길이 또는 이름의 길이가 적절한지 체크
		// 5. 아이디에 반드시 들어가야할 것, 들어가지 말아야할 것 체크
		// 6. 비밀번호에 반드시 들어가야할 것, 들어가지 말아야할 것 체크
		// 7. 
		
		// 회원 정보 생성
		MemberInfo memberInfo = new MemberInfo(id, pw, name);
		Database.memberInfoTable.add(memberInfo);
		
		response.sendRedirect("/web3/member/joinSuccess.html");
		// 회원 정보 table 저장
		
	}

}
