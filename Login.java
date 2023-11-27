package Demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/LoginLink")
public class Login extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user=req.getParameter("userName");
		String pass=req.getParameter("userPass");
		PrintWriter pw=resp.getWriter();
		if(user.equals("Anjali") && pass.equals("sql123")) {
			HttpSession session=req.getSession();
			session.setAttribute("userData", user);
			req.getRequestDispatcher("homeLink").forward(req, resp);
			}else {
				pw.print("<h1>INVALIDE USERNMAE AND PASSSOWRD</h1>");
				req.getRequestDispatcher("login.html").include(req, resp);
			}
		
		
	}
}
