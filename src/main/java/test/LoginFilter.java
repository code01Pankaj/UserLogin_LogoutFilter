package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@WebFilter("/log")
public class LoginFilter implements Filter {
	public FilterConfig fc = null;//instance variable
	public LoginDAO Id = null;
	@Override
	public void init(FilterConfig fc)throws ServletException{
		this.fc= fc;
	    Id=new LoginDAO();	
	}
	@Override
	public void doFilter(ServletRequest req,ServletResponse res,FilterChain chain)throws
	ServletException,IOException{
		UserBean ub = Id.login(req);
		if(ub==null) {
			req.setAttribute("msg","Invalid Login Process....<br>");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
		}else {
			String filterName = fc.getFilterName();
			req.setAttribute("filterName", filterName);
			req.setAttribute("ub", ub);
			chain.doFilter(req, res);//linking servlet program
		}
	}
	@Override
	public void destroy() {
		Id=null;
	}

}
