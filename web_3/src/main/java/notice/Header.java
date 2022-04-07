package notice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/notice/header")
public class Header extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		try {
			boolean isLogin = (boolean) session.getAttribute("isLogin");
			String loginUserName = (String) session.getAttribute("loginUserName");
			String userLevel = (String) session.getAttribute("userLevel");
			
			response.setContentType("application/json;charset=UTF-8");
			
			PrintWriter out = response.getWriter();
											
			out.print("{\"isLogin\"ftrue, \"loginUserName\":\"" + loginUserName + "\", \"userLevel\" :\"" + userLevel + "\"}");
			
			out.close();
		} catch(NullPointerException e) {
			// 로그인하지 않은 사용자의 경우 예외가 발생함
			PrintWriter out = response.getWriter();
			
			out.print("{\"isLogin\":false}");
		}
		
		
		
		
//			-> 로그인 여부 알려줘야 함
//			-> 로그인을 했다면(isLogin=true)
//			   -> 로그인한 사용자의 이름(loginUserName=name1)
//			   -> 로그인한 사용자의 레벨(loginUserLevel=user)

	}
}
