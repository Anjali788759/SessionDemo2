package Demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/homeLink")
public class home extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	PrintWriter pw=resp.getWriter();
	req.getRequestDispatcher("index.html").include(req, resp);
	
	HttpSession session =req.getSession(false);
	if(session!=null) {
		pw.print("<h1>WELCOME TO HOME PAGE</h1>");
		pw.print("<h1>WELCOME  " + session.getAttribute("userData"));
		session.setMaxInactiveInterval(10);
		
	}else {
		pw.print("<h1>FRIST LOGIN</h1>");
		req.getRequestDispatcher("index.html").include(req, resp);
	}
	
	
}
}
