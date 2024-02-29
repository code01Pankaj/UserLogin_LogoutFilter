package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/log")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws
	ServletException,IOException{
		HttpSession hs=req.getSession();
		UserBean ub =(UserBean)req.getAttribute("ub");
		hs.setAttribute("ub", ub);
		req.getRequestDispatcher("LogSuccess.jsp").forward(req, res);
	
		
	}

}
